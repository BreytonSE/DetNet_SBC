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
        networkPageObjectModel.deselectNetwork("1");
        networkPageObjectModel.deselectNetwork("3");
        networkPageObjectModel.deselectNetwork("5");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user clicks the enabled {string} button")
    public void the_user_clicks_the_enabled_button(String string) throws InterruptedException {
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        NetworkValidation networkValidation = new NetworkValidation(networkPageObjectModel);
        networkValidation.validateDeleteButtonVisibility();
        networkValidation.validateDeleteButtonState();
        networkPageObjectModel.deleteAll();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("a confirmation popup is displayed for network deletion")
    public void a_confirmation_popup_is_displayed_for_network_deletion() {
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        NetworkValidation networkValidation = new NetworkValidation(networkPageObjectModel);
        networkValidation.validateDeleteDialogVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user clicks {string} to confirm the deletion")
    public void the_user_clicks_to_confirm_the_deletion(String string) {
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        networkPageObjectModel.confirmToDeleteNetwork();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the selected networks should be successfully deleted from the interface")
    public void the_selected_networks_should_be_successfully_deleted_from_the_interface() throws InterruptedException {
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        NetworkValidation networkValidation = new NetworkValidation(networkPageObjectModel);
        networkValidation.validateIfSelectedNetworksIsDeleted("ETHER002-DUMMY");
        networkValidation.validateIfSelectedNetworksIsDeleted("ETHER004-DUMMY");
        networkValidation.validateIfSelectedNetworksIsDeleted("Ethernet");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}