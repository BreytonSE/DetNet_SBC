package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.DeviceDetailsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class DeviceDetailsValidation {
    private final DeviceDetailsPageObjectModel deviceDetailsPageObjectModel;
    private final SoftAssertions softly;

    public DeviceDetailsValidation(DeviceDetailsPageObjectModel deviceDetailsPageObjectModel) {
        this.deviceDetailsPageObjectModel = deviceDetailsPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateDeviceDetailsSummaryPageURL(String expectedURL){
        String actualURL = deviceDetailsPageObjectModel.getDeviceDetailsSummaryPageURL();
        softly.assertThat(actualURL)
                .as("Actual URL does not match expected URL")
                .matches(expectedURL);
    }

    public void validateDeviceStatusVisibility(){
        boolean isVisible = deviceDetailsPageObjectModel.isDeviceStatusVisible();
        softly.assertThat(isVisible)
                .as("Device status should be visible.")
                .isTrue();
    }

    public void validateDeviceDetailsAndConfigurationVisibility(){
        boolean isVisible = deviceDetailsPageObjectModel.isDeviceDetailsAndConfigurationVisible();
        softly.assertThat(isVisible)
                .as("Device details and configuration should be visible.")
                .isTrue();
    }

    public void validateDeviceStatisticsVisibility(){
        boolean isVisible = deviceDetailsPageObjectModel.isDeviceStatisticsVisible();
        softly.assertThat(isVisible)
                .as("Device statistics should be visible.")
                .isTrue();
    }

    public void validateDeviceAuxiliaryRelaysVisibility(){
        boolean isVisible = deviceDetailsPageObjectModel.isAuxiliaryRelaysVisible();
        softly.assertThat(isVisible)
                .as("Device auxiliary relays should be visible.")
                .isTrue();
    }

    public void validateBCUBlastKeyVisibility(){
        boolean isVisible = deviceDetailsPageObjectModel.isBCUBlastKeyVisible();
        softly.assertThat(isVisible)
                .as("Device BCU blast key should be visible.")
                .isTrue();
    }

    public void validateEventsTabVisibility(){
        boolean isDisplayed = deviceDetailsPageObjectModel.isEventsTabVisible();
        softly.assertThat(isDisplayed)
                .as("Events tab should be displaying on the device details page.")
                .isTrue();
    }

    public void validateEventsTabText(String expectedText){
        String actualText = deviceDetailsPageObjectModel.getEventsTabText();
        softly.assertThat(actualText)
                .as("Actual text does not match expected text.")
                .isEqualTo(expectedText);
    }
}