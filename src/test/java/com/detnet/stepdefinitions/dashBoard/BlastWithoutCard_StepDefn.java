package com.detnet.stepdefinitions.dashBoard;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.utilities.EmailUtils;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DashboardValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

import java.util.Arrays;
import java.util.List;

//   Scenario: Verify that a devices in "Ready to Blast" state will be presented to be blasted without using a blast card
public class BlastWithoutCard_StepDefn {
    private final PageObjectManager pageObjectManager;

    public BlastWithoutCard_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Given("select device with id {int}")
    public void select_device_with_id(Integer int1) {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.selectOrDeselectDevice(1);
    }
    @Given("verify the device {int} is in a {string} state else send an email request")
    public void verify_the_device_is_in_a_state_else_send_an_email_request(Integer deviceId, String expectedState) {
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
        String deviceName = "Device " + deviceId; // Device Id might change
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
    @When("the user supplies their own password")
    public void the_user_supplies_their_own_password() throws InterruptedException {
        Thread.sleep(5000);

    }
    @When("the user supplies valid account credentials for another user authorized to initiate a blast")
    public void the_user_supplies_valid_account_credentials_for_another_user_authorized_to_initiate_a_blast() {

    }
    @Then("the blast card prompt window should not be displayed")
    public void the_blast_card_prompt_window_should_not_be_displayed() {

    }
}