package com.detnet.validations;

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
}