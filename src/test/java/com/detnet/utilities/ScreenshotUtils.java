package com.detnet.utilities;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ScreenshotType;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.List;

public class ScreenshotUtils {

    public static void captureScreenshot(Page page, Scenario scenario){
        try{
            if(page != null){
                byte[] screenshot = page.screenshot(new Page.ScreenshotOptions()
                        .setType(ScreenshotType.PNG)
                        .setFullPage(true)); // Capture full page screenshot

//                If failure occurs, attach screenshot
                if(scenario.isFailed()){
                    scenario.attach(screenshot, "image/png", "Screenshot -" + scenario.getName());
                    attachScreenshotToReport(screenshot);
                }
            }
        }catch (AssertionError e){
            List<String> errors = SoftAssertionUtils.getAssertionErrors();
            errors.forEach(error -> {
                scenario.log("Step soft assertion error: " + error);
            });
        }
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Step Screenshot", type = "image/png")
    private static byte[] attachScreenshotToReport(byte[] screenshot){
        return screenshot;
    }

//    This method is used to capture screenshots for Windows App scenarios
    public static void captureScreenshotForWindowsApp(WindowsDriver<WindowsElement> driver, Scenario scenario){
        try{
            if (driver != null){
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot,"image/png", "Screenshot - " + scenario.getName());
                attachScreenshotToReport(screenshot);
            }
        }catch (AssertionError e){
            List<String> errors = SoftAssertionUtils.getAssertionErrors();
            errors.forEach(error -> {
                scenario.log("Step soft assertion error: " + error);
            });
        }
    }
}