package com.detnet.stepdefinitions.groupManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
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
        // TODO: Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user deletes a single group")
    public void the_user_deletes_a_single_group() {
        // TODO: Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user selects multiple groups by clicking on their checkboxes")
    public void the_user_selects_multiple_groups_by_clicking_on_their_checkboxes() {
        // TODO: Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user clicks on the Delete Groups button")
    public void the_user_clicks_on_the_delete_groups_button() {
        // TODO: Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the selected groups should no longer be visible in the list")
    public void the_selected_groups_should_no_longer_be_visible_in_the_list() {
        // TODO: Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}