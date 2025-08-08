package com.detnet.stepdefinitions.deviceDetails;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DeviceDetailsPageObjectModel;
import com.detnet.pageObjects.DeviceEventsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DeviceEventsValidations;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

import java.util.Random;

//   Scenario: Verify that the device details events components loads with appropriate data
public class DeviceDetailsEvents_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DeviceDetailsEvents_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user navigates to the device details events page")
    public void the_user_navigates_to_the_device_details_events_page() {
        DeviceDetailsPageObjectModel deviceDetailsPageObjectModel = pageObjectManager.getDeviceDetailsPageObjectModel();
        deviceDetailsPageObjectModel.viewDeviceEvents();
    }

    @Then("the device details events should display meaningful data without errors")
    public void the_device_details_events_should_display_meaningful_data_without_errors() {
        DeviceEventsPageObjectModel deviceEventsPageObjectModel = pageObjectManager.getDeviceEventsPageObjectModel();
        DeviceEventsValidations deviceEventsValidations = new DeviceEventsValidations(deviceEventsPageObjectModel);
        deviceEventsValidations.validateEventsPageVisibility();
        deviceEventsValidations.validateEventsTimeVisibility();
        deviceEventsValidations.validateEventDateVisibility();
        deviceEventsValidations.validateEventVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the events should be paginated")
    public void the_events_should_be_paginated() {
        DeviceEventsPageObjectModel deviceEventsPageObjectModel = pageObjectManager.getDeviceEventsPageObjectModel();
        DeviceEventsValidations deviceEventsValidations = new DeviceEventsValidations(deviceEventsPageObjectModel);
        deviceEventsValidations.validateIfEventsPageIsPaginated();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the user should be able to filter events by date")
    public void the_user_should_be_able_to_filter_events_by_date() {
        DeviceEventsPageObjectModel deviceEventsPageObjectModel = pageObjectManager.getDeviceEventsPageObjectModel();
        DeviceEventsValidations deviceEventsValidations = new DeviceEventsValidations(deviceEventsPageObjectModel);
        deviceEventsValidations.validateFromDatePickerButtonVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        deviceEventsPageObjectModel.openFromDatePicker();
        deviceEventsValidations.validateIfFromDatePickerWindowIsOpen();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        int randomDay = new Random().nextInt(30) + 1;
        deviceEventsPageObjectModel.selectDate(randomDay);
//        TODO: Finish off
    }
}