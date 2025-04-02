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
    private static final AtomicInteger scenarioCount = new AtomicInteger(0);
    private static final int TOTAL_SCENARIOS = 2; // Re adjust accordingly
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

    @After
    public void updateTestResults(Scenario scenario) throws InterruptedException {
        try {
            if(scenario.isFailed()){
                System.out.println("Scenario failed: Capturing screenshot...");
                if(page != null && !page.isClosed()){
                    ScreenshotUtils.captureScreenshot(page, scenario);
                }else {
                    System.out.println("Warning: Page is null, skipping screenshot");
                }
            }
        }catch (Exception e){
            throw new RuntimeException("Error in @After: " + e.getMessage(),e);
        }finally {
            PlaywrightManager.tearDownPlayWright();  // Close Playwright AFTER screenshot capture
            scenarioCount.incrementAndGet();
            SoftAssertionUtils.reset();

            if (scenarioCount.get() < TOTAL_SCENARIOS) {
//                Thread.sleep(2000); // Allow time for teardown to complete
                PlaywrightManager.setUpPlaywright(); // Ensure Playwright is fully reinitialized before the next test
                page = PlaywrightManager.getPage(); // Retrieve new page instance
                pageObjectManager.updatePage(page);
            }
        }
    }
}