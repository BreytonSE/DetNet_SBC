package com.detnet.stepdefinitions.dashBoard;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.pageObjects.DeviceSummaryPageObjectModel;
import com.detnet.utilities.EmailUtils;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DashboardValidation;
import com.detnet.validations.blastWebValidations.DeviceSummaryValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

import java.util.Arrays;
import java.util.List;

//   Scenario: Verify that device that are in the "Ready to Arm" state will be armed
public class ArmingSelectedDevice_StepDefn {
    private final PageObjectManager pageObjectManager;

    public ArmingSelectedDevice_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Given("verify that the device is in a {string} state")
    public void verify_that_the_device_is_in_a_state(String expectedState) {
       DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
       dashboardPageObjectModel.viewDeviceDetails(1);

        DeviceSummaryPageObjectModel deviceSummaryPageObjectModel = pageObjectManager.getDeviceSummaryPageObjectModel();
        DeviceSummaryValidation deviceSummaryValidation = new DeviceSummaryValidation(deviceSummaryPageObjectModel);
        String currentState = deviceSummaryPageObjectModel.getCurrentDeviceState();
        System.out.println("Current state before action: " + currentState);

//        If already in 'Ready to Arm' -state, no need to send state change request
        if(expectedState.equalsIgnoreCase(currentState)){
            System.out.println("Device already in expected state: " + expectedState);
            deviceSummaryValidation.validateDeviceState(expectedState);
            SoftAssertionUtils.getSoftAssertions().assertAll();
            return;
        }

//        Else, send a device state request
        String toEmail = "breyton.ernstzen@testheroes.co.za";
        List<String> ccEmails = Arrays.asList("breytonseanernstzen1224@gmail.com");
        String deviceName = "Device 502";
        int waitMinutes = 10;

        EmailUtils.sendDeviceControlRequest(toEmail, ccEmails,deviceName,expectedState,waitMinutes);

//        Wait up to 10 minutes polling every 30 seconds
        int pollIntervalSeconds = 30;
        int maxWaitSeconds = waitMinutes * 60;
        int elapsed = 0;
        boolean stateMatched = false;

        while(elapsed < maxWaitSeconds){
            currentState = dashboardPageObjectModel.getDeviceCurrentState();
            if(expectedState.equalsIgnoreCase(currentState)){
                stateMatched = true;
                System.out.printf("Device state updated to '%s' after %d seconds.\n",expectedState,elapsed);
                break;
            }

            try{
                Thread.sleep(pollIntervalSeconds * 1000L);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                throw new RuntimeException("Polling interrupted",e);
            }
            elapsed += pollIntervalSeconds;
            System.out.printf("Waiting...(" + elapsed + "s elapsed");
        }

        if(!stateMatched){
            throw new AssertionError("Device state did not change to '" + expectedState + "'within " +
                    waitMinutes + " minutes ");
        }
    }

    @When("the user selects a device that is in the {string} state")
    public void the_user_selects_a_device_that_is_in_the_state(String expectedState) {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.goToDashboard();
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