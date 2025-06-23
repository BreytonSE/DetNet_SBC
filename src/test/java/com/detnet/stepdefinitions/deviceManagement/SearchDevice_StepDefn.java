package com.detnet.stepdefinitions.deviceManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DevicePageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DeviceValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that a device can be searched using the ID, Location and IP
public class SearchDevice_StepDefn {
    private final PageObjectManager pageObjectManager;

    public SearchDevice_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Then("the device search bar should be visible")
    public void the_device_search_bar_should_be_visible() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        deviceValidation.validateDeviceSearchBarVisibility();
        deviceValidation.validateSearchBarState();
        deviceValidation.validateIfSearchBarIsEmpty();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user searches for a device by ID")
    public void the_user_searches_for_a_device_by_id() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        devicePageObjectModel.searchDeviceById("502");
        deviceValidation.validateSearchedDeviceId("502");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the searched device should appear by searched ID")
    public void the_searched_device_should_appear_by_searched_id() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        deviceValidation.validateSearchedDeviceVisibility("Cape Town 1");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user searches for a device by location")
    public void the_user_searches_for_a_device_by_location() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        devicePageObjectModel.searchDeviceByLocation("Kimberley");
        deviceValidation.validateSearchedDeviceLocation("Kimberley");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the searched device should appear by searched location")
    public void the_searched_device_should_appear_by_searched_location() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        deviceValidation.validateSearchedDeviceVisibility("Kimberley");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user searches for a device by IP")
    public void the_user_searches_for_a_device_by_ip() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        devicePageObjectModel.searchDeviceByIp("198.51.100.42");
        deviceValidation.validateSearchedDeviceIp("198.51.100.42");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the searched device should appear by searched IP")
    public void the_searched_device_should_appear_by_searched_ip() {
        DevicePageObjectModel devicePageObjectModel = pageObjectManager.getDevicePageObjectModel();
        DeviceValidation deviceValidation = new DeviceValidation(devicePageObjectModel);
        deviceValidation.validateSearchedDeviceVisibility("Kathu");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}