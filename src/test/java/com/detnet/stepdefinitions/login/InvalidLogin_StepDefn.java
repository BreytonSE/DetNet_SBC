package com.detnet.stepdefinitions.login;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.LoginPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.LoginValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//Scenario: Verify that that user is denied access to BlastWeb if credentials are invalid
public class InvalidLogin_StepDefn {
    private final PageObjectManager pageObjectManager;

    public InvalidLogin_StepDefn() {
     Page page = PlaywrightManager.getPage();
     pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Given("I enter an invalid username and password")
    public void i_enter_an_invalid_username_and_password() {
        LoginPageObjectModel loginPageObjectModel = pageObjectManager.getLoginPageObjectModel();
        LoginValidation loginValidation = new LoginValidation(loginPageObjectModel);
        loginPageObjectModel.setUsername("john");
        loginValidation.validateUsernameField("john");
        loginPageObjectModel.setPassword("portal123");
        loginValidation.validatePasswordField("portal123");
        loginPageObjectModel.togglePasswordVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("I click on {string}")
    public void i_click_on(String string) {
        LoginPageObjectModel loginPageObjectModel = pageObjectManager.getLoginPageObjectModel();
        loginPageObjectModel.logIn();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("I should see an error message under the password input field")
    public void i_should_see_an_error_message_under_the_password_input_field() {
        LoginPageObjectModel loginPageObjectModel = pageObjectManager.getLoginPageObjectModel();
        LoginValidation loginValidation = new LoginValidation(loginPageObjectModel);
        loginValidation.validatePasswordErrorVisibility();
        loginValidation.validateErrorMessage("Enter a valid password");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the {string} bar should be visible at the bottom right corner")
    public void the_bar_should_be_visible_at_the_bottom_right_corner(String string) {
        LoginPageObjectModel loginPageObjectModel = pageObjectManager.getLoginPageObjectModel();
        LoginValidation loginValidation = new LoginValidation(loginPageObjectModel);
       loginValidation.validateUnauthorizedUserAlertVisibility();
       loginValidation.validateUnauthorizedAlert(" Dismiss ");
       SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}