package com.detnet.stepdefinitions.groupManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.GroupsPageObjectModel;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//Scenario:  Verify that a user can add more groups
public class AddAdditionalGroups_StepDefn {
    private final PageObjectManager pageObjectManager;

    public AddAdditionalGroups_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user creates a second group")
    public void the_user_creates_a_second_group() {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        groupsPageObjectModel.setGroupName("Test Group 2");
        groupsPageObjectModel.openColorPicker();
        groupsPageObjectModel.switchColorCode(1);
        groupsPageObjectModel.setRGBColor("220","41","175");
        groupsPageObjectModel.saveGroup();
    }

    @When("the user creates a third group")
    public void the_user_creates_a_third_group() {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        groupsPageObjectModel.addGroup();
        groupsPageObjectModel.setGroupName("Test Group 3");
        groupsPageObjectModel.openColorPicker();
        groupsPageObjectModel.switchColorCode(1);
        groupsPageObjectModel.setRGBColor("14","79","218");
        groupsPageObjectModel.saveGroup();
    }

    @When("the user creates a fourth group")
    public void the_user_creates_a_fourth_group() {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        groupsPageObjectModel.addGroup();
        groupsPageObjectModel.setGroupName("Test Group 4");
        groupsPageObjectModel.openColorPicker();
        groupsPageObjectModel.switchColorCode(1);
        groupsPageObjectModel.setRGBColor("110","22","22");
        groupsPageObjectModel.saveGroup();
    }
    @When("the user creates a fifth group")
    public void the_user_creates_a_fifth_group() {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        groupsPageObjectModel.addGroup();
        groupsPageObjectModel.setGroupName("Test Group 5");
        groupsPageObjectModel.openColorPicker();
        groupsPageObjectModel.switchColorCode(1);
        groupsPageObjectModel.setRGBColor("140","202","160");
        groupsPageObjectModel.saveGroup();
    }
    @When("the user creates a sixth group")
    public void the_user_creates_a_sixth_group() {
        GroupsPageObjectModel groupsPageObjectModel = pageObjectManager.getGroupsPageObjectModel();
        groupsPageObjectModel.addGroup();
        groupsPageObjectModel.setGroupName("Test Group 6");
        groupsPageObjectModel.openColorPicker();
        groupsPageObjectModel.switchColorCode(1);
        groupsPageObjectModel.setRGBColor("28","25","194");
        groupsPageObjectModel.saveGroup();
    }
}