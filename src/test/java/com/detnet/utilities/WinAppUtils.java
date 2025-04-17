package com.detnet.utilities;

import com.detnet.managers.WinAppManager;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.concurrent.atomic.AtomicInteger;

public class WinAppUtils {
    public static WindowsDriver<WindowsElement> driver;
    private static final AtomicInteger scenarioCount = new AtomicInteger(0);
    private static final int TOTAL_SCENARIOS = 1;

    @Before("@desktop")
    public void launchBlastWeb(){
        WinAppManager.startWinAppDriver();
        WinAppManager.setUp();
    }

    @After("@desktop")
    public void updateTestResults(Scenario scenario){
        System.out.println("🔁 Entered @After hook for: " + scenario.getName());

        try{
            if(scenario.isFailed()){
                System.out.println("Scenario failed: Capturing screenshot...");
                if(driver != null){
                    ScreenshotUtils.captureScreenshotForWindowsApp(driver,scenario);
                }else {
                    System.out.println("Warning: WinAppDriver is null, skipping screenshot...");
                }
            }
        }catch (Exception e){
            throw new RuntimeException("Error in @After: " + e.getMessage(),e);
        }finally {
            scenarioCount.incrementAndGet();
            SoftAssertionUtils.reset();

            System.out.println("🧹 Calling tearDown()...");
            WinAppManager.tearDown();

            if(scenarioCount.get() < TOTAL_SCENARIOS){
                WinAppManager.setUp();
                driver = WinAppManager.getDriver();
                driver.manage().window().maximize();
            }
        }
    }
}