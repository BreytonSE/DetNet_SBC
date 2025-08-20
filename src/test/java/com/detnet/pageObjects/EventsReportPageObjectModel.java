package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.detnet.locators.EventsReportPageLocators.*;

public class EventsReportPageObjectModel {
    private final Page page;

    public EventsReportPageObjectModel(Page page) {
        this.page = page;
    }

    public String getPageURL(){
        try{
            page.waitForURL("**/reports/events");
            return page.url();
        }catch (PlaywrightException e){
            System.out.println("Report events URL not found or invalid: " + e.getMessage());
            return null;
        }
    }

    public boolean isEventsReportPageOpen(){
        try{
            page.locator(eventsReportHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'Events Report' -heading not visible or not found on events report page: " + e.getMessage());
            return false;
        }
    }

    public String getPageName(){
        try{
            return page.locator(eventsReportHeading).textContent();
        }catch (PlaywrightException e){
            System.out.println("'Events Report' -heading not visible or not found on events report page: " + e.getMessage());
            return null;
        }
    }

    public boolean isEventsTableVisible(){
        try{
            page.locator(eventsTable)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Events table not visible or not found to display reports of events: " + e.getMessage());
            return false;
        }
    }

    public boolean isEventsReportPaginated(){
        try{
            page.locator(paginatorRangeLabel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Paginator element not visible or not found on report events page: " + e.getMessage());
            return false;
        }
    }
}