package com.detnet.stepdefinitions.dashBoard;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DeviceDetailsPageObjectModel;
import com.detnet.pageObjects.DeviceEventsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DeviceDetailsValidation;
import com.detnet.validations.blastWebValidations.DeviceEventsValidations;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that the aggregated dashboard events log is functional and shows events
public class EventsLog_StepDefn {
    private final PageObjectManager pageObjectManager;

    public EventsLog_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user navigates to the BCU events section")
    public void the_user_navigates_to_the_bcu_events_section() {
        DeviceDetailsPageObjectModel deviceDetailsPageObjectModel = pageObjectManager.getDeviceDetailsPageObjectModel();
        DeviceDetailsValidation deviceDetailsValidation = new DeviceDetailsValidation(deviceDetailsPageObjectModel);
        deviceDetailsValidation.validateEventsTabVisibility();
        deviceDetailsValidation.validateEventsTabText("Events");
        SoftAssertionUtils.getSoftAssertions().assertAll();
        deviceDetailsPageObjectModel.viewDeviceEvents();
    }

    @Then("the event date should be visible")
    public void the_event_date_should_be_visible() {
        DeviceEventsPageObjectModel deviceEventsPageObjectModel = pageObjectManager.getDeviceEventsPageObjectModel();
        DeviceEventsValidations deviceEventsValidations = new DeviceEventsValidations(deviceEventsPageObjectModel);
        deviceEventsValidations.validateEventDateVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the event time should be visible")
    public void the_event_time_should_be_visible() {
        DeviceEventsPageObjectModel deviceEventsPageObjectModel = pageObjectManager.getDeviceEventsPageObjectModel();
        DeviceEventsValidations deviceEventsValidations = new DeviceEventsValidations(deviceEventsPageObjectModel);
        deviceEventsValidations.validateEventsTimeVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}