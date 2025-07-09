package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.detnet.locators.PasswordResetPageLocators.*;

public class PasswordResetPageObjectModel {
    private final Page page;

    public PasswordResetPageObjectModel(Page page) {
        this.page = page;
    }

    public String getPasswordResetPageURL(){
        page.waitForURL("**/password-reset");
        return page.url();
    }

    public boolean isPasswordResetFormVisible(){
        return page.locator(passwordResetForm).isVisible();
    }

    public boolean isCurrentPasswordFieldVisible(){
        return page.locator(currentPasswordField).isVisible();
    }

    public boolean isCurrentPasswordFieldEnabled(){
        return page.locator(currentPasswordField).isEnabled();
    }

    public boolean isCurrentPasswordFieldEmpty(){
        String currentPasswordInputField = page.locator(currentPasswordField).inputValue();
        return currentPasswordInputField == null || currentPasswordInputField.trim().isEmpty();
    }

    public void setCurrentPassword(String currentPassword){
        page.locator(currentPasswordField).fill(currentPassword);
    }

    public String getCurrentPassword(){
        return page.locator(currentPasswordField).inputValue();
    }

    public boolean isNewPasswordFieldVisible(){
        return page.locator(newPasswordField).isVisible();
    }

    public boolean isNewPasswordFieldEnabled(){
        return page.locator(newPasswordField).isEnabled();
    }

    public boolean isNewPasswordFieldEmpty(){
        String newPasswordInputField = page.locator(newPasswordField).inputValue();
        return newPasswordInputField == null || newPasswordInputField.trim().isEmpty();
    }

    public void setNewPassword(String newPassword){
        page.locator(newPasswordField).click();
        page.locator(newPasswordField).fill(newPassword);
    }

    public String getNewPassword(){
        return page.locator(newPasswordField).inputValue();
    }

    public boolean isConfirmedPasswordFieldVisible(){
        return page.locator(confirmedPasswordField).isVisible();
    }

    public boolean isConfirmedPasswordFieldEnabled(){
        return page.locator(confirmedPasswordField).isEnabled();
    }

    public boolean isConfirmedPasswordFieldEmpty(){
        String confirmPasswordInputField = page.locator(confirmedPasswordField).inputValue();
        return confirmPasswordInputField == null || confirmPasswordInputField.trim().isEmpty();
    }

    public void setConfirmedPassword(String confirmedPassword){
        page.locator(confirmedPasswordField).click();
        page.locator(confirmedPasswordField).fill(confirmedPassword);
    }

    public String getConfirmedPassword(){
        return page.locator(confirmedPasswordField).inputValue();
    }

    public boolean isChangePasswordButtonVisible(){
        return page.locator(changePasswordButton).isVisible();
    }

    public boolean isChangedPasswordButtonEnabled(){
        return page.locator(changePasswordButton).isEnabled();
    }

    public void changePassword(){
        page.locator(changePasswordButton).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isCurrentPasswordVisibilityIconPresent(){
        return page.locator(currentPasswordVisibilityIcon).isVisible();
    }

    public boolean isCurrentPasswordVisibilityIconEnabled(){
        return page.locator(currentPasswordVisibilityIcon).isEnabled();
    }

    public void toggleCurrentPasswordVisibility(){
        page.locator(currentPasswordVisibilityIcon).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isCurrentPasswordFieldTypeText(){
        Locator passwordInput = page.locator(currentPasswordField);
        String inputType = passwordInput.getAttribute("type");
        return inputType.equals("text");
    }

    public boolean isCurrentPasswordFieldPassword(){
        Locator passwordInput = page.locator(currentPasswordField);
        String inputType = passwordInput.getAttribute("type");
        return inputType.equals("password");
    }

    public boolean isNewPasswordVisibilityIconPresent(){
        return page.locator(newPasswordVisibilityIcon).isVisible();
    }

    public boolean isNewPasswordVisibilityIconEnabled(){
        return page.locator(newPasswordVisibilityIcon).isEnabled();
    }

    public void toggleNewPasswordVisibility(){
        page.locator(newPasswordVisibilityIcon).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isNewPasswordFieldTypeText(){
        Locator passwordInput = page.locator(newPasswordField);
        String inputType = passwordInput.getAttribute("type");
        return inputType.equals("text");
    }

    public boolean isNewPasswordFieldPassword(){
        Locator passwordInput = page.locator(newPasswordField);
        String inputType = passwordInput.getAttribute("type");
        return inputType.equals("password");
    }

    public boolean isConfirmPasswordVisibilityIconPresent(){
        return page.locator(confirmedPasswordVisibilityIcon).isVisible();
    }

    public boolean isConfirmPasswordVisibilityIconEnabled(){
        return page.locator(confirmedPasswordVisibilityIcon).isEnabled();
    }

    public void toggleConfirmedPasswordVisibility(){
        page.locator(confirmedPasswordVisibilityIcon).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isConfirmedPasswordHidden(){
        Locator passwordInput = page.locator(confirmedPasswordField);
        String inputType = passwordInput.getAttribute("type");
        return inputType.equals("password");
    }

    public boolean isConfirmedPasswordText(){
        Locator passwordInput = page.locator(confirmedPasswordField);
        String inputType = passwordInput.getAttribute("type");
        return inputType.equals("text");
    }
}