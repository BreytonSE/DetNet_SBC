package com.detnet.stepdefinitions.blastCardManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.BlastCardsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.BlastCardsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

public class BlastCardDelete_StepDefn {
    private Page page;
    private final PageObjectManager pageObjectManager;
    private final BlastCardsPageObjectModel blastCardsPageObjectModel;
    private final BlastCardsValidation blastCardsValidation;

    public BlastCardDelete_StepDefn() {
        this.page = PlaywrightManager.getPage();
        this.pageObjectManager = PageObjectManager.getInstance(page);
        this.blastCardsPageObjectModel = pageObjectManager.getBlastCardsPageObjectModel();
        this.blastCardsValidation = new BlastCardsValidation(blastCardsPageObjectModel);
    }

    @Then("the user clicks on the {string} button to delete multiple cards")
    public void the_user_clicks_on_the_button_to_delete_multiple_cards(String string) {
//        blastCardsValidation.validateDeleteCardsButtonVisibility();
//        blastCardsValidation.validateDeleteButtonOnClick();
//        blastCardsPageObjectModel.deleteBlastCard();
//        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the user clicks the {string} icon from the table to delete a single card")
    public void the_user_clicks_the_icon_from_the_table_to_delete_a_single_card(String string) {
//        TODO: Blast card must exist
    }
    @Then("the user verifies that the blast card has been removed from the system")
    public void the_user_verifies_that_the_blast_card_has_been_removed_from_the_system() {
//        TODO: Verify that the blast card was deleted successfully
    }
}