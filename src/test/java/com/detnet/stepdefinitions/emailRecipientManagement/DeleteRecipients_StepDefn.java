package com.detnet.stepdefinitions.emailRecipientManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.EmailRecipientsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.EmailRecipientsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

// Scenario: Verify that user can delete a single recipients, as well as multiple recipients
public class DeleteRecipients_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DeleteRecipients_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("delete a single recipient")
    public void delete_a_single_recipient() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsValidation.validateDeleteIconVisibility(1);
        emailRecipientsPageObjectModel.deleteRecipient(1);
        emailRecipientsValidation.validateDeleteDialogVisibility();
        emailRecipientsPageObjectModel.confirmToDeleteRecipient();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("verify the single recipient is deleted")
    public void verify_the_single_recipient_is_deleted() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsValidation.validateIfRecipientIsDeleted("alice.bennett@testmail.com");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("delete multiple recipients")
    public void delete_multiple_recipients() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsValidation.validateCheckboxVisibility();
        emailRecipientsValidation.validateCheckboxState();
        emailRecipientsPageObjectModel.selectAllRecipients();
        emailRecipientsPageObjectModel.selectOrDeselectRecipients(1);
        emailRecipientsPageObjectModel.selectOrDeselectRecipients(2);
        emailRecipientsPageObjectModel.selectOrDeselectRecipients(3);
        emailRecipientsValidation.validateDeleteAllButtonVisibility();
        emailRecipientsValidation.validateDeleteAllButtonState();
        emailRecipientsPageObjectModel.deleteAllRecipients();
        emailRecipientsPageObjectModel.confirmToDeleteRecipient();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("verify that selected recipients is deleted")
    public void verify_that_selected_recipients_is_deleted() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsValidation.validateIfRecipientIsDeleted("emma.foster@testmail.com");
        emailRecipientsValidation.validateIfRecipientIsDeleted("felix.gray@testmail.com");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}