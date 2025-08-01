package com.detnet.stepdefinitions.dashBoard;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.utilities.EmailUtils;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DashboardValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Then;

import java.util.Arrays;
import java.util.List;

//   Scenario: Verify that the device is in an UNKNOWN state when there is no communication between BCU and SBC
public class LostBCUComms_StepDefn {
    private final PageObjectManager pageObjectManager;

    public LostBCUComms_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Then("verify that the BCU is in an {string} state else send a state change request via email")
    public void verify_that_the_bcu_is_in_an_state_else_send_a_state_change_request_via_email(String expectedState) {
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
}