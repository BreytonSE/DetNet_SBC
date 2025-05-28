package com.detnet.stepdefinitions.groupManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.GroupsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.GroupsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that user can add groups to the system, ensuring that information can be stored in the database
public class AddGroups_StepDefn {
    private final PageObjectManager pageObjectManager;

    public AddGroups_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user clicks on the Add Group button")
    public void the_user_clicks_on_the_add_group_button() {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        GroupsValidation groupsValidation = new GroupsValidation(groupsPageObjectModel);
        groupsValidation.validateAddGroupButtonVisibility();
        groupsValidation.validateAddGroupButtonState();
        groupsPageObjectModel.addGroup();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the Add Group page should be displayed")
    public void the_add_group_page_should_be_displayed() {
//        TODO: Verify that the Add Groups page is showing
    }
    @When("the user enters a group name")
    public void the_user_enters_a_group_name() {
//        TODO: Enter a group name

    }
    @When("the user selects a group color")
    public void the_user_selects_a_group_color() {
//        TODO: Select a group color from the color picker
    }
    @When("the user saves the group")
    public void the_user_saves_the_group() {
//        TODO: Save the new created group
    }
    @Then("the group should appear on the Groups interface")
    public void the_group_should_appear_on_the_groups_interface() {
//        TODO: Verify that the new group is added
    }
    @Then("the group should be saved in the database")
    public void the_group_should_be_saved_in_the_database() {
//        TODO: Verify that the group is saved in the database
    }
}