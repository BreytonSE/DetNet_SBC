package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.DevicePageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class DeviceValidation {
    private final DevicePageObjectModel devicePageObjectModel;
    private final SoftAssertions softly;

    public DeviceValidation(DevicePageObjectModel devicePageObjectModel) {
        this.devicePageObjectModel = devicePageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateDeviceURL(String expectedURL){
        String actualURL = devicePageObjectModel.getDevicesURL();
        softly.assertThat(actualURL)
                .as("Actual URL does not match expected URL")
                .isEqualTo(expectedURL);
    }

    public void validateAddButtonVisibility(){
        boolean isVisible = devicePageObjectModel.isAddDeviceButtonVisible();
        softly.assertThat(isVisible)
                .as("'Add Device' -button should be visible")
                .isTrue();
    }

    public void validateAddButtonState(){
        boolean isEnabled = devicePageObjectModel.isAddDeviceButtonEnabled();
        softly.assertThat(isEnabled)
                .as("Add Device -button should be enabled")
                .isTrue();
    }

    public void validateAddDeviceFormVisibility(){
        boolean isOpen = devicePageObjectModel.isAddDeviceFormOpen();
        softly.assertThat(isOpen)
                .as("Add Device form should be visible")
                .isTrue();
    }

    public void validateDeviceIdFieldVisibility(){
        boolean isVisible = devicePageObjectModel.isDeviceIdFieldVisible();
        softly.assertThat(isVisible)
                .as("Device id field should be visible.")
                .isTrue();
    }

    public void validateDeviceIdFieldState(){
        boolean isEnabled = devicePageObjectModel.isDeviceIdFieldEnabled();
        softly.assertThat(isEnabled)
                .as("Device id field should be enabled.")
                .isTrue();
    }

    public void validateIfDeviceIdFieldIsEmpty(){
        boolean isEmpty = devicePageObjectModel.isDeviceIdFieldEmpty();
        softly.assertThat(isEmpty)
                .as("Device id field should be empty.")
                .isTrue();
    }

    public void validateEnteredDeviceId(String expectedDeviceId){
        String actualDeviceId = devicePageObjectModel.getDeviceId();
        softly.assertThat(actualDeviceId)
                .as("Actual device id, does not match expected device id.")
                .isEqualTo(expectedDeviceId);
    }

    public void validateLocationFieldVisibility(){
        boolean isVisible = devicePageObjectModel.isLocationFieldVisible();
        softly.assertThat(isVisible)
                .as("Device location input field should be visible")
                .isTrue();
    }

    public void validateLocationFieldState(){
        boolean isEnabled = devicePageObjectModel.isLocationFieldEnabled();
        softly.assertThat(isEnabled)
                .as("Device location input field should be enabled")
                .isTrue();
    }

    public void validateIfLocationFieldIsEmpty(){
        boolean isEmpty = devicePageObjectModel.isLocationFieldEmpty();
        softly.assertThat(isEmpty)
                .as("Device location field should be empty by default")
                .isTrue();
    }

    public void validateEnteredDeviceLocation(String expectedDeviceLocation){
        String actualDeviceLocation = devicePageObjectModel.getDeviceLocation();
        softly.assertThat(actualDeviceLocation)
                .as("Actual device location does not match expected device location.")
                .isEqualTo(expectedDeviceLocation);
    }

    public void validateNetworkFieldVisibility(){
        boolean isVisible = devicePageObjectModel.isNetworkFieldVisible();
        softly.assertThat(isVisible)
                .as("Network field should be visible")
                .isTrue();
    }

    public void validateNetworkFieldState(){
        boolean isEnabled = devicePageObjectModel.isNetworkFieldEnabled();
        softly.assertThat(isEnabled)
                .as("Network field should be enabled")
                .isTrue();
    }

    public void validateIfDeviceNetworkDropDownIsOpen(){
        boolean isOpen = devicePageObjectModel.isDeviceNetworkDropDownOpen();
        softly.assertThat(isOpen)
                .as("Network dropdown should be open.")
                .isTrue();
    }

    public void validateNetworkInterfaceFieldVisibility(){
        boolean isVisible = devicePageObjectModel.isNetworkInterfaceFieldVisible();
        softly.assertThat(isVisible)
                .as("Network interface dropdown should be visible")
                .isTrue();
    }

    public void validateNetworkInterfaceFieldState(){
        boolean isEnabled = devicePageObjectModel.isNetworkInterfaceFieldEnabled();
        softly.assertThat(isEnabled)
                .as("Network interface dropdown should be enabled")
                .isTrue();
    }

    public void validateNetworkInterfaceDropdownIsOpen(){
        boolean isOpen = devicePageObjectModel.isNetworkInterfaceDropDownOpen();
        softly.assertThat(isOpen)
                .as("Network interface dropdown should be open")
                .isTrue();
    }

    public void validateDeviceTypeFieldVisibility(){
        boolean isVisible = devicePageObjectModel.isDeviceTypeFieldVisible();
        softly.assertThat(isVisible)
                .as("Device type field should be visible")
                .isTrue();
    }

    public void validateDeviceTypeFieldState(){
        boolean isEnabled = devicePageObjectModel.isDeviceTypeFieldEnabled();
        softly.assertThat(isEnabled)
                .as("'Device Type' field should be enabled")
                .isTrue();
    }

    public void validateIfDeviceTypeDropDownIsOpen(){
        boolean isOpen = devicePageObjectModel.isDeviceDropDownOpen();
        softly.assertThat(isOpen)
                .as("Device type dropdown should be open")
                .isTrue();
    }

    public void validateIpFieldVisibility(){
        boolean isVisible = devicePageObjectModel.isIpAddressFieldVisible();
        softly.assertThat(isVisible)
                .as("'IP Address' field should be visible.")
                .isTrue();
    }

    public void validateIpFieldState(){
        boolean isEnabled = devicePageObjectModel.isIpAddressFieldEnabled();
        softly.assertThat(isEnabled)
                .as("'IP Address' field should be enabled.")
                .isTrue();
    }

    public void validateIfIPFieldIsFilled(){
        boolean isEmpty = devicePageObjectModel.isIpAddressFieldEmpty();
        softly.assertThat(isEmpty)
                .as("'IP Address' field should be filled.")
                .isFalse();
    }

    public void validateIpEntered(String expectedIP){
        String actualIP = devicePageObjectModel.getIpAddress();
        softly.assertThat(actualIP)
                .as("Actual IP address does not match expected IP.")
                .isEqualTo(expectedIP);
    }

    public void validateDeviceSubmitButtonVisibility(){
        boolean isVisible = devicePageObjectModel.isAddDeviceSubmitButtonVisible();
        softly.assertThat(isVisible)
                .as("'+ Add Device' -button should be visible.")
                .isTrue();
    }

    public void validateDeviceSubmitButtonState(){
        boolean isEnabled = devicePageObjectModel.isSubmitButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'+ Add Device' -button should be enabled.")
                .isTrue();
    }

    public void validateIfDeviceIsAdded(String deviceIp){
        boolean isAdded = devicePageObjectModel.isDeviceAdded(deviceIp);
        softly.assertThat(isAdded)
                .as("Device is added")
                .isTrue();
    }
}