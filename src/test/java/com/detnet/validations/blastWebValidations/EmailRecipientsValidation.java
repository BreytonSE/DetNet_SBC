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

     public void validateLastNameFieldVisibility(){
        boolean isVisible = emailRecipientsPageObjectModel.isLastnameFieldVisible();
        softly.assertThat(isVisible)
                .as("Last name field should be visible")
                .isTrue();
     }

     public void validateLastNameFieldState(){
        boolean isEnabled = emailRecipientsPageObjectModel.isLastNameFieldEnabled();
        softly.assertThat(isEnabled)
                .as("Last name field should be enabled")
                .isTrue();
     }

     public void validateIfLastNameFieldIsEmpty(){
        boolean isEmpty = emailRecipientsPageObjectModel.isLastNameFieldEmpty();
        softly.assertThat(isEmpty)
                .as("Last name field should be empty by default")
                .isTrue();
     }

     public void validateEnteredLastName(String expectedLastName){
        String actualLastName = emailRecipientsPageObjectModel.getLastName();
        softly.assertThat(actualLastName)
                .as("Actual last name does not match expected last name")
                .isEqualTo(expectedLastName);
     }

     public void validateSeverityLevelVisibility(){
        boolean isVisible = emailRecipientsPageObjectModel.isSeverityLevelsVisible();
        softly.assertThat(isVisible)
                .as("Severity levels should be visible")
                .isTrue();
     }

     public void validateSelectedSeverity(String expectedSeverity){
        String actualSeverity = emailRecipientsPageObjectModel.getSelectedSeverity();
        softly.assertThat(actualSeverity)
                .as("Actual severity does not match expected severity")
                .isEqualTo(expectedSeverity);
     }

     public void validateSaveRecipientButtonVisibility(){
        boolean isVisible = emailRecipientsPageObjectModel.isSaveRecipientButtonVisible();
        softly.assertThat(isVisible)
                .as("'+Add Recipient' -button should be visible")
                .isTrue();
     }

     public void validateSaveRecipientButtonState(){
        boolean isEnabled = emailRecipientsPageObjectModel.isSaveRecipientButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'+Add Recipient' -button should be enabled")
                .isTrue();
     }

     public void validateIfRecipientExists(String recipient){
        boolean exists = emailRecipientsPageObjectModel.isRecipientAdded(recipient);
        softly.assertThat(exists)
                .as("Recipient should exist on the 'Recipient List View' -page")
                .isTrue();
     }

     public void validateEditIconVisibility(){
        boolean isVisible = emailRecipientsPageObjectModel.isEditIconVisible();
        softly.assertThat(isVisible)
                .as("Edit/pencil icon should be visible")
                .isTrue();
     }

     public void validateEditIconState(){
        boolean isEnabled = emailRecipientsPageObjectModel.isEditIconEnabled();
        softly.assertThat(isEnabled)
                .as("Edit icon should be enabled")
                .isTrue();
     }

     public void validateEditEditRecipientPageVisibility(){
        boolean isVisible = emailRecipientsPageObjectModel.isEditRecipientPageOpen();
        softly.assertThat(isVisible)
                .as("Edit Recipient page should be open.")
                .isTrue();
     }

     public void validateEditRecipientSubmitButtonVisibility(){
        boolean isVisible = emailRecipientsPageObjectModel.isEditSubmitButtonVisible();
        softly.assertThat(isVisible)
                .as("Edit submit button should be visible")
                .isTrue();
     }

     public void validateEditRecipientSubmitButtonState(){
        boolean isEnabled = emailRecipientsPageObjectModel.isEditSubmitButtonEnabled();
        softly.assertThat(isEnabled)
                .as("Edit submit button should be enabled.")
                .isTrue();
     }

     public void validateModerateSeverityLevelSelected(int row){
        boolean isChecked = emailRecipientsPageObjectModel.isModerateSeverityLevelSelected(row);
        softly.assertThat(isChecked)
                .as("Moderate severity level should be checked")
                .isTrue();
     }

     public void validateSearchBarVisibility(){
        boolean isVisible = emailRecipientsPageObjectModel.isSearchBarVisible();
        softly.assertThat(isVisible)
                .as("Search bar should be visible.")
                .isTrue();
     }

     public void validateSearchBarState(){
        boolean isEnabled = emailRecipientsPageObjectModel.isSearchBarEnabled();
        softly.assertThat(isEnabled)
                .as("Search bar should be enabled")
                .isTrue();
     }

     public void validateIfSearchBarIsEmpty(){
        boolean isEmpty = emailRecipientsPageObjectModel.isSearchBarEmpty();
        softly.assertThat(isEmpty)
                .as("Search bar should be empty by default.")
                .isTrue();
     }

     public void validateIntervalDropDownVisibility(){
        boolean isVisible = emailRecipientsPageObjectModel.isIntervalDropdownVisible();
        softly.assertThat(isVisible)
                .as("Interval dropdown should be visible")
                .isTrue();
     }

     public void validateIntervalDropDownState(){
        boolean isEnabled = emailRecipientsPageObjectModel.isIntervalDropDownEnabled();
        softly.assertThat(isEnabled)
                .as("Interval dropdown box should be enabled")
                .isTrue();
     }

     public void validateIntervalDropDownPanelVisibility(){
        boolean isOpen = emailRecipientsPageObjectModel.isIntervalDropDownPanelOpen();
        softly.assertThat(isOpen)
                .as("Interval dropdown panel should be open")
                .isTrue();
     }

     public void validateDeleteIconVisibility(int rowNumber){
        boolean isVisible = emailRecipientsPageObjectModel.isDeleteIconVisible(rowNumber);
        softly.assertThat(isVisible)
                .as("Bin icon should be displaying")
                .isTrue();
     }

     public void validateDeleteDialogVisibility(){
        boolean isVisible = emailRecipientsPageObjectModel.isDeleteDialogVisible();
        softly.assertThat(isVisible)
                .as("Delete dialog should be visible")
                .isTrue();
     }

     public void validateIfRecipientIsDeleted(String recipientEmail){
        boolean isDeleted = emailRecipientsPageObjectModel.isRecipientDeleted(recipientEmail);
        softly.assertThat(isDeleted)
                .as("Recipient should not exist on the recipient list")
                .isTrue();
     }

     public void validateCheckboxVisibility(){
        boolean isVisible = emailRecipientsPageObjectModel.isCheckboxVisible();
        softly.assertThat(isVisible)
                .as("Check box should be visible")
                .isTrue();
     }

     public void validateCheckboxState(){
        boolean isEnabled = emailRecipientsPageObjectModel.isCheckBoxEnabled();
        softly.assertThat(isEnabled)
                .as("Checkbox should be enabled")
                .isTrue();
     }

     public void validateDeleteAllButtonVisibility(){
        boolean isVisible = emailRecipientsPageObjectModel.isDeleteAllRecipientsButtonVisible();
        softly.assertThat(isVisible)
                .as("'Delete Recipients' -button should be visible")
                .isTrue();
     }

     public void validateDeleteAllButtonState(){
        boolean isEnabled = emailRecipientsPageObjectModel.isDeleteAllRecipientsButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'Delete Recipient' -button should be enabled")
                .isTrue();
     }
}