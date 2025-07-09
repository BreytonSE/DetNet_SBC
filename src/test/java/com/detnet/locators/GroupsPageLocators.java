package com.detnet.locators;

public class GroupsPageLocators {
    public static final String groupsHeading = "//h2[normalize-space()=\"Groups\"]";
    public static final String noGroupsLabel = "//h2[normalize-space()=\"No Groups Present\"]";
    public static final String addGroupBtn = "//button[@class=\"addBtn ng-star-inserted\"]";
    public static final String addGroupHeading = "//h2[normalize-space()=\"Add Group\"]";
    public static final String groupNameInput = "//input[@id=\"name\"]";
    public static final String colorPicker = "//input[@class=\"colorPicker\"]";
    public static final String colorPickerTray = "//div[@class=\"color-picker open\"]";
    public static final String colorPickerDownArrow = "//color-picker[@class=\"ng-star-inserted\"]//span[2]";
    public static final String redInputField = "div[class=\"rgba-text ng-star-inserted\"] input:nth-child(1)";
    public static final String greenInputField = "div[class=\"rgba-text ng-star-inserted\"] input:nth-child(2)";
    public static final String blueInputField = "div[class=\"rgba-text ng-star-inserted\"] input:nth-child(3)";
    public static final String rgbField = "//div[@class=\"rgba-text ng-star-inserted\"]";
    public static final String saveGroup = "//span[contains(text(),\"Add Group\")]";
    public static final String group = "//tr[@class=\"mat-mdc-row mdc-data-table__row cdk-row ng-star-inserted\"]";
    public static final String editHeading = "//h2[normalize-space()=\"Edit Group\"]";
    public static final String updateGroupBtn = "//button[@id=\"addNetworkSubmitButton\"]//span[@class=\"mat-mdc-button-touch-target\"]";
    public static final String searchBar = "//input[@placeholder=\"Search using ID, Name\"]";
    public static final String binIcon = "(//span[@class='mat-mdc-tooltip-trigger material-symbols-outlined'][normalize-space()='delete'])[1]";
    public static final String deleteDialogWindow = "//div[@class=\"mat-mdc-dialog-surface mdc-dialog__surface\"]";
    public static final String yesButton = "//button[@class=\"yesBtn\"]";
    public static final String selectAllCheckbox = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-groups[1]/blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/table[1]/thead[1]/tr[1]/th[1]/mat-checkbox[1]/div[1]/div[1]/input[1]\n";
    public static final String deleteAllBtn = "//button[@class=\"deleteAllBtn\"]";
}