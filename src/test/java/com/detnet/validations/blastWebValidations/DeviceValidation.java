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

    public void validateDeviceListVisibility(int deviceNumber){
        boolean isVisible = devicePageObjectModel.isDevicesVisible(deviceNumber);
        softly.assertThat(isVisible)
                .as("A list of devices should be displaying.")
                .isTrue();
    }

    public void validateDeviceManagerFieldVisibility(){
        boolean isVisible = devicePageObjectModel.isDeviceManagerFieldVisible();
        softly.assertThat(isVisible)
                .as("Device manager field should be displaying")
                .isTrue();
    }

    public void validateDeviceManagerFieldState(){
        boolean isEnabled = devicePageObjectModel.isDeviceManageFieldEnabled();
        softly.assertThat(isEnabled)
                .as("Device manager state should be enabled")
                .isTrue();
    }

    public void validateDeviceManagerDropDownIsOpen(){
        boolean isOpen = devicePageObjectModel.isDeviceManagerDropDownOpen();
        softly.assertThat(isOpen)
                .as("Device manager dropdown should be able")
                .isTrue();
    }

    public void validateParenDeviceFieldVisibility(){
        boolean isVisible = devicePageObjectModel.isParentDeviceFieldVisible();
        softly.assertThat(isVisible)
                .as("Parent device field should be visible")
                .isTrue();
    }

    public void validateParentDeviceFieldState(){
        boolean isEnabled = devicePageObjectModel.isParentDeviceFieldEnabled();
        softly.assertThat(isEnabled)
                .as("Parent device field should be enabled")
                .isTrue();
    }

    public void validateParentDeviceDropDownIsOpen(){
        boolean isOpen = devicePageObjectModel.isParentDeviceDropDownOpen();
        softly.assertThat(isOpen)
                .as("Parent device dropdown should be open")
                .isTrue();
    }

    public void validateDeviceGroupFieldVisibility(){
        boolean isVisible = devicePageObjectModel.isDeviceGroupFieldVisible();
        softly.assertThat(isVisible)
                .as("Device group field should be visible")
                .isTrue();
    }

    public void validateDeviceGroupFieldState(){
        boolean isEnabled = devicePageObjectModel.isDeviceGroupFieldEnabled();
        softly.assertThat(isEnabled)
                .as("Device group field should be enabled")
                .isTrue();
    }

    public void validateDeviceGroupDropDownVisibility(){
        boolean isOpen = devicePageObjectModel.isDeviceGroupDropDownOpen();
        softly.assertThat(isOpen)
                .as("Device group dropdown should be visible")
                .isTrue();
    }

    public void validateEditIconVisibility(){
        boolean isVisible = devicePageObjectModel.isEditIconVisible();
        softly.assertThat(isVisible)
                .as("Edit icon should be visible")
                .isTrue();
    }

    public void validateEditIconState(){
        boolean isEnabled = devicePageObjectModel.isEditIconEnabled();
        softly.assertThat(isEnabled)
                .as("Edit icon should be enabled")
                .isTrue();
    }

    public void validateEditPageIsOpen(){
        boolean isOpen = devicePageObjectModel.isEditPageVisible();
        softly.assertThat(isOpen)
                .as("Edit page should be displaying.")
                .isTrue();
    }

    public void validateEditPageURL(String expectedURL){
        String actualURL = devicePageObjectModel.getEditPageURL();
        softly.assertThat(actualURL)
                .as("Actual URL does not match expected URL")
                .isEqualTo(expectedURL);
    }

    public void validateSaveUpdateButtonVisibility(){
        boolean isVisible = devicePageObjectModel.isSaveButtonVisible();
        softly.assertThat(isVisible)
                .as("'Save' -button should be visible")
                .isTrue();
    }

    public void validateDeviceGroupUpdated(String updatedDeviceName){
        boolean isUpdated = devicePageObjectModel.isDeviceLocationUpdated(updatedDeviceName);
        softly.assertThat(isUpdated)
                .as("Device name should have updated")
                .isTrue();
    }

    public void validateDeviceSearchBarVisibility(){
        boolean isVisible = devicePageObjectModel.isSearchBarVisible();
        softly.assertThat(isVisible)
                .as("Device search bar should be visible.")
                .isTrue();
    }

    public void validateSearchBarState(){
        boolean isEnabled = devicePageObjectModel.isSearchBarEnabled();
        softly.assertThat(isEnabled)
                .as("Search bar should be enabled")
                .isTrue();
    }

    public void validateIfSearchBarIsEmpty(){
        boolean isEmpty = devicePageObjectModel.isSearchBarEmpty();
        softly.assertThat(isEmpty)
                .as("Search bar should be empty by default")
                .isTrue();
    }

    public void validateSearchedDeviceId(String expectedId){
        String actualId = devicePageObjectModel.getSearchedDeviceId();
        softly.assertThat(actualId)
                .as("Actual searched device Id does not match expected device id.")
                .isEqualTo(expectedId);
    }

    public void validateSearchedDeviceLocation(String expectedLocation){
        String actualLocation = devicePageObjectModel.getSearchedDeviceLocation();
        softly.assertThat(actualLocation)
                .as("Actual searched device location does not match expected device location.")
                .isEqualTo(expectedLocation);
    }

    public void validateSearchedDeviceIp(String expectedIp){
        String actualIp = devicePageObjectModel.getSearchedDeviceIp();
        softly.assertThat(actualIp)
                .as("Actual searched ip does not match expected searched ip")
                .isEqualTo(expectedIp);
    }

    public void validateSearchedDeviceVisibility(String device){
        boolean isFound = devicePageObjectModel.isSearchedDeviceFound(device);
        softly.assertThat(isFound)
                .as("Searched device should be found after search")
                .isTrue();
    }

    public void validateDeleteIconVisibility(){
        boolean isVisible = devicePageObjectModel.isDeleteIconVisible();
        softly.assertThat(isVisible)
                .as("Delete icon should be visible")
                .isTrue();
    }

    public void validateDeleteIconState(){
        boolean isEnabled = devicePageObjectModel.isDeleteIconEnabled();
        softly.assertThat(isEnabled)
                .as("Delete icon should be enabled")
                .isTrue();
    }

    public void validateDeleteDialogVisibility(){
        boolean isVisible = devicePageObjectModel.isDeviceDeleteDialogOpen();
        softly.assertThat(isVisible)
                .as("Delete dialog should be opened")
                .isTrue();
    }

    public void validateIfDeviceIsDeleted(int deviceId){
        boolean isDeleted = devicePageObjectModel.isDeviceDeleted(deviceId);
        softly.assertThat(isDeleted)
                .as("Device with id '%s' should not be present in the device list.", deviceId)
                .isTrue();
    }

    public void validateSelectAllCheckboxVisibility(){
        boolean isVisible = devicePageObjectModel.isSelectAllCheckboxVisible();
        softly.assertThat(isVisible)
                .as("Select all checkbox should be visible.")
                .isTrue();
    }

    public void validateCheckboxState(){
        boolean isEnabled = devicePageObjectModel.isCheckboxEnabled();
        softly.assertThat(isEnabled)
                .as("Checkboxes should be enabled")
                .isTrue();
    }

    public void validateDeleteAllButtonVisibility(){
        boolean isVisible = devicePageObjectModel.isDeleteAllButtonVisible();
        softly.assertThat(isVisible)
                .as("'Delete Devices' -button should be visible")
                .isTrue();
    }

    public void validateDeleteAllButtonState(){
        boolean isEnabled = devicePageObjectModel.isDeleteAllButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'Delete Devices' -button should be enabled")
                .isTrue();
    }
}