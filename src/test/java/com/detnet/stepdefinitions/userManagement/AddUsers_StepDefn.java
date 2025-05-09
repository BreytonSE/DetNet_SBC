package com.detnet.stepdefinitions.userManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DatabaseObjectModel;
import com.detnet.pageObjects.UsersPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.UsersValidation;
import com.detnet.validations.databaseValidations.DatabaseUsersValidations;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

// Scenario: Verify that a new user can be added to the system, ensuring that the information can be written back to the backend
public class AddUsers_StepDefn {
    private final PageObjectManager pageObjectManager;

    public AddUsers_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Then("clicks on the Add User button")
    public void clicks_on_the_add_user_button() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateAddUserButtonVisibility();
        usersValidation.validateAddUserButtonState();
        usersPageObjectModel.AddNewUser();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("verify that the User form page is open")
    public void verify_that_the_user_form_page_is_open() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateAddUserLabelVisibility();
        usersValidation.validateAddUserFormURL("http://localhost:8080/en/settings/users/add");
        usersValidation.validateAddUserFormHeader("Add User");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("set the username")
    public void set_the_username() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateUsernameInputFieldVisibility();
        usersValidation.validateUsernameInputFieldState();
        usersValidation.validateIfUsernameFieldIsEmpty();
        usersPageObjectModel.setUsername("JohnD");
        usersValidation.validateEnteredUsername("JohnD");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("set the email")
    public void set_the_email() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateEmailInputFieldVisibility();
        usersValidation.validateEmailInputFieldState();
        usersValidation.validateEmailInputFieldIfEmpty();
        usersPageObjectModel.setEmail("johnD@detnet.com");
        usersValidation.validateEnteredEmail("johnD@detnet.com");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("set the name of the user")
    public void set_the_name_of_the_user() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateFirstNameInputFieldVisibility();
        usersValidation.validateFirstNameInputFieldState();
        usersValidation.validateIfFirstNameInputFieldIsEmpty();
        usersPageObjectModel.setFirstname("John");
        usersValidation.validateEnteredFirstname("John");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("set the surname of the user")
    public void set_the_surname_of_the_user() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateSurnameInputFieldVisibility();
        usersValidation.validateSurnameInputFieldState();
        usersValidation.validateIfSurnameInputFieldIsEmpty();
        usersPageObjectModel.setSurname("Doe");
        usersValidation.validateEnteredSurname("Doe");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("set a role for the user")
    public void set_a_role_for_the_user() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateRoleFieldVisibility();
        usersValidation.validateRoleFieldState();
        usersPageObjectModel.openRoleDropDown();
        usersValidation.validateIfRoleDropDownIsOpen();
        usersPageObjectModel.selectRole("administrator");
        usersValidation.validateSelectedRole("administrator");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("clicks the Add User button")
    public void clicks_the_add_user_button() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateAddUserSubmitButtonVisibility();
        usersValidation.validateUserSubmitButtonState();
        usersPageObjectModel.submitUserData();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("lastly verify that the user has been added and appears as the last item of the user view page")
    public void lastly_verify_that_the_user_has_been_added_and_appears_as_the_last_item_of_the_user_view_page() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateNewUsername(" JohnD ");
        usersValidation.validateIfNewUserAdded(2);
        DatabaseObjectModel databaseObjectModel = new DatabaseObjectModel();
        DatabaseUsersValidations databaseUsersValidations = new DatabaseUsersValidations(databaseObjectModel);
        databaseUsersValidations.validateUserExistsByEmail("johnD@detnet.com");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}