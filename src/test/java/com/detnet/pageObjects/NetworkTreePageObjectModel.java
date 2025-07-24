package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.detnet.locators.NetworkTreePageLocators.*;

public class NetworkTreePageObjectModel {
    private final Page page;

    public NetworkTreePageObjectModel(Page page) {
        this.page = page;
    }

    public String getNetworkTreePageURL(){
        try{
            page.waitForURL("**/settings/tree");
            return page.url();
        }catch (PlaywrightException e){
            System.out.println("URL not found or not valid: " + e.getMessage());
            return null;
        }
    }

    public boolean isNetworkTreePageOpen(){
        try{
            page.locator(networkTreeHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Network tree not found or not visible: " + e.getMessage());
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
            System.out.println("Network structure not found or not visible: " + e.getMessage());
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
            System.out.println("Device id not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void viewDeviceDetails(String deviceId){
        try{
            String device = "(//a[contains(text(),'Device ― " + deviceId + "')])[1]";
            page.locator(device).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Device id not found or not visible: " + e.getMessage());
        }
    }
}