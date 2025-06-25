package com.detnet.stepdefinitions.blastCardManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.BlastCardsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.BlastCardsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

public class BlastCardSearch_StepDefn {
    private final PageObjectManager pageObjectManager;

    public BlastCardSearch_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Then("enter a value in the search bar")
    public void enter_a_value_in_the_search_bar() {
        BlastCardsPageObjectModel blastCardsPageObjectModel = pageObjectManager.getBlastCardsPageObjectModel();
        BlastCardsValidation blastCardsValidation = new BlastCardsValidation(blastCardsPageObjectModel);
        blastCardsValidation.validateSearchBarVisibility();
        blastCardsValidation.validateSearchBarInteractability();
        blastCardsValidation.validateIfSearchBarIsEmpty();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        blastCardsPageObjectModel.setSearchValue("123456789");
        blastCardsValidation.validateSearchInputField("123456789");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("click the search button")
    public void click_the_search_button() {
        BlastCardsPageObjectModel blastCardsPageObjectModel = pageObjectManager.getBlastCardsPageObjectModel();
        BlastCardsValidation blastCardsValidation = new BlastCardsValidation(blastCardsPageObjectModel);
        blastCardsValidation.validateSearchButtonVisibility();
        blastCardsValidation.validateSearchButtonInteractability();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        blastCardsPageObjectModel.search();
    }
    @Then("finally verify if a list of cards is displaying based on the searched word")
    public void finally_verify_if_a_list_of_cards_is_displaying_based_on_the_searched_word() {
//        TODO: Verify that list of searched cards appears. Do this step if cards is available
    }
}
