package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.detnet.locators.BlastConfirmationPageLocators.*;

public class BlastConfirmationPageObjectModel {
    private final Page page;

    public BlastConfirmationPageObjectModel(Page page) {
        this.page = page;
    }

    public String getPageURL() {
        try{
            page.waitForURL("**/blast", new Page.WaitForURLOptions().setTimeout(10000));
            return page.url();
        }catch (PlaywrightException e){
            System.out.println("URL not found: " + e.getMessage());
            return null;
        }
    }

    public boolean isBlastConfirmationScreenOpen() {
        try {
            page.locator(confirmBlastHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Blast confirmation heading not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isProceedButtonVisible() {
        try {
            page.locator(proceedButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Proceed button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isProceedButtonEnabled() {
        try {
            page.locator(proceedButton).isEnabled();
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Proceed button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void proceedToBlast() {
        try{
            page.locator(proceedButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Proceed button not found or not visible: " + e.getMessage());
        }
    }

    public boolean isNFCReaderConfirmationDialogVisible() {
        try {
            page.locator(dialogTitle)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Dialog title not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isPasswordPromptWindowOpen(){
        try{
            page.locator(passwordPromptWindow)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Password prompt window not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isPasswordFieldVisible(){
        try{
            page.locator(passwordInputField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Password inout field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isPasswordFieldEnabled(){
        try{
            return page.locator(passwordInputField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Password inout field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isPasswordFieldEmpty(){
        try{
            String passwordField = page.locator(passwordInputField).textContent();
            return passwordField == null || passwordField.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Password inout field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void setPassword(String password){
        try{
            page.locator(passwordInputField).click(new Locator.ClickOptions().setTimeout(5000));
            page.locator(passwordInputField).fill(password);
        }catch (PlaywrightException e){
            System.out.println("Password inout field not found or not visible: " + e.getMessage());
        }
    }

    public boolean isPasswordSet(){
        try{
            String passwordField = page.locator(passwordInputField).inputValue();
            return passwordField != null && !passwordField.isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Password inout field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isContinueButtonVisible(){
        try{
            page.locator(continueButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Continue button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isContinueButtonEnabled(){
        try{
            page.locator(continueButton).isEnabled();
            return true;
        }catch (PlaywrightException e){
            System.out.println("'Continue' button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void continueToBlast(){
        try{
            page.locator(continueButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Continue' button not found or not visible: " + e.getMessage());
        }
    }

    public boolean isSuperVisorCredentialsWindowOpen(){
        try{
            page.locator(superVisorCredentialsPromptWindow)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Supervisor credentials window not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSupervisorUsernameFieldVisible(){
        try{
            page.locator(supervisorUsernameInputField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Supervisor username input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isSupervisorUsernameFieldEnabled(){
        try{
            return page.locator(supervisorUsernameInputField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Supervisor username input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isSupervisorUsernameFieldEmpty(){
        try{
            String usernameInputField = page.locator(supervisorUsernameInputField).textContent();
            return usernameInputField == null || usernameInputField.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Supervisor username input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void setSuperVisorUsername(String username){
        try{
            page.locator(supervisorUsernameInputField).click();
            page.locator(supervisorUsernameInputField).fill(username);
        }catch (PlaywrightException e){
            System.out.println("Supervisor username input field not visible or not found: " + e.getMessage());
        }
    }

    public boolean isSupervisorUsernameSet(){
        try{
            String usernameInputField = page.locator(supervisorUsernameInputField).inputValue();
            return usernameInputField != null && !usernameInputField.isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Supervisor username input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isSupervisorPasswordFieldVisible(){
        try {
            page.locator(supervisorPasswordInputField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Supervisor password input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSupervisorPasswordFieldEnabled(){
        try {
            return page.locator(supervisorPasswordInputField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Supervisor password input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSupervisorPasswordEmpty(){
        try {
            String passwordInputField = page.locator(supervisorPasswordInputField).textContent();
            return passwordInputField == null || passwordInputField.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Supervisor password input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void setSupervisorPassword(String password){
        try {
            page.locator(supervisorPasswordInputField).click();
            page.locator(supervisorPasswordInputField).fill(password);
        }catch (PlaywrightException e){
            System.out.println("Supervisor password input field not found or not visible: " + e.getMessage());
        }
    }

    public boolean isSupervisorPasswordSet(){
        try {
            String passwordInputField = page.locator(supervisorPasswordInputField).inputValue();
            return passwordInputField != null && !passwordInputField.isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Supervisor password input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isStartBlastButtonVisible(){
        try{
            page.locator(startBlastButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Start Blast button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isStartBlastButtonEnabled(){
        try{
            return page.locator(startBlastButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Start Blast button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void startBlast(){
        try{
            page.locator(startBlastButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Start Blast button not found or not visible: " + e.getMessage());
        }
    }
}