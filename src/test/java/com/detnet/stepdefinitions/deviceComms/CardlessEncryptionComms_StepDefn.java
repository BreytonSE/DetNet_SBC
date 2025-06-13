package com.detnet.stepdefinitions.deviceComms;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.pageObjects.DevicePageObjectModel;
import com.detnet.pageObjects.DeviceSummaryPageObjectModel;
import com.detnet.pageObjects.SettingsPageObjectModel;
import com.detnet.utilities.EmailUtils;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DashboardValidation;
import com.detnet.validations.blastWebValidations.DeviceSummaryValidation;
import com.detnet.validations.blastWebValidations.DeviceValidation;
import com.detnet.validations.blastWebValidations.SettingsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

import java.util.Arrays;
import java.util.List;

//   Scenario: Verify that a user can establish encrypted communication between SBC and BCU
public class CardlessEncryptionComms_StepDefn {
    private final PageObjectManager pageObjectManager;

    public CardlessEncryptionComms_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user navigates to Device Settings to add a device")
    public void the_user_navigates_to_device_settings_to_add_a_device() {
        SettingsPageObjectModel settingsPageObjectModel = pageObjectManager.getSettingsPageObjectModel();
        SettingsValidation settingsValidation = new SettingsValidation(settingsPageObjectModel);
        settingsValidation.validateDevicesTabVisibility();
        settingsValidation.validateDeviceTabState();
        settingsValidation.validateDevicesTabText("Devices");
        settingsPageObjectModel.viewDevices();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user clicks on the Add Device button")
    public void the_user_clicks_on_the_add_device_button() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        deviceValidation.validateDeviceURL("http://localhost:8080/en/settings/devices");
        deviceValidation.validateAddButtonVisibility();
        deviceValidation.validateAddButtonState();
        devicePageObjectModel.addNewDevice();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user enters the relevant device details for BCU II and presses {string}")
    public void the_user_enters_the_relevant_device_details_for_bcu_ii_and_presses(String string) {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        deviceValidation.validateAddDeviceFormVisibility();

        deviceValidation.validateDeviceIdFieldVisibility();
        deviceValidation.validateDeviceIdFieldState();
        deviceValidation.validateIfDeviceIdFieldIsEmpty();
        devicePageObjectModel.setDeviceId("502");
        deviceValidation.validateEnteredDeviceId("502");

        deviceValidation.validateLocationFieldVisibility();
        deviceValidation.validateLocationFieldState();
        deviceValidation.validateIfLocationFieldIsEmpty();
        devicePageObjectModel.setLocation("Cape Town");
        deviceValidation.validateEnteredDeviceLocation("Cape Town");

        deviceValidation.validateNetworkFieldVisibility();
        deviceValidation.validateNetworkFieldState();
        devicePageObjectModel.openDeviceNetworkDropDown();
        deviceValidation.validateIfDeviceNetworkDropDownIsOpen();
        devicePageObjectModel.selectNetwork("ETHER001-DUMMY");

        deviceValidation.validateNetworkInterfaceFieldVisibility();
        deviceValidation.validateNetworkInterfaceFieldState();
        devicePageObjectModel.openNetworkInterfaceDropDown();
        deviceValidation.validateNetworkInterfaceDropdownIsOpen();
        devicePageObjectModel.selectNetworkInterface("Ethernet");

        deviceValidation.validateDeviceTypeFieldVisibility();
        deviceValidation.validateDeviceTypeFieldState();
        devicePageObjectModel.openDeviceTypeDropDown();
        deviceValidation.validateIfDeviceTypeDropDownIsOpen();
        devicePageObjectModel.selectDeviceType("BCU");

        deviceValidation.validateIpFieldVisibility();
        deviceValidation.validateIpFieldState();
        devicePageObjectModel.setIpAddress("172.20.3.92");
        deviceValidation.validateIfIPFieldIsFilled();
        deviceValidation.validateIpEntered("172.20.3.92");

        deviceValidation.validateDeviceSubmitButtonVisibility();
        deviceValidation.validateDeviceSubmitButtonState();
        devicePageObjectModel.addDevice();
        deviceValidation.validateIfDeviceIsAdded("172.20.3.92");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the device state should be verified")
    public void the_device_state_should_be_verified() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateDashboardButtonState();
        dashboardPageObjectModel.goToDashboard();
        dashboardValidation.validateDeviceDetailsButtonVisibility();
        dashboardValidation.validateDeviceDetailsButtonState();
        dashboardValidation.validateIfNewDeviceIsOnDashboard();
        dashboardPageObjectModel.viewDeviceDetails(1);

        DeviceSummaryPageObjectModel deviceSummaryPageObjectModel = pageObjectManager.getDeviceSummaryPageObjectModel();
        DeviceSummaryValidation deviceSummaryValidation = new DeviceSummaryValidation(deviceSummaryPageObjectModel);
        deviceSummaryValidation.validateDeviceStateVisibility();

//        Sends a control request to colleague
        String toEmail = "breyton.ernstzen@testheroes.co.za";
        List<String> ccEmails = Arrays.asList(
                "coetseet@detnet.com",
                "maysond@detnet.com",
                "moosaa@detnet.com",
                "breytonseanernstzen1224@gmail.com");
        String deviceName = "Device 502";
        String expectedState = "IDLE";
        int waitMinutes = 10;

        EmailUtils.sendDeviceControlRequest(toEmail, ccEmails, deviceName, expectedState, waitMinutes);

//        Wait up to 10 minutes, polling every 30 seconds
        int pollIntervalsSeconds = 30;
        int maxWaitSeconds = waitMinutes * 60;
        int elapsed = 0;
        boolean stateMatched = false;

        while (elapsed < maxWaitSeconds){
            String currentState = deviceSummaryPageObjectModel.getCurrentDeviceState();
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
        deviceSummaryValidation.validateDeviceCurrentState("IDLE"); // IDLE
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}