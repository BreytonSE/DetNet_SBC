package com.detnet.locators;

public class SettingsPageLocators {
    public static final String settingsLabel = "//h2[normalize-space()='Settings']";
    public static final String blastCardsButton = "//span[contains(text(),'Blast Cards')]";
    public static final String usersButton = "//span[@class='mat-button-toggle-label-content']//span[contains(text(),'Users')]";
    public static final String networksButton = "//span[@class='mat-button-toggle-label-content']//span[contains(text(),'Networks')]";
    public static final String devicesTab = "//span[@class=\"mat-button-toggle-label-content\"]//span[contains(text(),\"Devices\")]";
    public static final String networkTreeTab = "//span[contains(text(),\"Network Tree\")]";
    public static final String groupsTab = "//span[@class=\"mat-button-toggle-label-content\"]//span[contains(text(),\"Groups\")]";
    public static final String emailRecipientsTab = "//span[normalize-space()=\"Email Recipients\"]";
}