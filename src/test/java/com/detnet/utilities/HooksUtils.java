package com.detnet.utilities;

import com.detnet.managers.PlaywrightManager;
import com.detnet.managers.ServiceManager;
import com.detnet.managers.PageObjectManager;
import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.concurrent.atomic.AtomicInteger;

public class HooksUtils {
    private static Page page;
    private PageObjectManager pageObjectManager;
    private static final AtomicInteger scenarioCount = new AtomicInteger(0);
    private static final int TOTAL_SCENARIOS = 32;
//    private static final int TOTAL_SCENARIOS = 1;

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutdown Hook Triggered 🚀");

            try{
                AllureReportUtils.generateAllureReport();
                System.out.println("✅ Allure Report Generated");

                EmailUtils.sendEmail();
                System.out.println("✅ Email Sent");

                PlaywrightManager.tearDownPlayWright();
                System.out.println("✅ Playwright connection closed successfully");

                ServiceManager.stopBlastWebService();
                System.out.println("✅ BlastWeb Service Stopped");
            }catch (Exception e){
                e.printStackTrace();
                System.err.println("❌ Error in Shutdown Hook: " + e.getMessage());
            }
        }));
    }

    static {
//        Start the service before any tests run
        ServiceManager.startBlastWebService();
    }

    @Before("@web")
    public void setUp(Scenario scenario){
        TestContextUtils.getInstance().setScenario(scenario);
        try {
            if (page == null || page.isClosed()) { // Ensure page is reinitialized
                PlaywrightManager.setUpPlaywright();
                page = PlaywrightManager.getPage(); // Retrieve the initialized page
            }
            if(pageObjectManager == null){
                pageObjectManager = PageObjectManager.getInstance(page);
            }else{
                pageObjectManager.updatePage(page); // Ensure the page object manager is updated
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @After("@web")
    public void updateTestResults(Scenario scenario) {
        try {
            if(scenario.isFailed() && page != null && !page.isClosed()){
                ScreenshotUtils.captureScreenshot(page, scenario);
            }
        }catch (Exception e){
            throw new RuntimeException("Error in @After: " + e.getMessage(),e);
        }finally {
            scenarioCount.incrementAndGet();
            SoftAssertionUtils.reset();
            PlaywrightManager.shutDownActiveTab();
            PlaywrightManager.clearBrowsingSession();
            PlaywrightManager.closeBrowser();

            if(scenarioCount.get() < TOTAL_SCENARIOS) {
                PlaywrightManager.setUpPlaywright();
                page = PlaywrightManager.getPage();
                pageObjectManager.updatePage(page);
            }
        }
    }
}