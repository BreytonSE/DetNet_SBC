package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.DeviceLogsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class DeviceLogsValidation {
    private final DeviceLogsPageObjectModel deviceLogsPageObjectModel;
    private final SoftAssertions softly;

    public DeviceLogsValidation(DeviceLogsPageObjectModel deviceLogsPageObjectModel) {
        this.deviceLogsPageObjectModel = deviceLogsPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateDeviceLogsScreenVisibility(){
        boolean isVisible = deviceLogsPageObjectModel.isDeviceLogsScreenOpen();
        softly.assertThat(isVisible)
                .as("Device logs screen should be displaying after user clicked on 'Logs'")
                .isTrue();
    }

    public void validateDeviceLogsVisibility(){
        boolean isPresent = deviceLogsPageObjectModel.isDeviceLogsVisible();
        softly.assertThat(isPresent)
                .as("Device logs should be displaying when user opens the logs menu.")
                .isTrue();
    }

    public void validateLogsFromDatePickerVisibility(){
        boolean isVisible = deviceLogsPageObjectModel.isFromDatePickerButtonVisible();
        softly.assertThat(isVisible)
                .as("From date picker button should be displaying from the logs screen.")
                .isTrue();
    }

    public void validateFromDatePickerWindowIsOpen(){
        boolean isOpen = deviceLogsPageObjectModel.isFromDatePickerOpen();
        softly.assertThat(isOpen)
                .as("From date picker window should be displaying after user clicked on 'From' date picker.")
                .isTrue();
    }

    public void validateClockVisibility(){
        boolean isVisible = deviceLogsPageObjectModel.isClockVisible();
        softly.assertThat(isVisible)
                .as("Clock should be displaying after user selected a 'from' date.")
                .isTrue();
    }

    public void validateToDatePickerVisibility(){
        boolean isVisible = deviceLogsPageObjectModel.isToDatePickerVisible();
        softly.assertThat(isVisible)
                .as("To date picker button should be displaying.")
                .isTrue();
    }

    public void validateLogCategoryPickerVisibility(){
        boolean isVisible = deviceLogsPageObjectModel.isLogCategorySelectorVisible();
        softly.assertThat(isVisible)
                .as("Log category picker should be displaying.")
                .isTrue();
    }

    public void validateLogCategoryPickerState(){
        boolean isEnabled = deviceLogsPageObjectModel.isLogCategorySelectorEnabled();
        softly.assertThat(isEnabled)
                .as("Log category picker should be enabled.")
                .isTrue();
    }

    public void validateCategoryDropDownVisibility(){
        boolean isVisible = deviceLogsPageObjectModel.isLogCategoryDropDownOpen();
        softly.assertThat(isVisible)
                .as("Log category dropdown should be displaying.")
                .isTrue();
    }
}