package com.detnet.stepdefinitions.emailRecipientManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.EmailRecipientsPageObjectModel;
import com.detnet.pageObjects.SettingsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.EmailRecipientsValidation;
import com.detnet.validations.blastWebValidations.SettingsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that email recipients can be viewed
public class ViewEmailRecipients_StepDefn {
    private final PageObjectManager pageObjectManager;

    public ViewEmailRecipients_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user navigates to the Email Recipients section")
    public void the_user_navigates_to_the_email_recipients_section() {
        SettingsPageObjectModel settingsPageObjectModel = pageObjectManager.getSettingsPageObjectModel();
        SettingsValidation settingsValidation = new SettingsValidation(settingsPageObjectModel);
        settingsValidation.validateEmailRecipientsTabVisibility();
        settingsValidation.validateEmailRecipientsTabState();
        settingsValidation.validateEmailRecipientsText("Email Recipients");
        settingsPageObjectModel.viewEmailRecipients();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the user should be on the email recipients page")
    public void the_user_should_be_on_the_email_recipients_page() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsValidation.validateEmailRecipientsPageURL("http://localhost:8080/en/settings/emailRecipient");
        emailRecipientsValidation.validateEmailRecipientHeadingVisibility();
        emailRecipientsValidation.validateHeadingText("Recipient List");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("if the list is empty, the text {string} should be displayed")
    public void if_the_list_is_empty_the_text_should_be_displayed(String string) {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsValidation.validateIfEmailRecipientListIsEmpty();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}