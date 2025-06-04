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

// Scenario: Verify that user can edit groups, ensuring that information can be updated on the backend
public class EditGroups_StepDefn {
    private final PageObjectManager pageObjectManager;

    public EditGroups_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Then("the pencil \\(edit) icon should be visible for each group")
    public void the_pencil_edit_icon_should_be_visible_for_each_group() {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        GroupsValidation groupsValidation = new GroupsValidation(groupsPageObjectModel);
        groupsValidation.validateEditIconVisibility(1);
        groupsPageObjectModel.editGroup(1);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user edits the group information")
    public void the_user_edits_the_group_information() {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        GroupsValidation groupsValidation = new GroupsValidation(groupsPageObjectModel);
        groupsValidation.validateEditGroupsPageHeadingVisibility();
        groupsValidation.validateEditGroupsHeading("Edit Group");
        groupsPageObjectModel.editGroupName("Test Group 1");
        groupsPageObjectModel.openColorPicker();
        groupsPageObjectModel.switchColorCode(1);
        groupsPageObjectModel.setRGBColor("0","80","102");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user saves the changes")
    public void the_user_saves_the_changes() {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        GroupsValidation groupsValidation = new GroupsValidation(groupsPageObjectModel);
        groupsValidation.validateUpdateButtonVisibility();
        groupsValidation.validateUpdateButtonButtonState();
        groupsPageObjectModel.updateGroupDetails();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the updated group information should be visible on the frontend")
    public void the_updated_group_information_should_be_visible_on_the_frontend() {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        GroupsValidation groupsValidation = new GroupsValidation(groupsPageObjectModel);
        groupsValidation.validateUpdateGroupNameVisibility("Test Group 1");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the updated group information should be persisted in the backend")
    public void the_updated_group_information_should_be_persisted_in_the_backend() {
        DatabaseObjectModel databaseObjectModel = new DatabaseObjectModel();
        DatabaseGroupsValidations databaseGroupsValidations = new DatabaseGroupsValidations(databaseObjectModel);
        databaseGroupsValidations.validateIfGroupExistByName("Test Group 1");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}