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
            if (playwright == null){
                playwright = Playwright.create();
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                        .setHeadless(false) // Run in UI mode
                        .setArgs(Arrays.asList(
                                "--start-fullscreen",
                                "--disable-infobars",
                                "--disable-extentions",
                                "--disable-popup-blocking"
                        ))
                        .setIgnoreDefaultArgs(Collections.singletonList("--disable-blink-features=AutomationControlled")) // Mimic user behavior
                );
                context = browser.newContext(new Browser.NewContextOptions()
                        .setIgnoreHTTPSErrors(true) // Accept insecure certificates
//                        .setViewportSize(1920,1080) // Maximize border window
                );
                page = context.newPage();

//                ** Resize window to full screen
                page.evaluate("window.moveTo(0, 0); window.resizeTo(screen.width, screen.height);");

//                Navigate to the login page
                page.navigate("http://localhost:8080/en/login");
            }
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