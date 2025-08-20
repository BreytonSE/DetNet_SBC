package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.UserAccountPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class UserAccountValidations {
    private final UserAccountPageObjectModel userAccountPageObjectModel;
    private final SoftAssertions softly;

    public UserAccountValidations(UserAccountPageObjectModel userAccountPageObjectModel) {
        this.userAccountPageObjectModel = userAccountPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateUserDetailsPageURL(String expectedURL){
        String actualURL = userAccountPageObjectModel.getUserAccountURL();
        softly.assertThat(actualURL)
                .as("Actual URL does not match expected URL.")
                .isEqualTo(expectedURL);
    }

    public void validateIfUserDetailsPageVisibility(){
        boolean isVisible = userAccountPageObjectModel.isUserAccountPageVisible();
        softly.assertThat(isVisible)
                .as("User account details page should be displaying.")
                .isTrue();
    }

    public void validateEditDetailsButtonVisibility(){
        boolean isVisible = userAccountPageObjectModel.isEditDetailsButtonVisible();
        softly.assertThat(isVisible)
                .as("'Edit Details' -button should be displaying on user account page.")
                .isTrue();
    }

    public void validateEditDetailsButtonState(){
        boolean isEnabled = userAccountPageObjectModel.isEditDetailsButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'Edit Details' -button should be enabled on user account page.")
                .isTrue();
    }

    public void validateEditDetailsButtonText(String expectedText){
        String actualText = userAccountPageObjectModel.getEditDetailsButtonText();
        softly.assertThat(actualText)
                .as("Actual text on button does not match expected text.")
                .isEqualTo(expectedText);
    }

    public void validatePasswordChangeButtonVisibility(){
        boolean isVisible = userAccountPageObjectModel.isPasswordChangeButtonVisible();
        softly.assertThat(isVisible)
                .as("'Change My Password' -button should be displaying on user account page.")
                .isTrue();
    }

    public void validatePasswordChangeButtonState(){
        boolean isEnabled = userAccountPageObjectModel.isPasswordChangeButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'Change My Password' -button should be enabled on user account page.")
                .isTrue();
    }

    public void validatePasswordChangeButtonText(String expectedText){
        String actualText = userAccountPageObjectModel.getPasswordChangeButtonText();
        softly.assertThat(actualText)
                .as("Actual button text does not match expected button text.")
                .isEqualTo(expectedText);
    }
}