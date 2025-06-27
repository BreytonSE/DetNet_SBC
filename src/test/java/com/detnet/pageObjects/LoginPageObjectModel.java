package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

public class LoginPageObjectModel {
    private final Page page;
    private final String userNameInputField = "//input[@id='loginUsername']";
    private final String passwordInputField = "//input[@id='loginPassword']";
    private final String loginButton = "//button[@id='loginButton']";
    private final String visibilityIcon = "//mat-icon[@role='img']";
    private final String passwordErrorLabel = "[id^='mat-mdc-error-']";
    private final String unauthorizedLabel = "//span[normalize-space()='Dismiss']";

    public LoginPageObjectModel(Page page) {
        this.page = page;
    }

    public void setUsername(String username){
        page.locator(userNameInputField).fill(username);
    }

    public String getUsername(){
        return page.locator(userNameInputField).inputValue();
    }

    public void setPassword(String password){
        page.locator(passwordInputField).click(new Locator.ClickOptions().setTimeout(5000));
        page.locator(passwordInputField).fill(password);
    }

    public String getPassword(){
        return page.locator(passwordInputField).inputValue();
    }

    public void logIn(){
        page.locator(loginButton).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isLoginButtonEnabled(){
        return page.locator(loginButton).isEnabled();
    }

    public boolean isVisibilityIconVisible(){
        try{
            page.locator(visibilityIcon)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isVisibilityIconEnabled(){
        return page.locator(visibilityIcon).isEnabled();
    }

    public void togglePasswordVisibility(){
        page.locator(visibilityIcon).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isPasswordShowing(){
        Locator eyeIcon = page.locator(visibilityIcon);
        String iconState = eyeIcon.textContent().trim();
        return iconState.equals("visibility_off");
    }

    public boolean isPasswordHidden(){
        Locator eyeIcon = page.locator(visibilityIcon);
        String iconState = eyeIcon.textContent().trim();
        return iconState.equals("visibility");
    }

    public String getLoginURL(){
        page.waitForURL("**/login");
        return page.url();
    }

    public boolean isPasswordErrorMessageVisible(){
        try{
            page.locator(passwordErrorLabel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public String getPasswordErrorLabel(){
        return page.locator(passwordErrorLabel).textContent();
    }

    public boolean isUnauthorizedMessageVisible(){
        try{
            page.locator(unauthorizedLabel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public String getUnauthorizedLabel(){
        return page.locator(unauthorizedLabel).textContent();
    }

    public boolean isPasswordFieldTypeText(){
        Locator passwordInput = page.locator(passwordInputField);
        String inputType = passwordInput.getAttribute("type");
        return inputType.equals("text");
    }

    public boolean isPasswordFieldPassword(){
        Locator passwordInput = page.locator(passwordInputField);
        String inputType = passwordInput.getAttribute("type");
        return inputType.equals("password");
    }
}