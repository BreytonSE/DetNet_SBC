package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.detnet.locators.PasswordResetPageLocators.*;

public class PasswordResetPageObjectModel {
    private final Page page;

    public PasswordResetPageObjectModel(Page page) {
        this.page = page;
    }

    public String getPasswordResetPageURL(){
        try{
            page.waitForURL("**/password-reset");
            return page.url();
        }catch (PlaywrightException e){
            System.out.println("URL not found or not valid: " + e.getMessage());
            return null;
        }
    }

    public boolean isPasswordResetFormVisible(){
        try{
            page.locator(passwordResetForm)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Password reset form not found or not displaying: " + e.getMessage());
            return false;
        }
    }

    public boolean isCurrentPasswordFieldVisible(){
        try{
            page.locator(currentPasswordField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'Current Password' input field not found or not displaying: " + e.getMessage());
            return false;
        }
    }

    public boolean isCurrentPasswordFieldEnabled(){
        try{
            return page.locator(currentPasswordField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Current Password' input field not found or not displaying: " + e.getMessage());
            return false;
        }
    }

    public boolean isCurrentPasswordFieldEmpty(){
        try{
            String currentPasswordInputField = page.locator(currentPasswordField).inputValue();
            return currentPasswordInputField == null || currentPasswordInputField.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("'Current Password' input field not found or not displaying: " + e.getMessage());
            return false;
        }
    }

    public void setCurrentPassword(String currentPassword){
        try{
            page.locator(currentPasswordField).fill(currentPassword);
        }catch (PlaywrightException e){
            System.out.println("'Current Password' input field not found or not displaying: " + e.getMessage());
        }
    }

    public String getCurrentPassword(){
        try{
            return page.locator(currentPasswordField).inputValue();
        }catch (PlaywrightException e){
            System.out.println("'Current Password' input field not found or not displaying: " + e.getMessage());
            return null;
        }
    }

    public boolean isNewPasswordFieldVisible(){
        try{
            page.locator(newPasswordField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'New Password' input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isNewPasswordFieldEnabled(){
        try{
            return page.locator(newPasswordField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'New Password' input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isNewPasswordFieldEmpty(){
        try{
            String newPasswordInputField = page.locator(newPasswordField).inputValue();
            return newPasswordInputField == null || newPasswordInputField.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("'New Password' input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void setNewPassword(String newPassword){
        try{
            page.locator(newPasswordField).click(new Locator.ClickOptions().setTimeout(5000));
            page.locator(newPasswordField).fill(newPassword);
        }catch (PlaywrightException e){
            System.out.println("'New Password' input field not visible or not found: " + e.getMessage());
        }
    }

    public String getNewPassword(){
        try{
            return page.locator(newPasswordField).inputValue();
        }catch (PlaywrightException e){
            System.out.println("'New Password' input field not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public boolean isConfirmedPasswordFieldVisible(){
        try{
            page.locator(confirmedPasswordField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'Confirmed Password' input field not found or not displaying: " + e.getMessage());
            return false;
        }
    }

    public boolean isConfirmedPasswordFieldEnabled(){
        try{
            return page.locator(confirmedPasswordField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Confirmed Password' input field not found or not displaying: " + e.getMessage());
            return false;
        }
    }

    public boolean isConfirmedPasswordFieldEmpty(){
        try{
            String confirmPasswordInputField = page.locator(confirmedPasswordField).inputValue();
            return confirmPasswordInputField == null || confirmPasswordInputField.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("'Confirmed Password' input field not found or not displaying: " + e.getMessage());
            return false;
        }
    }

    public void setConfirmedPassword(String confirmedPassword){
        try{
            page.locator(confirmedPasswordField).click(new Locator.ClickOptions().setTimeout(5000));
            page.locator(confirmedPasswordField).fill(confirmedPassword);
        }catch (PlaywrightException e){
            System.out.println("'Confirmed Password' input field not found or not displaying: " + e.getMessage());
        }
    }

    public String getConfirmedPassword(){
        try{
            return page.locator(confirmedPasswordField).inputValue();
        }catch (PlaywrightException e){
            System.out.println("'Confirmed Password' input field not found or not displaying: " + e.getMessage());
            return null;
        }
    }

    public boolean isChangePasswordButtonVisible(){
        try{
            page.locator(changePasswordButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Change Password button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isChangedPasswordButtonEnabled(){
        try{
            return page.locator(changePasswordButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Change Password button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void changePassword(){
        try{
            Thread.sleep(5000);
            page.locator(changePasswordButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Change Password button not visible or not found: " + e.getMessage());
        }catch (Exception e){
            System.out.println("Timeout exception: " + e.getMessage());
        }
    }

    public boolean isCurrentPasswordVisibilityIconPresent(){
        try{
            page.locator(currentPasswordVisibilityIcon)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Password visibility icon not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isCurrentPasswordVisibilityIconEnabled(){
        try{
            return page.locator(currentPasswordVisibilityIcon).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Password visibility icon not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void toggleCurrentPasswordVisibility(){
        try{
            page.locator(currentPasswordVisibilityIcon).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Password visibility icon not found or not visible: " + e.getMessage());
        }
    }

    public boolean isCurrentPasswordFieldTypeText(){
        try{
            Locator passwordInput = page.locator(currentPasswordField);
            String inputType = passwordInput.getAttribute("type");
            return inputType.equals("text");
        }catch (PlaywrightException e){
            System.out.println("Current Password field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isCurrentPasswordFieldPassword(){
        try{
            Locator passwordInput = page.locator(currentPasswordField);
            String inputType = passwordInput.getAttribute("type");
            return inputType.equals("password");
        }catch (PlaywrightException e){
            System.out.println("Current Password field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isNewPasswordVisibilityIconEnabled(){
        try{
            return page.locator(newPasswordVisibilityIcon).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Password visibility icon not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void toggleNewPasswordVisibility(){
        try{
            page.locator(newPasswordVisibilityIcon).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Password visibility icon not found or not visible: " + e.getMessage());
        }
    }

    public boolean isNewPasswordFieldTypeText(){
        try{
            Locator passwordInput = page.locator(newPasswordField);
            String inputType = passwordInput.getAttribute("type");
            return inputType.equals("text");
        }catch (PlaywrightException e){
            System.out.println("'New Password' -input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isNewPasswordFieldPassword(){
        try{
            Locator passwordInput = page.locator(newPasswordField);
            String inputType = passwordInput.getAttribute("type");
            return inputType.equals("password");
        }catch (PlaywrightException e){
            System.out.println("Password field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isConfirmPasswordVisibilityIconPresent(){
        try{
            page.locator(confirmedPasswordVisibilityIcon)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Password visibility icon not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isConfirmPasswordVisibilityIconEnabled(){
        try{
            return page.locator(confirmedPasswordVisibilityIcon).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Password visibility icon not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void toggleConfirmedPasswordVisibility(){
        try{
            page.locator(confirmedPasswordVisibilityIcon).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Password visibility icon not found or not visible: " + e.getMessage());
        }
    }

    public boolean isConfirmedPasswordHidden(){
        try{
            Locator passwordInput = page.locator(confirmedPasswordField);
            String inputType = passwordInput.getAttribute("type");
            return inputType.equals("password");
        }catch (PlaywrightException e){
            System.out.println("'Confirmed Password' field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isConfirmedPasswordText(){
        try{
            Locator passwordInput = page.locator(confirmedPasswordField);
            String inputType = passwordInput.getAttribute("type");
            return inputType.equals("text");
        }catch (PlaywrightException e){
            System.out.println("'Confirmed Password' field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isPasswordUpdated(){
        try{
            page.locator(passwordResetUpdateMessage)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Password update not displaying or not found on password reset screen: " + e.getMessage());
            return false;
        }
    }
}