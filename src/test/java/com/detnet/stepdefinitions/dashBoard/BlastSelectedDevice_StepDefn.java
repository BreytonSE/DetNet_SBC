package com.detnet.stepdefinitions.dashBoard;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that device in "Ready to Blast" -state will be presented to be blasted
public class BlastSelectedDevice_StepDefn {
    private final PageObjectManager pageObjectManager;

    public BlastSelectedDevice_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user selects a device that is in the Ready to Blast state")
    public void the_user_selects_a_device_that_is_in_the_ready_to_blast_state() {
//        TODO: User select the device that is already in "Ready to Blast" -state
    }

    @When("the user opens the action panel and selects Blast Selected")
    public void the_user_opens_the_action_panel_and_selects_blast_selected() {
//       TODO: The user opens the action panel
    }

    @Then("the blast confirmation screen should be displayed")
    public void the_blast_confirmation_screen_should_be_displayed() {
//       TODO: Verify blast confirmation screen
    }

    @Then("the user clicks the {string} button")
    public void the_user_clicks_the_button(String string) {
    }
}