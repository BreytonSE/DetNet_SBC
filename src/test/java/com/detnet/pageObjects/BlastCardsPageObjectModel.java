package com.detnet.pageObjects;

import com.microsoft.playwright.Page;

import static com.detnet.locators.BlastCardsPageLocators.*;

public class BlastCardsPageObjectModel {
    private final Page page;

    public BlastCardsPageObjectModel(Page page) {
        this.page = page;
    }

    public String getActiveBlastCardsPageURL(){
        page.waitForURL("**/settings/activeCards");
        return page.url();
    }

    public boolean isActiveCardsLabelVisible(){
        return page.locator(activeCardsLabel).isVisible();
    }

    public String getActiveCardsLabel(){
        return page.locator(activeCardsLabel).textContent();
    }

    public boolean isAddBlastCardButtonVisible(){
        return page.locator(addBlastCardsButton).isVisible();
    }

    public boolean isAddBlastCardButtonEnabled(){
        return page.locator(addBlastCardsButton).isEnabled();
    }

    public void addBlastCard(){
        page.locator(addBlastCardsButton).click();
    }

    public boolean isArchiveButtonVisible(){
        return page.locator(archiveCardsButton).isVisible();
    }

    public boolean isArchiveButtonEnabled(){
        return page.locator(archiveCardsButton).isEnabled();
    }

    public void archiveCards(){
        page.locator(archiveCardsButton).click();
    }

    public void viewArchivedCards(){
        page.locator(archivedCardsButton).click();
    }

    public boolean isArchivedCardsButtonEnabled(){
        return page.locator(archivedCardsButton).isEnabled();
    }

    public boolean isArchivedCardsButtonVisible(){
        return page.locator(archivedCardsButton).isVisible();
    }

    public String getArchivedBlastCardsURL(){
        page.waitForURL("**/settings/archivedCards");
        return page.url();
    }

    public boolean isBlastCardAlertWindowOpen(){
        return page.locator(blastCardAlertWindow).isVisible();
    }

    public void closeBlastCardAlertWindow(){
        page.locator(closeIcon).click();
    }

    public boolean isArchivedCardsLabelVisible(){
        return page.locator(archiveCardsLabel).isVisible();
    }

    public String getArchivedCardsLabel(){
        return page.locator(archiveCardsLabel).textContent();
    }

    public boolean isDeleteButtonVisible(){
        return page.locator(deleteCardsButton).isVisible();
    }

    public boolean isDeleteButtonEnabled(){
        return page.locator(deleteCardsButton).isEnabled();
    }

    public void deleteBlastCard(){
        page.locator(deleteCardsButton).click();
    }

    public boolean isSearchBarVisible(){
        return page.locator(searchBar).isVisible();
    }

    public boolean isSearchBarEnabled(){
        return page.locator(searchBar).isEnabled();
    }

    public boolean isSearchBarEmpty(){
        String value = page.locator(searchBar).inputValue();
        return value == null || value.trim().isEmpty();
    }

    public void setSearchValue(String value){
        page.locator(searchBar).click();
        page.locator(searchBar).fill(value);
    }

    public String getSearchValue(){
        return page.locator(searchBar).inputValue();
    }

    public boolean isSearchButtonVisible(){
        return page.locator(searchButton).isVisible();
    }

    public boolean isSearchButtonEnabled(){
        return page.locator(searchButton).isEnabled();
    }

    public void search(){
        page.locator(searchButton).click();
    }
}