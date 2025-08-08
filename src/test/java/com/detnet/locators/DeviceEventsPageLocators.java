package com.detnet.locators;

public class DeviceEventsPageLocators {
    public static final String eventsHeader = "//span[@class=\"EventsHeaderTxt\"]";
    public static final String dateTableHeading = "//th[normalize-space()=\"Date\"]";
    public static final String timeTableHeading = "//th[normalize-space()=\"Time\"]";
    public static final String eventTableHeading = "//th[normalize-space()=\"Event\"]";
    public static final String paginatorPageSizeLabel = "xpath=/html[1]/body[1]/app-root[1]/device-details[1]/div[1]/div[2]/app-device-events[1]/div[1]/blastweb-spinner[1]/blastweb-zero-data[1]/mat-paginator[1]/div[1]/div[1]/div[1]/div[1]";
    public static final String paginatorRangeLabel = "//div[@class=\"mat-mdc-paginator-range-label\"]";
    public static final String fromDatePicker = "xpath=/html[1]/body[1]/app-root[1]/device-details[1]/div[1]/div[2]/app-device-events[1]/div[1]/div[2]/div[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]/mat-datetimepicker-toggle[1]/button[1]/span[4]";
    public static final String toDatePicker = "xpath=/html[1]/body[1]/app-root[1]/device-details[1]/div[1]/div[2]/app-device-events[1]/div[1]/div[2]/div[1]/div[2]/mat-form-field[1]/div[1]/div[1]/div[3]/mat-datetimepicker-toggle[1]/button[1]/span[4]";
}