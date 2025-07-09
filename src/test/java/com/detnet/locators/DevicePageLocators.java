package com.detnet.locators;

public class DevicePageLocators {
    public static final String addDeviceButton = "//button[@class=\"addBtn ng-star-inserted\"]";
    public static final String addDeviceForm = "//h2[normalize-space()=\"Add Device\"]";
    public static final String deviceIdInput = "//input[@id=\"id\"]";
    public static final String deviceLocationInput = "//input[@id=\"location\"]";
    public static final String deviceNetworkDropdown = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/add-device[1]/div[1]/form[1]/div[1]/div[1]/mat-form-field[3]/div[1]/div[2]/div[1]/mat-select[1]/div[1]/div[1]/span[1]";
    public static final String deviceNetworkPanel = "//div[@id=\"networkId-panel\"]";
    public static final String deviceNetworkInterfaceDropDown = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/add-device[1]/div[1]/form[1]/div[1]/div[1]/mat-form-field[4]/div[1]/div[2]/div[1]/mat-select[1]/div[1]/div[1]";
    public static final String deviceNetworkInterfacePanel = "//div[@id=\"method-panel\"]";
    public static final String deviceTypeField = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/add-device[1]/div[1]/form[1]/div[1]/div[1]/mat-form-field[5]/div[1]/div[2]/div[1]/mat-select[1]/div[1]/div[1]";
    public static final String deviceTypePanel = "//div[@id=\"deviceType-panel\"]";
    public static final String ipInputField = "//input[@id=\"ipAddress\"]";
    public static final String addDeviceSubmitButton = "//button[@id=\"addDeviceSubmitButton\"]//span[@class=\"mat-mdc-button-touch-target\"]";
    public static final String deviceManagerField = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/add-device[1]/div[1]/form[1]/div[1]/div[1]/mat-form-field[6]/div[1]/div[2]/div[1]/mat-select[1]/div[1]/div[1]";
    public static final String deviceManagerDropdownPanel = "//div[@id=\"managerId-panel\"]";
    public static final String parentDeviceField = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/add-device[1]/div[1]/form[1]/div[1]/div[1]/mat-form-field[7]/div[1]/div[2]/div[1]/mat-select[1]/div[1]";
    public static final String parentDeviceDropDownPanel = "//div[@id=\"parentId-panel\"]";
    public static final String deviceGroupField = "//span[normalize-space()=\"Default Group\"]";
    public static final String deviceGroupDropDown = "//div[@id=\"groupId-panel\"]";
    public static final String editIcon = "//tbody/tr[4]/td[11]/div[1]/mat-icon[1]";
    public static final String editDeviceTxt = "//h2[normalize-space()=\"Edit Device\"]";
    public static final String saveUpdates = "//button[@id=\"addDeviceSubmitButton\"]//span[@class=\"mat-mdc-button-touch-target\"]";
    public static final String searchBar = "//input[@placeholder=\"Search using ID, Location, IP\"]";
    public static final String deleteIcon = "(//span[@class='mat-mdc-tooltip-trigger material-symbols-outlined ng-star-inserted'][normalize-space()='delete'])[1]";
    public static final String deleteDialog = "//blastweb-confirmation-dialog[@class=\"ng-star-inserted\"]";
    public static final String yesButton = "//button[@class=\"yesBtn\"]";
    public static final String selectAllCheckbox = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-devices[1]/blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/table[1]/thead[1]/tr[1]/th[1]/mat-checkbox[1]/div[1]/div[1]/input[1]";
    public static final String deleteAllButton = "//button[@class=\"deleteAllBtn\"]";
}