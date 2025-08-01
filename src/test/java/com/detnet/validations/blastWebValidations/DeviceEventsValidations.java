package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.DeviceEventsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class DeviceEventsValidations {
    private final DeviceEventsPageObjectModel deviceEventsPageObjectModel;
    private final SoftAssertions softly;

    public DeviceEventsValidations(DeviceEventsPageObjectModel deviceEventsPageObjectModel) {
        this.deviceEventsPageObjectModel = deviceEventsPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateEventDateVisibility(){
        boolean isVisible = deviceEventsPageObjectModel.isEventsDateDisplayed();
        softly.assertThat(isVisible)
                .as("Event dates should be displaying under device details.")
                .isTrue();
    }

    public void validateEventsTimeVisibility(){
        boolean isVisible = deviceEventsPageObjectModel.isEventsTimeDisplayed();
        softly.assertThat(isVisible)
                .as("Events time should be displaying under device details.")
                .isTrue();
    }
}