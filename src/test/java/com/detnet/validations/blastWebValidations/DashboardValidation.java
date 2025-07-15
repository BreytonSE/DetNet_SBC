package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class DashboardValidation {
    private final DashboardPageObjectModel dashboardPageObjectModel;
    private final SoftAssertions softly;

    public DashboardValidation(DashboardPageObjectModel dashboardPageObjectModel) {
        this.dashboardPageObjectModel = dashboardPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateDashboardLabelVisibility(){
        boolean isDashboardLabelVisible = dashboardPageObjectModel.isDashboardPageOpen();
        softly.assertThat(isDashboardLabelVisible)
                .as("Test Failed! Dashboard label should be displaying")
                .isTrue();
    }

    public void validateDashboardLabelName(String expectedLabelName){
        String actualLabelName = dashboardPageObjectModel.getDashboardLabelName();
        softly.assertThat(actualLabelName)
                .as("Actual text does not match expected text")
                .isEqualTo(expectedLabelName);
    }

    public void validateDashboardPageURL(String expectedURL){
        String actualURL = dashboardPageObjectModel.getDashboardURL();
        softly.assertThat(actualURL)
                .as("Actual URL does not match expected URL")
                .isEqualTo(expectedURL);
    }

    public void validateUserRoleLabelVisibility(){
        boolean isRoleVisible = dashboardPageObjectModel.isUserRoleLabelVisible();
        softly.assertThat(isRoleVisible)
                .as("Test Failed! User role label should be visible")
                .isTrue();
    }

    public void validateRoleName(String expectedRoleName){
        String actualRoleName = dashboardPageObjectModel.getUserRoleLabel();
        softly.assertThat(actualRoleName)
                .as("Actual role name does not match expected role name")
                .isEqualTo(expectedRoleName);
    }

    public void validateNavigationMenuVisibility(){
        boolean isMenuVisible = dashboardPageObjectModel.isNavigationMenuOpen();
        softly.assertThat(isMenuVisible)
                .as("Dropdown menu should be visible")
                .isTrue();
    }

    public void validateLogOutButtonVisibility(){
        boolean isLogOutVisible = dashboardPageObjectModel.isLogoutButtonVisible();
        softly.assertThat(isLogOutVisible)
                .as("Test Failed! Log out button should be visible on the dropdown")
                .isTrue();
    }

    public void validateLogOutButtonClick(){
        boolean isButtonEnabled = dashboardPageObjectModel.isLogoutButtonEnabled();
        softly.assertThat(isButtonEnabled)
                .as("Test Failed! Log out button should be enabled")
                .isTrue();
    }

    public void validateSettingsButtonVisibility(){
        boolean isButtonVisible = dashboardPageObjectModel.isSettingsButtonVisible();
        softly.assertThat(isButtonVisible)
                .as("Settings button should be visible on the dropdown menu")
                .isTrue();
    }

    public void validateSettingsButtonClick(){
        boolean isButtonEnabled = dashboardPageObjectModel.isSettingsButtonEnabled();
        softly.assertThat(isButtonEnabled)
                .as("Settings button should be enabled")
                .isTrue();
    }

    public void validateDashboardButtonState(){
        boolean isEnabled = dashboardPageObjectModel.isDashboardButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'Dashboard' button should be enabled.")
                .isTrue();
    }

    public void validateDeviceDetailsButtonVisibility(){
        boolean isVisible = dashboardPageObjectModel.isViewDeviceDetailsButtonVisible();
        softly.assertThat(isVisible)
                .as("'View Device Details' -button should be visible.")
                .isTrue();
    }

    public void validateDeviceDetailsButtonState(){
        boolean isEnabled = dashboardPageObjectModel.isViewDetailsButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'View Device Details' -button should be enabled.")
                .isTrue();
    }

    public void validateIfNewDeviceIsOnDashboard(){
        boolean isPresent = dashboardPageObjectModel.isNewDeviceOnDashboard();
        softly.assertThat(isPresent)
                .as("New created device should be visible on the BlastWeb dashboard.")
                .isTrue();
    }

    public void validateEventsButtonVisibility(){
        boolean isVisible = dashboardPageObjectModel.isEventsButtonVisible();
        softly.assertThat(isVisible)
                .as("Events button in footer section should be visible.")
                .isTrue();
    }

    public void validateEventsLogVisibility(){
        boolean isVisible = dashboardPageObjectModel.isEventsLogOpen();
        softly.assertThat(isVisible)
                .as("Events log should be visible.")
                .isTrue();
    }

    public void validateDeviceState(String expectedState){
        String actualState = dashboardPageObjectModel.getDeviceCurrentState();
        softly.assertThat(actualState)
                .as("Actual state does not match expected device state")
                .isEqualToIgnoringCase(expectedState);
    }

    public void validateOffsetToolTipVisibility(){
        boolean isVisible = dashboardPageObjectModel.isOffsetToolTipVisible();
        softly.assertThat(isVisible)
                .as("Offset tool tip should be displaying")
                .isTrue();
    }

    public void validateOffsetToolTipState(){
        boolean isEnabled = dashboardPageObjectModel.isOffsetToolTipEnabled();
        softly.assertThat(isEnabled)
                .as("Offset tool tip should be enabled")
                .isTrue();
    }

    public void validateOffsetChannelWindowVisibility(){
        boolean isVisible = dashboardPageObjectModel.isChannelOffsetWindowOpen();
        softly.assertThat(isVisible)
                .as("Channel offset window should be opened")
                .isTrue();
    }

    public void validateOffsetChannelFields(String channelNumber){
        boolean isVisible = dashboardPageObjectModel.isSixChannelFieldsVisible(channelNumber);
        softly.assertThat(isVisible)
                .as("Six channel offset fields should be displaying.")
                .isTrue();
    }

    public void validateOffsetDelayFieldVisibility(String channelOffsetDelayField){
        boolean isVisible = dashboardPageObjectModel.isChannelOffsetDelayFieldVisible(channelOffsetDelayField);
        softly.assertThat(isVisible)
                .as("Offset delay fields should be visible")
                .isTrue();
    }

    public void validateOffsetDelayFieldState(String channelOffsetDelayField){
        boolean isEnabled = dashboardPageObjectModel.isChannelOffsetDelayFieldEnabled(channelOffsetDelayField);
        softly.assertThat(isEnabled)
                .as("Channel offset delay field should be enabled")
                .isTrue();
    }

    public void validateSaveButtonVisibility(){
        boolean isVisible = dashboardPageObjectModel.isSaveButtonVisible();
        softly.assertThat(isVisible)
                .as("'Save' -button should be displaying")
                .isTrue();
    }

    public void validateSaveButtonState(){
        boolean isEnabled = dashboardPageObjectModel.isSaveButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'Save' -button should be enabled")
                .isTrue();
    }

    public void validateGroupByDropDownVisibility(){
        boolean isVisible = dashboardPageObjectModel.isGroupByDropDownVisible();
        softly.assertThat(isVisible)
                .as("'Group By' dropdown should be visible")
                .isTrue();
    }

    public void validateGroupByDropDownState(){
        boolean isEnabled = dashboardPageObjectModel.isGroupByDropDownEnabled();
        softly.assertThat(isEnabled)
                .as("'Group By' dropdown should be enabled.")
                .isTrue();
    }

    public void validateGroupByDropDownPanelVisibility(){
        boolean isVisible = dashboardPageObjectModel.isGroupByDownOpen();
        softly.assertThat(isVisible)
                .as("'Group By' dropdown should be opened")
                .isTrue();
    }

    public void validateAlertDropDownButtonVisibility(){
        boolean isVisible = dashboardPageObjectModel.isAlertDropDownButtonVisible();
        softly.assertThat(isVisible)
                .as("Alert dropdown button should be visible.")
                .isTrue();
    }

    public void validateAlertDropDownButtonState(){
        boolean isEnabled = dashboardPageObjectModel.isAlertDropDownButtonEnabled();
        softly.assertThat(isEnabled)
                .as("Alert dropdown button should be enabled.")
                .isTrue();
    }

    public void validateCurrentDeviceAlert(String expectedAlert){
        List<String> currentAlerts = dashboardPageObjectModel.getAllCurrentDeviceAlerts();
        softly.assertThat(currentAlerts)
                .as("Actual device alert does not match expected device alert")
                .anyMatch(alert -> alert.equalsIgnoreCase(expectedAlert));
    }

    public void validateReportTabVisibility(){
        boolean isVisible = dashboardPageObjectModel.isReportTabVisible();
        softly.assertThat(isVisible)
                .as("Reports tab should be visible on the dashboard.")
                .isTrue();
    }

    public void validateReportTabState(){
        boolean isEnabled = dashboardPageObjectModel.isReportTabEnabled();
        softly.assertThat(isEnabled)
                .as("Report tab should be enabled on the dashboard")
                .isTrue();
    }

    public void validateReportDropDownVisibility(){
        boolean isOpen = dashboardPageObjectModel.isReportsDropDownOpen();
        softly.assertThat(isOpen)
                .as("Report dropdown should be open")
                .isTrue();
    }

    public void validateErrorVisibilityOnEventLogReport(String event){
        boolean isVisible = dashboardPageObjectModel.isErrorPresentOnEventsReport(event);
        softly.assertThat(isVisible)
                .as("Error should be visible on the event report")
                .isTrue();
    }

    public void validateIfAlertsAreCleared(String alert,String device){
        boolean isCleared = dashboardPageObjectModel.isAlertRemoved(alert);
        softly.assertThat(isCleared)
                .as("All alerts/error should be cleared for device '%s'",device)
                .isTrue();
    }

    public void validateIfDevicesGroupByKey(){
        boolean isGrouped = dashboardPageObjectModel.isDeviceGroupedByKey();
        softly.assertThat(isGrouped)
                .as("Devices should be grouped by 'key'")
                .isTrue();
    }

    public void validateIfDeviceGroupByNetwork(){
        boolean isGrouped = dashboardPageObjectModel.isDeviceGroupedByNetwork();
        softly.assertThat(isGrouped)
                .as("Devices should be grouped by 'network'")
                .isTrue();
    }

    public void validateIfDeviceGroupedByState(){
        boolean isGrouped = dashboardPageObjectModel.isDeviceGroupedByState();
        softly.assertThat(isGrouped)
                .as("Devices should be grouped by 'state'")
                .isTrue();
    }

    public void validateIfDeviceGroupedByFirmware(){
        boolean isGrouped = dashboardPageObjectModel.isDeviceGroupedByFirmware();
        softly.assertThat(isGrouped)
                .as("Devices should be grouped by 'firmware'")
                .isTrue();
    }

    public void validateIfDeviceGroupedByCustom(){
        boolean isGrouped = dashboardPageObjectModel.isDeviceGroupedByCustom();
        softly.assertThat(isGrouped)
                .as("Devices should be grouped by 'custom'")
                .isTrue();
    }

    public void validateIfDeviceGroupedBySelected(){
        boolean isGrouped = dashboardPageObjectModel.isDeviceGroupedBySelected();
        softly.assertThat(isGrouped)
                .as("Devices should be grouped by 'selected'")
                .isTrue();
    }

    public void validateIfDeviceGroupedByAlive(){
        boolean isGrouped = dashboardPageObjectModel.isDeviceGroupedByAlive();
        softly.assertThat(isGrouped)
                .as("Devices should be grouped by 'alive'")
                .isTrue();
    }

    public void validateIfDeviceGroupByType(){
        boolean isGrouped = dashboardPageObjectModel.isDeviceGroupedByType();
        softly.assertThat(isGrouped)
                .as("Devices should be grouped by 'type'")
                .isTrue();
    }

    public void validateDeviceCheckboxVisibility(int checkbox){
        boolean isVisible = dashboardPageObjectModel.isDeviceCheckBoxVisible(checkbox);
        softly.assertThat(isVisible)
                .as("The checkbox should appear next to the device on the dashboard.")
                .isTrue();
    }

    public void validateDeviceCheckBoxState(int checkbox){
        boolean isEnabled = dashboardPageObjectModel.isDeviceCheckboxEnabled(checkbox);
        softly.assertThat(isEnabled)
                .as("The checkbox next to the device should be enabled on the dashboard")
                .isTrue();
    }

    public void validateIfDeviceIsSelected(int checkbox){
        boolean isSelected = dashboardPageObjectModel.isDeviceSelected(checkbox);
        softly.assertThat(isSelected)
                .as("Checkbox should be in a selected state.")
                .isTrue();
    }

    public void validateIfDeviceIsDeselected(int checkbox){
        boolean isDeselected = dashboardPageObjectModel.isDeviceDeselected(checkbox);
        softly.assertThat(isDeselected)
                .as("Device should be deselected.")
                .isTrue();
    }

    public void validateSelectAllCheckboxVisibility(){
        boolean isVisible = dashboardPageObjectModel.isSelectAllCheckBoxVisible();
        softly.assertThat(isVisible)
                .as("Select all checkbox should be visible")
                .isTrue();
    }

    public void validateSelectAllCheckBoxState(){
        boolean isEnabled = dashboardPageObjectModel.isSelectAllCheckBoxEnabled();
        softly.assertThat(isEnabled)
                .as("Select all checkbox should be enabled")
                .isTrue();
    }

    public void validateIfSelectAllCheckboxIsChecked(){
        boolean isChecked = dashboardPageObjectModel.isAllDevicesChecked();
        softly.assertThat(isChecked)
                .as("All devices should be selected.")
                .isTrue();
    }

    public void validateIfOffsetIsActive(){
        boolean isActive = dashboardPageObjectModel.isOffsetActive();
        softly.assertThat(isActive)
                .as("Offset should be in an active state")
                .isTrue();
    }

    public void validatePlusIconVisibility(){
        boolean isVisible = dashboardPageObjectModel.isPlusIconVisible();
        softly.assertThat(isVisible)
                .as("Plus icon to open action panel should be displaying on the dashboard top right corner.")
                .isTrue();
    }

    public void validatePlusIconState(){
        boolean isEnabled = dashboardPageObjectModel.isPlusIconEnabled();
        softly.assertThat(isEnabled)
                .as("Plus icon to open action panel should be enabled on the dashboard top right corner.")
                .isTrue();
    }

    public void validateActionPanelVisibility(){
        boolean isOpen = dashboardPageObjectModel.isActionPanelOpen();
        softly.assertThat(isOpen)
                .as("Action panel should be visible")
                .isTrue();
    }

    public void validateArmSelectedButtonVisibility(){
        boolean isVisible = dashboardPageObjectModel.isArmSelectedButtonVisible();
        softly.assertThat(isVisible)
                .as("Arm Selected button and its corresponding label should be displaying.")
                .isTrue();
    }

    public void validateIfDeviceIsReadyToBlast(){
        boolean readyToBlast = dashboardPageObjectModel.isDeviceReadyToBlast();
        softly.assertThat(readyToBlast)
                .as("Device should be in 'Ready to Blast' -state")
                .isTrue();
    }

    public void validateBlastSelectedOptionVisibility(){
        boolean isVisible = dashboardPageObjectModel.isBlastSelectedOptionAvailable();
        softly.assertThat(isVisible)
                .as("Blast Selected option should be visible in the action panel.")
                .isTrue();
    }

    public void validateArmAllReadyOptionVisibility(){
        boolean isVisible = dashboardPageObjectModel.isArmAllReadyOptionAvailable();
        softly.assertThat(isVisible)
                .as("'Arm All Ready' -button should be visible and its corresponding label.")
                .isTrue();
    }

    public void validateNoDeviceToArmSnackBarVisibility(){
        boolean isHidden = dashboardPageObjectModel.isNoDeviceToArmSnackBarHidden();
        softly.assertThat(isHidden)
                .as("Snack bar with message 'There are no devices to arm' should not be displaying.")
                .isTrue();
    }

    public void validateIfArmWirelessOptionIsAvailable(){
        boolean isVisible = dashboardPageObjectModel.isArmWirelessSelectedOptionAvailable();
        softly.assertThat(isVisible)
                .as("'Arm Wireless Selected' -option should be visible from the action panel.")
                .isTrue();
    }

    public void validateCyberDetDialogVisibility(){
        boolean isOpen = dashboardPageObjectModel.isCyberDetDialogOpen();
        softly.assertThat(isOpen)
                .as("CyberDet dialog should be open before user can select a blast group.")
                .isTrue();
    }

    public void validateBlastGroupDropDownVisibility(){
        boolean isVisible = dashboardPageObjectModel.isBlastGroupDropDownVisible();
        softly.assertThat(isVisible)
                .as("Blast group dropdown should be visible")
                .isTrue();
    }

    public void validateBlastGroupDropDownState(){
        boolean isEnabled = dashboardPageObjectModel.isBlastGroupDropDownEnabled();
        softly.assertThat(isEnabled)
                .as("Blast group dropdown should be enabled ")
                .isTrue();
    }

    public void validateReBlastCheckBoxVisibility(){
        boolean isVisible = dashboardPageObjectModel.isReBlastCheckBoxVisible();
        softly.assertThat(isVisible)
                .as("Re-blast checkbox should be visible on the Cyberdet dialogue window.")
                .isTrue();
    }

    public void validateReBlastCheckBoxState(){
        boolean isEnabled = dashboardPageObjectModel.isReBlastCheckBoxEnabled();
        softly.assertThat(isEnabled)
                .as("Re-blast checkbox should be enabled by default on the Cyberdet dialogue window.")
                .isTrue();
    }

    public void validateIfDeviceIsSelectedForReBlast(){
        boolean isSelected = dashboardPageObjectModel.isDeviceSelectedToReBlast();
        softly.assertThat(isSelected)
                .as("Device should be selected for re-blast.")
                .isTrue();
    }

    public void validateCyberDetOkButtonVisible(){
        boolean isVisible = dashboardPageObjectModel.isCyberDetOkButtonVisible();
        softly.assertThat(isVisible)
                .as("'OK' -button should be visible.")
                .isTrue();
    }

    public void validateCyberDetOkButtonState(){
        boolean isEnabled = dashboardPageObjectModel.isCyberDetOkButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'OK' -button should be enabled.")
                .isTrue();
    }
}