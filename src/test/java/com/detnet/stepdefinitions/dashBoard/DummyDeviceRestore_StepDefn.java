package com.detnet.stepdefinitions.dashBoard;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DevicePageObjectModel;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.When;

//   Scenario: Add the dummy device back to the dashboard that user deleted earlier
public class DummyDeviceRestore_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DummyDeviceRestore_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user sets the device ID of the device")
    public void the_user_sets_the_device_id_of_the_device() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        devicePageObjectModel.setDeviceId("5600");
    }
    @When("the user sets the device location for the device")
    public void the_user_sets_the_device_location_for_the_device() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        devicePageObjectModel.setLocation("Dummy device");
    }
    @When("the user selects the device network for the device")
    public void the_user_selects_the_device_network_for_the_device() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        devicePageObjectModel.openDeviceNetworkDropDown();
        devicePageObjectModel.selectNetwork("ETHER001-DUMMY");
    }
    @When("the user selects the device network interface as Ethernet")
    public void the_user_selects_the_device_network_interface_as_ethernet() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        devicePageObjectModel.openNetworkInterfaceDropDown();
        devicePageObjectModel.selectNetworkInterface("Ethernet");
    }
    @When("the user selects the device type as BCU")
    public void the_user_selects_the_device_type_as_bcu() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        devicePageObjectModel.openDeviceTypeDropDown();
        devicePageObjectModel.selectDeviceType("BCU");
    }
    @When("the user assigns an administrator as device manager")
    public void the_user_assigns_an_administrator_as_device_manager() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        devicePageObjectModel.openDeviceManageDropDown();
        devicePageObjectModel.selectManager("administrator");
    }
    @When("the user sets the device IP address of the device")
    public void the_user_sets_the_device_ip_address_of_the_device() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        devicePageObjectModel.setIpAddress("192.0.2.1");
    }
}