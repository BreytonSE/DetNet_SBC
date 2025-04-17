package com.detnet.pageObjects;

import com.microsoft.playwright.Page;

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

    //    Set the username
    public void setUsername(String username){
        page.locator(userNameInputField).fill(username);
    }

    public String getUsername(){
        return page.locator(userNameInputField).inputValue();
    }

    //    Set the password
    public void setPassword(String password){
        page.locator(passwordInputField).click();
        page.locator(passwordInputField).fill(password);
    }

    public String getPassword(){
        return page.locator(passwordInputField).inputValue();
    }

    //    Click on the login button
    public void logIn(){
        page.locator(loginButton).click();
    }

    public boolean isLoginButtonEnabled(){
        return page.locator(loginButton).isEnabled();
    }

    public boolean isVisibilityIconVisible(){
        return page.locator(visibilityIcon).isVisible();
    }

    public void togglePasswordVisibility(){
        page.locator(visibilityIcon).click();
    }

    public String getLoginURL(){
        page.waitForURL("**/login");
        return page.url();
    }

    public boolean isPasswordErrorMessageVisible(){
        return page.locator(passwordErrorLabel).isVisible();
    }

    public String getPasswordErrorLabel(){
        return page.locator(passwordErrorLabel).textContent();
    }

    public boolean isUnauthorizedMessageVisible(){
        return page.locator(unauthorizedLabel).isVisible();
    }

    public String getUnauthorizedLabel(){
        return page.locator(unauthorizedLabel).textContent();
    }
}