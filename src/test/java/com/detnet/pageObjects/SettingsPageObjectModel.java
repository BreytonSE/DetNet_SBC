package com.detnet.pageObjects;

import com.microsoft.playwright.Page;

public class SettingsPageObjectModel {
    private final Page page;
    private final String settingsLabel = "//h2[normalize-space()='Settings']";
    private final String blastCardsButton = "//span[contains(text(),'Blast Cards')]";
    private final String usersButton = "//span[@class='mat-button-toggle-label-content']//span[contains(text(),'Users')]";

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

    public boolean isUserButtonVisible(){
        return page.locator(usersButton).isVisible();
    }

    public boolean isUserButtonEnabled(){
        return page.locator(usersButton).isEnabled();
    }

    public String getUsersLabel(){
        return page.locator(usersButton).textContent();
    }

    public void viewUsers(){
        page.locator(usersButton).click();
    }
}