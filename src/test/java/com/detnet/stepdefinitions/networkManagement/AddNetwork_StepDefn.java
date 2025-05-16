package com.detnet.stepdefinitions.networkManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DatabaseObjectModel;
import com.detnet.pageObjects.NetworkPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.NetworkValidation;
import com.detnet.validations.databaseValidations.DatabaseNetworksValidations;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

// Scenario: Verify that networks can be added to the system, ensuring the information can written back to the backend
public class AddNetwork_StepDefn {
    private final PageObjectManager pageObjectManager;

    public AddNetwork_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String string) {
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        NetworkValidation networkValidation = new NetworkValidation(networkPageObjectModel);
        networkValidation.validateAddNetworkButtonVisibility();
        networkValidation.validateAddNetworkButtonState();
        networkPageObjectModel.addNetwork();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user fills in all required form fields with valid network information")
    public void the_user_fills_in_all_required_form_fields_with_valid_network_information() {
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        NetworkValidation networkValidation = new NetworkValidation(networkPageObjectModel);
        networkValidation.validateResourceNameInputFieldVisibility();
        networkValidation.validateResourceNameInputFieldState();
        networkValidation.validateIfResourceNameFieldIsEmpty();
        networkPageObjectModel.setResourceName("Ethernet");
        networkValidation.validateEnteredResourceName("Ethernet");

        networkValidation.validateMessageGapFieldVisibility();
        networkValidation.validateMessageGapFieldState();
        networkValidation.validateIfMessageGapFieldIsEmpty();
        networkPageObjectModel.setNewMessageGap("20");
        networkValidation.validateEnteredGapMessage("20");

        networkValidation.validateDelayInputFieldVisibility();
        networkValidation.validateDelayInputFieldState();
        networkValidation.validateIfDelayInputFieldIsEmpty();
        networkPageObjectModel.setDelay("1500");
        networkValidation.validateEnteredDelayValue("1500");

        networkValidation.validateBaudRateFieldVisibility();
        networkValidation.validateBaudRateFieldState();
        networkValidation.validateIfBaudRateFieldIsEmpty();
        networkPageObjectModel.setBaudRate("1200");
        networkValidation.validateEnteredBaudRate("1200");

        networkValidation.validateReportDetonatorsCheckBoxVisibility();
        networkValidation.validateReportDetonatorsCheckBoxState();
        networkPageObjectModel.reportDetonators();
        networkPageObjectModel.inUse();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user submits the new network")
    public void the_user_submits_the_new_network() {
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        NetworkValidation networkValidation = new NetworkValidation(networkPageObjectModel);
        networkValidation.validateSaveButtonVisibility();
        networkValidation.validateSaveButtonState();
        networkPageObjectModel.saveNewNetwork();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the user adds another network")
    public void the_user_adds_another_network() {
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        networkPageObjectModel.addNetwork();
        networkPageObjectModel.setResourceName("ETHER002-DUMMY");
        networkPageObjectModel.reportDetonators();
        networkPageObjectModel.inUse();
        networkPageObjectModel.saveNewNetwork();

        networkPageObjectModel.addNetwork();
        networkPageObjectModel.setResourceName("ETHER003-DUMMY");
        networkPageObjectModel.reportDetonators();
        networkPageObjectModel.inUse();
        networkPageObjectModel.saveNewNetwork();

        networkPageObjectModel.addNetwork();
        networkPageObjectModel.setResourceName("ETHER004-DUMMY");
        networkPageObjectModel.reportDetonators();
        networkPageObjectModel.inUse();
        networkPageObjectModel.saveNewNetwork();

        networkPageObjectModel.addNetwork();
        networkPageObjectModel.setResourceName("ETHER005-DUMMY");
        networkPageObjectModel.reportDetonators();
        networkPageObjectModel.inUse();
        networkPageObjectModel.saveNewNetwork();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the new network should appear as the last item in the network list")
    public void the_new_network_should_appear_as_the_last_item_in_the_network_list() throws InterruptedException {
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        NetworkValidation networkValidation = new NetworkValidation(networkPageObjectModel);
        networkValidation.validateIfNewNetworkIsAdded();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the new network should be present in the backend database")
    public void the_new_network_should_be_present_in_the_backend_database() {
        DatabaseObjectModel databaseObjectModel = new DatabaseObjectModel();
        DatabaseNetworksValidations databaseNetworksValidations = new DatabaseNetworksValidations(databaseObjectModel);
        databaseNetworksValidations.validateNetworkExistById(26);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}