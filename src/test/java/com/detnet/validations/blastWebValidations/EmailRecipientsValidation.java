package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.EmailRecipientsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class EmailRecipientsValidation {
    private final EmailRecipientsPageObjectModel emailRecipientsPageObjectModel;
    private final SoftAssertions softly;

    public EmailRecipientsValidation(EmailRecipientsPageObjectModel emailRecipientsPageObjectModel) {
        this.emailRecipientsPageObjectModel = emailRecipientsPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateEmailRecipientsPageURL(String expectedURL){
        String actualURL = emailRecipientsPageObjectModel.getEmailRecipientPageURL();
        softly.assertThat(actualURL)
                .as("Actual URL does not match expected URL")
                .isEqualTo(expectedURL);
    }

    public void validateEmailRecipientHeadingVisibility(){
        boolean isVisible = emailRecipientsPageObjectModel.isRecipientListHeadingVisible();
        softly.assertThat(isVisible)
                .as("'Recipient List' -heading should be visible")
                .isTrue();
    }

    public void validateHeadingText(String expectedText){
        String actualText = emailRecipientsPageObjectModel.getHeadingText();
        softly.assertThat(actualText)
                .as("Actual text does not match expected text.")
                .isEqualTo(expectedText);
    }

    public void validateIfEmailRecipientListIsEmpty(){
        boolean isEmpty = emailRecipientsPageObjectModel.isRecipientListEmpty();
        softly.assertThat(isEmpty)
                .as("Email recipient list should be empty")
                .isTrue();
    }

    public void validateAddRecipientButtonVisibility(){
        boolean isVisible = emailRecipientsPageObjectModel.isAddRecipientButtonVisible();
        softly.assertThat(isVisible)
                .as("'+Add Recipient' -button should be visible")
                .isTrue();
    }

    public void validateAddRecipientButtonState(){
        boolean isEnabled = emailRecipientsPageObjectModel.isAddRecipientButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'+Add Recipient' -button should be enabled")
                .isTrue();
    }

    public void validateIfCreateRecipientFormIsOpen(){
        boolean isOpen = emailRecipientsPageObjectModel.isAddRecipientFormVisible();
        softly.assertThat(isOpen)
                .as("Add Recipient form should be open")
                .isTrue();
    }

     public void validateEmailAddressInputFieldVisibility(){
        boolean isVisible = emailRecipientsPageObjectModel.isEmailAddressFieldVisible();
        softly.assertThat(isVisible)
                .as("Email address input field should be visible.")
                .isTrue();
     }

     public void validateEmailAddressInputFieldState(){
        boolean isEnabled = emailRecipientsPageObjectModel.isEmailAddressFieldEnabled();
        softly.assertThat(isEnabled)
                .as("Email address input field should be enabled")
                .isTrue();
     }

     public void validateIfEmailAddressInputFieldIsEmpty(){
        boolean isEmpty = emailRecipientsPageObjectModel.isEmailAddressFieldEmpty();
        softly.assertThat(isEmpty)
                .as("Email address field should be empty by default")
                .isTrue();
     }

     public void validateEnteredEmailAddress(String expectedEmailAddress){
        String actualEmailAddress = emailRecipientsPageObjectModel.getEmailAddress();
        softly.assertThat(actualEmailAddress)
                .as("Actual email address does not match expected email address")
                .isEqualTo(expectedEmailAddress);
     }

     public void validateFirstNameInputFieldVisibility(){
        boolean isVisible = emailRecipientsPageObjectModel.isFirstNameFieldVisible();
        softly.assertThat(isVisible)
                .as("First name input field should be visible")
                .isTrue();
     }

     public void validateFirstNameInputFieldState(){
        boolean isEnabled = emailRecipientsPageObjectModel.isFirstNameFieldEnabled();
        softly.assertThat(isEnabled)
                .as("First name input field should be enabled")
                .isTrue();
     }

     public void validateIfFirstNameFieldIsEmpty(){
        boolean isEmpty = emailRecipientsPageObjectModel.isFirstNameFieldEmpty();
        softly.assertThat(isEmpty)
                .as("First name input field should be empty.")
                .isTrue();
     }

     public void validateEnteredFirstName(String expectedFirstName){
        String actualFirstName = emailRecipientsPageObjectModel.getFirstName();
        softly.assertThat(actualFirstName)
                .as("Actual first name does not match expected first name")
                .isEqualTo(expectedFirstName);
     }
}