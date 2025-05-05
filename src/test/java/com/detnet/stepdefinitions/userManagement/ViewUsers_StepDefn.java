package com.detnet.stepdefinitions.userManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DatabaseObjectModel;
import com.detnet.pageObjects.SettingsPageObjectModel;
import com.detnet.pageObjects.UsersPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.SettingsValidation;
import com.detnet.validations.blastWebValidations.UsersValidation;
import com.detnet.validations.databaseValidations.DatabaseUsersValidations;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

// Scenario: Verify that users can be viewed without any retrieval issues
public class ViewUsers_StepDefn {
    private final PageObjectManager pageObjectManager;

    public ViewUsers_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Then("go to users")
    public void go_to_users() {
        SettingsPageObjectModel settingsPageObjectModel = pageObjectManager.getSettingsPageObjectModel();
        SettingsValidation settingsValidation = new SettingsValidation(settingsPageObjectModel);
        settingsValidation.validateUserButtonVisibility();
        settingsValidation.validateUserButtonState();
        settingsValidation.validateUsersButtonText("Users");
        settingsPageObjectModel.viewUsers();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("verify that the system users can be seen")
    public void verify_that_the_system_users_can_be_seen() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateUserLabelVisibility();
        usersValidation.validateUserLabelText("Users");
        usersValidation.validateUsersURL("http://localhost:8080/en/settings/users");
        usersValidation.validateUserVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("also on the database")
    public void also_on_the_database() {
        DatabaseObjectModel databaseObjectModel = new DatabaseObjectModel();
        DatabaseUsersValidations databaseUsersValidations = new DatabaseUsersValidations(databaseObjectModel);
        databaseUsersValidations.validateUserExistenceInDatabase();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}