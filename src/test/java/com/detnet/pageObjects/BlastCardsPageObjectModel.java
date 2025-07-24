package com.detnet.pageObjects;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;

import static com.detnet.locators.BlastCardsPageLocators.*;

public class BlastCardsPageObjectModel {
    private final Page page;

    public BlastCardsPageObjectModel(Page page) {
        this.page = page;
    }

    public String getActiveBlastCardsPageURL(){
        try{
            page.waitForURL("**/settings/activeCards");
            return page.url();
        }catch (PlaywrightException e){
            System.out.println("URL not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public boolean isActiveCardsLabelVisible(){
        try{
            return page.locator(activeCardsLabel).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Active cards label not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public String getActiveCardsLabel(){
        try{
            return page.locator(activeCardsLabel).textContent();
        }catch (PlaywrightException e){
            System.out.println("Active cards label not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public boolean isAddBlastCardButtonVisible(){
        try{
            return page.locator(addBlastCardsButton).isVisible();
        }catch (PlaywrightException e){
            System.out.println("'Add Blast Card' -button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isAddBlastCardButtonEnabled(){
        try{
            return page.locator(addBlastCardsButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Add Blast Card' -button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void addBlastCard(){
        try{
            page.locator(addBlastCardsButton).click();
        }catch (PlaywrightException e){
            System.out.println("'Add Blast Card' -button not found or not visible: " + e.getMessage());
        }
    }

    public boolean isArchiveButtonVisible(){
        try{
            return page.locator(archiveCardsButton).isVisible();
        }catch (PlaywrightException e){
            System.out.println("'Archive Card' -button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isArchiveButtonEnabled(){
        try{
            return page.locator(archiveCardsButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Archive Card' -button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void viewArchivedCards(){
        try{
            page.locator(archivedCardsButton).click();
        }catch (PlaywrightException e){
            System.out.println("'Archive Card' -button not found or not visible: " + e.getMessage());
        }
    }

    public boolean isArchivedCardsButtonEnabled(){
        try{
            return page.locator(archivedCardsButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Archive Card' -button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isArchivedCardsButtonVisible(){
        try{
            return page.locator(archivedCardsButton).isVisible();
        }catch (PlaywrightException e){
            System.out.println("'Archive Card' -button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public String getArchivedBlastCardsURL(){
        try{
            page.waitForURL("**/settings/archivedCards");
            return page.url();
        }catch (PlaywrightException e){
            System.out.println("URL not found or not valid: " + e.getMessage());
            return null;
        }
    }

    public boolean isBlastCardAlertWindowOpen(){
        try{
            return page.locator(blastCardAlertWindow).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Blast card alert window not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void closeBlastCardAlertWindow(){
        try{
            page.locator(closeIcon).click();
        }catch (PlaywrightException e){
            System.out.println("Close icon not found or not visible: " + e.getMessage());
        }
    }

    public boolean isArchivedCardsLabelVisible(){
        try{
            return page.locator(archiveCardsLabel).isVisible();
        }catch (PlaywrightException e){
            System.out.println("'Archive Cards' -label not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public String getArchivedCardsLabel(){
        try{
            return page.locator(archiveCardsLabel).textContent();
        }catch (PlaywrightException e){
            System.out.println("'Archive Cards' -label not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public boolean isDeleteButtonVisible(){
        try{
            return page.locator(deleteCardsButton).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Delete button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeleteButtonEnabled(){
        try{
            return page.locator(deleteCardsButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Delete button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSearchBarVisible(){
        try{
            return page.locator(searchBar).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSearchBarEnabled(){
        try{
            return page.locator(searchBar).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSearchBarEmpty(){
        try{
            String value = page.locator(searchBar).inputValue();
            return value == null || value.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void setSearchValue(String value){
        try{
            page.locator(searchBar).click();
            page.locator(searchBar).fill(value);
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
        }
    }

    public String getSearchValue(){
        try{
            return page.locator(searchBar).inputValue();
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public boolean isSearchButtonVisible(){
        try{
            return page.locator(searchButton).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Search button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSearchButtonEnabled(){
        try{
            return page.locator(searchButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Search button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void search(){
        try{
            page.locator(searchButton).click();
        }catch (PlaywrightException e){
            System.out.println("Search button not found or not visible: " + e.getMessage());
        }
    }
}