package com.detnet.locators;

public class NetworkPageLocators {
    public static final String addNetworkButton = "//button[@class='addBtn ng-star-inserted']//span[contains(text(),'Add Network')]";
    public static final String network = "//tr[@class='mat-mdc-row mdc-data-table__row cdk-row ng-star-inserted']";
    public static final String networkLabel = "//h2[normalize-space()='Networks']";
    public static final String networkName = "//td[normalize-space()='ETHER001-DUMMY']";
    public static final String resourceNameInputField = "//input[@id='addNetworkResourceName']";
    public static final String messageGapInputField = "//input[@id='networkMessageGap']";
    public static final String delayInputField = "//input[@id='networkDelay']";
    public static final String baudRateInputField = "//input[@id='baudRate']";
    public static final String reportDetonatorsLabel = "//label[normalize-space()='Report Detonators']";
    public static final String inUseLabel = "//label[normalize-space()='In Use']";
    public static final String saveNewNetwork = "//button[@id='addNetworkSubmitButton']//span[@class='mat-mdc-button-touch-target']";
    public static final String newNetworkPath = "//td[normalize-space()=\"Ethernet\"]";
    public static final String editIcon = "tbody tr:nth-child(2) td:nth-child(8) mat-icon:nth-child(1)";
    public static final String saveButton2 = "//button[@type='submit']//span[@class='mat-mdc-button-persistent-ripple mdc-button__ripple']";
    public static final String deleteIcon = "//tbody/tr[1]/td[8]/span[1]";
    public static final String yesButton = ".yesBtn";
    public static final String selectAllCheckBox = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-networks[1]/blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/table[1]/thead[1]/tr[1]/th[1]/mat-checkbox[1]/div[1]/div[1]/input[1]";
    public static final String searchBar = "//input[@placeholder=\"Search using ID, Name\"]";
    public static final String deleteDialog = "//div[@class=\"mat-mdc-dialog-surface mdc-dialog__surface\"]";
    public static final String deleteAllBtn = "//button[@class=\"deleteAllBtn\"]";
}