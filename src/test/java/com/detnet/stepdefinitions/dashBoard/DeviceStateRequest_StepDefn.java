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

public class DeviceStateRequest_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DeviceStateRequest_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user views the device details")
    public void the_user_views_the_device_details() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.viewDeviceDetails(1);
    }
    @When("the device state is not already {string}")
    public void the_device_state_is_not_already(String string) {
        DeviceSummaryPageObjectModel deviceSummaryPageObjectModel = pageObjectManager.getDeviceSummaryPageObjectModel();
        DeviceSummaryValidation deviceSummaryValidation = new DeviceSummaryValidation(deviceSummaryPageObjectModel);
        deviceSummaryPageObjectModel.getCurrentDeviceState();
        deviceSummaryValidation.validateDeviceCurrentState("Ready to Arm");
        SoftAssertionUtils.getSoftAssertions().assertAll();

    }

    @When("the device by firmware and sort by descending")
    public void the_device_by_firmware_and_sort_by_descending() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardPageObjectModel.goToDashboard();
        dashboardPageObjectModel.openGroupByDropDown();
        dashboardPageObjectModel.selectGroupByOption("Firmware");
        dashboardValidation.validateIfDeviceGroupedByFirmware();
        dashboardValidation.validateSortByDropDownVisibility();
        dashboardValidation.validateSortByDropDownState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        dashboardPageObjectModel.openSortByDropDown();
        dashboardPageObjectModel.sortBy("Descending");
    }

    @Then("the user sends a device state change request to set it to {string}")
    public void the_user_sends_a_device_state_change_request_to_set_it_to(String expectedState) {
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