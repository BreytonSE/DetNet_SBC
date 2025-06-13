package com.detnet.stepdefinitions.emailRecipientManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.EmailRecipientsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.EmailRecipientsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

// Scenario: Verify that additional recipients can be added to the system
public class AddAdditionalEmailRecipients_StepDefn {
    private final PageObjectManager pageObjectManager;

    public AddAdditionalEmailRecipients_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Then("the user creates a second recipient")
    public void the_user_creates_a_second_recipient() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsPageObjectModel.setEmailAddress("brian.cooper@testmail.com");
        emailRecipientsPageObjectModel.setFirstName("Brian");
        emailRecipientsPageObjectModel.setLastName("Cooper");
        emailRecipientsPageObjectModel.saveNewRecipient();
        emailRecipientsValidation.validateIfRecipientExists("brian.cooper@testmail.com");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the user creates a third recipient")
    public void the_user_creates_a_third_recipient() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsPageObjectModel.createEmailRecipient();
        emailRecipientsPageObjectModel.setEmailAddress("carla.diaz@testmail.com");
        emailRecipientsPageObjectModel.setFirstName("Carla");
        emailRecipientsPageObjectModel.setLastName("Diaz");
        emailRecipientsPageObjectModel.saveNewRecipient();
        emailRecipientsValidation.validateIfRecipientExists("carla.diaz@testmail.com");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the user creates a fourth recipient")
    public void the_user_creates_a_fourth_recipient() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsPageObjectModel.createEmailRecipient();
        emailRecipientsPageObjectModel.setEmailAddress("daniel.evans@testmail.com");
        emailRecipientsPageObjectModel.setFirstName("Daniel");
        emailRecipientsPageObjectModel.setLastName("Evans");
        emailRecipientsPageObjectModel.saveNewRecipient();
        emailRecipientsValidation.validateIfRecipientExists("daniel.evans@testmail.com");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the user creates a fifth recipient")
    public void the_user_creates_a_fifth_recipient() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsPageObjectModel.createEmailRecipient();
        emailRecipientsPageObjectModel.setEmailAddress("emma.foster@testmail.com");
        emailRecipientsPageObjectModel.setFirstName("Emma");
        emailRecipientsPageObjectModel.setLastName("Foster");
        emailRecipientsPageObjectModel.saveNewRecipient();
        emailRecipientsValidation.validateIfRecipientExists("emma.foster@testmail.com");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the user creates a sixth recipient")
    public void the_user_creates_a_sixth_recipient() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsPageObjectModel.createEmailRecipient();
        emailRecipientsPageObjectModel.setEmailAddress("felix.gray@testmail.com");
        emailRecipientsPageObjectModel.setFirstName("Felix");
        emailRecipientsPageObjectModel.setLastName("Gray");
        emailRecipientsPageObjectModel.saveNewRecipient();
        emailRecipientsValidation.validateIfRecipientExists("felix.gray@testmail.com");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}