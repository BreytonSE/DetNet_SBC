package com.detnet.stepdefinitions.deviceDetails;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DeviceDetailsPageObjectModel;
import com.detnet.pageObjects.DeviceEventsPageObjectModel;
import com.detnet.pageObjects.DeviceLogsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DeviceEventsValidations;
import com.detnet.validations.blastWebValidations.DeviceLogsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

import java.util.Random;

//   Scenario: Verify that the device details logs component can request a log
public class DeviceDetailsLogRequest_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DeviceDetailsLogRequest_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user modifies the datetime filters for logs")
    public void the_user_modifies_the_datetime_filters_for_logs() {
//        DeviceLogsPageObjectModel deviceLogsPageObjectModel = pageObjectManager.getDeviceLogsPageObjectModel();
//        DeviceLogsValidation deviceLogsValidation = new DeviceLogsValidation(deviceLogsPageObjectModel);
//        deviceLogsValidation.validateLogsFromDatePickerVisibility();
//        SoftAssertionUtils.getSoftAssertions().assertAll();
//
//        deviceLogsPageObjectModel.openFromDatePicker();
//
//        deviceLogsValidation.validateFromDatePickerWindowIsOpen();
//        SoftAssertionUtils.getSoftAssertions().assertAll();
//
//        deviceLogsPageObjectModel.goToPreviousMonth();
//        int randomDay = new Random().nextInt(30) + 1;
//        deviceLogsPageObjectModel.selectDay(randomDay);
//        deviceLogsValidation.validateClockVisibility();
//        SoftAssertionUtils.getSoftAssertions().assertAll();
//        for (int i=0;i<2;i++){
//            deviceLogsPageObjectModel.selectTime();
//        }
//        deviceLogsValidation.validateToDatePickerVisibility();
//        SoftAssertionUtils.getSoftAssertions().assertAll();
//        deviceLogsPageObjectModel.openToDatePicker();
//        deviceLogsPageObjectModel.selectDay(randomDay);
//        deviceLogsValidation.validateClockVisibility();
//        SoftAssertionUtils.getSoftAssertions().assertAll();
//        for (int i=0;i<2;i++){
//            deviceLogsPageObjectModel.selectTime();
//        }
    }

    @When("the user modifies the category filters for logs")
    public void the_user_modifies_the_category_filters_for_logs() throws InterruptedException {
        DeviceLogsPageObjectModel deviceLogsPageObjectModel = pageObjectManager.getDeviceLogsPageObjectModel();
        DeviceLogsValidation deviceLogsValidation = new DeviceLogsValidation(deviceLogsPageObjectModel);
        deviceLogsValidation.validateLogCategoryPickerVisibility();
        deviceLogsValidation.validateLogCategoryPickerState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        deviceLogsPageObjectModel.openLogCategoryDropDown();
        deviceLogsValidation.validateCategoryDropDownVisibility();
        deviceLogsPageObjectModel.selectLogCategory(1);
    }

    @When("the user requests a log from the device")
    public void the_user_requests_a_log_from_the_device() {
        DeviceLogsPageObjectModel deviceLogsPageObjectModel = pageObjectManager.getDeviceLogsPageObjectModel();
        DeviceLogsValidation deviceLogsValidation = new DeviceLogsValidation(deviceLogsPageObjectModel);
        deviceLogsValidation.validateLogRequestButtonVisibility();
        deviceLogsValidation.validateLogRequestButtonState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        deviceLogsPageObjectModel.requestLog();
    }

    @Then("a notification should be displayed confirming the log request")
    public void a_notification_should_be_displayed_confirming_the_log_request() {
        DeviceLogsPageObjectModel deviceLogsPageObjectModel = pageObjectManager.getDeviceLogsPageObjectModel();
        DeviceLogsValidation deviceLogsValidation = new DeviceLogsValidation(deviceLogsPageObjectModel);
        deviceLogsValidation.validateDeviceLogsLoaderLabelVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the events page should show an entry indicating the log request")
    public void the_events_page_should_show_an_entry_indicating_the_log_request() {
        DeviceDetailsPageObjectModel deviceDetailsPageObjectModel = pageObjectManager.getDeviceDetailsPageObjectModel();
        deviceDetailsPageObjectModel.viewDeviceEvents();

        DeviceEventsPageObjectModel deviceEventsPageObjectModel = pageObjectManager.getDeviceEventsPageObjectModel();
        DeviceEventsValidations deviceEventsValidations = new DeviceEventsValidations(deviceEventsPageObjectModel);
        deviceEventsValidations.validateEventVisibility();
        deviceEventsValidations.validateDeviceLogsVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}