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
                .isEqualTo(expectedState);
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
}