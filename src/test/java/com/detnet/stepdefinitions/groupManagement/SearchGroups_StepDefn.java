package com.detnet.stepdefinitions.groupManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.GroupsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.GroupsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

// Scenario: Verify that a group can be searched using their ID and name
public class SearchGroups_StepDefn {
    private final PageObjectManager pageObjectManager;

    public SearchGroups_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user enters the group name or group ID in the search bar")
    public void the_user_enters_the_group_name_or_group_id_in_the_search_bar() {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        GroupsValidation groupsValidation = new GroupsValidation(groupsPageObjectModel);
        groupsValidation.validateSearchBarVisibility();
        groupsValidation.validateSearchBarState();
        groupsValidation.validateIfSearchbarIsEmpty();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        groupsPageObjectModel.searchGroup("3");
        groupsPageObjectModel.searchGroup("Test Group 5");
        groupsPageObjectModel.searchGroup("2");
    }
    @Then("the group matching the entered name or ID should appear in the results list")
    public void the_group_matching_the_entered_name_or_id_should_appear_in_the_results_list() {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        GroupsValidation groupsValidation = new GroupsValidation(groupsPageObjectModel);
        groupsValidation.validateIfSearchedGroupIsFound("Test Group 2");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}