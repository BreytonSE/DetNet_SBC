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

//   Scenario: Verify that user can set the channel offset using SBC
public class ChannelOffset_StepDefn {
    private final PageObjectManager pageObjectManager;

    public ChannelOffset_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Given("the selected device is in the {string} state")
    public void the_selected_device_is_in_the_state(String string) {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
//        Sends a control request to colleague
        String toEmail = "breyton.ernstzen@testheroes.co.za";
        List<String> ccEmails = Arrays.asList(
                "coetseet@detnet.com",
                "maysond@detnet.com",
                "moosaa@detnet.com",
                "mbhalatil@detnet0.onmicrosoft.com");
        String deviceName = "Device 502"; // Device Id might change
        String expectedState = "Ready to Arm";
        int waitMinutes = 10;

        EmailUtils.sendDeviceControlRequest(toEmail, ccEmails, deviceName, expectedState, waitMinutes);

//        Wait up to 10 minutes, polling every 30 seconds
        int pollIntervalsSeconds = 30;
        int maxWaitSeconds = waitMinutes * 60;
        int elapsed = 0;
        boolean stateMatched = false;

        while (elapsed < maxWaitSeconds){
            String currentState = dashboardPageObjectModel.getDeviceCurrentState();
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
        dashboardValidation.validateDeviceState("READY TO ARM");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user clicks on the offset icon")
    public void the_user_clicks_on_the_offset_icon() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateOffsetToolTipVisibility();
        dashboardValidation.validateOffsetToolTipState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        dashboardPageObjectModel.openOffsetChannelWindow();
    }
    @Then("six channel fields should be displayed")
    public void six_channel_fields_should_be_displayed() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateOffsetChannelWindowVisibility();
        dashboardValidation.validateOffsetChannelFields("C1");
        dashboardValidation.validateOffsetChannelFields("C2");
        dashboardValidation.validateOffsetChannelFields("C3");
        dashboardValidation.validateOffsetChannelFields("C4");
        dashboardValidation.validateOffsetChannelFields("C5");
        dashboardValidation.validateOffsetChannelFields("C6");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user sets the channel offset values")
    public void the_user_sets_the_channel_offset_values() throws InterruptedException {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);

        for(int i=1;i<=6;i++){
            String channel = String.valueOf(i);

            dashboardValidation.validateOffsetDelayFieldVisibility(channel);
            dashboardValidation.validateOffsetDelayFieldState(channel);
            SoftAssertionUtils.getSoftAssertions().assertAll();

            int randomDelay = (int) (Math.random() * 20001);
            dashboardPageObjectModel.setOffSetDelay(channel,randomDelay);
        }
    }
    @When("clicks the save button")
    public void clicks_the_save_button() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateSaveButtonVisibility();
        dashboardValidation.validateSaveButtonState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        dashboardPageObjectModel.saveOffsetChannel();
    }
    @Then("the offset icon should be displayed in blue and black")
    public void the_offset_icon_should_be_displayed_in_blue_and_black() {
//        TODO: Validate the offset icon has changed to blue and black
    }
    @Then("the BCU should update the channels with the specified offset seconds")
    public void the_bcu_should_update_the_channels_with_the_specified_offset_seconds() {
//        TODO: Validate that the BCU update the channels with the offset seconds
    }
}