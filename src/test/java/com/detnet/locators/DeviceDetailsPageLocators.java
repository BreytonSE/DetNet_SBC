package com.detnet.locators;

public class DeviceDetailsPageLocators {
    public static final String deviceStatusColumn = "(//mat-toolbar[@class='mat-toolbar summary-div-header mat-toolbar-single-row'])[1]";
    public static final String deviceDetailsAndConfigColumn = "(//mat-toolbar[@class='mat-toolbar summary-div-header mat-toolbar-single-row'])[2]";
    public static final String deviceStatisticsColumn = "(//mat-toolbar[@class='mat-toolbar summary-div-header mat-toolbar-single-row'])[3]";
    public static final String deviceAuxiliaryRelaysColumn = "(//mat-toolbar[@class='mat-toolbar summary-div-header mat-toolbar-single-row'])[4]";
    public static final String bcuBlastKeyColumn = "(//mat-toolbar[@class='mat-toolbar summary-div-header mat-toolbar-single-row'])[5]";
    public static final String eventsTab = "//span[normalize-space()=\"Events\"]";
    public static final String channelsTab = "//span[@class=\"titlecase\"][normalize-space()=\"Channels\"]";
    public static final String logsTab = "//span[normalize-space()=\"Logs\"]";
    public static final String commentsTab = "//span[@class=\"mat-button-toggle-label-content\"]//span[contains(text(),\"Comments\")]";
    public static final String detonatorsTab = "//span[normalize-space()=\"Detonators\"]";
}