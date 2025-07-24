package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;

import static com.detnet.locators.DeviceSummaryPageLocators.*;

public class DeviceSummaryPageObjectModel {
    private final Page page;

    public DeviceSummaryPageObjectModel(Page page) {
        this.page = page;
    }

    public boolean isDeviceStateVisible(){
        try{
            page.locator(deviceStateLabel).waitFor(new Locator.WaitForOptions().setTimeout(5000));
            return page.locator(deviceStateLabel).isVisible();
        }catch (Exception e){
            System.out.println("Device state label not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public String getCurrentDeviceState() {
        try{
            Locator stateLocator = page.locator("//span[@class='text' and (normalize-space()='Idle' or " +
                    "normalize-space()='Ready to blast' or normalize-space()='Unknown' or normalize-space()='Ready to arm')]");
            return stateLocator.textContent().trim();
        }catch (PlaywrightException e){
            System.out.println("Device state not found or not visible: " + e.getMessage());
            return null;
        }
    }
}