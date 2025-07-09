package com.detnet.stepdefinitions.dashBoard;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.BlastConfirmationPageObjectModel;
import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.pageObjects.DeviceSummaryPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.BlastConfirmationValidation;
import com.detnet.validations.blastWebValidations.DashboardValidation;
import com.detnet.validations.blastWebValidations.DeviceSummaryValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that device in "Ready to Blast" -state will be presented to be blasted
public class BlastSelectedDevice_StepDefn {
    private final PageObjectManager pageObjectManager;

    public BlastSelectedDevice_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user selects a device that is in the Ready to Blast state")
    public void the_user_selects_a_device_that_is_in_the_ready_to_blast_state() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.viewDeviceDetails(1);

        DeviceSummaryPageObjectModel deviceSummaryPageObjectModel = pageObjectManager.getDeviceSummaryPageObjectModel();
        DeviceSummaryValidation deviceSummaryValidation = new DeviceSummaryValidation(deviceSummaryPageObjectModel);
        deviceSummaryValidation.validateDeviceCurrentState("Ready to blast");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        dashboardPageObjectModel.goToDashboard();
        dashboardPageObjectModel.selectOrDeselectDevice(1);
    }

    @When("the user opens the action panel and selects Blast Selected")
    public void the_user_opens_the_action_panel_and_selects_blast_selected() throws InterruptedException {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardPageObjectModel.openActionPanel();
        dashboardValidation.validateBlastSelectedOptionVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        dashboardPageObjectModel.blastSelectDevice();
    }

    @Then("the blast confirmation screen should be displayed")
    public void the_blast_confirmation_screen_should_be_displayed() {
        BlastConfirmationPageObjectModel blastConfirmationPageObjectModel = pageObjectManager.getBlastConfirmationPageObjectModel();
        BlastConfirmationValidation blastConfirmationValidation = new BlastConfirmationValidation(blastConfirmationPageObjectModel);
        blastConfirmationValidation.validateBlastConfirmationPageURL("http://localhost:8080/en/blast");
        blastConfirmationValidation.validateBlastConfirmationPageVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the user clicks the {string} button")
    public void the_user_clicks_the_button(String string) {
        BlastConfirmationPageObjectModel blastConfirmationPageObjectModel = pageObjectManager.getBlastConfirmationPageObjectModel();
        BlastConfirmationValidation blastConfirmationValidation = new BlastConfirmationValidation(blastConfirmationPageObjectModel);
        blastConfirmationValidation.validateProceedButtonVisibility();
        blastConfirmationValidation.validateProceedButtonState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        blastConfirmationPageObjectModel.proceedToBlast();
        blastConfirmationValidation.validateNFCReaderConfirmationDialogVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}