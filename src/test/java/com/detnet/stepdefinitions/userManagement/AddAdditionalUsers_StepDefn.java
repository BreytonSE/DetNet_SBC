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
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.setEmail("aWilkinson@detnet.com");
        usersValidation.validateEnteredEmail("aWilkinson@detnet.com");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.setFirstname("Amy");
        usersValidation.validateEnteredFirstname("Amy");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.setSurname("Wilkinson");
        usersValidation.validateEnteredSurname("Wilkinson");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.openRoleDropDown();
        usersPageObjectModel.selectRole("operator");
        usersValidation.validateSelectedRole("operator");
        SoftAssertionUtils.getSoftAssertions().assertAll();

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
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.setEmail("hughesE@detnet.com");
        usersValidation.validateEnteredEmail("hughesE@detnet.com");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.setFirstname("Ethan");
        usersValidation.validateEnteredFirstname("Ethan");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.setSurname("Hughes");
        usersValidation.validateEnteredSurname("Hughes");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.openRoleDropDown();
        usersPageObjectModel.selectRole("operator");
        usersValidation.validateSelectedRole("operator");
        SoftAssertionUtils.getSoftAssertions().assertAll();

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
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.setEmail("dixonCody@detnet.com");
        usersValidation.validateEnteredEmail("dixonCody@detnet.com");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.setFirstname("Cody");
        usersValidation.validateEnteredFirstname("Cody");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.setSurname("Dixon");
        usersValidation.validateEnteredSurname("Dixon");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.openRoleDropDown();
        usersPageObjectModel.selectRole("central blast operator");
        usersValidation.validateSelectedRole("central blast operator");
        SoftAssertionUtils.getSoftAssertions().assertAll();

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
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.setEmail("smithj@detnet.com");
        usersValidation.validateEnteredEmail("smithj@detnet.com");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.setFirstname("Jane");
        usersValidation.validateEnteredFirstname("Jane");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.setSurname("Smith");
        usersValidation.validateEnteredSurname("Smith");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.openRoleDropDown();
        usersPageObjectModel.selectRole("administrator");
        usersValidation.validateSelectedRole("administrator");
        SoftAssertionUtils.getSoftAssertions().assertAll();

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
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.setEmail("thomaso@detnet.com");
        usersValidation.validateEnteredEmail("thomaso@detnet.com");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.setFirstname("Oliver");
        usersValidation.validateEnteredFirstname("Oliver");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.setSurname("Thomas");
        usersValidation.validateEnteredSurname("Thomas");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.openRoleDropDown();
        usersPageObjectModel.selectRole("detnet engineering");
        usersValidation.validateSelectedRole("detnet engineering");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.submitUserData();
        usersValidation.validateIfNewUserAdded(7);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the user adds an eight user who is a blast operator")
    public void the_user_adds_an_eight_user_who_is_a_blast_operator() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersPageObjectModel.AddNewUser();
        usersPageObjectModel.setUsername("breyton");
        usersValidation.validateEnteredUsername("breyton");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.setEmail("breyton.ernstzen@testheroes.co.za");
        usersValidation.validateEnteredEmail("breyton.ernstzen@testheroes.co.za");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.setFirstname("Breyton");
        usersValidation.validateEnteredFirstname("Breyton");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.setSurname("Ernstzen");
        usersValidation.validateEnteredSurname("Ernstzen");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.openRoleDropDown();
        usersPageObjectModel.selectRole("central blast operator");
        usersValidation.validateSelectedRole("central blast operator");
        SoftAssertionUtils.getSoftAssertions().assertAll();

        usersPageObjectModel.submitUserData();
        usersValidation.validateIfNewUserAdded(8);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}