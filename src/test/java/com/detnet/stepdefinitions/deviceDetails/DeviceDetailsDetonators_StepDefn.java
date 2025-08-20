package com.detnet.stepdefinitions.deviceDetails;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DeviceDetailsPageObjectModel;
import com.detnet.pageObjects.DeviceDetonatorsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DeviceDetailsValidation;
import com.detnet.validations.blastWebValidations.DeviceDetonatorsValidations;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that the device details detonators are displayed when user request for detonators
public class DeviceDetailsDetonators_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DeviceDetailsDetonators_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user navigates to the device details detonators page")
    public void the_user_navigates_to_the_device_details_detonators_page() {
        DeviceDetailsPageObjectModel deviceDetailsPageObjectModel = pageObjectManager.getDeviceDetailsPageObjectModel();
        DeviceDetailsValidation deviceDetailsValidation = new DeviceDetailsValidation(deviceDetailsPageObjectModel);
        deviceDetailsValidation.validateDetonatorsTabVisibility();
        deviceDetailsValidation.validateDetonatorsTabText("Detonators");
        SoftAssertionUtils.getSoftAssertions().assertAll();
        deviceDetailsPageObjectModel.openDeviceDetonatorsPage();
    }

    @Then("the device details detonators page should be displayed")
    public void the_device_details_detonators_page_should_be_displayed() {
        DeviceDetonatorsPageObjectModel deviceDetonatorsPageObjectModel = pageObjectManager.getDeviceDetonatorsPageObjectModel();
        DeviceDetonatorsValidations deviceDetonatorsValidations = new DeviceDetonatorsValidations(deviceDetonatorsPageObjectModel);
        deviceDetonatorsValidations.validateDetonatorsPageVisibility();
        deviceDetonatorsValidations.validateDetonatorsPageURL("http://localhost:8080/en/device-details/502/detonators");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user request for detonators")
    public void the_user_request_for_detonators() {
        DeviceDetonatorsPageObjectModel deviceDetonatorsPageObjectModel = pageObjectManager.getDeviceDetonatorsPageObjectModel();
        DeviceDetonatorsValidations deviceDetonatorsValidations = new DeviceDetonatorsValidations(deviceDetonatorsPageObjectModel);
        deviceDetonatorsValidations.validateDetonatorRequestButtonVisibility();
        deviceDetonatorsValidations.validateDetonatorRequestButtonState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        deviceDetonatorsPageObjectModel.requestDetonators();
    }

    @Then("a list of detonators should be displayed")
    public void a_list_of_detonators_should_be_displayed() {
        DeviceDetonatorsPageObjectModel deviceDetonatorsPageObjectModel = pageObjectManager.getDeviceDetonatorsPageObjectModel();
        DeviceDetonatorsValidations deviceDetonatorsValidations = new DeviceDetonatorsValidations(deviceDetonatorsPageObjectModel);
        deviceDetonatorsValidations.validateDetonatorRequestSnackBarVisibility();
        deviceDetonatorsValidations.validateIfDetonatorsFound();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}