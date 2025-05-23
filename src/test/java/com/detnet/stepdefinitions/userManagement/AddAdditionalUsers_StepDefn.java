package com.detnet.stepdefinitions.userManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.UsersPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.UsersValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that you can add five additional users
public class AddAdditionalUsers_StepDefn {
    private final PageObjectManager pageObjectManager;

    public AddAdditionalUsers_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Then("the user adds a third user")
    public void the_user_adds_a_third_user() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersPageObjectModel.setUsername("amy.wilkinson");
        usersValidation.validateEnteredUsername("amy.wilkinson");

        usersPageObjectModel.setEmail("aWilkinson@detnet.com");
        usersValidation.validateEnteredEmail("aWilkinson@detnet.com");

        usersPageObjectModel.setFirstname("Amy");
        usersValidation.validateEnteredFirstname("Amy");

        usersPageObjectModel.setSurname("Wilkinson");
        usersValidation.validateEnteredSurname("Wilkinson");

        usersPageObjectModel.openRoleDropDown();
        usersPageObjectModel.selectRole("operator");
        usersValidation.validateSelectedRole("operator");

        usersPageObjectModel.submitUserData();
        usersValidation.validateIfNewUserAdded(3);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the user adds a fourth user")
    public void the_user_adds_a_fourth_user() throws InterruptedException {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersPageObjectModel.AddNewUser();
        usersPageObjectModel.setUsername("ethan.hughes");
        usersValidation.validateEnteredUsername("ethan.hughes");

        usersPageObjectModel.setEmail("hughesE@detnet.com");
        usersValidation.validateEnteredEmail("hughesE@detnet.com");

        usersPageObjectModel.setFirstname("Ethan");
        usersValidation.validateEnteredFirstname("Ethan");

        usersPageObjectModel.setSurname("Hughes");
        usersValidation.validateEnteredSurname("Hughes");

        usersPageObjectModel.openRoleDropDown();
        usersPageObjectModel.selectRole("operator");
        usersValidation.validateSelectedRole("operator");

        usersPageObjectModel.submitUserData();
        usersValidation.validateIfNewUserAdded(4);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the user adds a fifth user")
    public void the_user_adds_a_fifth_user() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersPageObjectModel.AddNewUser();
        usersPageObjectModel.setUsername("cody007");
        usersValidation.validateEnteredUsername("cody007");

        usersPageObjectModel.setEmail("dixonCody@detnet.com");
        usersValidation.validateEnteredEmail("dixonCody@detnet.com");

        usersPageObjectModel.setFirstname("Cody");
        usersValidation.validateEnteredFirstname("Cody");

        usersPageObjectModel.setSurname("Dixon");
        usersValidation.validateEnteredSurname("Dixon");

        usersPageObjectModel.openRoleDropDown();
        usersPageObjectModel.selectRole("central blast operator");
        usersValidation.validateSelectedRole("central blast operator");

        usersPageObjectModel.submitUserData();
        usersValidation.validateIfNewUserAdded(5);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the user adds a sixth user")
    public void the_user_adds_a_sixth_user() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersPageObjectModel.AddNewUser();
        usersPageObjectModel.setUsername("jane.smith");
        usersValidation.validateEnteredUsername("jane.smith");

        usersPageObjectModel.setEmail("smithj@detnet.com");
        usersValidation.validateEnteredEmail("smithj@detnet.com");

        usersPageObjectModel.setFirstname("Jane");
        usersValidation.validateEnteredFirstname("Jane");

        usersPageObjectModel.setSurname("Smith");
        usersValidation.validateEnteredSurname("Smith");

        usersPageObjectModel.openRoleDropDown();
        usersPageObjectModel.selectRole("administrator");
        usersValidation.validateSelectedRole("administrator");

        usersPageObjectModel.submitUserData();
        usersValidation.validateIfNewUserAdded(6);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the user adds a seventh user")
    public void the_user_adds_a_seventh_user() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersPageObjectModel.AddNewUser();
        usersPageObjectModel.setUsername("oliver.thomas");
        usersValidation.validateEnteredUsername("oliver.thomas");

        usersPageObjectModel.setEmail("thomaso@detnet.com");
        usersValidation.validateEnteredEmail("thomaso@detnet.com");

        usersPageObjectModel.setFirstname("Oliver");
        usersValidation.validateEnteredFirstname("Oliver");

        usersPageObjectModel.setSurname("Thomas");
        usersValidation.validateEnteredSurname("Thomas");

        usersPageObjectModel.openRoleDropDown();
        usersPageObjectModel.selectRole("detnet engineering");
        usersValidation.validateSelectedRole("detnet engineering");

        usersPageObjectModel.submitUserData();
        usersValidation.validateIfNewUserAdded(7);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}