package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

public class NetworkTreePageObjectModel {
    private final Page page;
    private final String networkTreeHeading = "//span[@class=\"networkTreeTxt\"]";
    private final String networkStructure = "//ul[@class=\"network-structure\"]";

    public NetworkTreePageObjectModel(Page page) {
        this.page = page;
    }

    public String getNetworkTreePageURL(){
        page.waitForURL("**/settings/tree");
        return page.url();
    }

    public boolean isNetworkTreePageOpen(){
        try{
            page.locator(networkTreeHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean hasDevices(){
        try{
            page.locator(networkStructure)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isDevicePresent(String deviceId){
        String device = "(//a[contains(text(),'Device ― " + deviceId + "')])[1]";
        try{
            page.locator(device)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public void viewDeviceDetails(String deviceId){
        String device = "(//a[contains(text(),'Device ― " + deviceId + "')])[1]";
        page.locator(device).click(new Locator.ClickOptions().setTimeout(5000));
    }
}