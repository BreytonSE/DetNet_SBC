package com.detnet.stepdefinitions.login;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.LoginPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.LoginValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that a user can view the password they entered on the login screen
public class PasswordVisibility_StepDefn {
    private final PageObjectManager pageObjectManager;

    public PasswordVisibility_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("I click on the eye icon")
    public void i_click_on_the_eye_icon() {
        LoginPageObjectModel loginPageObjectModel = pageObjectManager.getLoginPageObjectModel();
        LoginValidation loginValidation = new LoginValidation(loginPageObjectModel);
        loginValidation.validatePasswordVisibilityIcon();
        loginValidation.validatePasswordVisibilityIconState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        loginPageObjectModel.togglePasswordVisibility();
    }
    @Then("the password should be revealed")
    public void the_password_should_be_revealed() {
        LoginPageObjectModel loginPageObjectModel = pageObjectManager.getLoginPageObjectModel();
        LoginValidation loginValidation = new LoginValidation(loginPageObjectModel);
        loginValidation.validateIfPasswordIsShowing();
        loginValidation.validateIfPasswordVisibilityChangedToText();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("I click the eye icon with a slash to hide the password again")
    public void i_click_the_eye_icon_with_a_slash_to_hide_the_password_again() {
        LoginPageObjectModel loginPageObjectModel = pageObjectManager.getLoginPageObjectModel();
        LoginValidation loginValidation = new LoginValidation(loginPageObjectModel);
        loginPageObjectModel.togglePasswordVisibility();
        loginValidation.validateIfPasswordIsHidden();
        loginValidation.validateIfPasswordVisibilityChangedToPassword();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}