package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SettingsPageObjectModel {
    private final Page page;
    private final String settingsLabel = "//h2[normalize-space()='Settings']";
    private final String blastCardsButton = "//span[contains(text(),'Blast Cards')]";
    private final String usersButton = "//span[@class='mat-button-toggle-label-content']//span[contains(text(),'Users')]";
    private final String networksButton = "//span[@class='mat-button-toggle-label-content']//span[contains(text(),'Networks')]";
    private final String devicesTab = "//span[@class=\"mat-button-toggle-label-content\"]//span[contains(text(),\"Devices\")]";
    private final String networkTreeTab = "//span[contains(text(),\"Network Tree\")]";
    private final String groupsTab = "//span[@class=\"mat-button-toggle-label-content\"]//span[contains(text(),\"Groups\")]";

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

    public boolean isNetworksTabPresent(){
        return page.locator(networksButton).isVisible();
    }

    public void goToNetworks(){
        page.locator(networksButton).click();
    }

    public boolean isDeviceTabPresent(){
        return page.locator(devicesTab).isVisible();
    }

    public boolean isDeviceTabEnabled(){
        return page.locator(devicesTab).isEnabled();
    }

    public String getDeviceTabText(){
        return page.locator(devicesTab).textContent();
    }

    public void viewDevices(){
        page.locator(devicesTab).click();
    }

    public boolean isNetworkTreeTabVisible(){
        return page.locator(networkTreeTab).isVisible();
    }

    public String getNetworkTreeText(){
        return page.locator(networkTreeTab).textContent();
    }

    public void openNetworkTree(){
        page.locator(networkTreeTab).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isGroupsTabVisible(){
         return page.locator(groupsTab).isVisible();
    }

    public String getGroupsTabText(){
        return page.locator(groupsTab).textContent();
    }

    public void openGroups(){
        page.locator(groupsTab).click(new Locator.ClickOptions().setTimeout(5000));
    }
}