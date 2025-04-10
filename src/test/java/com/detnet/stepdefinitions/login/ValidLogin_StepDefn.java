package com.detnet.stepdefinitions.login;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.pageObjects.LoginPageObjectModel;
import com.detnet.utilities.EncryptionUtils;
import com.detnet.utilities.LoginConstantUtils;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DashboardValidation;
import com.detnet.validations.blastWebValidations.LoginValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that an authorized user can successfully log in and out of the application
public class ValidLogin_StepDefn {
    private final Page page;
    private final PageObjectManager pageObjectManager;
    private final LoginPageObjectModel loginPageObjectModel;
    private final LoginValidation loginValidation;
    private final DashboardPageObjectModel dashboardPageObjectModel;
    private final DashboardValidation dashboardValidation;

    public ValidLogin_StepDefn() {
        this.page = PlaywrightManager.getPage();
        this.pageObjectManager = PageObjectManager.getInstance(page);
        this.loginPageObjectModel = pageObjectManager.getLoginPageObjectModel();
        this.dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        this.loginValidation = new LoginValidation(loginPageObjectModel);
        this.dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
    }

    @Given("I enter my BlastWeb username and password")
    public void i_enter_my_blast_web_username_and_password() throws Exception {
        String username = EncryptionUtils.decrypt(LoginConstantUtils.getDecryptedUsername());
        loginPageObjectModel.setUsername(username);
        String password = EncryptionUtils.decrypt(LoginConstantUtils.getDecryptedPassword());
        loginPageObjectModel.setPassword(password);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginValidation.validateLoginButtonClick();
        loginPageObjectModel.logIn();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("I should be on the dashboard page")
    public void i_should_be_on_the_dashboard_page() {
        dashboardValidation.validateDashboardPageURL("http://localhost:8080/en/dashboard");
        dashboardValidation.validateDashboardLabelVisibility();
        dashboardValidation.validateDashboardLabelName("Dashboard");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("then I log out of the application again")
    public void then_i_log_out_of_the_application_again() {
        dashboardValidation.validateUserRoleLabelVisibility();
        dashboardValidation.validateRoleName("administrator");
        dashboardPageObjectModel.openNavigationMenu();
        dashboardValidation.validateNavigationMenuVisibility();
        dashboardValidation.validateLogOutButtonVisibility();
        dashboardValidation.validateLogOutButtonClick();
        dashboardPageObjectModel.logOut();
        SoftAssertionUtils.getSoftAssertions().assertAll();

    }
    @Then("verify that I am back on the login page")
    public void verify_that_i_am_back_on_the_login_page() {
        loginValidation.validateLoginPageURL("http://localhost:8080/en/login");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}