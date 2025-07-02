package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.LoginPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class LoginValidation {
   private final LoginPageObjectModel loginPageObjectModel;
   private final SoftAssertions softly;

    public LoginValidation(LoginPageObjectModel loginPageObjectModel) {
        this.loginPageObjectModel = loginPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateUsernameField(String expectedUsername){
        String actualUsername = loginPageObjectModel.getUsername();
        softly.assertThat(actualUsername)
                .as("Validation Failed! Actual username does not match expected username")
                .isEqualTo(expectedUsername);
    }

    public void validatePasswordField(String expectedPassword){
        String actualPassword = loginPageObjectModel.getPassword();
        softly.assertThat(actualPassword)
                .as("Validation Failed! Actual password does not match expected password")
                .isEqualTo(expectedPassword);
    }

    public void validateLoginButtonClick(){
        boolean isButtonEnabled = loginPageObjectModel.isLoginButtonEnabled();
        softly.assertThat(isButtonEnabled)
                .as("Validation Failed! Login button should be enabled")
                .isTrue();
    }

    public void validatePasswordVisibilityIcon(){
        boolean isEyeIconVisible = loginPageObjectModel.isVisibilityIconVisible();
        softly.assertThat(isEyeIconVisible)
                .as("Validation Failed! Eye icon should be visible in the password input field")
                .isTrue();
    }

    public void validatePasswordVisibilityIconState(){
        boolean isEnabled = loginPageObjectModel.isVisibilityIconEnabled();
        softly.assertThat(isEnabled)
                .as("Password visibility icon should be enabled")
                .isTrue();
    }

    public void validateLoginPageURL(String expectedURL){
        String actualURL = loginPageObjectModel.getLoginURL();
        softly.assertThat(actualURL)
                .as("Actual URL does not match expected URL")
                .isEqualTo(expectedURL);
    }

    public void validatePasswordErrorVisibility(){
        boolean isPasswordErrorVisible = loginPageObjectModel.isPasswordErrorMessageVisible();
        softly.assertThat(isPasswordErrorVisible)
                .as("Test Failed! Password error message should be displaying")
                .isTrue();
    }

    public void validateErrorMessage(String expectedErrorMessage){
        String actualErrorMessage = loginPageObjectModel.getPasswordErrorLabel();
        softly.assertThat(actualErrorMessage)
                .as("Actual error message does not match expected error message")
                .isEqualTo(expectedErrorMessage);
    }

    public void validateUnauthorizedUserAlertVisibility(){
        boolean isAlertVisible = loginPageObjectModel.isUnauthorizedMessageVisible();
        softly.assertThat(isAlertVisible)
                .as("Unauthorized user label should be displaying if invalid credentials is entered")
                .isTrue();
    }

    public void validateUnauthorizedAlert(String expectedAlert){
        String actualAlert = loginPageObjectModel.getUnauthorizedLabel();
        softly.assertThat(actualAlert)
                .as("Actual alert message does not match expected alert message")
                .isEqualTo(expectedAlert);
    }

    public void validateIfPasswordIsShowing(){
        boolean isVisible = loginPageObjectModel.isPasswordShowing();
        softly.assertThat(isVisible)
                .as("Password should be visible after user toggled the password visibility.")
                .isTrue();
    }

    public void validateIfPasswordVisibilityChangedToText(){
        boolean isText = loginPageObjectModel.isPasswordFieldTypeText();
        softly.assertThat(isText)
                .as("Password should appear as text, and unhidden.")
                .isTrue();
    }

    public void validateIfPasswordIsHidden(){
        boolean isHidden = loginPageObjectModel.isPasswordHidden();
        softly.assertThat(isHidden)
                .as("Password should be hidden after user toggled the password visibility.")
                .isTrue();
    }

    public void validateIfPasswordVisibilityChangedToPassword(){
        boolean isPassword = loginPageObjectModel.isPasswordFieldPassword();
        softly.assertThat(isPassword)
                .as("Password should appear as dots or stars (hidden)")
                .isTrue();
    }

    public void validateIfCredentialsIsValid(){
        boolean isValid = loginPageObjectModel.isCredentialsValid();
        softly.assertThat(isValid)
                .as("Unauthorized user label should not be displaying when credentials is valid.")
                .isTrue();
    }
}