package com.detnet.stepdefinitions.networkTree;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DeviceDetailsPageObjectModel;
import com.detnet.pageObjects.NetworkTreePageObjectModel;
import com.detnet.pageObjects.SettingsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DeviceDetailsValidation;
import com.detnet.validations.blastWebValidations.NetworkTreeValidation;
import com.detnet.validations.blastWebValidations.SettingsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

// Scenario: Verify that the network tree of the system can be viewed and allows navigation to specific devices on a selected network.
public class networkTree_StepDefn {
    private final PageObjectManager pageObjectManager;

    public networkTree_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user opens the network tree")
    public void the_user_opens_the_network_tree() {
        SettingsPageObjectModel settingsPageObjectModel = pageObjectManager.getSettingsPageObjectModel();
        SettingsValidation settingsValidation = new SettingsValidation(settingsPageObjectModel);
        settingsValidation.validateNetworkTreeTabVisibility();
        settingsValidation.validateNetworkTreeTabText("Network Tree");
        SoftAssertionUtils.getSoftAssertions().assertAll();
        settingsPageObjectModel.openNetworkTree();
    }

    @Then("the user verifies url of the network tree page")
    public void the_user_verifies_url_of_the_network_tree_page() {
        NetworkTreePageObjectModel networkTreePageObjectModel = pageObjectManager.getNetworkTreePageObjectModel();
        NetworkTreeValidation networkTreeValidation = new NetworkTreeValidation(networkTreePageObjectModel);
        networkTreeValidation.validateNetworkTreeURL("http://localhost:8080/en/settings/tree");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the user verifies that the network tree page is open")
    public void the_user_verifies_that_the_network_tree_page_is_open() {
        NetworkTreePageObjectModel networkTreePageObjectModel = pageObjectManager.getNetworkTreePageObjectModel();
        NetworkTreeValidation networkTreeValidation = new NetworkTreeValidation(networkTreePageObjectModel);
        networkTreeValidation.validateNetworkTreePageVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the user selects a device to view the dropdown list of sub-devices or navigates to the selected device's details page")
    public void the_user_selects_a_device_to_view_the_dropdown_list_of_sub_devices_or_navigates_to_the_selected_device_s_details_page() {
        NetworkTreePageObjectModel networkTreePageObjectModel = pageObjectManager.getNetworkTreePageObjectModel();
        NetworkTreeValidation networkTreeValidation = new NetworkTreeValidation(networkTreePageObjectModel);
        networkTreeValidation.validateIfTreeHasDevices();
        networkTreeValidation.validateIfDeviceIsInTree("502");
        SoftAssertionUtils.getSoftAssertions().assertAll();
        networkTreePageObjectModel.viewDeviceDetails("502");
    }

    @Then("verify that the user is on device details page")
    public void verify_that_the_user_is_on_device_details_page() {
        DeviceDetailsPageObjectModel deviceDetailsPageObjectModel = pageObjectManager.getDeviceDetailsPageObjectModel();
        DeviceDetailsValidation deviceDetailsValidation = new DeviceDetailsValidation(deviceDetailsPageObjectModel);
        deviceDetailsValidation.validateDeviceDetailsSummaryPageURL("http://localhost:8080/en/device-details/502/summary");
        deviceDetailsValidation.validateDeviceStatusVisibility();
        deviceDetailsValidation.validateDeviceDetailsAndConfigurationVisibility();
        deviceDetailsValidation.validateDeviceStatisticsVisibility();
        deviceDetailsValidation.validateDeviceAuxiliaryRelaysVisibility();
        deviceDetailsValidation.validateBCUBlastKeyVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}