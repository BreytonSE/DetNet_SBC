package com.detnet.stepdefinitions.emailRecipientManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.EmailRecipientsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.EmailRecipientsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//  Scenario: Verify that recipients can be searched using their username, firstname and lastname
public class SearchRecipient_StepDefn {
    private final PageObjectManager pageObjectManager;

    public SearchRecipient_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Then("the search bar should be visible")
    public void the_search_bar_should_be_visible() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsValidation.validateSearchBarVisibility();
        emailRecipientsValidation.validateSearchBarState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user enters a recipient's username into the search bar")
    public void the_user_enters_a_recipient_s_username_into_the_search_bar() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsValidation.validateIfSearchBarIsEmpty();
        emailRecipientsPageObjectModel.search("felix.gray@testmail.com");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the matching recipient username should appear in the results")
    public void the_matching_recipient_username_should_appear_in_the_results() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsValidation.validateIfRecipientExists("felix.gray@testmail.com");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user enters a recipient's first name into the search bar")
    public void the_user_enters_a_recipient_s_first_name_into_the_search_bar() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        emailRecipientsPageObjectModel.search("Daniel");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the matching recipient first name should appear in the results")
    public void the_matching_recipient_first_name_should_appear_in_the_results() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsValidation.validateIfRecipientExists("Daniel");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user enters a recipient's last name into the search bar")
    public void the_user_enters_a_recipient_s_last_name_into_the_search_bar() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        emailRecipientsPageObjectModel.search("Bennet");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the matching recipient last name should appear in the results")
    public void the_matching_recipient_last_name_should_appear_in_the_results() {
        EmailRecipientsPageObjectModel emailRecipientsPageObjectModel = pageObjectManager.getEmailRecipientsPageObjectModel();
        EmailRecipientsValidation emailRecipientsValidation = new EmailRecipientsValidation(emailRecipientsPageObjectModel);
        emailRecipientsValidation.validateIfRecipientExists("alice.bennett@testmail.com");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}