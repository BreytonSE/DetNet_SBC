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

public class DeleteUser_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DeleteUser_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Then("user click on the trash bin icon")
    public void user_click_on_the_trash_bin_icon() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateDeleteIconVisibility(1);
        usersPageObjectModel.deleteUser(1);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("confirm to delete the user")
    public void confirm_to_delete_the_user() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateDeleteDialogBoxVisibility();
        usersValidation.validateYesButtonVisibility();
        usersPageObjectModel.confirmToDelete();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("then verify in the database that the user has been deleted")
    public void then_verify_in_the_database_that_the_user_has_been_deleted() {
        DatabaseObjectModel databaseObjectModel = new DatabaseObjectModel();
        DatabaseUsersValidations databaseUsersValidations = new DatabaseUsersValidations(databaseObjectModel);
        databaseUsersValidations.validateIfUserIsDeleted("johnD@detnet.com");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}