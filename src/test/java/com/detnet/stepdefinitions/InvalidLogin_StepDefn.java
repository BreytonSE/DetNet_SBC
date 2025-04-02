package com.detnet.stepdefinitions;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.LoginPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.LoginValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

public class InvalidLogin_StepDefn {
    private Page page;

    public InvalidLogin_StepDefn() {
      this.page = PlaywrightManager.getPage();
    }

    private PageObjectManager getPageObjectManager(){
        return PageObjectManager.getInstance(page);
    }

    @Given("I enter an invalid username and password")
    public void i_enter_an_invalid_username_and_password() {
        LoginPageObjectModel loginPageObjectModel = getPageObjectManager().getLoginPageObjectModel();
        LoginValidation loginValidation = new LoginValidation(loginPageObjectModel);
        loginPageObjectModel.setUsername("john");
        loginPageObjectModel.setPassword("portal123");
        loginValidation.validatePasswordVisibilityIcon();
        loginPageObjectModel.togglePasswordVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("I click on {string}")
    public void i_click_on(String string) {
        getPageObjectManager().getLoginPageObjectModel().logIn();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("I should see an error message under the password input field")
    public void i_should_see_an_error_message_under_the_password_input_field() {
        LoginValidation loginValidation = new LoginValidation(getPageObjectManager().getLoginPageObjectModel());
        loginValidation.validatePasswordErrorVisibility();
        loginValidation.validateErrorMessage("Enter a valid password");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the {string} bar should be visible at the bottom right corner")
    public void the_bar_should_be_visible_at_the_bottom_right_corner(String string) {
        LoginValidation loginValidation = new LoginValidation(getPageObjectManager().getLoginPageObjectModel());
       loginValidation.validateUnauthorizedUserAlertVisibility();
       loginValidation.validateUnauthorizedAlert("Unauthorized - Token invalid , user unauthorized!");
       SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}