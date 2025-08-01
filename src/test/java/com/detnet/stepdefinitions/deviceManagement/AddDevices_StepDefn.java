package com.detnet.stepdefinitions.deviceManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DevicePageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DeviceValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//  Scenario: Verify that devices can be added to the system
public class AddDevices_StepDefn {
    private final PageObjectManager pageObjectManager;

    public AddDevices_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user enters the device ID")
    public void the_user_enters_the_device_id() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        devicePageObjectModel.setDeviceId("1");
        deviceValidation.validateEnteredDeviceId("1");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user enters the device location")
    public void the_user_enters_the_device_location() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        devicePageObjectModel.setLocation("Kathu");
        deviceValidation.validateEnteredDeviceLocation("Kathu");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user selects the device network")
    public void the_user_selects_the_device_network() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        devicePageObjectModel.openDeviceNetworkDropDown();
        devicePageObjectModel.selectNetwork("ETHER001-DUMMY");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user selects the device network interface")
    public void the_user_selects_the_device_network_interface() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        devicePageObjectModel.openNetworkInterfaceDropDown();
        devicePageObjectModel.selectNetworkInterface("Serial");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user selects the device type")
    public void the_user_selects_the_device_type() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        devicePageObjectModel.openDeviceTypeDropDown();
        devicePageObjectModel.selectDeviceType("Converter");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user assigns a device manager")
    public void the_user_assigns_a_device_manager() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        deviceValidation.validateDeviceManagerFieldVisibility();
        deviceValidation.validateDeviceManagerFieldState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        devicePageObjectModel.openDeviceManageDropDown();
        deviceValidation.validateDeviceManagerDropDownIsOpen();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        devicePageObjectModel.selectManager("ethan.hughes");
    }

    @When("the user assigns a parent device")
    public void the_user_assigns_a_parent_device() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        deviceValidation.validateParenDeviceFieldVisibility();
        deviceValidation.validateParentDeviceFieldState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        devicePageObjectModel.openParentDeviceDropDown();
        deviceValidation.validateParentDeviceDropDownIsOpen();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        devicePageObjectModel.selectParentDevice("Dummy device");
    }

    @When("the user assigns a group to the device")
    public void the_user_assigns_a_group_to_the_device() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        deviceValidation.validateDeviceGroupFieldVisibility();
        deviceValidation.validateDeviceGroupFieldState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        devicePageObjectModel.openDeviceGroupDropDown();
        deviceValidation.validateDeviceGroupDropDownVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        devicePageObjectModel.selectDeviceGroup("2");
    }

    @When("the user sets the device IP address")
    public void the_user_sets_the_device_ip_address() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        devicePageObjectModel.setIpAddress("198.51.100.42");
        deviceValidation.validateIpEntered("198.51.100.42");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user saves the new device")
    public void the_user_saves_the_new_device() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        devicePageObjectModel.addDevice();
    }

    @Then("the device should be visible in the list and successfully registered on the backend")
    public void the_device_should_be_visible_in_the_list_and_successfully_registered_on_the_backend() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        deviceValidation.validateIfDeviceIsAdded("198.51.100.42");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user adds a fourth device")
    public void the_user_adds_a_fourth_device() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        devicePageObjectModel.addNewDevice();
        devicePageObjectModel.setDeviceId("2");
        devicePageObjectModel.setLocation("Kimberley");
        devicePageObjectModel.openDeviceNetworkDropDown();
        devicePageObjectModel.selectNetwork("ETHER001-DUMMY");
        devicePageObjectModel.openNetworkInterfaceDropDown();
        devicePageObjectModel.selectNetworkInterface("Ethernet");
        devicePageObjectModel.openDeviceTypeDropDown();
        devicePageObjectModel.selectDeviceType("Converter");
        devicePageObjectModel.openDeviceManageDropDown();
        devicePageObjectModel.selectManager("amy.wilkinson");
        devicePageObjectModel.openParentDeviceDropDown();
        devicePageObjectModel.selectParentDevice("Dummy device");
        devicePageObjectModel.openDeviceGroupDropDown();
        devicePageObjectModel.selectDeviceGroup("1");
        devicePageObjectModel.setIpAddress("203.0.113.10");
        devicePageObjectModel.addDevice();
        deviceValidation.validateIfDeviceIsAdded("203.0.113.10");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user adds a fifth device")
    public void the_user_adds_a_fifth_device() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        devicePageObjectModel.addNewDevice();
        devicePageObjectModel.setDeviceId("3");
        devicePageObjectModel.setLocation("Rustenburg");
        devicePageObjectModel.openDeviceNetworkDropDown();
        devicePageObjectModel.selectNetwork("ETHER001-DUMMY");
        devicePageObjectModel.openNetworkInterfaceDropDown();
        devicePageObjectModel.selectNetworkInterface("Ethernet");
        devicePageObjectModel.openDeviceTypeDropDown();
        devicePageObjectModel.selectDeviceType("Converter");
        devicePageObjectModel.openDeviceManageDropDown();
        devicePageObjectModel.selectManager("cody007");
        devicePageObjectModel.openParentDeviceDropDown();
        devicePageObjectModel.selectParentDevice("Dummy device");
        devicePageObjectModel.setIpAddress("192.0.2.123");
        devicePageObjectModel.addDevice();
        deviceValidation.validateIfDeviceIsAdded("192.0.2.123");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}