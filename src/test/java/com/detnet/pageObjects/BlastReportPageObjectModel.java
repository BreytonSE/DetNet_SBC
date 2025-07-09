package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.detnet.locators.BlastReportPageLocators.*;

public class BlastReportPageObjectModel {
    private final Page page;

    public BlastReportPageObjectModel(Page page) {
        this.page = page;
    }

    public String getPageURL(){
        try{
            page.waitForURL("**/reports/blast");
            return page.url();
        }catch (PlaywrightException e){
            System.out.println("Failed to get blast report page URL: " + e.getMessage());
            return null;
        }
    }

    public boolean isBlastReportPageOpen(){
        try{
            page.locator(blastReportHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Blast report heading not found or not visible: " + e.getMessage());
            return false;
        }
    }
}