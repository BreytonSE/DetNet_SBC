package com.detnet.stepdefinitions.deviceDetails;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.pageObjects.DeviceChannelPageObjectModel;
import com.detnet.pageObjects.DeviceDetailsPageObjectModel;
import com.detnet.pageObjects.LoginPageObjectModel;
import com.detnet.utilities.LoginConstantUtils;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DeviceChannelValidation;
import com.detnet.validations.blastWebValidations.DeviceDetailsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that the device details channels component loads with appropriate data
public class DeviceDetailsChannels_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DeviceDetailsChannels_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Given("the user is logged into BlastWeb with valid credentials")
    public void the_user_is_logged_into_blast_web_with_valid_credentials() throws Exception {
        LoginPageObjectModel loginPageObjectModel = pageObjectManager.getLoginPageObjectModel();
        String username = LoginConstantUtils.getDecryptedUsername();
        loginPageObjectModel.setUsername(username);
        String password = LoginConstantUtils.getDecryptedPassword();
        loginPageObjectModel.setPassword(password);
        loginPageObjectModel.logIn();
    }

    @When("the user selects a device from the device list")
    public void the_user_selects_a_device_from_the_device_list() {
       DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
       dashboardPageObjectModel.selectOrDeselectDevice(1);
    }

    @When("the user navigates to the device details page")
    public void the_user_navigates_to_the_device_details_page() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.viewDeviceDetails(1);
    }

    @Then("the device details channels component should load successfully")
    public void the_device_details_channels_component_should_load_successfully() {
        DeviceDetailsPageObjectModel deviceDetailsPageObjectModel = pageObjectManager.getDeviceDetailsPageObjectModel();
        DeviceDetailsValidation deviceDetailsValidation = new DeviceDetailsValidation(deviceDetailsPageObjectModel);
        deviceDetailsValidation.validateChannelsTabVisibility();
        deviceDetailsValidation.validateChannelsTabText("Channels");
        SoftAssertionUtils.getSoftAssertions().assertAll();
        deviceDetailsPageObjectModel.viewDeviceChannels();

        DeviceChannelPageObjectModel deviceChannelPageObjectModel = pageObjectManager.getDeviceChannelPageObjectModel();
        DeviceChannelValidation deviceChannelValidation = new DeviceChannelValidation(deviceChannelPageObjectModel);
        deviceChannelValidation.validateDevicePanelScreenVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the error panels should display the correct error types")
    public void the_error_panels_should_display_the_correct_error_types() {
//        TODO: Verify here for any errors
    }
}