package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.detnet.locators.LoginPageLocators.*;

public class LoginPageObjectModel {
    private final Page page;

    public LoginPageObjectModel(Page page) {
        this.page = page;
    }

    public void setUsername(String username){
        try{
            page.locator(userNameInputField).fill(username);
        }catch (PlaywrightException e){
            System.out.println("Username input field not or not visible: " + e.getMessage());
        }
    }

    public String getUsername(){
        try{
            return page.locator(userNameInputField).inputValue();
        }catch (PlaywrightException e){
            System.out.println("Username input field not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public void setPassword(String password){
        try{
            page.locator(passwordInputField).click(new Locator.ClickOptions().setTimeout(5000));
            page.locator(passwordInputField).fill(password);
        }catch (PlaywrightException e){
            System.out.println("Password input field not found or not visible: " + e.getMessage());
        }
    }

    public String getPassword(){
        try{
            return page.locator(passwordInputField).inputValue();
        }catch (PlaywrightException e){
            System.out.println("Password input field not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public void logIn(){
        try{
            page.locator(loginButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Login button not found or not visible: " + e.getMessage());
        }
    }

    public boolean isLoginButtonEnabled(){
        try{
            return page.locator(loginButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Login button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isVisibilityIconVisible(){
        try{
            page.locator(visibilityIcon)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Visibility icon not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isVisibilityIconEnabled(){
        try{
            return page.locator(visibilityIcon).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Visibility icon not found or not visible: "  + e.getMessage());
            return false;
        }
    }

    public void togglePasswordVisibility(){
        try{
            page.locator(visibilityIcon).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Visibility icon not found or not visible: " + e.getMessage());
        }
    }

    public boolean isPasswordShowing(){
        try{
            Locator eyeIcon = page.locator(visibilityIcon);
            String iconState = eyeIcon.textContent().trim();
            return iconState.equals("visibility_off");
        }catch (PlaywrightException e){
            System.out.println("Visibility icon not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isPasswordHidden(){
        try{
            Locator eyeIcon = page.locator(visibilityIcon);
            String iconState = eyeIcon.textContent().trim();
            return iconState.equals("visibility");
        }catch (PlaywrightException e){
            System.out.println("Visibility icon not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public String getLoginURL(){
        try{
            page.waitForURL("**/login");
            return page.url();
        }catch (PlaywrightException e){
            System.out.println("Failed to get login page URL: " + e.getMessage());
            return null;
        }
    }

    public boolean isPasswordErrorMessageVisible(){
        try{
            page.locator(passwordErrorLabel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Password error not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public String getPasswordErrorLabel(){
        try{
            return page.locator(passwordErrorLabel).textContent();
        }catch (PlaywrightException e){
            System.out.println("Password error not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public boolean isUnauthorizedMessageVisible(){
        try{
            page.locator(unauthorizedLabel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Unauthorized snack bar not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public String getUnauthorizedLabel(){
        try{
            return page.locator(unauthorizedLabel).textContent();
        }catch (PlaywrightException e){
            System.out.println("Unauthorized snack bar not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public boolean isPasswordFieldTypeText(){
        try{
            Locator passwordInput = page.locator(passwordInputField);
            String inputType = passwordInput.getAttribute("type");
            return inputType.equals("text");
        }catch (PlaywrightException e){
            System.out.println("Password input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isPasswordFieldPassword(){
        try{
            Locator passwordInput = page.locator(passwordInputField);
            String inputType = passwordInput.getAttribute("type");
            return inputType.equals("password");
        }catch (PlaywrightException e){
            System.out.println("Password input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isCredentialsValid(){
        try{
            page.locator(unauthorizedLabel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.HIDDEN)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Unauthorized label not found or not visible: " + e.getMessage());
            return false;
        }
    }
}