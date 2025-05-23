package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.DeviceSummaryPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class DeviceSummaryValidation {
    private final DeviceSummaryPageObjectModel deviceSummaryPageObjectModel;
    private final SoftAssertions softly;

    public DeviceSummaryValidation(DeviceSummaryPageObjectModel deviceSummaryPageObjectModel) {
        this.deviceSummaryPageObjectModel = deviceSummaryPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateDeviceStateVisibility(){
        boolean isVisible = deviceSummaryPageObjectModel.isDeviceStateVisible();
        softly.assertThat(isVisible)
                .as("Device state should be visible.")
                .isTrue();
    }

    public void validateDeviceCurrentState(String expectedState){
        String actualState = deviceSummaryPageObjectModel.getCurrentDeviceState();
        softly.assertThat(actualState)
                .as("Actual device state does not match expected device state")
                .isEqualToIgnoringCase(expectedState);
    }
}