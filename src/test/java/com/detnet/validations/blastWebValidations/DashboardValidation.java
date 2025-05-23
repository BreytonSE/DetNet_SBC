package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

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
}