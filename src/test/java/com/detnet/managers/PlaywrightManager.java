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
            tearDownPlayWright(); // Ensures that no stale instances exists before starting a new session

            playwright = Playwright.create();

//            Detect if running in GitHub Actions
            boolean isCI = System.getenv("GITHUB_ACTIONS") != null;

            browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(isCI) // Run headless in CD/CI, non-headless locally
                    .setArgs(Arrays.asList(
                            "--start-fullscreen",
                            "--disable-infobars",
                            "--disable-extentions",
                            "--disable-popup-blocking"
                    ))
                    .setIgnoreDefaultArgs(Collections.singletonList("--disable-blink-features=AutomationControlled")) // Mimic user behavior
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
        if(page == null){
            throw new IllegalStateException("Playwright page is not initialized. Call 'setUpPlaywright()' first.");
        }else{
            return page;
        }
    }

    public static void tearDownPlayWright(){
        try{
            if(page != null){
                page.close();
                page = null;
            }
            if (context != null){
                context.close();
                context = null;
            }
            if(browser != null){
                browser.close();
                browser = null;
            }
            if(playwright != null){
                playwright.close();
                playwright = null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}