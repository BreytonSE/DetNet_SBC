package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.detnet.locators.DeviceLogsPageLocators.deviceLogsText;
import static com.detnet.locators.DeviceLogsPageLocators.*;

public class DeviceLogsPageObjectModel {
    private final Page page;

    public DeviceLogsPageObjectModel(Page page) {
        this.page = page;
    }

    public boolean isDeviceLogsScreenOpen(){
        try{
            page.locator(deviceLogsText)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Logs screen not visible or not found after user clicked on 'Logs' button: " +
                    e.getMessage());
            return false;
        }
    }

    public boolean isDeviceLogsVisible(){
        try{
            page.locator(noDeviceLogsText)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.HIDDEN)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Device logs not found or not visible on the logs menu: " + e.getMessage());
            return false;
        }
    }

    public boolean isFromDatePickerButtonVisible(){
        try{
            page.locator(fromDatePicker)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'From' date picker button not found or not visible on the logs screen: " + e.getMessage());
            return false;
        }
    }

    public void openFromDatePicker(){
        try{
            page.locator(fromDatePicker).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'From' date picker button not found or not visible on the logs screen: " + e.getMessage());
        }
    }

    public boolean isFromDatePickerOpen(){
        try{
            page.locator(fromDatePickerWindow)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'From' -date picker window is not open or not found caused by: " + e.getMessage());
            return false;
        }
    }

    public void goToPreviousMonth(){
        try{
            page.locator(previousMonthArrow).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Back arrow not visible or not found on date picker tool: " + e.getMessage());
        }
    }

    public void selectDay(int day){
        try{
            String dayElement = "(//div[normalize-space()='" + day + "'])[1]";
            page.locator(dayElement).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Selected day not found or not visible on date picker: " + e.getMessage());
        }
    }

    public boolean isClockVisible(){
        try{
            page.locator(clock)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Clock not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void selectTime(){
        try{
            page.locator(clock).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Clock not visible or not found: " + e.getMessage());
        }
    }

    public boolean isToDatePickerVisible(){
        try{
            page.locator(toDatePicker)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'To' date picker button not visible or not found on device logs screen: " +
                    e.getMessage());
            return false;
        }
    }

    public void openToDatePicker(){
        try{
            page.locator(toDatePicker).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'To' date picker button not visible or not found on device logs screen: " +
                    e.getMessage());
        }
    }

    public boolean isLogCategorySelectorVisible(){
        try{
            page.locator(logCategoryPicker)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Log category element not found or not visible. Caused by: " + e.getMessage());
            return false;
        }
    }

    public boolean isLogCategorySelectorEnabled(){
        try{
            return page.locator(logCategoryPicker).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Log category element not found or not visible. Caused by: " + e.getMessage());
            return false;
        }
    }

    public void openLogCategoryDropDown(){
        try{
            page.locator(logCategoryPicker).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Log category element not found or not visible. Caused by: " + e.getMessage());
        }
    }

    public boolean isLogCategoryDropDownOpen(){
        try{
            page.locator(logCategoryDropDown)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Log category dropdown not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void selectLogCategory(int optionNumber){
        try{
            String category = "xpath=/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/mat-option[" + optionNumber + "]/span[1]/" +
                    "div[1]/mat-checkbox[1]/div[1]/div[1]/input[1]\n";
            page.locator(category).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Selected option not visible or not found in the dropdown: " + e.getMessage());
        }
    }

    public boolean isLogRequestButtonVisible(){
        try{
            page.locator(logRequestButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'Request Log' -button not visible or not found on device logs page: " + e.getMessage());
            return false;
        }
    }

    public boolean isLogRequestButtonEnabled(){
        try{
            return page.locator(logRequestButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Request Log' -button not visible or not found on device logs page: " + e.getMessage());
            return false;
        }
    }

    public void requestLog(){
        try{
            page.locator(logRequestButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Request Log' -button not visible or not found on device logs page: " + e.getMessage());
        }
    }

    public boolean isDeviceLogsRequestSent(){
        try{
            page.locator(deviceLogRequestLoaderText)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Device log loader label not visible or not found on device logs page: " + e.getMessage());
            return false;
        }
    }

    public boolean isDownloadIconVisible(){
        try{
            page.locator(cloudDownloadIcon)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Cloud download icon not visible or not found on device logs page: " + e.getMessage());
            return false;
        }
    }

    public boolean isDownloadIconEnabled(){
        try{
            return page.locator(cloudDownloadIcon).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Cloud download icon not visible or not found on device logs page: " + e.getMessage());
            return false;
        }
    }

    public void downloadLogs(){
        try{
            page.locator(cloudDownloadIcon).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Cloud download icon not visible or not found on device logs page: " + e.getMessage());
        }
    }
}