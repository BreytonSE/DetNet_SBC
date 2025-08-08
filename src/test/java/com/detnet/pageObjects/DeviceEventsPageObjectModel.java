package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.detnet.locators.DeviceEventsPageLocators.*;

public class DeviceEventsPageObjectModel {
    private final Page page;

    public DeviceEventsPageObjectModel(Page page) {
       this.page = page;
    }

    public boolean isEventsDateDisplayed() {
        try {
            page.locator(dateTableHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Events date not found or not visible on the events page. " + e.getMessage());
            return false;
        }
    }

    public boolean isEventsTimeDisplayed(){
        try{
            page.locator(timeTableHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Events time not found or not visible on the events page: " + e.getMessage());
            return false;
        }
    }

    public boolean isEventNameDisplayed(){
        try{
            page.locator(eventTableHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Events not found or not visible on the events page: " + e.getMessage());
            return false;
        }
    }

    public boolean isEventsPageOpen(){
        try{
            page.locator(eventsHeader)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Events page not visible or not found. Caused by:" + e.getMessage());
            return false;
        }
    }

    public boolean isEventsPaginated(){
        try{
            page.locator(paginatorPageSizeLabel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            page.locator(paginatorRangeLabel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Paginator elements not found or not visible on the device events page: " + e.getMessage());
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
            page.locator(fromDatePicker)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'From' -date picker window is not open or not found caused by: " + e.getMessage());
            return false;
        }
    }

    public void selectDate(int day){
        try {
            String dayElement = "(//div[normalize-space()='" + day + "'])[1]";
            page.locator(dayElement).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Selected day not found or not visible on the calendar: " + e.getMessage());
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
}