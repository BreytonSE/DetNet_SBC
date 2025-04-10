package com.detnet.pageObjects;

import com.microsoft.playwright.Page;

public class SettingsPageObjectModel {
    private final Page page;
    private final String settingsLabel = "//h2[normalize-space()='Settings']";
    private final String blastCardsButton = "//span[contains(text(),'Blast Cards')]";

    public SettingsPageObjectModel(Page page) {
        this.page = page;
    }

    public String getSettingsURL(){
        page.waitForURL("**/settings/networks");
        return page.url();
    }

    public boolean isSettingsLabelVisible(){
        return page.locator(settingsLabel).isVisible();
    }

    public String getSettingsLabel(){
        return page.locator(settingsLabel).textContent();
    }

    public boolean isBlastCardButtonVisible(){
        return page.locator(blastCardsButton).isVisible();
    }

    public boolean isBlastCardButtonEnabled(){
        return page.locator(blastCardsButton).isEnabled();
    }

    public void viewActiveBlastCards(){
        page.locator(blastCardsButton).click();
    }
}