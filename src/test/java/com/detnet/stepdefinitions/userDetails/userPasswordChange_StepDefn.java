package com.detnet.stepdefinitions.userDetails;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.PasswordResetPageObjectModel;
import com.detnet.pageObjects.UserAccountPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.PasswordResetValidation;
import com.detnet.validations.blastWebValidations.UserAccountValidations;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//    Scenario: Verify that user gets directed to the "Password Reset" page when clicking on "Change My Password" -button
public class userPasswordChange_StepDefn {
    private final PageObjectManager pageObjectManager;

    public userPasswordChange_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("click on {string}")
    public void click_on(String buttonName) {
        UserAccountPageObjectModel userAccountPageObjectModel = pageObjectManager.getUserAccountPageObjectModel();
        UserAccountValidations userAccountValidations = new UserAccountValidations(userAccountPageObjectModel);
        userAccountValidations.validatePasswordChangeButtonVisibility();
        userAccountValidations.validatePasswordChangeButtonState();
        userAccountValidations.validatePasswordChangeButtonText(buttonName);
        SoftAssertionUtils.getSoftAssertions().assertAll();
        userAccountPageObjectModel.goToPasswordResetPage();
    }

    @Then("verify that the user is navigated to the password reset page")
    public void verify_that_the_user_is_navigated_to_the_password_reset_page() {
        PasswordResetPageObjectModel passwordResetPageObjectModel = pageObjectManager.getPasswordResetPageObjectModel();
        PasswordResetValidation passwordResetValidation = new PasswordResetValidation(passwordResetPageObjectModel);
        passwordResetValidation.validatePasswordResetFormVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}