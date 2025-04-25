package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.UsersPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class UsersValidation {
    private final UsersPageObjectModel usersPageObjectModel;
    private final SoftAssertions softly;

    public UsersValidation(UsersPageObjectModel usersPageObjectModel) {
        this.usersPageObjectModel = usersPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateUsersURL(String expectedURL){
        String actualURL = usersPageObjectModel.getUsersURL();
        softly.assertThat(actualURL)
                .as("Actual URL does not match expected URL.")
                .isEqualTo(expectedURL);
    }

    public void validateUserLabelVisibility(){
        boolean isLabelDisplayed = usersPageObjectModel.isUsersLabelVisible();
        softly.assertThat(isLabelDisplayed)
                .as("'Users' label should be visible")
                .isTrue();
    }

    public void validateUserLabelText(String expectedText){
        String actualText = usersPageObjectModel.getUsersLabel();
        softly.assertThat(actualText)
                .as("Actual text does not match expected text")
                .isEqualTo(expectedText);
    }

    public void validateUserVisibility(){
        boolean isDisplayed = usersPageObjectModel.isUserVisible();
        softly.assertThat(isDisplayed)
                .as("System users should be visible")
                .isTrue();
    }

    public void validateAddUserButtonVisibility(){
        boolean isButtonVisible = usersPageObjectModel.isAddUserButtonVisible();
        softly.assertThat(isButtonVisible)
                .as("'+Add User' -button should be visible")
                .isTrue();
    }

    public void validateAddUserButtonState(){
        boolean isButtonEnabled = usersPageObjectModel.isAddUserButtonEnabled();
        softly.assertThat(isButtonEnabled)
                .as("'+Add User' -button should be enabled")
                .isTrue();
    }

    public void validateAddUserLabelVisibility(){
        boolean isLabelVisible = usersPageObjectModel.isAddUserFormOpen();
        softly.assertThat(isLabelVisible)
                .as("'Add User' label should be visible")
                .isTrue();
    }

    public void validateAddUserFormURL(String expectedURL){
        String actualURL = usersPageObjectModel.getAddUserURL();
        softly.assertThat(actualURL)
                .as("Actual URL does not match expected URL")
                .isEqualTo(expectedURL);
    }

    public void validateAddUserFormHeader(String expectedHeading){
        String actualHeading = usersPageObjectModel.getAddUserLabel();
        softly.assertThat(actualHeading)
                .as("Actual text does not match expected text")
                .isEqualTo(expectedHeading);
    }

    public void validateUsernameInputFieldVisibility(){
        boolean isVisible = usersPageObjectModel.isUsernameInputFieldVisible();
        softly.assertThat(isVisible)
                .as("'Username' -input field should be visible")
                .isTrue();
    }

    public void validateUsernameInputFieldState(){
        boolean isEnabled = usersPageObjectModel.isUsernameInputFieldEnabled();
        softly.assertThat(isEnabled)
                .as("'Username' -input field should be enabled")
                .isTrue();
    }

    public void validateIfUsernameFieldIsEmpty(){
        boolean isEmpty = usersPageObjectModel.isUsernameInputFieldEmpty();
        softly.assertThat(isEmpty)
                .as("Username input field should be empty")
                .isTrue();
    }

    public void validateEnteredUsername(String expectedUsername){
        String actualUsername = usersPageObjectModel.getUsername();
        softly.assertThat(actualUsername)
                .as("Actual username does not match expected username")
                .isEqualTo(expectedUsername);
    }

    public void validateEmailInputFieldVisibility(){
        boolean isVisible = usersPageObjectModel.isEmailInputFieldVisible();
        softly.assertThat(isVisible)
                .as("Email input field should be visible")
                .isTrue();
    }

    public void validateEmailInputFieldState(){
        boolean isEnabled = usersPageObjectModel.isEmailInputFieldEnabled();
        softly.assertThat(isEnabled)
                .as("Email input field should be enabled")
                .isTrue();
    }

    public void validateEmailInputFieldIfEmpty(){
        boolean isEmpty = usersPageObjectModel.isEmailInputFieldEmpty();
        softly.assertThat(isEmpty)
                .as("Email input field should be empty by default")
                .isTrue();
    }

    public void validateEnteredEmail(String expectedEmail){
        String actualEmail = usersPageObjectModel.getEmail();
        softly.assertThat(actualEmail)
                .as("Actual email does not match expected email")
                .isEqualTo(expectedEmail);
    }
}