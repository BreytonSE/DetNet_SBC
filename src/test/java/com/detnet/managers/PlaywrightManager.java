package com.detnet.managers;

import com.microsoft.playwright.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PlaywrightManager {
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    public static void setUpPlaywright(){
        try{
            if(playwright == null){
                playwright = Playwright.create();
            }

//            Detect if running in GitHub Actions or Docker
            boolean isCI = System.getenv("GITHUB_ACTIONS") != null || System.getenv("RUNNING_IN_DOCKER") != null;

//            Use host.docker.internal if in Docker, otherwise localhost
            String targetURL = isCI ? "http://host.docker.internal:8080/en/login" : "http://localhost:8080/en/login";
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(isCI) // Run headless in CD/CI, non-headless locally
                    .setArgs(Arrays.asList(
                            "--disable-gpu",
                            "--start-fullscreen",
                            "--disable-extensions",
                            "--disable-popup-blocking",
                            "--no-sandbox",
                            "--disable-dev-shm-usage",
                            "--disable-blink-features=AutomationControlled", // disguise automation
                            "--disable-infobars", // hide "Chrome is being controlled"
                            "--disable-notifications", // block notification prompts
                            "--disable-background-timer-throttling",
                            "--disable-renderer-backgrounding",
                            "--disable-background-occluded-windows"
                    ))
                            .setIgnoreDefaultArgs(Collections.emptyList())
            );
            context = browser.newContext(new Browser.NewContextOptions().setIgnoreHTTPSErrors(true));
            page = context.newPage();

//          Resize window to full screen (only if not headless)
            if(!isCI){
                page.evaluate("window.moveTo(0, 0); window.resizeTo(screen.width, screen.height);");
            }

//          Navigates to the login page.
            page.navigate(targetURL);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Page getPage(){
        if(page == null || page.isClosed()){
           throw new IllegalStateException("❌ Playwright page is not initialized. Call 'setUpPlaywright()' first.");
        }else{
            return page;
        }
    }

    public static void tearDownPlayWright(){
        try{
            if(playwright != null){
                playwright.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            playwright = null;
        }
    }

    public static void shutDownActiveTab(){
        try{
            if(page != null && !page.isClosed()){
                page.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            page = null;
        }
    }

    public static void clearBrowsingSession(){
        try{
            if (context != null){
                context.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            context = null;
        }
    }

    public static void closeBrowser(){
        try {
            if(browser != null){
                browser.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            browser = null;
        }
    }
}