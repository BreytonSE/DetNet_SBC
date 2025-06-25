package com.detnet.stepdefinitions.dashBoard;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DevicePageObjectModel;
import com.detnet.pageObjects.SettingsPageObjectModel;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//    Scenario: Delete dummy device from the dashboard
public class DummyDeviceDeletion_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DummyDeviceDeletion_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user navigates to the Devices page")
    public void the_user_navigates_to_the_devices_page() {
        SettingsPageObjectModel settingsPageObjectModel = pageObjectManager.getSettingsPageObjectModel();
        settingsPageObjectModel.viewDevices();
    }

    @When("the user select the Dummy Device to delete")
    public void the_user_select_the_dummy_device_to_delete() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        devicePageObjectModel.selectOrDeselectDevices(2);
    }

    @Then("the user deletes the dummy device completely from the dashboard")
    public void the_user_deletes_the_dummy_device_completely_from_the_dashboard() throws InterruptedException {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        devicePageObjectModel.deleteSelectedDevices();
        devicePageObjectModel.confirmDelete();
        Thread.sleep(5000);
    }
}