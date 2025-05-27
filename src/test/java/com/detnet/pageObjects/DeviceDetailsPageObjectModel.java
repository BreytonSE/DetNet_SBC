package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

public class DeviceDetailsPageObjectModel {
    private final Page page;

    private final String deviceStatusColumn = "(//mat-toolbar[@class='mat-toolbar summary-div-header mat-toolbar-single-row'])[1]";
    private final String deviceDetailsAndConfigColumn = "(//mat-toolbar[@class='mat-toolbar summary-div-header mat-toolbar-single-row'])[2]";
    private final String deviceStatisticsColumn = "(//mat-toolbar[@class='mat-toolbar summary-div-header mat-toolbar-single-row'])[3]";
    private final String deviceAuxiliaryRelaysColumn = "(//mat-toolbar[@class='mat-toolbar summary-div-header mat-toolbar-single-row'])[4]";
    private final String bcuBlastKeyColumn = "(//mat-toolbar[@class='mat-toolbar summary-div-header mat-toolbar-single-row'])[5]";

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