package com.detnet.stepdefinitions.emailRecipientManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.EmailRecipientsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.EmailRecipientsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//  Scenario: Verify that recipients can be edited, ensuring that information can be updated on the backend
public class EditRecipient_StepDefn {
    private final PageObjectManager pageObjectManager;

    public EditRecipient_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user clicks the pencil icon for a recipient")
    public void the_user_clicks_the_pencil_icon_for_a_recipient() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsValidation.validateEditIconVisibility();
        emailRecipientsValidation.validateEditIconState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        emailRecipientsPageObjectModel.openEditRecipientPage(2);
        emailRecipientsValidation.validateEditEditRecipientPageVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user edits the recipient information")
    public void the_user_edits_the_recipient_information() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        emailRecipientsPageObjectModel.selectSeverityLevel("Moderate");
    }
    @When("the user clicks the save button")
    public void the_user_clicks_the_save_button() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsValidation.validateEditRecipientSubmitButtonVisibility();
        emailRecipientsValidation.validateEditRecipientSubmitButtonState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        emailRecipientsPageObjectModel.updateRecipientDetails();
    }

    @When("update the interval")
    public void update_the_interval() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsValidation.validateIntervalDropDownVisibility();
        emailRecipientsValidation.validateIntervalDropDownState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        emailRecipientsPageObjectModel.openIntervalPanel();
        emailRecipientsValidation.validateIntervalDropDownPanelVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        emailRecipientsPageObjectModel.selectInterval("120 min");
    }

    @Then("the recipient data should be updated")
    public void the_recipient_data_should_be_updated() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsValidation.validateModerateSeverityLevelSelected(2);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}