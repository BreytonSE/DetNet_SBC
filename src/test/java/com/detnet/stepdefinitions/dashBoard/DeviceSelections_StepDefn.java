package com.detnet.stepdefinitions.dashBoard;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DashboardValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that device selection and device de-selection is functional
public class DeviceSelections_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DeviceSelections_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user selects a single device checkbox")
    public void the_user_selects_a_single_device_checkbox() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateDeviceCheckboxVisibility(1);
        dashboardValidation.validateDeviceCheckBoxState(1);
        SoftAssertionUtils.getSoftAssertions().assertAll();
        dashboardPageObjectModel.selectOrDeselectDevice(1);
        dashboardValidation.validateIfDeviceIsSelected(1);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user de-selects the device checkbox")
    public void the_user_de_selects_the_device_checkbox() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardPageObjectModel.selectOrDeselectDevice(1);
        dashboardValidation.validateIfDeviceIsDeselected(1);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user selects all devices")
    public void the_user_selects_all_devices() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateSelectAllCheckboxVisibility();
        dashboardValidation.validateSelectAllCheckBoxState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        dashboardPageObjectModel.selectAllDevices();

    }
    @Then("all devices should be selected successfully")
    public void all_devices_should_be_selected_successfully() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateIfSelectAllCheckboxIsChecked();
        dashboardValidation.validateIfDeviceIsSelected(1);
        dashboardValidation.validateIfDeviceIsSelected(2);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}