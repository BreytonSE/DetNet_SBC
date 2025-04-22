package com.detnet.managers;

import com.microsoft.playwright.*;

import java.util.Arrays;
import java.util.Collections;

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

//            Detect if running in GitHub Actions
            boolean isCI = System.getenv("GITHUB_ACTIONS") != null;
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(isCI) // Run headless in CD/CI, non-headless locally
                    .setArgs(Arrays.asList("--disable-gpu",
                            "--start-fullscreen",
                            "--disable-extentions",
                            "--disable-popup-blocking",
                            "--no-sandbox",
                            "--disable-dev-shm-usage"
                    ))
//                     Mimic user behavior
                    .setIgnoreDefaultArgs(Collections.singletonList("--disable-blink-features=AutomationControlled"))
            );
            context = browser.newContext(new Browser.NewContextOptions().setIgnoreHTTPSErrors(true));
            page = context.newPage();

//          Resize window to full screen (only if not headless)
            if(!isCI){
                page.evaluate("window.moveTo(0, 0); window.resizeTo(screen.width, screen.height);");
            }

//          Navigate to the login page
            page.navigate("http://localhost:8080/en/login");
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