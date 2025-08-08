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

    public void validateEventsPageVisibility(){
        boolean isVisible = deviceEventsPageObjectModel.isEventsPageOpen();
        softly.assertThat(isVisible)
                .as("Events page should be displaying after user clicked on the 'Events' -tab")
                .isTrue();
    }

    public void validateEventVisibility(){
        boolean isVisible = deviceEventsPageObjectModel.isEventNameDisplayed();
        softly.assertThat(isVisible)
                .as("Event should be displaying under the events table heading.")
                .isTrue();
    }

    public void validateIfEventsPageIsPaginated(){
        boolean isPaginated = deviceEventsPageObjectModel.isEventsPaginated();
        softly.assertThat(isPaginated)
                .as("Event should be paginated on the device events page.")
                .isTrue();
    }

    public void validateFromDatePickerButtonVisibility(){
        boolean isVisible = deviceEventsPageObjectModel.isFromDatePickerButtonVisible();
        softly.assertThat(isVisible)
                .as("'From' date picker button should be visible on the events screen.")
                .isTrue();
    }

    public void validateIfFromDatePickerWindowIsOpen(){
        boolean isOpen = deviceEventsPageObjectModel.isFromDatePickerOpen();
        softly.assertThat(isOpen)
                .as("'From' date picker window should be open.")
                .isTrue();
    }

    public void validateToDatePickerVisibility(){
        boolean isVisible = deviceEventsPageObjectModel.isToDatePickerVisible();
        softly.assertThat(isVisible)
                .as("'To' date picker should be visible on the events screen.")
                .isTrue();
    }
}