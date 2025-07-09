package com.detnet.locators;

public class EmailRecipientsPageLocators {
    public static final String recipientListHeading = "//h2[normalize-space()=\"Recipient List\"]";
    public static final String noRecipientsText = "//h2[normalize-space()=\"No Recipient Present\"]";
    public static final String addRecipientBtn = "//button[@class=\"addBtn ng-star-inserted\"]";
    public static final String addRecipientHeading = "//h2[normalize-space()=\"Add Recipient\"]";
    public static final String emailAddressField = "//input[@id=\"addRecipientEmail\"]";
    public static final String firstNameField = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/app-add-email[1]/div[1]/div[1]/div[1]/form[1]/mat-form-field[2]/div[1]/div[2]/div[1]/label[1]/mat-label[1]";
    public static final String lastNameField = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/app-add-email[1]/div[1]/div[1]/div[1]/form[1]/mat-form-field[3]/div[1]/div[2]/div[1]/input[1]";
    public static final String severityLevel = "//div[@fxlayout=\"column\"]//div[@fxlayout=\"row\"]";
    public static final String moderateSeverityElement = "//label[normalize-space()=\"Moderate\"]";
    public static final String addRecipientButton = "//button[@id=\"addRecipientSubmitButton\"]//span[@class=\"mat-mdc-button-touch-target\"]";
    public static final String editIcon = "(//mat-icon[@role='img'][normalize-space()='edit'])[2]";
    public static final String editRecipientHeading = "//h2[normalize-space()=\"Edit Recipient\"]";
    public static final String editRecipientSubmitBtn = "//button[@id=\"editRecipientSubmitButton\"]//span[@class=\"mat-mdc-button-touch-target\"]";
    public static final String searchBar = "//input[@placeholder=\"Search using Username, First Name, Last Name\"]";
    public static final String intervalDropDown = "//mat-icon[normalize-space()=\"timer\"]";
    public static final String intervalDropDownPanel = "//div[@id=\"minutes-panel\"]";
    public static final String deleteDialog = "//div[@class=\"mat-mdc-dialog-surface mdc-dialog__surface\"]";
    public static final String yesButton = "//button[@class=\"yesBtn\"]";
    public static final String checkBox = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/app-email-recipient[1]/blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/table[1]/thead[1]/tr[1]/th[1]/mat-checkbox[1]/div[1]/div[1]/input[1]";
    public static final String deleteAllButton = "//button[@class=\"deleteAllBtn\"]";
}