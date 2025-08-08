package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.detnet.locators.DeviceChannelPageLocators.*;

public class DeviceChannelPageObjectModel {
    private final Page page;

    public DeviceChannelPageObjectModel(Page page) {
        this.page = page;
    }

    public boolean isDeviceChannelScreenOpen(){
        try{
            page.locator(panelText)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Device channel screen not found or not visible after clicking on channel tab: " +
                    e.getMessage());
            return false;
        }
    }
}