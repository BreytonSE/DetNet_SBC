package com.detnet.stepdefinitions.blastCardManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.BlastCardsPageObjectModel;
import com.detnet.pageObjects.SettingsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.BlastCardsValidation;
import com.detnet.validations.blastWebValidations.SettingsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

// Scenario: Verify that a user can search for an archived card using serial number, key type, or updated date
public class BlastCardArchiveSearch_StepDefn {
    private final PageObjectManager pageObjectManager;

    public BlastCardArchiveSearch_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("navigates to archived blast cards tab")
    public void navigates_to_archived_blast_cards_tab() {
        SettingsPageObjectModel settingsPageObjectModel = pageObjectManager.getSettingsPageObjectModel();
        SettingsValidation settingsValidation = new SettingsValidation(settingsPageObjectModel);
        settingsValidation.validateBlastCardClick();
        settingsPageObjectModel.viewActiveBlastCards();

        BlastCardsPageObjectModel blastCardsPageObjectModel = pageObjectManager.getBlastCardsPageObjectModel();
        BlastCardsValidation blastCardsValidation = new BlastCardsValidation(blastCardsPageObjectModel);
        blastCardsValidation.validateArchivedButtonVisibility();
        blastCardsValidation.validateArchivedButtonOnClick();
        blastCardsPageObjectModel.viewArchivedCards();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("search for an archived blast card in the seach bar")
    public void search_for_an_archived_blast_card_in_the_seach_bar() {
        BlastCardsPageObjectModel blastCardsPageObjectModel = pageObjectManager.getBlastCardsPageObjectModel();
        BlastCardsValidation blastCardsValidation = new BlastCardsValidation(blastCardsPageObjectModel);
        blastCardsValidation.validateIfSearchBarIsEmpty();
        blastCardsPageObjectModel.setSearchValue("1234567890");
        blastCardsValidation.validateSearchInputField("1234567890");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("I verify that a list of cards is displaying based on the searched word")
    public void i_verify_that_a_list_of_cards_is_displaying_based_on_the_searched_word() {
//        TODO: Validate that a list of cards is displaying that has a matched serial number, key type, or updated date
    }
}