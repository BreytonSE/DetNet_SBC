package com.detnet.stepdefinitions.dashBoard;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DashboardValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that a device in "Ready to Arm" -state will be armed using the "Arm All Ready" option from action panel
public class ArmingAllReady_StepDefn {
    private final PageObjectManager pageObjectManager;

    public ArmingAllReady_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user opens the action panel and selects Arm All Ready")
    public void the_user_opens_the_action_panel_and_selects_arm_all_ready() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardPageObjectModel.openActionPanel();
        dashboardValidation.validateArmAllReadyOptionVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        dashboardPageObjectModel.armAllReady();
    }

    @Then("the device should be successfully armed after selecting the {string} option")
    public void the_device_should_be_successfully_armed_after_selecting_the_option(String string) {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateNoDeviceToArmSnackBarVisibility();
//        TODO: Validate that devices is successfully armed
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}