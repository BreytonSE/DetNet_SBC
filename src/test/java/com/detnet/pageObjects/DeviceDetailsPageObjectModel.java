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
        try{
            page.waitForURL("**/device-details/*/summary");
            return page.url();
        }catch (PlaywrightException e){
            System.out.println("URL not found or not valid: " + e.getMessage());
            return null;
        }
    }

    public boolean isDeviceStatusVisible(){
        try{
            page.locator(deviceStatusColumn)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Device status column not found or not visible: " + e.getMessage());
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
            System.out.println("Device details and configuration column not visible or not found: " + e.getMessage());
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
            System.out.println("Device statistics column not visible or not found: " + e.getMessage());
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
            System.out.println("Device auxiliary relays column not found or not visible: " + e.getMessage());
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
            System.out.println("Blast key column not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isEventsTabVisible(){
        try{
            page.locator(eventsTab)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Events -tab not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public String getEventsTabText(){
        try{
            return page.locator(eventsTab).textContent();
        }catch (PlaywrightException e){
            System.out.println("Events -tab not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public void viewDeviceEvents(){
        try{
            page.locator(eventsTab).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Events -tab not visible or not found: " + e.getMessage());
        }
    }

    public boolean isChannelsTabVisible(){
        try {
            page.locator(channelsTab)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Channels tab not visible or not found from the menu: " + e.getMessage());
            return false;
        }
    }

    public String getChannelsTabText(){
        try{
            return page.locator(channelsTab).textContent();
        }catch (PlaywrightException e){
            System.out.println("Channels tab not visible or not found from the menu: " + e.getMessage());
            return null;
        }
    }

    public void viewDeviceChannels(){
        try{
            page.locator(channelsTab).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Channels tab not visible or not found from the menu: " + e.getMessage());
        }
    }

    public boolean isLogsTabVisible(){
        try{
            page.locator(logsTab)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Logs tab not found or not visible on the menu panel: " + e.getMessage());
            return false;
        }
    }

    public String getLogsTabText(){
        try{
            return page.locator(logsTab).textContent();
        }catch (PlaywrightException e){
            System.out.println("Logs tab not found or not visible on the menu panel: " + e.getMessage());
            return null;
        }
    }

    public void viewDeviceLogs(){
        try{
            page.locator(logsTab).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Logs tab not found or not visible on the menu panel: " + e.getMessage());
        }
    }

    public boolean isCommentsTabVisible(){
        try{
            page.locator(commentsTab)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.printf("Device comments tab not visible or not found on the device details screen: " +
                    e.getMessage());
            return false;
        }
    }

    public void openDeviceComments(){
        try{
            page.locator(commentsTab).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Device comments tab not visible or not found on the device details screen: " +
                    e.getMessage());
        }
    }

    public boolean isDetonatorsTabVisible(){
        try{
            page.locator(detonatorsTab)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Detonators tab not visible or not found on device details menu: " + e.getMessage());
            return false;
        }
    }

    public String getDetonatorsTabText(){
        try{
            return page.locator(detonatorsTab).textContent();
        }catch (PlaywrightException e){
            System.out.println("Detonators tab not visible or not found on device details menu: " + e.getMessage());
            return null;
        }
    }

    public void openDeviceDetonatorsPage(){
        try{
            page.locator(detonatorsTab).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Detonators tab not visible or not found on device details menu: " + e.getMessage());
        }
    }
}