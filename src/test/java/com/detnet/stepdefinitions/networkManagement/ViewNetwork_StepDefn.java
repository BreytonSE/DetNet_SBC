package com.detnet.stepdefinitions.networkManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DatabaseObjectModel;
import com.detnet.pageObjects.NetworkPageObjectModel;
import com.detnet.pageObjects.SettingsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.NetworkValidation;
import com.detnet.validations.blastWebValidations.SettingsValidation;
import com.detnet.validations.databaseValidations.DatabaseNetworksValidations;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

// Scenario: Verify that networks of the system can be viewed on the BlastWeb interface as well as on the backend (database)
public class ViewNetwork_StepDefn {
    private final PageObjectManager pageObjectManager;

    public ViewNetwork_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user opens the {string} page")
    public void the_user_opens_the_page(String string) {
        SettingsPageObjectModel settingsPageObjectModel = pageObjectManager.getSettingsPageObjectModel();
        SettingsValidation settingsValidation = new SettingsValidation(settingsPageObjectModel);
        settingsValidation.validateNetworksTabVisibility();
        settingsPageObjectModel.goToNetworks();
        settingsValidation.validateSettingsURL("http://localhost:8080/en/settings/networks");
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        NetworkValidation networkValidation = new NetworkValidation(networkPageObjectModel);
        networkValidation.validateNetworkLabelVisibility();
        networkValidation.validateNetworkLabelText("Networks");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("a list of networks should be displayed on the interface")
    public void a_list_of_networks_should_be_displayed_on_the_interface() {
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        NetworkValidation networkValidation = new NetworkValidation(networkPageObjectModel);
        networkValidation.validateIfNetworkIsPresent();
        networkValidation.validateNetworkName(" ETHER001-DUMMY ");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the same list of networks should be present in the backend database")
    public void the_same_list_of_networks_should_be_present_in_the_backend_database() {
        DatabaseObjectModel databaseObjectModel = new DatabaseObjectModel();
        DatabaseNetworksValidations databaseNetworksValidations = new DatabaseNetworksValidations(databaseObjectModel);
        databaseNetworksValidations.validateNetworkExistenceInDatabase();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}