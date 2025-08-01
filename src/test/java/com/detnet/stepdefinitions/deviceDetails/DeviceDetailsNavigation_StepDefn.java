package com.detnet.stepdefinitions.deviceDetails;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.pageObjects.DeviceDetailsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DeviceDetailsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that the navigation to the device details screen works correctly
public class DeviceDetailsNavigation_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DeviceDetailsNavigation_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("I select a device to view the details")
    public void i_select_a_device_to_view_the_details() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.viewDeviceDetails(1);
    }

    @Then("I verify the device summary screen is open")
    public void i_verify_the_device_summary_screen_is_open() {
        DeviceDetailsPageObjectModel deviceDetailsPageObjectModel = pageObjectManager.getDeviceDetailsPageObjectModel();
        DeviceDetailsValidation deviceDetailsValidation = new DeviceDetailsValidation(deviceDetailsPageObjectModel);
        deviceDetailsValidation.validateDeviceDetailsSummaryPageURL("http://localhost:8080/en/device-details/\\d+/summary");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}