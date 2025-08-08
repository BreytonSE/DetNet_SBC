package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.PasswordResetPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class PasswordResetValidation {
    private final PasswordResetPageObjectModel passwordResetPageObjectModel;
    private final SoftAssertions softly;

    public PasswordResetValidation(PasswordResetPageObjectModel passwordResetPageObjectModel) {
        this.passwordResetPageObjectModel = passwordResetPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validatePasswordResetURL(String expectedURL){
        String actualURL = passwordResetPageObjectModel.getPasswordResetPageURL();
        softly.assertThat(actualURL)
                .as("Actual URL does not match expected URL.")
                .isEqualTo(expectedURL);
    }

    public void validatePasswordResetFormVisibility(){
        boolean isVisible = passwordResetPageObjectModel.isPasswordResetFormVisible();
        softly.assertThat(isVisible)
                .as("Password reset form should be visible where user can set a new password.")
                .isTrue();
    }

    public void validateCurrentPasswordFieldVisibility(){
        boolean isVisible = passwordResetPageObjectModel.isCurrentPasswordFieldVisible();
        softly.assertThat(isVisible)
                .as("'Current password' input field should be visible")
                .isTrue();
    }

    public void validateCurrentPasswordFieldState(){
        boolean isEnabled = passwordResetPageObjectModel.isCurrentPasswordFieldEnabled();
        softly.assertThat(isEnabled)
                .as("'Current password' field should be enabled")
                .isTrue();
    }

    public void validateIfCurrentPasswordFieldIsEmpty(){
        boolean isEmpty = passwordResetPageObjectModel.isCurrentPasswordFieldEmpty();
        softly.assertThat(isEmpty)
                .as("Current password field should be empty by default")
                .isTrue();
    }

    public void validateCurrentPassword(String expectedCurrentPassword){
        String actualCurrentPassword = passwordResetPageObjectModel.getCurrentPassword();
        softly.assertThat(actualCurrentPassword)
                .as("Actual current password does not match expected current password")
                .isEqualTo(expectedCurrentPassword);
    }

    public void validateNewPasswordFieldVisibility(){
        boolean isVisible = passwordResetPageObjectModel.isNewPasswordFieldVisible();
        softly.assertThat(isVisible)
                .as("'New Password' -input field should be visible")
                .isTrue();
    }

    public void validateNewPasswordFieldState(){
        boolean isEnabled = passwordResetPageObjectModel.isNewPasswordFieldEnabled();
        softly.assertThat(isEnabled)
                .as("'New Password' -input field should be enabled")
                .isTrue();
    }

    public void validateIfNewPasswordFieldIsEmpty(){
        boolean isEmpty = passwordResetPageObjectModel.isNewPasswordFieldEmpty();
        softly.assertThat(isEmpty)
                .as("New Password field should be empty by default")
                .isTrue();
    }

    public void validateNewPassword(String expectedPassword){
        String actualPassword = passwordResetPageObjectModel.getNewPassword();
        softly.assertThat(actualPassword)
                .as("Actual new password does not match expected new password.")
                .isEqualTo(expectedPassword);
    }

    public void validateConfirmedPasswordFieldVisibility(){
        boolean isVisible = passwordResetPageObjectModel.isConfirmedPasswordFieldVisible();
        softly.assertThat(isVisible)
                .as("'Confirm New Password' -input field should be visible")
                .isTrue();
    }

    public void validateConfirmedPasswordFieldState(){
        boolean isVisible = passwordResetPageObjectModel.isConfirmedPasswordFieldEnabled();
        softly.assertThat(isVisible)
                .as("'Confirm New Password' -input field should be enabled")
                .isTrue();
    }

    public void validateIfConfirmPasswordFieldIsEmpty(){
        boolean isEmpty = passwordResetPageObjectModel.isConfirmedPasswordFieldEmpty();
        softly.assertThat(isEmpty)
                .as("'Confirm New Password' -input field should be enabled")
                .isTrue();
    }

    public void validateConfirmedPassword(String expectedConfirmedPassword){
        String actualConfirmedPassword = passwordResetPageObjectModel.getConfirmedPassword();
        softly.assertThat(actualConfirmedPassword)
                .as("Actual confirmed password does not match expected confirmed password.")
                .isEqualTo(expectedConfirmedPassword);
        String actualNewPassword = passwordResetPageObjectModel.getNewPassword();
        softly.assertThat(actualNewPassword)
                .as("New actual password does not match expected confirmed password.")
                .isEqualTo(expectedConfirmedPassword);
    }

    public void validateChangePasswordButtonVisibility(){
        boolean isVisible = passwordResetPageObjectModel.isChangePasswordButtonVisible();
        softly.assertThat(isVisible)
                .as("'Change Password' button should be visible")
                .isTrue();
    }

    public void validateChangePasswordButtonState(){
        boolean isEnabled = passwordResetPageObjectModel.isChangedPasswordButtonEnabled();
        softly.assertThat(isEnabled)
                .as("Change password should be enabled")
                .isTrue();
    }

    public void validateCurrentPasswordVisibilityIconPresence(){
        boolean isVisible = passwordResetPageObjectModel.isCurrentPasswordVisibilityIconPresent();
        softly.assertThat(isVisible)
                .as("Password visibility icon should be present.")
                .isTrue();
    }

    public void validateCurrentPasswordVisibilityIconState(){
        boolean isEnabled = passwordResetPageObjectModel.isCurrentPasswordVisibilityIconEnabled();
        softly.assertThat(isEnabled)
                .as("Password visibility icon should be enabled before user can toggle password visibility")
                .isTrue();
    }

    public void validateIfCurrentPasswordIsShownAsText(){
        boolean isText = passwordResetPageObjectModel.isCurrentPasswordFieldTypeText();
        softly.assertThat(isText)
                .as("Current password visibility should appear as text")
                .isTrue();
    }

    public void validateIfCurrentPasswordIsHidden(){
        boolean isHidden = passwordResetPageObjectModel.isCurrentPasswordFieldPassword();
        softly.assertThat(isHidden)
                .as("Current password visibility should appear as text")
                .isTrue();
    }

    public void validateNewPasswordVisibilityIconState(){
        boolean isEnabled = passwordResetPageObjectModel.isNewPasswordVisibilityIconEnabled();
        softly.assertThat(isEnabled)
                .as("Password visibility icon should be enabled")
                .isTrue();
    }

    public void validateIfNewPasswordIsShowAsText(){
        boolean isText = passwordResetPageObjectModel.isNewPasswordFieldTypeText();
        softly.assertThat(isText)
                .as("Password should be showing as plain text")
                .isTrue();
    }

    public void validateIfNewPasswordIsHidden(){
        boolean isHidden = passwordResetPageObjectModel.isNewPasswordFieldPassword();
        softly.assertThat(isHidden)
                .as("Password should be hidden")
                .isTrue();
    }

    public void validateConfirmPasswordVisibilityIconPresence(){
        boolean isPresent = passwordResetPageObjectModel.isConfirmPasswordVisibilityIconPresent();
        softly.assertThat(isPresent)
                .as("Confirmed Password visibility icon should be visible.")
                .isTrue();
    }

    public void validateConfirmPasswordVisibilityIconState(){
        boolean isEnabled = passwordResetPageObjectModel.isConfirmPasswordVisibilityIconEnabled();
        softly.assertThat(isEnabled)
                .as("Confirmed Password visibility icon should be enabled.")
                .isTrue();
    }

    public void validateIfConfirmedPasswordIsHidden(){
        boolean isHidden = passwordResetPageObjectModel.isConfirmedPasswordHidden();
        softly.assertThat(isHidden)
                .as("Confirmed password should be hidde")
                .isTrue();
    }

    public void validateIfConfirmPasswordIsText(){
        boolean isText = passwordResetPageObjectModel.isConfirmedPasswordText();
        softly.assertThat(isText)
                .as("Confirmed password should be displayed as plain text")
                .isTrue();
    }

    public void validatePasswordResetSuccess(){
        boolean isUpdated = passwordResetPageObjectModel.isPasswordUpdated();
        softly.assertThat(isUpdated)
                .as("Password should be updated successfully.")
                .isTrue();
    }
}