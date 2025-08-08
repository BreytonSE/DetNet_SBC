package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.DeviceChannelPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class DeviceChannelValidation {
    private final SoftAssertions softly;
    private final DeviceChannelPageObjectModel deviceChannelPageObjectModel;

    public DeviceChannelValidation(DeviceChannelPageObjectModel deviceChannelPageObjectModel) {
        this.deviceChannelPageObjectModel = deviceChannelPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateDevicePanelScreenVisibility(){
        boolean isOpen = deviceChannelPageObjectModel.isDeviceChannelScreenOpen();
        softly.assertThat(isOpen)
                .as("Device panel screen should be displaying when user clicks on 'Channels'")
                .isTrue();
    }
}