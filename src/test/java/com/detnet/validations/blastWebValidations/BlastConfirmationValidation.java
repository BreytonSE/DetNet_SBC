package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.BlastConfirmationPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class BlastConfirmationValidation {
    private final SoftAssertions softly;
    private final BlastConfirmationPageObjectModel blastConfirmationPageObjectModel;

    public BlastConfirmationValidation(BlastConfirmationPageObjectModel blastConfirmationPageObjectModel) {
        this.blastConfirmationPageObjectModel = blastConfirmationPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateBlastConfirmationPageURL(String expectedURL){
        String actualURL = blastConfirmationPageObjectModel.getPageURL();
        softly.assertThat(actualURL)
                .as("Actual URL does not match expected URL.")
                .isEqualTo(expectedURL);
    }

    public void validateBlastConfirmationPageVisibility(){
        boolean isFound = blastConfirmationPageObjectModel.isBlastConfirmationScreenOpen();
        softly.assertThat(isFound)
                .as("Blast confirmation page should be visible.")
                .isTrue();
    }

    public void validateProceedButtonVisibility(){
        boolean isVisible = blastConfirmationPageObjectModel.isProceedButtonVisible();
        softly.assertThat(isVisible)
                .as("'Proceed To Blast' -button should be visible.")
                .isTrue();
    }

    public void validateProceedButtonState(){
        boolean isEnabled = blastConfirmationPageObjectModel.isProceedButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'Proceed To Blast' -button should be enabled.")
                .isTrue();
    }

    public void validateNFCReaderConfirmationDialogVisibility(){
        boolean isVisible = blastConfirmationPageObjectModel.isNFCReaderConfirmationDialogVisible();
        softly.assertThat(isVisible)
                .as("NFC Reader confirmation dialog should be opened that prompt user to connect a NFC reader.")
                .isTrue();
    }

    public void validatePasswordPromptWindowVisibility(){
        boolean isVisible = blastConfirmationPageObjectModel.isPasswordPromptWindowOpen();
        softly.assertThat(isVisible)
                .as("Password prompt window should appear after user proceed with blast.")
                .isTrue();
    }

    public void validatePasswordFieldVisibility(){
        boolean isVisible = blastConfirmationPageObjectModel.isPasswordFieldVisible();
        softly.assertThat(isVisible)
                .as("Password field should be visible on the password prompt window.")
                .isTrue();
    }

    public void validatePasswordFieldState(){
        boolean isEnabled = blastConfirmationPageObjectModel.isPasswordFieldEnabled();
        softly.assertThat(isEnabled)
                .as("Password field should be enabled on the password prompt window")
                .isTrue();
    }

    public void validatePasswordFieldIsEmpty(){
        boolean isEmpty = blastConfirmationPageObjectModel.isPasswordFieldEmpty();
        softly.assertThat(isEmpty)
                .as("Password field should be empty by default.")
                .isTrue();
    }

    public void validateIfPasswordIsSet(){
        boolean isFilled = blastConfirmationPageObjectModel.isPasswordSet();
        softly.assertThat(isFilled)
                .as("Password field should be filled after user set password.")
                .isTrue();
    }

    public void validateContinueButtonVisibility(){
        boolean isVisible = blastConfirmationPageObjectModel.isContinueButtonVisible();
        softly.assertThat(isVisible)
                .as("Continue button should be visible.")
                .isTrue();
    }

    public void validateContinueButtonState(){
        boolean isEnabled = blastConfirmationPageObjectModel.isContinueButtonEnabled();
        softly.assertThat(isEnabled)
                .as("Continue button should be enabled.")
                .isTrue();
    }

    public void validateSuperVisorCredentialsWindowVisibility(){
        boolean isVisible = blastConfirmationPageObjectModel.isSuperVisorCredentialsWindowOpen();
        softly.assertThat(isVisible)
                .as("Supervisor credential window should be displaying.")
                .isTrue();
    }

    public void validateSupervisorUsernameFieldVisibility(){
        boolean isVisible = blastConfirmationPageObjectModel.isSupervisorUsernameFieldVisible();
        softly.assertThat(isVisible)
                .as("Username field should be displaying on the supervisor credentials alert window.")
                .isTrue();
    }

    public void validateSupervisorUsernameFieldState(){
        boolean isEnabled = blastConfirmationPageObjectModel.isSupervisorUsernameFieldEnabled();
        softly.assertThat(isEnabled)
                .as("Supervisor username input field should be enabled on the supervisor credentials alert window.")
                .isTrue();
    }

    public void validateSupervisorUsernameFieldIfEmpty(){
        boolean isEmpty = blastConfirmationPageObjectModel.isSupervisorUsernameFieldEmpty();
        softly.assertThat(isEmpty)
                .as("Supervisor username input field should be empty on the supervisor credentials alert window.")
                .isTrue();
    }

    public void validateSupervisorUsernameIsSet(){
        boolean isSet = blastConfirmationPageObjectModel.isSupervisorUsernameSet();
        softly.assertThat(isSet)
                .as("A supervisor username should be set in the username input field.")
                .isTrue();
    }

    public void validateSupervisorPasswordFieldVisibility(){
        boolean isVisible = blastConfirmationPageObjectModel.isSupervisorPasswordFieldVisible();
        softly.assertThat(isVisible)
                .as("Supervisor password input field should be displaying on the supervisor credentials window.")
                .isTrue();
    }

    public void validateSupervisorPasswordFieldState(){
        boolean isEnabled = blastConfirmationPageObjectModel.isSupervisorPasswordFieldEnabled();
        softly.assertThat(isEnabled)
                .as("Supervisor password input field should be enabled on the supervisor credentials window.")
                .isTrue();
    }

    public void validateSupervisorPasswordFieldIfEmpty(){
        boolean isEmpty = blastConfirmationPageObjectModel.isSupervisorPasswordEmpty();
        softly.assertThat(isEmpty)
                .as("Supervisor password input field should be empty by default on the supervisor credentials window.")
                .isTrue();
    }

    public void validateIfSupervisorPasswordIsSet(){
        boolean isSet = blastConfirmationPageObjectModel. isSupervisorPasswordSet();
        softly.assertThat(isSet)
                .as("Supervisor password should be set on the supervisor credentials window.")
                .isTrue();
    }

    public void validateStartBlastButtonVisibility(){
        boolean isVisible = blastConfirmationPageObjectModel.isStartBlastButtonVisible();
        softly.assertThat(isVisible)
                .as("Start Blast button should be visible.")
                .isTrue();
    }

    public void validateStartBlastButtonState(){
        boolean isEnabled = blastConfirmationPageObjectModel.isStartBlastButtonEnabled();
        softly.assertThat(isEnabled)
                .as("Start Blast button should be enabled.")
                .isTrue();
    }
}