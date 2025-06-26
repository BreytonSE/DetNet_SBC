package com.detnet.stepdefinitions.networkManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.NetworkPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.NetworkValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

public class SearchNetwork_StepDefn {

    private final PageObjectManager pageObjectManager;

    public SearchNetwork_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user clicks the search bar")
    public void the_user_clicks_the_search_bar() {
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        NetworkValidation networkValidation = new NetworkValidation(networkPageObjectModel);
        networkValidation.validateSearchBarVisibility();
        networkValidation.validateSearchBarState();
        networkValidation.validateIfSearchBarIsEmpty();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        networkPageObjectModel.openSearchBar();
    }
    @When("the user types the ID or name of the network in the search bar")
    public void the_user_types_the_id_or_name_of_the_network_in_the_search_bar() {
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        networkPageObjectModel.searchId("2");
    }
    @Then("the list should display results matching the entered search keyword")
    public void the_list_should_display_results_matching_the_entered_search_keyword() {
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        NetworkValidation networkValidation = new NetworkValidation(networkPageObjectModel);
        networkValidation.validateIfNetworkIsPresentFromSearch("2");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}