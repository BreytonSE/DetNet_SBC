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
}