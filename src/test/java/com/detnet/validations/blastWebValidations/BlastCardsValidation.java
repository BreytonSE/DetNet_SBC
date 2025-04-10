package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.BlastCardsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class BlastCardsValidation {
    private final BlastCardsPageObjectModel blastCardsPageObjectModel;
    private final SoftAssertions softly;

    public BlastCardsValidation(BlastCardsPageObjectModel blastCardsPageObjectModel) {
        this.blastCardsPageObjectModel = blastCardsPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateActiveBlastCardsURL(String expectedURL){
        String actualURL = blastCardsPageObjectModel.getActiveBlastCardsPageURL();
        softly.assertThat(actualURL)
                .as("Actual URL does not match expected URL")
                .isEqualTo(expectedURL);
    }

    public void validateActiveBlastCardsVisibility(){
        boolean isLabelVisible = blastCardsPageObjectModel.isActiveCardsLabelVisible();
        softly.assertThat(isLabelVisible)
                .as("'Active Cards' -label should be visible")
                .isTrue();
    }

    public void validateActiveBlastCardLabelName(String expectedLabelName){
        String actualLabelName = blastCardsPageObjectModel.getActiveCardsLabel();
        softly.assertThat(actualLabelName)
                .as("Actual text does not match expected text")
                .isEqualTo(expectedLabelName);
    }

    public void validateAddBlastCardButtonVisibility(){
        boolean isButtonVisible = blastCardsPageObjectModel.isAddBlastCardButtonVisible();
        softly.assertThat(isButtonVisible)
                .as("'Add Blast Card' -button should be visible")
                .isTrue();
    }

    public void validateAddBlastCardClick(){
        boolean isButtonEnabled = blastCardsPageObjectModel.isAddBlastCardButtonEnabled();
        softly.assertThat(isButtonEnabled)
                .as("'Add Blast Card' button should be enabled")
                .isTrue();
    }

    public void validateArchiveButtonVisibility(){
        boolean isButtonDisplayed = blastCardsPageObjectModel.isArchiveButtonVisible();
        softly.assertThat(isButtonDisplayed)
                .as("'Archive Cards' -button should be displaying")
                .isTrue();
    }

    public void validateArchiveButtonOnClick(){
        boolean isButtonEnabled = blastCardsPageObjectModel.isArchiveButtonEnabled();
        softly.assertThat(isButtonEnabled)
                .as("'Archive Cards -button should be enabled'")
                .isTrue();
    }

    public void validateArchivedButtonVisibility(){
        boolean isButtonVisible = blastCardsPageObjectModel.isArchivedCardsButtonVisible();
        softly.assertThat(isButtonVisible)
                .as("'Archived Cards' -button should be visible")
                .isTrue();
    }

    public void validateArchivedButtonOnClick(){
        boolean isButtonEnabled = blastCardsPageObjectModel.isArchivedCardsButtonEnabled();
        softly.assertThat(isButtonEnabled)
                .as("'Archived Cards' -button should be enabled")
                .isTrue();
    }

    public void validateArchivedCardsURL(String expectedURL){
        String actualURL = blastCardsPageObjectModel.getArchivedBlastCardsURL();
        softly.assertThat(actualURL)
                .as("Actual URL does not match expected URL")
                .isEqualTo(expectedURL);
    }

    public void validateBlastCardAlertWindowVisibility(){
        boolean isWindowOpen = blastCardsPageObjectModel.isBlastCardAlertWindowOpen();
        softly.assertThat(isWindowOpen)
                .as("NFC alert window should be displaying")
                .isTrue();
    }

    public void validateArchiveCardsLabelVisibility(){
        boolean isLabelVisible = blastCardsPageObjectModel.isArchivedCardsLabelVisible();
        softly.assertThat(isLabelVisible)
                .as("'Archive Cards' -label should be visible")
                .isTrue();
    }

    public void validateArchiveCardsLabelName(String expectedText){
        String actualText = blastCardsPageObjectModel.getArchivedCardsLabel();
        softly.assertThat(actualText)
                .as("Actual text does not match expected text")
                .isEqualTo(expectedText);
    }

    public void validateDeleteCardsButtonVisibility(){
        boolean isButtonVisible = blastCardsPageObjectModel.isDeleteButtonVisible();
        softly.assertThat(isButtonVisible)
                .as("'Delete Cards' -button should be visible")
                .isTrue();
    }

    public void validateDeleteButtonOnClick(){
        boolean isButtonEnabled = blastCardsPageObjectModel.isDeleteButtonEnabled();
        softly.assertThat(isButtonEnabled)
                .as("'Delete Cards' -button should be enabled")
                .isTrue();
    }

    public void validateSearchBarVisibility(){
        boolean isSearchBarVisible = blastCardsPageObjectModel.isSearchBarVisible();
        softly.assertThat(isSearchBarVisible)
                .as("Search bar should be visible on the 'Active Cards' page")
                .isTrue();
    }

    public void validateSearchBarInteractability(){
        boolean isSearchBarEnabled = blastCardsPageObjectModel.isSearchBarEnabled();
        softly.assertThat(isSearchBarEnabled)
                .as("Search bar should be enabled to interact with it")
                .isTrue();
    }

    public void validateIfSearchBarIsEmpty(){
        boolean isSearchBarEmpty = blastCardsPageObjectModel.isSearchBarEmpty();
        softly.assertThat(isSearchBarEmpty)
                .as("Search bar should be empty by default")
                .isTrue();
    }

    public void validateSearchInputField(String expectedValue){
        String actualValue = blastCardsPageObjectModel.getSearchValue();
        softly.assertThat(actualValue)
                .as("Actual search value does not match expected search value")
                .isEqualTo(expectedValue);
    }
    
    public void validateSearchButtonVisibility(){
        boolean isSearchIconVisible = blastCardsPageObjectModel.isSearchButtonVisible();
        softly.assertThat(isSearchIconVisible)
                .as("Search icon should be visible")
                .isTrue();
    }
    
    public void validateSearchButtonInteractability(){
        boolean isSearchBarEnabled = blastCardsPageObjectModel.isSearchButtonEnabled();
        softly.assertThat(isSearchBarEnabled)
                .as("Search icon should be enabled by default")
                .isTrue();
    }
}