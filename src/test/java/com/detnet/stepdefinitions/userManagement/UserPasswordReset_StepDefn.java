package com.detnet.stepdefinitions.userManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.pageObjects.LoginPageObjectModel;
import com.detnet.pageObjects.PasswordResetPageObjectModel;
import com.detnet.pageObjects.UsersPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.LoginValidation;
import com.detnet.validations.blastWebValidations.PasswordResetValidation;
import com.detnet.validations.blastWebValidations.UsersValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that a user can reset their password
public class UserPasswordReset_StepDefn {
    private final PageObjectManager pageObjectManager;

    public UserPasswordReset_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Then("the user clicks on the shield icon next to the target user")
    public void the_user_clicks_on_the_shield_icon_next_to_the_target_user() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validatePasswordResetIconVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        usersPageObjectModel.requestPasswordReset("5");
    }

    @Then("a popup prompt should appear asking the user to confirm the password reset")
    public void a_popup_prompt_should_appear_asking_the_user_to_confirm_the_password_reset() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validatePasswordResetDialogVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user clicks {string} to confirm the password reset")
    public void the_user_clicks_to_confirm_the_password_reset(String string) {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        usersPageObjectModel.confirmToResetPassword();
    }

    @Then("log out of again")
    public void log_out_of_again() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.openNavigationMenu();
        dashboardPageObjectModel.logOut();
    }

    @Then("enter the username in both username and password field once on the login screen")
    public void enter_the_username_in_both_username_and_password_field_once_on_the_login_screen() {
        LoginPageObjectModel loginPageObjectModel = pageObjectManager.getLoginPageObjectModel();
        LoginValidation loginValidation = new LoginValidation(loginPageObjectModel);
        loginValidation.validateLoginPageURL("http://localhost:8080/en/login");
        SoftAssertionUtils.getSoftAssertions().assertAll();
        loginPageObjectModel.setUsername("breyton");
        loginPageObjectModel.setPassword("breyton");
        loginPageObjectModel.logIn();
    }

    @Then("the user should be prompted to set a new password")
    public void the_user_should_be_prompted_to_set_a_new_password() throws InterruptedException {
        PasswordResetPageObjectModel passwordResetPageObjectModel = pageObjectManager.getPasswordResetPageObjectModel();
        PasswordResetValidation passwordResetValidation = new PasswordResetValidation(passwordResetPageObjectModel);
        passwordResetValidation.validatePasswordResetURL("http://localhost:8080/en/password-reset");
        passwordResetValidation.validatePasswordResetFormVisibility();
        passwordResetValidation.validateCurrentPasswordFieldVisibility();
        passwordResetValidation.validateCurrentPasswordFieldState();
        passwordResetValidation.validateIfCurrentPasswordFieldIsEmpty();
        SoftAssertionUtils.getSoftAssertions().assertAll();

        passwordResetPageObjectModel.setCurrentPassword("breyton");
        passwordResetValidation.validateIfCurrentPasswordIsHidden();
        passwordResetValidation.validateCurrentPasswordVisibilityIconPresence();
        passwordResetValidation.validateCurrentPasswordVisibilityIconState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        passwordResetPageObjectModel.toggleCurrentPasswordVisibility();
        passwordResetValidation.validateIfCurrentPasswordIsShownAsText();
        passwordResetValidation.validateCurrentPassword("breyton");
        passwordResetValidation.validateNewPasswordFieldVisibility();
        passwordResetValidation.validateNewPasswordFieldState();
        passwordResetValidation.validateIfNewPasswordFieldIsEmpty();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        passwordResetPageObjectModel.setNewPassword("breyton@123");
        passwordResetValidation.validateIfNewPasswordIsHidden();
        passwordResetValidation.validateNewPasswordVisibilityIconState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        passwordResetPageObjectModel.toggleNewPasswordVisibility();
        passwordResetValidation.validateIfNewPasswordIsShowAsText();
        passwordResetValidation.validateNewPassword("breyton@123");
        SoftAssertionUtils.getSoftAssertions().assertAll();
        passwordResetValidation.validateConfirmedPasswordFieldVisibility();
        passwordResetValidation.validateConfirmedPasswordFieldState();
        passwordResetValidation.validateIfConfirmPasswordFieldIsEmpty();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        passwordResetPageObjectModel.setConfirmedPassword("breyton@123");
        passwordResetValidation.validateIfConfirmedPasswordIsHidden();
        passwordResetValidation.validateConfirmPasswordVisibilityIconPresence();
        passwordResetValidation.validateConfirmPasswordVisibilityIconState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        passwordResetPageObjectModel.toggleConfirmedPasswordVisibility();
        passwordResetValidation.validateIfConfirmPasswordIsText();
        passwordResetValidation.validateConfirmedPassword("breyton@123");
        passwordResetValidation.validateChangePasswordButtonVisibility();
        passwordResetValidation.validateChangePasswordButtonState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        passwordResetPageObjectModel.changePassword();
    }
}