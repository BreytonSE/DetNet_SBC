package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.detnet.locators.BlastConfirmationPageLocators.*;

public class BlastConfirmationPageObjectModel {
    private final Page page;

    public BlastConfirmationPageObjectModel(Page page) {
        this.page = page;
    }

    public String getPageURL() {
        page.waitForURL("**/blast");
        return page.url();
    }

    public boolean isBlastConfirmationScreenOpen() {
        try {
            page.locator(confirmBlastHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public boolean isProceedButtonVisible() {
        try {
            page.locator(proceedButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public boolean isProceedButtonEnabled() {
        try {
            page.locator(proceedButton).isEnabled();
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public void proceedToBlast() {
        page.locator(proceedButton).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isNFCReaderConfirmationDialogVisible() {
        try {
            page.locator(dialogTitle)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }
}