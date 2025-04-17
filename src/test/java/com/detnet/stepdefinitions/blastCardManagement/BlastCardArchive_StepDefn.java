package com.detnet.stepdefinitions.blastCardManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.BlastCardsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.BlastCardsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//  Scenario: Verify that user can archive blast cards
public class BlastCardArchive_StepDefn {
    private Page page;
    private final PageObjectManager pageObjectManager;
    private final BlastCardsPageObjectModel blastCardsPageObjectModel;
    private final BlastCardsValidation blastCardsValidation;

    public BlastCardArchive_StepDefn() {
        this.page = PlaywrightManager.getPage();
        this.pageObjectManager = PageObjectManager.getInstance(page);
        this.blastCardsPageObjectModel = pageObjectManager.getBlastCardsPageObjectModel();
        this.blastCardsValidation = new BlastCardsValidation(blastCardsPageObjectModel);
    }

    @Then("the user clicks on the Archive Cards button to archive multiple cards")
    public void the_user_clicks_on_the_archive_cards_button_to_archive_multiple_cards() {
        blastCardsValidation.validateBlastCardAlertWindowVisibility();
        blastCardsPageObjectModel.closeBlastCardAlertWindow();
//        TODO: Blast cards mus exists!
//        blastCardsValidation.validateArchiveButtonVisibility();
//        blastCardsValidation.validateArchiveButtonOnClick();
//        blastCardsPageObjectModel.archiveCards();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the user clicks the Archive icon from the table to archive a single card")
    public void the_user_clicks_the_archive_icon_from_the_table_to_archive_a_single_card() {
//        TODO: Card must be available first for the archive button to become visible
    }
    @Then("the user navigates to the Archived cards")
    public void the_user_navigates_to_the_archived_cards() {
        blastCardsValidation.validateArchivedButtonVisibility();
        blastCardsValidation.validateArchivedButtonOnClick();
        blastCardsPageObjectModel.viewArchivedCards();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the user verifies that the blast card is visible in the archive list")
    public void the_user_verifies_that_the_blast_card_is_visible_in_the_archive_list() {
        blastCardsValidation.validateArchivedCardsURL("http://localhost:8080/en/settings/archivedCards");
        blastCardsValidation.validateArchiveCardsLabelVisibility();
        blastCardsValidation.validateArchiveCardsLabelName("Archive Cards");
//        TODO: There must be blast cards added to archives in order to complete this scenario
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}