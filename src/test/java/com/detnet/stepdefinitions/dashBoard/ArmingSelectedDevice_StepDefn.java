package com.detnet.stepdefinitions.dashBoard;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DashboardValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that device that are in the "Ready to Arm" state will be armed
public class ArmingSelectedDevice_StepDefn {
    private final PageObjectManager pageObjectManager;

    public ArmingSelectedDevice_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user selects a device that is in the {string} state")
    public void the_user_selects_a_device_that_is_in_the_state(String string) {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.selectOrDeselectDevice(1);
    }

    @When("the user opens the action panel and selects {string}")
    public void the_user_opens_the_action_panel_and_selects(String string) {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validatePlusIconVisibility();
        dashboardValidation.validatePlusIconState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        dashboardPageObjectModel.openActionPanel();
        dashboardValidation.validateActionPanelVisibility();
        dashboardValidation.validateArmSelectedButtonVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        dashboardPageObjectModel.armSelectedDevice();
    }

    @Then("the device should be presented for arming without any errors")
    public void the_device_should_be_presented_for_arming_without_any_errors() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateIfDeviceIsReadyToBlast();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}