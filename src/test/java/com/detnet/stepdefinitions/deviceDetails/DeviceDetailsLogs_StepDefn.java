package com.detnet.stepdefinitions.deviceDetails;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DeviceDetailsPageObjectModel;
import com.detnet.pageObjects.DeviceLogsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DeviceDetailsValidation;
import com.detnet.validations.blastWebValidations.DeviceLogsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that the device details logs component loads with appropriate data.
public class DeviceDetailsLogs_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DeviceDetailsLogs_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user opens the device details logs panel")
    public void the_user_opens_the_device_details_logs_panel() {
        DeviceDetailsPageObjectModel deviceDetailsPageObjectModel = pageObjectManager.getDeviceDetailsPageObjectModel();
        DeviceDetailsValidation deviceDetailsValidation = new DeviceDetailsValidation(deviceDetailsPageObjectModel);
        deviceDetailsValidation.validateLogTabVisibility();
        deviceDetailsValidation.validateLogsTabText("Logs");
        SoftAssertionUtils.getSoftAssertions().assertAll();
        deviceDetailsPageObjectModel.viewDeviceLogs();
    }

    @Then("the device logs panel should be visible with appropriate data")
    public void the_device_logs_panel_should_be_visible_with_appropriate_data() {
        DeviceLogsPageObjectModel deviceLogsPageObjectModel = pageObjectManager.getDeviceLogsPageObjectModel();
        DeviceLogsValidation deviceLogsValidation = new DeviceLogsValidation(deviceLogsPageObjectModel);
        deviceLogsValidation.validateDeviceLogsScreenVisibility();
        deviceLogsValidation.validateDeviceLogsVisibility(); // Fails. No device logs.
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}