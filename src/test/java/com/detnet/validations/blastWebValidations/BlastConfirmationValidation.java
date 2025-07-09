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
}