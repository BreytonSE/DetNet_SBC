package com.detnet.stepdefinitions.userDetails;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.UserAccountPageObjectModel;
import com.detnet.pageObjects.UsersPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.UserAccountValidations;
import com.detnet.validations.blastWebValidations.UsersValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that user gets directed to the "Edit User" page when clicking on "Edit Details" -button
public class editUserDetails_StepDefn {
    private final PageObjectManager pageObjectManager;

    public editUserDetails_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("click on {string} button")
    public void click_on_button(String buttonName) {
        UserAccountPageObjectModel userAccountPageObjectModel = pageObjectManager.getUserAccountPageObjectModel();
        UserAccountValidations userAccountValidations = new UserAccountValidations(userAccountPageObjectModel);
        userAccountValidations.validateEditDetailsButtonVisibility();
        userAccountValidations.validateEditDetailsButtonState();
        userAccountValidations.validateEditDetailsButtonText(buttonName);
        SoftAssertionUtils.getSoftAssertions().assertAll();
        userAccountPageObjectModel.navigateToEditUserPage();
    }

    @Then("verify that the {string} page is open")
    public void verify_that_the_page_is_open(String pageName) {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateIfEditUserFormIsOpen();
        usersValidation.validateEditUserText(pageName);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}