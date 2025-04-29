package com.detnet.stepdefinitions.userManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.UsersPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.UsersValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Then;

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
        usersPageObjectModel.editUserData(2);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("edit any information about the user")
    public void edit_any_information_about_the_user() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateIfEditUserFormIsOpen();
        usersValidation.validateEditUserText("Edit User");
        usersPageObjectModel.setEmail("johnDoe@detnet.com");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("apply the new changes by clicking the {string} button")
    public void apply_the_new_changes_by_clicking_the_button(String string) {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateIfSaveButtonIsPresent();
        usersValidation.validateIfSaveButtonState();
        usersPageObjectModel.saveUpdatedUserInformation();
    }
    @Then("I verify that the user information has been updated")
    public void i_verify_that_the_user_information_has_been_updated() {

    }
}
