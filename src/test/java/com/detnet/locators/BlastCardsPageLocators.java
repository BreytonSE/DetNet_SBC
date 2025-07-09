package com.detnet.locators;

public class BlastCardsPageLocators {
    public static final String activeCardsLabel = "//h2[normalize-space()='Active Cards']";
    public static final String addBlastCardsButton = "//button[@class='addBtn ng-star-inserted']//span[contains(text(),'Add Blast Card')]";
    public static final String archiveCardsButton = "//button[@class='disableThirdBtn ng-star-inserted']//span[contains(text(),'Archive Cards')]";
    public static final String archivedCardsButton = "//span[normalize-space()='Archived Cards']";
    public static final String blastCardAlertWindow = "//div[@class='mat-mdc-dialog-surface mdc-dialog__surface']";
    public static final String closeIcon = "//span[normalize-space()='highlight_off']";
    public static final String archiveCardsLabel = "//h2[normalize-space()='Archive Cards']";
    public static final String deleteCardsButton = "//button[@class='disableDeleteAllBtn']//span[contains(text(),'Delete Cards')]";
    public static final String searchBar = "//input[@placeholder='Search using Serial Number, Key Type, Updated Date']";
    public static final String searchButton = "//mat-icon[normalize-space()='search']";
}