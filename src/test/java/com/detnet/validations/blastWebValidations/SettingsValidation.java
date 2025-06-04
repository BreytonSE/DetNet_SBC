package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.SettingsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class SettingsValidation {
    private final SettingsPageObjectModel settingsPageObjectModel;
    private final SoftAssertions softly;

    public SettingsValidation(SettingsPageObjectModel settingsPageObjectModel) {
        this.settingsPageObjectModel = settingsPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateSettingsLabelVisibility(){
        boolean isSettingsLabelVisible = settingsPageObjectModel.isSettingsLabelVisible();
        softly.assertThat(isSettingsLabelVisible)
                .as("Settings label should be visible when navigating to settings screen")
                .isTrue();
    }

    public void validateSettingsLabelName(String expectedLabelName){
        String actualLabelName = settingsPageObjectModel.getSettingsLabel();
        softly.assertThat(actualLabelName)
                .as("Actual label name does not match expected label name")
                .isEqualTo(expectedLabelName);
    }

    public void validateSettingsURL(String expectedURL){
        String actualURL = settingsPageObjectModel.getSettingsURL();
        softly.assertThat(actualURL)
                .as("Actual URL does not match expected URL")
                .isEqualTo(expectedURL);
    }

    public void validateBlastCardClick(){
        boolean isButtonEnabled = settingsPageObjectModel.isBlastCardButtonEnabled();
        softly.assertThat(isButtonEnabled)
                .as("Blast Card button should be enabled")
                .isTrue();
    }

    public void validateBlastCardButtonVisibility(){
        boolean isButtonVisible = settingsPageObjectModel.isBlastCardButtonVisible();
        softly.assertThat(isButtonVisible)
                .as("Blast Card button should be visible")
                .isTrue();
    }

    public void validateUserButtonVisibility(){
        boolean isButtonVisible = settingsPageObjectModel.isUserButtonVisible();
        softly.assertThat(isButtonVisible)
                .as("'Users' button should be visible under settings menu.")
                .isTrue();
    }

    public void validateUserButtonState(){
        boolean isButtonEnabled = settingsPageObjectModel.isUserButtonEnabled();
        softly.assertThat(isButtonEnabled)
                .as("'Users' button should enabled.")
                .isTrue();
    }

    public void validateUsersButtonText(String expectedText){
        String actualText = settingsPageObjectModel.getUsersLabel();
        softly.assertThat(actualText)
                .as("Actual text does not match expected text")
                .isEqualTo(expectedText);
    }

    public void validateNetworksTabVisibility(){
        boolean isPresent = settingsPageObjectModel.isNetworksTabPresent();
        softly.assertThat(isPresent)
                .as("'Networks' -tab should be present in the left side menu bar.")
                .isTrue();
    }

    public void validateDevicesTabVisibility(){
        boolean isVisible = settingsPageObjectModel.isDeviceTabPresent();
        softly.assertThat(isVisible)
                .as("Devices tab should be visible on the settings menu on the left")
                .isTrue();
    }

    public void validateDeviceTabState(){
        boolean isEnabled = settingsPageObjectModel.isDeviceTabEnabled();
        softly.assertThat(isEnabled)
                .as("Devices tab should be enabled on the settings menu on the left")
                .isTrue();
    }

    public void validateDevicesTabText(String expectedText){
        String actualText = settingsPageObjectModel.getDeviceTabText();
        softly.assertThat(actualText)
                .as("Actual text does not match expected text.")
                .isEqualTo(expectedText);
    }

    public void validateNetworkTreeTabVisibility(){
        boolean isVisible = settingsPageObjectModel.isNetworkTreeTabVisible();
        softly.assertThat(isVisible)
                .as("Network Tree tab should be visible.")
                .isTrue();
    }

    public void validateNetworkTreeTabText(String expectedText){
        String actualText = settingsPageObjectModel.getNetworkTreeText();
        softly.assertThat(actualText)
                .as("Actual text does not match expected text.")
                .isEqualTo(expectedText);
    }

    public void validateGroupsTabVisibility(){
        boolean isVisible = settingsPageObjectModel.isGroupsTabVisible();
        softly.assertThat(isVisible)
                .as("'Groups' -tab should be visible")
                .isTrue();
    }

    public void validateGroupsTabText(String expectedText){
        String actualText = settingsPageObjectModel.getGroupsTabText();
        softly.assertThat(actualText)
                .as("Actual text does not match expected text.")
                .isEqualTo(expectedText);
    }

    public void validateEmailRecipientsTabVisibility(){
        boolean isVisible = settingsPageObjectModel.isEmailRecipientsTabVisible();
        softly.assertThat(isVisible)
                .as("'Email Recipients' -tab should be visible")
                .isTrue();
    }

    public void validateEmailRecipientsTabState(){
        boolean isEnabled = settingsPageObjectModel.isEmailRecipientsTabEnabled();
        softly.assertThat(isEnabled)
                .as("'Email Recipients' -tab should be enabled")
                .isTrue();
    }

    public void validateEmailRecipientsText(String expectedText){
        String actualText = settingsPageObjectModel.getEmailRecipientsTabText();
        softly.assertThat(actualText)
                .as("Actual text does not match expected text.")
                .isEqualTo(expectedText);
    }
}