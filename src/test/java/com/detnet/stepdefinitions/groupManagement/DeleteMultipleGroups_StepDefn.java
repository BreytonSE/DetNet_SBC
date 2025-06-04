package com.detnet.stepdefinitions.groupManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.GroupsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.GroupsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//  Scenario: Validate user can select and delete multiple groups
public class DeleteMultipleGroups_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DeleteMultipleGroups_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user clicks on the bin icon next to a group")
    public void the_user_clicks_on_the_bin_icon_next_to_a_group() {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        GroupsValidation groupsValidation = new GroupsValidation(groupsPageObjectModel);
        groupsValidation.validateDeleteIconVisibility();
        groupsValidation.validateDeleteIconState();
        groupsPageObjectModel.deleteSingleGroup(2);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user deletes a single group")
    public void the_user_deletes_a_single_group() {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        GroupsValidation groupsValidation = new GroupsValidation(groupsPageObjectModel);
        groupsValidation.validateDeleteDialogWindowVisibility();
        groupsPageObjectModel.confirmDelete();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user selects multiple groups by clicking on their checkboxes")
    public void the_user_selects_multiple_groups_by_clicking_on_their_checkboxes() {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        GroupsValidation groupsValidation = new GroupsValidation(groupsPageObjectModel);
        groupsValidation.validateCheckBoxVisibility();
        groupsPageObjectModel.selectAllGroups();
        groupsPageObjectModel.selectOrDeselectMultipleGroups(2);
        groupsPageObjectModel.selectOrDeselectMultipleGroups(4);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user clicks on the Delete Groups button")
    public void the_user_clicks_on_the_delete_groups_button() {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        GroupsValidation groupsValidation = new GroupsValidation(groupsPageObjectModel);
        groupsValidation.validateDeleteAllButtonVisibility();
        groupsValidation.validateDeleteAllButtonState();
        groupsPageObjectModel.deleteSelectedGroups();
        groupsPageObjectModel.confirmDelete();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the selected groups should no longer be visible in the list")
    public void the_selected_groups_should_no_longer_be_visible_in_the_list() {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        GroupsValidation groupsValidation = new GroupsValidation(groupsPageObjectModel);
        groupsValidation.validateIfGroupIsDeleted("Test Group 2");
        groupsValidation.validateIfGroupIsDeleted("Test Group 5");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}