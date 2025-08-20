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

// Scenario: Verify the expiration countdown window period for the 'Ready to Blast' command
public class CountDownTimerTX_StepDefn {
    private final PageObjectManager pageObjectManager;

    public CountDownTimerTX_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Given("the device is in {string} state or a request is made for a state change")
    public void the_device_is_in_state_or_a_request_is_made_for_a_state_change(String expectedState) {
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

    @When("the user selects the wireless device to arm")
    public void the_user_selects_the_wireless_device_to_arm() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.selectOrDeselectDevice(1);
    }

    @When("the user clicks on {string}")
    public void the_user_clicks_on(String string) {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateIfArmWirelessOptionIsAvailable();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        dashboardPageObjectModel.armWirelessSelected();
    }

    @Then("the device state should change to {string}")
    public void the_device_state_should_change_to(String expectedState) {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateDeviceState(expectedState);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("then change to {string}")
    public void then_change_to(String expectedState) throws InterruptedException {
        Thread.sleep(5000);
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateDeviceState(expectedState);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the countdown window period should be displayed")
    public void the_countdown_window_period_should_be_displayed() {
//       TODO: Verify that the countdown window is displayed
    }

    @Then("the device state should revert to {string} after the window period expires")
    public void the_device_state_should_revert_to_after_the_window_period_expires(String expectedState) {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateDeviceState(expectedState);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}