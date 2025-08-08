package com.detnet.locators;

public class DeviceLogsPageLocators {
    public static final String deviceLogsText = "//span[@class=\"deviceLogsTxt\"]";
    public static final String noDeviceLogsText = "//h2[normalize-space()=\"Device Logs Not Found\"]";
    public static final String fromDatePicker = "xpath=/html[1]/body[1]/app-root[1]/device-details[1]/div[1]/div[2]/app-device-logs[1]/div[1]/div[2]/div[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]/mat-datetimepicker-toggle[1]/button[1]/span[4]";
    public static final String toDatePicker = "xpath=/html[1]/body[1]/app-root[1]/device-details[1]/div[1]/div[2]/app-device-logs[1]/div[1]/div[2]/div[1]/div[2]/mat-form-field[1]/div[1]/div[1]/div[3]/mat-datetimepicker-toggle[1]/button[1]/span[4]";
    public static final String fromDatePickerWindow = "xpath=/html[1]/body[1]/div[2]/div[2]/div[1]/mat-datetimepicker-content[1]/mat-datetimepicker-calendar[1]/div[2]/mat-datetimepicker-month-view[1]";
    public static final String previousMonthArrow = "//div[@aria-label=\"Previous month\"]//*[name()=\"svg\"]";
    public static final String clock = "//mat-datetimepicker-clock[@role=\"clock\"]";
    public static final String logCategoryPicker = "xpath=/html[1]/body[1]/app-root[1]/device-details[1]/div[1]/div[2]/app-device-logs[1]/div[1]/div[2]/div[1]/div[3]/mat-form-field[1]/div[1]/div[1]/div[2]";
    public static final String logCategoryDropDown = "xpath=/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]";
}