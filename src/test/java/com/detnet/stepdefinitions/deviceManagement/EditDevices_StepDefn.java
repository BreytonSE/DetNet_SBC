package com.detnet.stepdefinitions.deviceManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DatabaseObjectModel;
import com.detnet.pageObjects.DevicePageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DeviceValidation;
import com.detnet.validations.databaseValidations.DatabaseDevicesValidations;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that a device can be edited, ensuring that information can be updated on the backend
public class EditDevices_StepDefn {
    private final PageObjectManager pageObjectManager;

    public EditDevices_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user clicks on the pencil icon for a device")
    public void the_user_clicks_on_the_pencil_icon_for_a_device() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        deviceValidation.validateEditIconVisibility();
        deviceValidation.validateEditIconState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        devicePageObjectModel.clickEditIcon();
    }
    @Then("the device edit page should be displayed")
    public void the_device_edit_page_should_be_displayed() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        deviceValidation.validateEditPageIsOpen();
        deviceValidation.validateEditPageURL("http://localhost:8080/en/settings/devices/502/edit");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user updates the group of the selected device")
    public void the_user_updates_the_group_of_the_selected_device() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        devicePageObjectModel.setLocation("Cape Town 1");
        devicePageObjectModel.openDeviceGroupDropDown();
        devicePageObjectModel.selectDeviceGroup("3");
        deviceValidation.validateSaveUpdateButtonVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        devicePageObjectModel.updateDeviceDetails();
    }
    @Then("the updated group should be reflected on the front end")
    public void the_updated_group_should_be_reflected_on_the_front_end() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        deviceValidation.validateDeviceGroupUpdated("Cape Town 1");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the backend should reflect the updated device group")
    public void the_backend_should_reflect_the_updated_device_group() {
        DatabaseObjectModel databaseObjectModel = new DatabaseObjectModel();
        DatabaseDevicesValidations databaseDevicesValidations = new DatabaseDevicesValidations(databaseObjectModel);
        databaseDevicesValidations.validateIfDeviceUpdatedInDatabase(502,"Cape Town 1",4);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}