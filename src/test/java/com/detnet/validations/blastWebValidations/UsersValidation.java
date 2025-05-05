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

    public void validateFirstNameInputFieldVisibility(){
        boolean isVisible = usersPageObjectModel.isFirstNameInputFieldVisible();
        softly.assertThat(isVisible)
                .as("First name input field should be visible")
                .isTrue();
    }

    public void validateFirstNameInputFieldState(){
        boolean isEnabled = usersPageObjectModel.isFirstNameInputFieldEnabled();
        softly.assertThat(isEnabled)
                .as("First name input field should be enabled")
                .isTrue();
    }

    public void validateIfFirstNameInputFieldIsEmpty(){
        boolean isEmpty = usersPageObjectModel.isFirstNameInputFieldEmpty();
        softly.assertThat(isEmpty)
                .as("First name input field should be empty")
                .isTrue();
    }

    public void validateEnteredFirstname(String expectedName){
        String actualName = usersPageObjectModel.getFirstName();
        softly.assertThat(actualName)
                .as("Actual name does not match expected name")
                .isEqualTo(expectedName);
    }

    public void validateSurnameInputFieldVisibility(){
        boolean isVisible = usersPageObjectModel.isSurnameInputFieldVisible();
        softly.assertThat(isVisible)
                .as("Surname input field should be visible")
                .isTrue();
    }

    public void validateSurnameInputFieldState(){
        boolean isEnabled = usersPageObjectModel.isSurnameInputFieldEnabled();
        softly.assertThat(isEnabled)
                .as("Surname input field should be enabled")
                .isTrue();
    }

    public void validateIfSurnameInputFieldIsEmpty(){
        boolean isEmpty = usersPageObjectModel.isSurnameInputFieldEmpty();
        softly.assertThat(isEmpty)
                .as("Surname input field should be empty")
                .isTrue();
    }

    public void validateEnteredSurname(String expectedSurname){
        String actualName = usersPageObjectModel.getSurname();
        softly.assertThat(actualName)
                .as("Actual name does not match expected name")
                .isEqualTo(expectedSurname);
    }

    public void validateRoleFieldVisibility(){
        boolean isVisible = usersPageObjectModel.isRoleFieldVisible();
        softly.assertThat(isVisible)
                .as("Role field should be visible")
                .isTrue();
    }

    public void validateRoleFieldState(){
        boolean isEnabled = usersPageObjectModel.isRoleFieldEnabled();
        softly.assertThat(isEnabled)
                .as("Role field should be enabled")
                .isTrue();
    }

    public void validateIfRoleDropDownIsOpen(){
        boolean isOpen = usersPageObjectModel.isRoleDropDownOpen();
        softly.assertThat(isOpen)
                .as("Role dropdown should be open")
                .isTrue();
    }

    public void validateSelectedRole(String expectedSelectedRole){
        String actualSelectedRole = usersPageObjectModel.getSelectedRole();
        softly.assertThat(actualSelectedRole)
                .as("Actual selected role does not match expected selected role")
                .isEqualTo(expectedSelectedRole);
    }

    public void validateIfCheckboxVisibility(){
        boolean isVisible = usersPageObjectModel.isCheckBoxVisible();
        softly.assertThat(isVisible)
                .as("Checkbox should be visible")
                .isTrue();
    }

    public void validateIfCheckBoxIsEnabled(){
        boolean isSelected = usersPageObjectModel.isCheckboxEnabled();
        softly.assertThat(isSelected)
                .as("Checkbox should be enabled by default")
                .isTrue();
    }

    public void validateAddUserSubmitButtonVisibility(){
        boolean isVisible = usersPageObjectModel.isSubmitButtonVisible();
        softly.assertThat(isVisible)
                .as("Add User button should be visible")
                .isTrue();
    }

    public void validateUserSubmitButtonState(){
        boolean isEnabled = usersPageObjectModel.isSubmitButtonEnabled();
        softly.assertThat(isEnabled)
                .as("Add User button should be enabled")
                .isTrue();
    }

    public void validateIfNewUserAdded(int rowNumber){
        boolean isAdded = usersPageObjectModel.isNewUserAdded(rowNumber);
        softly.assertThat(isAdded)
                .as("New user should be added and appear at row number: " + rowNumber)
                .isTrue();
    }

    public void validateNewUsername(String expectedUsername){
        String actualUsername = usersPageObjectModel.getNewUserName();
        softly.assertThat(actualUsername)
                .as("Actual username does not match expected username.")
                .isEqualTo(expectedUsername);
    }

    public void validateIfEditIconIsVisible(){
        boolean isVisible = usersPageObjectModel.isEditIconVisible();
        softly.assertThat(isVisible)
                .as("Edit icon should be visible.")
                .isTrue();
    }

    public void validateIfEditUserFormIsOpen(){
        boolean isVisible = usersPageObjectModel.isEditUserFormOpen();
        softly.assertThat(isVisible)
                .as("'Edit User' form should be visible.")
                .isTrue();
    }

    public void validateEditUserText(String expectedText){
        String actualText = usersPageObjectModel.getEditUserLabel();
        softly.assertThat(actualText)
                .as("Actual text does not match expected text.")
                .isEqualTo(expectedText);
    }

    public void validateIfSaveButtonIsPresent(){
        boolean isPresent = usersPageObjectModel.isSaveButtonPresent();
        softly.assertThat(isPresent)
                .as("'Save' -button should be visible.")
                .isTrue();
    }

    public void validateIfSaveButtonState(){
        boolean isEnabled = usersPageObjectModel.isSaveButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'Save' -button should be enabled.")
                .isTrue();
    }

    public void validateUpdatedSurname(String expectedSurname){
        String actualSurname = usersPageObjectModel.getUpdatedSurname();
        softly.assertThat(actualSurname)
                .as("Actual updated surname does not match expected updated surname")
                .isEqualTo(expectedSurname);
    }

    public void validateDeleteIconVisibility(int rowNumber){
        boolean isVisible = usersPageObjectModel.isDeleteIconVisible(rowNumber);
        softly.assertThat(isVisible)
                .as("Delete icon should be visible on row " + rowNumber + " in order to delete the user")
                .isTrue();
    }

    public void validateDeleteDialogBoxVisibility(){
        boolean isOpen = usersPageObjectModel.isDeleteDialogBoxOpen();
        softly.assertThat(isOpen)
                .as("Delete dialog box should be open after user clicked on trash bin icon.")
                .isTrue();
    }

    public void validateYesButtonVisibility(){
        boolean isVisible = usersPageObjectModel.isYesButtonPresent();
        softly.assertThat(isVisible)
                .as("'Yes' -button should be visible on the delete alert window")
                .isTrue();
    }
}