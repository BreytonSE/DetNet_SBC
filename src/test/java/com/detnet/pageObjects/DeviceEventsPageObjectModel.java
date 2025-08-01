package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.detnet.locators.DeviceEventsPageLocators.eventTime;
import static com.detnet.locators.DeviceEventsPageLocators.eventsDate;

public class DeviceEventsPageObjectModel {
    private final Page page;

    public DeviceEventsPageObjectModel(Page page) {
       this.page = page;
    }

    public boolean isEventsDateDisplayed() {
        try {
            page.locator(eventsDate)
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
            page.locator(eventTime)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Events time not found or not visible on the events page: " + e.getMessage());
            return false;
        }
    }
}