package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.detnet.locators.DeviceDetonatorsPageLocators.*;

public class DeviceDetonatorsPageObjectModel {
    private final Page page;

    public DeviceDetonatorsPageObjectModel(Page page) {
        this.page = page;
    }

    public String getDeviceDetonatorsPageURL(){
        try{
            page.waitForURL("**/device-details/*/detonators");
            return page.url();
        }catch (PlaywrightException e){
            System.out.println("Page URL not found or invalid: " + e.getMessage());
            return null;
        }
    }

    public boolean isDeviceDetonatorsPageOpen(){
        try{
            page.locator(deviceDetonatorsHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Device detonators page not found or not visible after clicking on 'Detonators' -tab: " +
                    e.getMessage());
            return false;
        }
    }

    public boolean isRequestDetonatorButtonVisible(){
        try{
            page.locator(detonatorRequestButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'Request Detonators' -button not found or not visible on the device detonators page: " +
                    e.getMessage());
            return false;
        }
    }

    public boolean isRequestDetonatorButtonEnabled(){
        try{
            return page.locator(detonatorRequestButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Request Detonators' -button not found or not visible on the device detonators page: " +
                    e.getMessage());
            return false;
        }
    }

    public void requestDetonators(){
        try{
            page.locator(detonatorRequestButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Request Detonators' -button not found or not visible on the device detonators page: " +
                    e.getMessage());
        }
    }

    public boolean isDetonatorsRequestSnackBarVisible(){
        try{
            page.locator(detonatorsRequestSnackBarLabel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Detonators request snack bar alert not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isDetonatorsListVisible(){
        try{
            page.locator(detonatorsList)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Detonator list not visible or not found on device detonars page: " + e.getMessage());
            return false;
        }
    }
}