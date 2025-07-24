package com.detnet.stepdefinitions.dashBoard;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DashboardValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that a BCU connected to a wireless system will be armed
public class ArmWireless_StepDefn {
    private final PageObjectManager pageObjectManager;

    public ArmWireless_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user opens the action panel and selects Arm Wireless Selected")
    public void the_user_opens_the_action_panel_and_selects_arm_wireless_selected() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardPageObjectModel.openActionPanel();
        dashboardValidation.validateIfArmWirelessOptionIsAvailable();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        dashboardPageObjectModel.armWirelessSelected();
    }

    @When("the user selects the blast group associated with the blast and confirms")
    public void the_user_selects_the_blast_group_associated_with_the_blast_and_confirms() throws InterruptedException {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateCyberDetDialogVisibility();
        dashboardValidation.validateBlastGroupDropDownVisibility();
        dashboardValidation.validateBlastGroupDropDownState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        dashboardPageObjectModel.openBlastGroupDropDown();
        dashboardPageObjectModel.selectBlastGroup("Test Group 2");
    }

    @When("the user clicks the re-blast checkbox")
    public void the_user_clicks_the_re_blast_checkbox() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateReBlastCheckBoxVisibility();
        dashboardValidation.validateReBlastCheckBoxState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        dashboardPageObjectModel.reBlastDevice();
        dashboardValidation.validateIfDeviceIsSelectedForReBlast();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user clicks the OK button")
    public void the_user_clicks_the_ok_button() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateCyberDetOkButtonVisible();
        dashboardValidation.validateCyberDetOkButtonState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        dashboardPageObjectModel.applyBlastGroupToDevice();
    }

    @Then("the device should be successfully armed with a wireless channel")
    public void the_device_should_be_successfully_armed_with_a_wireless_channel() {
//        TODO: The device should be successfully armed with wireless channel
    }

    @Then("the device state should be {string} if re-blast checkbox is checked, otherwise it should remain as {string}")
    public void the_device_state_should_be_if_re_blast_checkbox_is_checked_otherwise_it_should_remain_as(String string, String string2) {
//        TODO: The device state should be in 'Ready to Arm' -state if re-blast checkbox is checked, else it would remain as 'Blasted'
    }
}