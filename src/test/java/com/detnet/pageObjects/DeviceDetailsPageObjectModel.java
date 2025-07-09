package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.detnet.locators.DeviceDetailsPageLocators.*;

public class DeviceDetailsPageObjectModel {
    private final Page page;

    public DeviceDetailsPageObjectModel(Page page) {
        this.page = page;
    }

    public String getDeviceDetailsSummaryPageURL(){
        page.waitForURL("**/device-details/*/summary");
        return page.url();
    }

    public boolean isDeviceStatusVisible(){
        try{
            page.locator(deviceStatusColumn)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isDeviceDetailsAndConfigurationVisible(){
        try{
            page.locator(deviceDetailsAndConfigColumn)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isDeviceStatisticsVisible(){
        try {
            page.locator(deviceStatisticsColumn)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isAuxiliaryRelaysVisible(){
        try{
            page.locator(deviceAuxiliaryRelaysColumn)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isBCUBlastKeyVisible(){
        try{
            page.locator(bcuBlastKeyColumn)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }
}