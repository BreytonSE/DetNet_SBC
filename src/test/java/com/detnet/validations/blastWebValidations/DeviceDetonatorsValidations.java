package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.DeviceDetonatorsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class DeviceDetonatorsValidations {
    private final DeviceDetonatorsPageObjectModel deviceDetonatorsPageObjectModel;
    private final SoftAssertions softly;

    public DeviceDetonatorsValidations(DeviceDetonatorsPageObjectModel deviceDetonatorsPageObjectModel) {
        this.deviceDetonatorsPageObjectModel = deviceDetonatorsPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateDetonatorsPageURL(String expectedURL){
        String actualURL = deviceDetonatorsPageObjectModel.getDeviceDetonatorsPageURL();
        softly.assertThat(actualURL)
                .as("Actual URL does not match expected URL.")
                .matches(expectedURL);
    }

    public void validateDetonatorsPageVisibility(){
        boolean isVisible = deviceDetonatorsPageObjectModel.isDeviceDetonatorsPageOpen();
        softly.assertThat(isVisible)
                .as("Device detonators page should be displaying.")
                .isTrue();
    }

    public void validateDetonatorRequestButtonVisibility(){
        boolean isFound = deviceDetonatorsPageObjectModel.isRequestDetonatorButtonVisible();
        softly.assertThat(isFound)
                .as("'Request Detonators' -button should be displaying.")
                .isTrue();
    }

    public void validateDetonatorRequestButtonState(){
        boolean isEnabled = deviceDetonatorsPageObjectModel.isRequestDetonatorButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'Request Detonators' -button should be enabled.")
                .isTrue();
    }

    public void validateDetonatorRequestSnackBarVisibility(){
        boolean isVisible = deviceDetonatorsPageObjectModel.isDetonatorsRequestSnackBarVisible();
        softly.assertThat(isVisible)
                .as("Detonators request snack bar should be displaying when user request for detonators.")
                .isTrue();
    }

    public void validateIfDetonatorsFound(){
        boolean isFound = deviceDetonatorsPageObjectModel.isDetonatorsListVisible();
        softly.assertThat(isFound)
                .as("A list of requested detonators should be displaying when user request for detonators.")
                .isTrue();
    }
}