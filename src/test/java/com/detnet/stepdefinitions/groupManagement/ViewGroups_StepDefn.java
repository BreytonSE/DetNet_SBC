package com.detnet.stepdefinitions.groupManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.GroupsPageObjectModel;
import com.detnet.pageObjects.SettingsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.GroupsValidation;
import com.detnet.validations.blastWebValidations.SettingsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that user can view groups of the system
public class ViewGroups_StepDefn {
    private final PageObjectManager pageObjectManager;

    public ViewGroups_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user navigates to the Groups section")
    public void the_user_navigates_to_the_groups_section() {
        SettingsPageObjectModel settingsPageObjectModel = pageObjectManager.getSettingsPageObjectModel();
        SettingsValidation settingsValidation = new SettingsValidation(settingsPageObjectModel);
        settingsValidation.validateGroupsTabVisibility();
        settingsValidation.validateGroupsTabText("Groups");
        settingsPageObjectModel.openGroups();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the Groups page should be displayed")
    public void the_groups_page_should_be_displayed() {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        GroupsValidation groupsValidation = new GroupsValidation(groupsPageObjectModel);
        groupsValidation.validateGroupPageHeadingVisibility();
        groupsValidation.validateGroupPageURL("http://localhost:8080/en/settings/groups");
        groupsValidation.validateGroupPageHeadingText("Groups");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the system should display a list of groups or show the message {string}")
    public void the_system_should_display_a_list_of_groups_or_show_the_message(String string) throws InterruptedException {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        GroupsValidation groupsValidation = new GroupsValidation(groupsPageObjectModel);
        groupsValidation.validateIfNoGroupsPresent();
        groupsValidation.validateNoGroupsText("No Groups Present");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}