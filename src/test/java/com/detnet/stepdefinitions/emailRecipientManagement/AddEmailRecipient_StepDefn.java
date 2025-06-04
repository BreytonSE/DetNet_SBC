package com.detnet.stepdefinitions.emailRecipientManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.EmailRecipientsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.EmailRecipientsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//  Scenario: Verify that recipients can be added to the system, ensuring that information can be written back to the backend
public class AddEmailRecipient_StepDefn {
    private final PageObjectManager pageObjectManager;

    public AddEmailRecipient_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user clicks on the Add Recipient button")
    public void the_user_clicks_on_the_add_recipient_button() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsValidation.validateAddRecipientButtonVisibility();
        emailRecipientsValidation.validateAddRecipientButtonState();
        emailRecipientsPageObjectModel.createEmailRecipient();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the Add Recipient form should be displayed")
    public void the_add_recipient_form_should_be_displayed() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsValidation.validateIfCreateRecipientFormIsOpen();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user enters the recipient email address")
    public void the_user_enters_the_recipient_email_address() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsValidation.validateEmailAddressInputFieldVisibility();
        emailRecipientsValidation.validateEmailAddressInputFieldState();
        emailRecipientsValidation.validateIfEmailAddressInputFieldIsEmpty();
        emailRecipientsPageObjectModel.setEmailAddress("moosaa@detnet.com");
        emailRecipientsValidation.validateEnteredEmailAddress("moosaa@detnet.com");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user enters the recipient first name")
    public void the_user_enters_the_recipient_first_name() throws InterruptedException {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsValidation.validateFirstNameInputFieldVisibility();
        emailRecipientsValidation.validateFirstNameInputFieldState();
        emailRecipientsValidation.validateIfFirstNameFieldIsEmpty();
        emailRecipientsPageObjectModel.setFirstName("Allie");
        emailRecipientsValidation.validateEnteredFirstName("Allie");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user enters the recipient last name")
    public void the_user_enters_the_recipient_last_name() {
//        TODO: Add logic here to validate and add recipient last name
    }
    @When("the user selects the recipient severity")
    public void the_user_selects_the_recipient_severity() {
//        TODO: Add logic here to validate recipient severity
    }
    @When("the user clicks the Add Recipient button to save the entry")
    public void the_user_clicks_the_add_recipient_button_to_save_the_entry() {
//        TODO: Add logic here to validate and add the recipient
    }
    @Then("the new recipient should appear in the recipients list as well is in the database")
    public void the_new_recipient_should_appear_in_the_recipients_list_as_well_is_in_the_database() {
//        TODO: Add logic here to validate that recipient is added to the backend
    }
}