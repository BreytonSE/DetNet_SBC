package com.detnet.stepdefinitions.deviceManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DevicePageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DeviceValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.*;

//   Scenario: Verify that devices can be deleted from the device view list
public class DeleteDevices_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DeleteDevices_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user clicks on the delete icon to delete a single device")
    public void the_user_clicks_on_the_delete_icon_to_delete_a_single_device() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        deviceValidation.validateDeleteIconVisibility();
        deviceValidation.validateDeleteIconState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        devicePageObjectModel.openDeleteDialog();
    }
    @Then("the device delete confirmation dialog should be displayed")
    public void the_device_delete_confirmation_dialog_should_be_displayed() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        deviceValidation.validateDeleteDialogVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user confirms deletion of the single device")
    public void the_user_confirms_deletion_of_the_single_device() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        devicePageObjectModel.confirmDelete();
    }
    @Then("the device should be removed from the list")
    public void the_device_should_be_removed_from_the_list() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        deviceValidation.validateIfDeviceIsDeleted(1);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the checkboxes for device selection should be visible")
    public void the_checkboxes_for_device_selection_should_be_visible() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        deviceValidation.validateSelectAllCheckboxVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user selects all devices using the header checkbox")
    public void the_user_selects_all_devices_using_the_header_checkbox() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        deviceValidation.validateCheckboxState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        devicePageObjectModel.selectAllDevices();
    }
    @When("the user deselects specific devices from the bulk delete selection")
    public void the_user_deselects_specific_devices_from_the_bulk_delete_selection() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        devicePageObjectModel.selectOrDeselectDevices(3);
        devicePageObjectModel.selectOrDeselectDevices(4);
    }
    @When("the user clicks the Delete Devices button")
    public void the_user_clicks_the_delete_devices_button() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        deviceValidation.validateDeleteAllButtonVisibility();
        deviceValidation.validateDeleteAllButtonState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        devicePageObjectModel.deleteSelectedDevices();
        devicePageObjectModel.confirmDelete();
    }
    @Then("the selected devices should be deleted and removed from the list")
    public void the_selected_devices_should_be_deleted_and_removed_from_the_list() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        deviceValidation.validateIfDeviceIsDeleted(1);
        deviceValidation.validateIfDeviceIsDeleted(3);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}