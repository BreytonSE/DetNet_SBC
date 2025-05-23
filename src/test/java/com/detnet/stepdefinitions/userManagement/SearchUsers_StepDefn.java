package com.detnet.stepdefinitions.userManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.UsersPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.UsersValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//  Scenario: Verify that a user can be searched using their username, first name and surname
public class SearchUsers_StepDefn {
    private final PageObjectManager pageObjectManager;

    public SearchUsers_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user types the username into the search bar")
    public void the_user_types_the_username_into_the_search_bar() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateSearchBarVisibility();
        usersValidation.validateSearchBarState();
        usersValidation.validateIfSearchBarIsEmpty();
        usersPageObjectModel.searchUser("amy.wilkinson");
        usersValidation.validateSearchedUser("amy.wilkinson");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the user should be found in the search results")
    public void the_user_should_be_found_in_the_search_results() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersValidation.validateIfUserIsFound("amy.wilkinson");
        usersPageObjectModel.clearSearchBar();
        usersValidation.validateIfSearchBarIsEmpty();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user types the first name into the search bar")
    public void the_user_types_the_first_name_into_the_search_bar() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersPageObjectModel.searchUser("Amy");
        usersValidation.validateSearchedUser("Amy");
        usersPageObjectModel.clearSearchBar();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user types the surname into the search bar")
    public void the_user_types_the_surname_into_the_search_bar() {
        UsersPageObjectModel usersPageObjectModel = pageObjectManager.getUsersPageObjectModel();
        UsersValidation usersValidation = new UsersValidation(usersPageObjectModel);
        usersPageObjectModel.searchUser("Wilkinson");
        usersValidation.validateSearchedUser("Wilkinson");
        usersPageObjectModel.clearSearchBar();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}