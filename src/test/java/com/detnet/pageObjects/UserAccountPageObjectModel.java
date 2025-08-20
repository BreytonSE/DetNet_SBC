package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.detnet.locators.UserAccountPageLocators.*;

public class UserAccountPageObjectModel {
    private final Page page;

    public UserAccountPageObjectModel(Page page) {
        this.page = page;
    }

    public String getUserAccountURL(){
        try{
            page.waitForURL("**/en/user-account");
            return page.url();
        }catch (PlaywrightException e){
            System.out.println("URL not found or not valid: " + e.getMessage());
            return null;
        }
    }

    public boolean isUserAccountPageVisible(){
        try{
            page.locator(userAccountDetailsHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("User account details heading not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isEditDetailsButtonVisible(){
        try{
            page.locator(editDetailsButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'Edit Details' -button not visible or not found on user details page: " + e.getMessage());
            return false;
        }
    }

    public boolean isEditDetailsButtonEnabled(){
        try{
            return page.locator(editDetailsButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Edit Details' -button not visible or not found on user details page: " + e.getMessage());
            return false;
        }
    }

    public String getEditDetailsButtonText(){
        try{
            return page.locator(editDetailsButton).textContent();
        }catch (PlaywrightException e){
            System.out.println("'Edit Details' -button not visible or not found on user details page: " + e.getMessage());
            return null;
        }
    }

    public void navigateToEditUserPage(){
        try{
            page.locator(editDetailsButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Edit Details' -button not visible or not found on user details page: " + e.getMessage());
        }
    }

    public boolean isPasswordChangeButtonVisible(){
        try{
            page.locator(changeMyPasswordBtn)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'Change My Password' -button not visible or not found on user details page: " +
                    e.getMessage());
            return false;
        }
    }

    public boolean isPasswordChangeButtonEnabled(){
        try{
            return page.locator(changeMyPasswordBtn).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Change My Password' -button not visible or not found on user details page: " +
                    e.getMessage());
            return false;
        }
    }

    public void goToPasswordResetPage(){
        try{
            page.locator(changeMyPasswordBtn).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Change My Password' -button not visible or not found on user details page: " +
                    e.getMessage());
        }
    }

    public String getPasswordChangeButtonText(){
        try{
            return page.locator(changeMyPasswordBtn).textContent();
        }catch (PlaywrightException e){
            System.out.println("'Change My Password' -button not visible or not found on user details page: " +
                    e.getMessage());
            return null;
        }
    }
}