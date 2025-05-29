package com.detnet.stepdefinitions.groupManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DatabaseObjectModel;
import com.detnet.pageObjects.GroupsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.GroupsValidation;
import com.detnet.validations.databaseValidations.DatabaseGroupsValidations;
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
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        GroupsValidation groupsValidation = new GroupsValidation(groupsPageObjectModel);
        groupsValidation.validateAddGroupPageURL("http://localhost:8080/en/settings/groups/add");
        groupsValidation.validateAddGroupFormVisibility();
        groupsValidation.validateAddGroupHeadingText("Add Group");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user enters a group name")
    public void the_user_enters_a_group_name() {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        GroupsValidation groupsValidation = new GroupsValidation(groupsPageObjectModel);
        groupsValidation.validateGroupNameFieldVisibility();
        groupsValidation.validateGroupNameFieldState();
        groupsValidation.validateGroupNameFieldIfEmpty();
        groupsPageObjectModel.setGroupName("Test Group");
        groupsValidation.validateGroupNameFieldIfFilled();
        groupsValidation.validateGroupName("Test Group");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user selects a group color")
    public void the_user_selects_a_group_color() throws InterruptedException {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        GroupsValidation groupsValidation = new GroupsValidation(groupsPageObjectModel);
        groupsValidation.validateColorPickerVisibility();
        groupsValidation.validateColorPickerState();
        groupsPageObjectModel.openColorPicker();
        groupsValidation.validateIfColorPickerOpen();
        groupsPageObjectModel.switchColorCode(1); // 1 for RGB and 2 for HSL
        groupsValidation.validateRGBFieldVisibility();
        groupsPageObjectModel.setRGBColor("255","165","0");
        groupsValidation.validateRGBColorCode("255","165","0");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user saves the group")
    public void the_user_saves_the_group() {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        GroupsValidation groupsValidation = new GroupsValidation(groupsPageObjectModel);
        groupsValidation.validateSaveGroupButtonVisibility();
        groupsValidation.validateSaveGroupButtonState();
        groupsPageObjectModel.saveGroup();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the group should appear on the Groups interface")
    public void the_group_should_appear_on_the_groups_interface() {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        GroupsValidation groupsValidation = new GroupsValidation(groupsPageObjectModel);
        groupsValidation.validateIfGroupIsAdded();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the group should be saved in the database")
    public void the_group_should_be_saved_in_the_database() {
        DatabaseObjectModel databaseObjectModel = new DatabaseObjectModel();
        DatabaseGroupsValidations databaseGroupsValidations = new DatabaseGroupsValidations(databaseObjectModel);
        databaseGroupsValidations.validateGroupsExistsInDatabase();
        databaseGroupsValidations.validateIfGroupExistByName("Test Group");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}