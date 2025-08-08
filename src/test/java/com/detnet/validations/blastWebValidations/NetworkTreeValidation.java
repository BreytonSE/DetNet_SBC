package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.NetworkTreePageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class NetworkTreeValidation {
    private final NetworkTreePageObjectModel networkTreePageObjectModel;
    private final SoftAssertions softly;

    public NetworkTreeValidation(NetworkTreePageObjectModel networkTreePageObjectModel) {
        this.networkTreePageObjectModel = networkTreePageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateNetworkTreeURL(String expectedURL){
        String actualURL = networkTreePageObjectModel.getNetworkTreePageURL();
        softly.assertThat(actualURL)
                .as("Actual URL does not match expected URL")
                .isEqualTo(expectedURL);
    }

    public void validateNetworkTreePageVisibility(){
        boolean isVisible = networkTreePageObjectModel.isNetworkTreePageOpen();
        softly.assertThat(isVisible)
                .as("Network tree should be visible")
                .isTrue();
    }

    public void validateIfDeviceIsInTree(String deviceId){
        boolean isPresent = networkTreePageObjectModel.isDevicePresent(deviceId);
        softly.assertThat(isPresent)
                .as("Device with %s should be present in the network tree",deviceId)
                .isTrue();
    }
}