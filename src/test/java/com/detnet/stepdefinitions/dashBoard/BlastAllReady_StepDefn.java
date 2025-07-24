package com.detnet.stepdefinitions.dashBoard;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.BlastConfirmationPageObjectModel;
import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.utilities.EmailUtils;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.BlastConfirmationValidation;
import com.detnet.validations.blastWebValidations.DashboardValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

import java.util.Arrays;
import java.util.List;

//   Scenario: Verify that the device in the "Ready to Blast" state will be presented to be blasted
public class BlastAllReady_StepDefn {
    private final PageObjectManager pageObjectManager;

    public BlastAllReady_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Given("the device is in a {string} state")
    public void the_device_is_in_a_state(String expectedState) {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);

//        Initial check before sending the request
        String currentState = dashboardPageObjectModel.getDeviceCurrentState();
        System.out.println("Current state before action: " + currentState);

//        If already in inspected state, no need to send request
        if(expectedState.equalsIgnoreCase(currentState)){
            System.out.println("Device is already in inspected state: " + expectedState);
            dashboardValidation.validateDeviceState(expectedState.toUpperCase());
            SoftAssertionUtils.getSoftAssertions().assertAll();
            return;
        }

//        Else, send the control request
        String toEmail = "breyton.ernstzen@testheroes.co.za";
        List<String> ccEmails = Arrays.asList(
                "coetseet@detnet.com",
                "maysond@detnet.com",
                "moosaa@detnet.com",
                "mbhalatil@detnet0.onmicrosoft.com");
        String deviceName = "Device 502"; // Device Id might change
        int waitMinutes = 10;

        EmailUtils.sendDeviceControlRequest(toEmail, ccEmails, deviceName, expectedState, waitMinutes);

//        Wait up to 10 minutes, polling every 30 seconds
        int pollIntervalsSeconds = 30;
        int maxWaitSeconds = waitMinutes * 60;
        int elapsed = 0;
        boolean stateMatched = false;

        while (elapsed < maxWaitSeconds){
            currentState = dashboardPageObjectModel.getDeviceCurrentState();
            if(expectedState.equalsIgnoreCase(currentState)){
                stateMatched = true;
                System.out.printf("Device state updated to '%s' after %d seconds.\n",expectedState,elapsed);
                break;
            }

            try{
                Thread.sleep(pollIntervalsSeconds * 1000L);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                throw new RuntimeException("Polling interrupted",e);
            }

            elapsed += pollIntervalsSeconds;
            System.out.println("Waiting... (" + elapsed + "s elapsed");
        }

        if(!stateMatched){
            throw new AssertionError("Device state did not change to '" + expectedState + "' within " +
                    waitMinutes + " minutes.");
        }
        dashboardValidation.validateDeviceState(expectedState.toUpperCase());
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user opens the action panel")
    public void the_user_opens_the_action_panel() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.openActionPanel();
    }

    @When("the user selects {string} from the action panel")
    public void the_user_selects_from_the_action_panel(String string) {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateBlastAllReadyOptionVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user proceeds to blast")
    public void the_user_proceeds_to_blast() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.blastAllReady();

        BlastConfirmationPageObjectModel blastConfirmationPageObjectModel = pageObjectManager.getBlastConfirmationPageObjectModel();
        BlastConfirmationValidation blastConfirmationValidation = new BlastConfirmationValidation(blastConfirmationPageObjectModel);
        blastConfirmationValidation.validateProceedButtonState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        blastConfirmationPageObjectModel.proceedToBlast();
    }

    @When("the user supplies the currently logged in user's password")
    public void the_user_supplies_the_currently_logged_in_user_s_password() {
        BlastConfirmationPageObjectModel blastConfirmationPageObjectModel = pageObjectManager.getBlastConfirmationPageObjectModel();
        BlastConfirmationValidation blastConfirmationValidation = new BlastConfirmationValidation(blastConfirmationPageObjectModel);
        blastConfirmationValidation.validatePasswordPromptWindowVisibility();
        blastConfirmationValidation.validatePasswordFieldVisibility();
        blastConfirmationValidation.validatePasswordFieldState();
        blastConfirmationValidation.validatePasswordFieldIsEmpty();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        blastConfirmationPageObjectModel.setPassword("Steven");
        blastConfirmationValidation.validateIfPasswordIsSet();
        blastConfirmationValidation.validateContinueButtonVisibility();
        blastConfirmationValidation.validateContinueButtonState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        blastConfirmationPageObjectModel.continueToBlast();
    }

    @When("the user supplies account details for another user that has rights to initiate a blast")
    public void the_user_supplies_account_details_for_another_user_that_has_rights_to_initiate_a_blast() {
        BlastConfirmationPageObjectModel blastConfirmationPageObjectModel = pageObjectManager.getBlastConfirmationPageObjectModel();
        BlastConfirmationValidation blastConfirmationValidation = new BlastConfirmationValidation(blastConfirmationPageObjectModel);
        blastConfirmationValidation.validateSuperVisorCredentialsWindowVisibility();
        blastConfirmationValidation.validateSupervisorUsernameFieldVisibility();
        blastConfirmationValidation.validateSupervisorUsernameFieldState();
        blastConfirmationValidation.validateSupervisorUsernameFieldIfEmpty();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        blastConfirmationPageObjectModel.setSuperVisorUsername("Johnathan");
        blastConfirmationValidation.validateSupervisorUsernameIsSet();
        blastConfirmationValidation.validateSupervisorPasswordFieldVisibility();
        blastConfirmationValidation.validateSupervisorPasswordFieldState();
        blastConfirmationValidation.validateSupervisorPasswordFieldIfEmpty();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        blastConfirmationPageObjectModel.setSupervisorPassword("Johnathan");
        blastConfirmationValidation.validateIfSupervisorPasswordIsSet();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the device should transition to a blasting state")
    public void the_device_should_transition_to_a_blasting_state() {
        BlastConfirmationPageObjectModel blastConfirmationPageObjectModel = pageObjectManager.getBlastConfirmationPageObjectModel();
        BlastConfirmationValidation blastConfirmationValidation = new BlastConfirmationValidation(blastConfirmationPageObjectModel);
        blastConfirmationValidation.validateStartBlastButtonState();
        blastConfirmationValidation.validateStartBlastButtonState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        blastConfirmationPageObjectModel.startBlast();
    }
}