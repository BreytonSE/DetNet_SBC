package com.detnet.stepdefinitions.networkManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.NetworkPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.NetworkValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

// Scenario: Verify that multiple networks can be deleted at once
public class DeleteMultipleNetworks_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DeleteMultipleNetworks_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user selects multiple networks by clicking the checkboxes in the network list or the header checkbox")
    public void the_user_selects_multiple_networks_by_clicking_the_checkboxes_in_the_network_list_or_the_header_checkbox() throws InterruptedException {
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        NetworkValidation networkValidation = new NetworkValidation(networkPageObjectModel);
        networkValidation.validateCheckBoxVisibility();
        networkValidation.validateCheckboxState();
        networkPageObjectModel.selectAllNetworks();
//        networkPageObjectModel.selectNetwork("5");
//        networkPageObjectModel.selectNetwork("6");
//        networkPageObjectModel.selectNetwork("7");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user clicks the enabled {string} button")
    public void the_user_clicks_the_enabled_button(String string) {

    }
    @When("a confirmation popup is displayed for network deletion")
    public void a_confirmation_popup_is_displayed_for_network_deletion() {

    }
    @When("the user clicks {string} to confirm the deletion")
    public void the_user_clicks_to_confirm_the_deletion(String string) {

    }
    @Then("the selected networks should be successfully deleted from the interface")
    public void the_selected_networks_should_be_successfully_deleted_from_the_interface() {

    }
}