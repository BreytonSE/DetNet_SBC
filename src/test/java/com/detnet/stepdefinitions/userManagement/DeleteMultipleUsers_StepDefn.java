package com.detnet.stepdefinitions.userManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.UsersPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.UsersValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

// Scenario: Verify that multiple users can be deleted, ensuring that information can be deleted on the backend
public class DeleteMultipleUsers_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DeleteMultipleUsers_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Then("the administrator clicks on the square icon to select multiple or all users")
    public void the_administrator_clicks_on_the_square_icon_to_select_multiple_or_all_users() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateSelectAllCheckboxVisibility();
        usersValidation.validateSelectAllCheckboxState();
        usersPageObjectModel.selectAllUsers();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the administrator clicks on the {string} button to delete selected users")
    public void the_administrator_clicks_on_the_button_to_delete_selected_users(String string) throws InterruptedException {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersPageObjectModel.selectOrDeselectUsers("2");
        usersPageObjectModel.selectOrDeselectUsers("3");
        usersPageObjectModel.selectOrDeselectUsers("4");

        usersValidation.validateDeleteUsersButtonVisibility();
        usersValidation.validateDeleteUsersButtonState();
        usersPageObjectModel.deleteAllUsers();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the administrator confirms deletion of the selected users")
    public void the_administrator_confirms_deletion_of_the_selected_users() throws InterruptedException {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateDeleteDialogBoxVisibility();
        usersPageObjectModel.confirmToDelete();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the selected users should no longer be visible in the users interface")
    public void the_selected_users_should_no_longer_be_visible_in_the_users_interface() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateIfUserIsDeleted("jane.smith");
        usersValidation.validateIfUserIsDeleted("oliver.thomas");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}