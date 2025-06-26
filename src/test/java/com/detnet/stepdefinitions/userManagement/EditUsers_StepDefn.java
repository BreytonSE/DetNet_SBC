package com.detnet.stepdefinitions.userManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DatabaseObjectModel;
import com.detnet.pageObjects.UsersPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.UsersValidation;
import com.detnet.validations.databaseValidations.DatabaseUsersValidations;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Then;

//  Scenario: Verify that an existing user's data can be edited, ensuring that information can be updated on the backend
public class EditUsers_StepDefn {
    private final PageObjectManager pageObjectManager;

    public EditUsers_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Then("click on the pencil icon")
    public void click_on_the_pencil_icon() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateIfEditIconIsVisible();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        usersPageObjectModel.editUserData(2);
    }
    @Then("edit any information about the user")
    public void edit_any_information_about_the_user() throws InterruptedException {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateIfEditUserFormIsOpen();
        usersValidation.validateEditUserText("Edit User");
        SoftAssertionUtils.getSoftAssertions().assertAll();
        usersPageObjectModel.setNewSurname("Johnson");
    }
    @Then("apply the new changes by clicking the {string} button")
    public void apply_the_new_changes_by_clicking_the_button(String string) {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateIfSaveButtonIsPresent();
        usersValidation.validateIfSaveButtonState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        usersPageObjectModel.saveUpdatedUserInformation();
    }
    @Then("I verify that the user information has been updated")
    public void i_verify_that_the_user_information_has_been_updated() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateUpdatedSurname(" Johnson ");
        SoftAssertionUtils.getSoftAssertions().assertAll();
        DatabaseObjectModel databaseObjectModel = new DatabaseObjectModel();
        DatabaseUsersValidations databaseUsersValidations = new DatabaseUsersValidations(databaseObjectModel);
        String email = "johnD@detnet.com";
        databaseUsersValidations.validateIfUserSurnameUpdated("Johnson",email);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}