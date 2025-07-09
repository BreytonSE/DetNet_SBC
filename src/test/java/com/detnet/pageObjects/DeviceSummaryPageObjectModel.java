package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

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
            return false;
        }
    }

    public String getCurrentDeviceState() {
        Locator stateLocator = page.locator("//span[@class='text' and (normalize-space()='Idle' or normalize-space()='Ready to blast' or normalize-space()='Unknown')]");
        return stateLocator.textContent().trim();
    }
}