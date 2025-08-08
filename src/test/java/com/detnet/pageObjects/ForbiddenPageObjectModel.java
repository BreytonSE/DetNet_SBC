package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.detnet.locators.ForbiddenPageLocators.errorStatusCode;

public class ForbiddenPageObjectModel {
    private final Page page;

    public ForbiddenPageObjectModel(Page page) {
        this.page = page;
    }

    public boolean isForbiddenPageHidden(){
        try{
            page.locator(errorStatusCode)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.HIDDEN)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Forbidden page is displaying after user attempted a password reset: " + e.getMessage());
            return false;
        }
    }
}