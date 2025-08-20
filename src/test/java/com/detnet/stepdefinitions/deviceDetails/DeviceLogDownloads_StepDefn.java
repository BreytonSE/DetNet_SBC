package com.detnet.stepdefinitions.deviceDetails;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DeviceLogsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DeviceLogsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Then;

//   Scenario: Verify the device details log generates completely and is downloadable
public class DeviceLogDownloads_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DeviceLogDownloads_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Then("click the download icon in the action column")
    public void click_the_download_icon_in_the_action_column() {
        DeviceLogsPageObjectModel deviceLogsPageObjectModel = pageObjectManager.getDeviceLogsPageObjectModel();
        DeviceLogsValidation deviceLogsValidation = new DeviceLogsValidation(deviceLogsPageObjectModel);
        deviceLogsValidation.validateCloudDownloadIconVisibility();
        deviceLogsValidation.validateCloudDownloadIconState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        deviceLogsPageObjectModel.downloadLogs();
    }
}