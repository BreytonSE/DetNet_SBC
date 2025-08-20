package com.detnet.locators;

public class DeviceDetonatorsPageLocators {
    public static final String deviceDetonatorsHeading = "//span[normalize-space()=\"Device Detonator\"]";
    public static final String detonatorRequestButton = "//span[contains(text(),\"Request Detonators\")]";
    public static final String detonatorsRequestSnackBarLabel = "//div[@class=\"mat-mdc-snack-bar-label mdc-snackbar__label\"]";
    public static final String detonatorsList = "//table[@role=\"table\"]";
    public static final String noDetonatorsFoundElement = "//blastweb-zero-data[@description=\"Device Detonators Not Found\"]";
}
