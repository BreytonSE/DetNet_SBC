package com.detnet.stepdefinitions;

import com.detnet.managers.PlaywrightManager;
import com.detnet.managers.PageObjectManager;
import com.detnet.pageObjects.LoginPageObjectModel;
import com.detnet.utilities.*;
import com.detnet.validations.LoginValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

public class TestStepDefn {
    private final Page page;
    private final PageObjectManager pageObjectManager;
    private final LoginPageObjectModel loginPageObjectModel;
    private final LoginValidation loginValidation;

    public TestStepDefn() {
        page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
        loginPageObjectModel = pageObjectManager.getLoginPageObjectModel();
        loginValidation = new LoginValidation(loginPageObjectModel);
    }

    @Given("I launch BlastWeb")
    public void i_launch_blast_web() {
        System.out.println("Launching BlastWeb...");
    }
    @When("I set Username")
    public void i_set_username() throws Exception {
        String username = EncryptionUtils.decrypt(LoginConstantUtils.USERNAME);
        loginPageObjectModel.setUsername(username);
        loginValidation.validateUsernameField("administrator");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("I set the Password")
    public void i_set_the_password() throws Exception {
        String password = EncryptionUtils.decrypt(LoginConstantUtils.PASSWORD);
        loginPageObjectModel.setPassword(password);
        loginValidation.validatePasswordField("detnet");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("I toggle password visibility")
    public void i_toggle_password_visibility() {
        loginValidation.validatePasswordVisibilityIcon();
        loginPageObjectModel.togglePasswordVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("click on the login button")
    public void click_on_the_login_button() {
        loginValidation.validateLoginButtonClick();
        loginPageObjectModel.logIn();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}