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
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;
    private static final AtomicInteger scenarioCount = new AtomicInteger(0);
    private static final int TOTAL_SCENARIOS = 1; // Re adjust accordingly
    private PageObjectManager pageObjectManager;

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            AllureReportUtils.generateAllureReport();
            EmailUtils.sendEmail();
            ServiceManager.stopBlastWebService(); // Stops the service when the tests finish
        }));
    }

    static {
//        Start the service before any tests run
        ServiceManager.startBlastWebService();
    }

    @Before
    public void setUp(Scenario scenario){
        TestContextUtils.getInstance().setScenario(scenario);
        try {
            if (page == null) {
                PlaywrightManager.setUpPlaywright();
                page = PlaywrightManager.getPage(); // Retrieve the initialized page
            }

            if(pageObjectManager == null){
                pageObjectManager = PageObjectManager.getInstance(page);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @After
    public void updateTestResults(Scenario scenario){
        try {
            if(scenario.isFailed()){
                System.out.println("Scenario failed: Capturing screenshot...");
                ScreenshotUtils.captureScreenshot(page, scenario);
            }

            scenarioCount.incrementAndGet();
            SoftAssertionUtils.reset();

            if (context != null) {
                context.close();
            }

            if (scenarioCount.get() < TOTAL_SCENARIOS) {
//            Start a new browser context for the next scenario
                context = browser.newContext();
                page = context.newPage();
            } else {
               PlaywrightManager.tearDownPlayWright(); // Might move this later to the EmailUtils class at the end
            }
        }catch (Exception e){
            throw new RuntimeException("Error in @After: " + e.getMessage(),e);
        }
    }
}