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

public class EditNetwork_StepDefn {
    private final PageObjectManager pageObjectManager;

    public EditNetwork_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user clicks on the edit \\(pencil) icon of an existing network")
    public void the_user_clicks_on_the_edit_pencil_icon_of_an_existing_network() {
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        NetworkValidation networkValidation = new NetworkValidation(networkPageObjectModel);
        networkValidation.validateEditIconVisibility();
        networkValidation.validateEditIconState();
        networkPageObjectModel.editNetwork("2");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user updates the desired network information")
    public void the_user_updates_the_desired_network_information() {
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        networkPageObjectModel.setNewMessageGap("30");
        networkPageObjectModel.setDelay("2000");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user clicks the Save button")
    public void the_user_clicks_the_save_button() {
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        NetworkValidation networkValidation = new NetworkValidation(networkPageObjectModel);
        networkValidation.validateSaveUpdateButtonVisibility();
        networkValidation.validateSaveUpdateButtonState();
        networkPageObjectModel.updateNetwork();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the updated network information should be saved successfully without any errors")
    public void the_updated_network_information_should_be_saved_successfully_without_any_errors() {
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        NetworkValidation networkValidation = new NetworkValidation(networkPageObjectModel);
        networkValidation.validateIfMessageGapUpdated("30");
        networkValidation.validateIfDelayUpdated("2000");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the changes should be reflected in the backend database")
    public void the_changes_should_be_reflected_in_the_backend_database() {
        DatabaseObjectModel databaseObjectModel = new DatabaseObjectModel();
        DatabaseNetworksValidations databaseNetworksValidations = new DatabaseNetworksValidations(databaseObjectModel);
        databaseNetworksValidations.validateIfNetworkMessageGapUpdated(30,"Ethernet");
        databaseNetworksValidations.validateIfNetworkDelayUpdated(2000,"Ethernet");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}