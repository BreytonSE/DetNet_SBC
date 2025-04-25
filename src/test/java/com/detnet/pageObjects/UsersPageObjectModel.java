package com.detnet.pageObjects;

import com.microsoft.playwright.Page;

public class UsersPageObjectModel {
    private final Page page;
    private final String usersLabel = "//h2[normalize-space()='Users']";
    private final String user = "//tr[@class='mat-mdc-row mdc-data-table__row cdk-row ng-star-inserted']";
    private final String addButton = "//button[@class='addBtn ng-star-inserted']";
    private final String addUserLabel = "//h2[normalize-space()='Add User']";
    private final String userNameInputField = "//input[@id='addUserUsername']";
    private final String emailInputField = "//input[@id='addUserEmail']";

    public UsersPageObjectModel(Page page) {
        this.page = page;
    }

    public String getUsersURL(){
        page.waitForURL("**/settings/users");
        return page.url();
    }

    public boolean isUsersLabelVisible(){
        return page.locator(usersLabel).isVisible();
    }

    public String getUsersLabel(){
        return page.locator(usersLabel).textContent();
    }

    public boolean isUserVisible(){
        return page.locator(user).isVisible();
    }

    public boolean isAddUserButtonVisible(){
        return page.locator(addButton).isVisible();
    }

    public boolean isAddUserButtonEnabled(){
        return page.locator(addButton).isEnabled();
    }

    public void AddNewUser(){
        page.locator(addButton).click();
    }

    public boolean isAddUserFormOpen(){
        return page.locator(addUserLabel).isVisible();
    }

    public String getAddUserURL(){
        page.waitForURL("**/settings/users/add");
        return page.url();
    }

    public String getAddUserLabel(){
        return page.locator(addUserLabel).textContent();
    }

    public boolean isUsernameInputFieldVisible(){
        return page.locator(userNameInputField).isVisible();
    }

    public boolean isUsernameInputFieldEnabled(){
        return page.locator(userNameInputField).isEnabled();
    }

    public boolean isUsernameInputFieldEmpty(){
        String usernameInputField = page.locator(userNameInputField).inputValue();
        return usernameInputField == null || usernameInputField.trim().isEmpty();
    }

    public void setUsername(String username){
        page.locator(userNameInputField).click();
        page.locator(userNameInputField).fill(username);
    }

    public String getUsername(){
        return page.locator(userNameInputField).inputValue();
    }

    public boolean isEmailInputFieldVisible(){
        return page.locator(emailInputField).isVisible();
    }

    public boolean isEmailInputFieldEnabled(){
        return page.locator(emailInputField).isEnabled();
    }

    public boolean isEmailInputFieldEmpty(){
        String emailInput = page.locator(emailInputField).inputValue();
        return emailInput == null || emailInput.trim().isEmpty();
    }

    public void setEmail(String email){
        page.locator(emailInputField).fill(email);
    }

    public String getEmail(){
        return page.locator(emailInputField).inputValue();
    }
}