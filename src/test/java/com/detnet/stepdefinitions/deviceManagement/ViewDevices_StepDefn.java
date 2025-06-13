package com.detnet.stepdefinitions.deviceManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DevicePageObjectModel;
import com.detnet.pageObjects.SettingsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DeviceValidation;
import com.detnet.validations.blastWebValidations.SettingsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify devices can be viewed
public class ViewDevices_StepDefn {
    private final PageObjectManager pageObjectManager;

    public ViewDevices_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user navigates to the Devices section")
    public void the_user_navigates_to_the_devices_section() {
        SettingsPageObjectModel settingsPageObjectModel = pageObjectManager.getSettingsPageObjectModel();
        SettingsValidation settingsValidation = new SettingsValidation(settingsPageObjectModel);
        settingsValidation.validateDevicesTabVisibility();
        settingsValidation.validateDeviceTabState();
        settingsValidation.validateDevicesTabText("Devices");
        settingsPageObjectModel.viewDevices();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the user should see all system devices listed without errors")
    public void the_user_should_see_all_system_devices_listed_without_errors() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        deviceValidation.validateDeviceListVisibility(1);
        deviceValidation.validateDeviceListVisibility(2);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}