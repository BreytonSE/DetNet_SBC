package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.detnet.locators.UsersPageLocators.*;

public class UsersPageObjectModel {
    private final Page page;

    public UsersPageObjectModel(Page page) {
        this.page = page;
    }

    public String getUsersURL() {
        try{
            page.waitForURL("**/settings/users");
            return page.url();
        }catch (PlaywrightException e){
            System.out.println("URL to direct to user's page not found or invalid: " + e.getMessage());
            return null;
        }
    }

    public boolean isUsersLabelVisible() {
        try{
            page.locator(usersLabel).
                    waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'User' -label not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public String getUsersLabel() {
        try{
            return page.locator(usersLabel).textContent();
        }catch (PlaywrightException e){
            System.out.println("'User' -label not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public boolean isUserVisible() {
        try{
            page.locator(user)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("User not visible or not found on the Users page: " + e.getMessage());
            return false;
        }
    }

    public boolean isAddUserButtonVisible() {
        try{
            page.locator(addButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'Add' button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isAddUserButtonEnabled() {
        try{
            return page.locator(addButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Add' button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void AddNewUser() {
        try{
            page.locator(addButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Add' button not visible or not found: " + e.getMessage());
        }
    }

    public boolean isAddUserFormOpen() {
        try{
            page.locator(addUserLabel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'Add User' -label not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public String getAddUserURL() {
        try{
            page.waitForURL("**/settings/users/add");
            return page.url();
        }catch (PlaywrightException e){
            System.out.println("Add User's page URL invalid or not found: " + e.getMessage());
            return null;
        }
    }

    public String getAddUserLabel() {
        try{
            return page.locator(addUserLabel).textContent();
        }catch (PlaywrightException e){
            System.out.println("Add User's -label not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public boolean isUsernameInputFieldVisible() {
        try{
            page.locator(userNameInputField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("User name input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isUsernameInputFieldEnabled() {
        try{
            return page.locator(userNameInputField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Username input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isUsernameInputFieldEmpty() {
        try{
            String usernameInputField = page.locator(userNameInputField).inputValue();
            return usernameInputField == null || usernameInputField.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Username input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void setUsername(String username) {
        try{
            page.locator(userNameInputField).click();
            page.locator(userNameInputField).fill(username);
        }catch (PlaywrightException e){
            System.out.println("Username input field not visible or not found: " + e.getMessage());
        }
    }

    public String getUsername() {
        try{
            return page.locator(userNameInputField).inputValue();
        }catch (PlaywrightException e){
            System.out.println("Username input field not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public boolean isEmailInputFieldVisible() {
        try{
            page.locator(emailInputField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Email input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isEmailInputFieldEnabled() {
        try{
            return page.locator(emailInputField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Email input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isEmailInputFieldEmpty() {
        try{
            String emailInput = page.locator(emailInputField).inputValue();
            return emailInput == null || emailInput.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Email input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void setEmail(String email) {
        try{
            page.locator(emailInputField).click();
            page.locator(emailInputField).fill(email);
        }catch (PlaywrightException e){
            System.out.println("Email input field not visible or not found: " + e.getMessage());
        }
    }

    public String getEmail() {
        try{
            return page.locator(emailInputField).inputValue();
        }catch (PlaywrightException e){
            System.out.println("Email input field not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public boolean isFirstNameInputFieldVisible() {
        try{
            page.locator(nameInputField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Name input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isFirstNameInputFieldEnabled() {
        try{
            return page.locator(nameInputField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Name input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isFirstNameInputFieldEmpty() {
        try{
            String firstnameInput = page.locator(nameInputField).inputValue();
            return firstnameInput == null || firstnameInput.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Name input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void setFirstname(String firstname) {
        try{
            page.locator(nameInputField).click();
            page.locator(nameInputField).fill(firstname);
        }catch (PlaywrightException e){
            System.out.println("Name input field not found or not visible: " + e.getMessage());
        }
    }

    public String getFirstName() {
        try{
            return page.locator(nameInputField).inputValue();
        }catch (PlaywrightException e){
            System.out.println("Name input field not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public boolean isSurnameInputFieldVisible() {
        try{
            page.locator(surnameInputField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Surname input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isSurnameInputFieldEnabled() {
        try{
            return page.locator(surnameInputField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Surname input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isSurnameInputFieldEmpty() {
        try{
            String surnameInput = page.locator(surnameInputField).inputValue();
            return surnameInput == null || surnameInput.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Surname input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void setSurname(String surname) {
        try{
            page.locator(surnameInputField).click();
            page.locator(surnameInputField).fill(surname);
        }catch (PlaywrightException e){
            System.out.println("Surname input field not visible or not found: " + e.getMessage());
        }
    }

    public String getSurname() {
        try{
            return page.locator(surnameInputField).inputValue();
        }catch (PlaywrightException e){
            System.out.println("Surname input field not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public boolean isRoleFieldVisible() {
        try{
            page.locator(role)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Role element not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isRoleFieldEnabled() {
        try{
            return page.locator(role).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Role element not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void openRoleDropDown() {
        try{
            page.locator(role).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Role element not visible or not found: " + e.getMessage());
        }
    }

    public boolean isRoleDropDownOpen() {
        try{
            page.locator(roleDropDown)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Role dropdown not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void selectRole(String roleOption) {
        try{
            String role = "//span[normalize-space()='" + roleOption + "']";
            page.locator(role).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Role option not visible or not found: " + e.getMessage());
        }
    }

    public String getSelectedRole() {
        try{
            return page.locator(selectedRole).textContent();
        }catch (PlaywrightException e){
            System.out.println("Selected role not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public boolean isSubmitButtonVisible() {
        try{
            page.locator(addUserSubmitButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'Add User' -submit button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isSubmitButtonEnabled() {
        try{
            return page.locator(addUserSubmitButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Add User' -submit button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void submitUserData() {
        try{
            page.locator(addUserSubmitButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Add User' -submit button not visible or not found: " + e.getMessage());
        }
    }

    public boolean isNewUserAdded(int rowNumber) {
        try {
            String row = "//body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-users[1]/blastweb-spinner[1]/blastweb-" +
                    "zero-data[1]/div[1]/table[1]/tbody[1]/tr[" + rowNumber + "]";
            page.locator(row)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("New user does appear on list or not found: " + e.getMessage());
            return false;
        }
    }

    public String getNewUserName() {
        try{
            return page.locator(username).textContent();
        }catch (PlaywrightException e){
            System.out.println("Username not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public boolean isEditIconVisible() {
        try{
            page.locator(editIcon)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Edit icon not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void editUserData(int rowNumber) {
        try{
            String rowEditIcon = "(//mat-icon[@role='img'][normalize-space()='edit'])[" + rowNumber + "]";
            page.locator(rowEditIcon).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Edit icon for row number " + rowNumber + " not found or not visible: " +e.getMessage());
        }
    }

    public boolean isEditUserFormOpen() {
        try{
            page.locator(editUserLabel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Edit User -label not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public String getEditUserLabel() {
        try{
            return page.locator(editUserLabel).textContent();
        }catch (PlaywrightException e){
            System.out.println("Edit User -label not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public boolean isSaveButtonPresent() {
        try{
            page.locator(saveButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'Save' -button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isSaveButtonEnabled() {
        try{
            return page.locator(saveButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Save' -button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void saveUpdatedUserInformation() {
        try{
            page.locator(saveButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Save' -button not visible or not found: " + e.getMessage());
        }
    }

    public void setNewSurname(String surname) {
        try{
            page.locator(editSurnameInputField).click(new Locator.ClickOptions().setTimeout(5000));
            page.locator(editSurnameInputField).clear();
            page.locator(editSurnameInputField).fill(surname);
        }catch (PlaywrightException e){
            System.out.println("Edit surname input field not visible or not found: " + e.getMessage());
        }
    }

    public String getUpdatedSurname() {
        try{
            String updatedSurname = "//td[normalize-space()='Johnson']";
            return page.locator(updatedSurname).textContent();
        }catch (PlaywrightException e){
            System.out.println("Surname not found or not visible on the list: " + e.getMessage());
            return null;
        }
    }

    public boolean isDeleteIconVisible(int rowNumber) {
        String row = "(//span[@class='mat-mdc-tooltip-trigger material-symbols-outlined ng-star-inserted'])[" + rowNumber + "]";
        try{
            page.locator(row)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Delete icon in row number " + rowNumber + "not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void deleteUser(int rowNumber) {
        try{
            String row = "(//span[@class='mat-mdc-tooltip-trigger material-symbols-outlined ng-star-inserted'])[" + rowNumber + "]";
            page.locator(row).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("User not found or not visible to delete: " + e.getMessage());
        }
    }

    public boolean isDeleteDialogBoxOpen() {
        try{
            page.locator(deleteAlertBox)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Delete alert window not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isYesButtonPresent() {
        try{
            page.locator(yesButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'Yes' -button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void confirmToDelete() {
        try{
            page.locator(yesButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Yes' -button not visible or not found: " + e.getMessage());
        }
    }

    public boolean isUserDeleted(String userName) {
        try {
            String user = "(//td[normalize-space()='" + userName + "'])[1]";
            page.locator(user)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.HIDDEN)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("User name element should not be present on the list or should be hidden: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeleteAllCheckboxVisible() {
        try{
            page.locator(deleteAllCheckBox)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Delete All checkbox not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeleteAllCheckboxEnabled() {
        try{
            return page.locator(deleteAllCheckBox).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Delete All' -checkbox not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void selectAllUsers() {
        try{
            page.locator(deleteAllCheckBox).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Delete All' -checkbox not visible or not found: " + e.getMessage());
        }
    }

    public void selectOrDeselectUsers(String rowNumber) {
        try{
            String row = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-users[1]/blastweb-spinner[1]/" +
                    "blastweb-zero-data[1]/div[1]/table[1]/tbody[1]/tr[" + rowNumber + "]/td[1]/mat-checkbox[1]/div[1]/div[1]" +
                    "/input[1]";
            page.locator(row).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Row number not found or not visible on the list: " + e.getMessage());
        }
    }

    public boolean isDeleteUsersButtonVisible() {
        try{
            page.locator(deleteAllBtn)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'Delete All' -button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeleteUsersButtonEnabled(){
        try{
            return page.locator(deleteAllBtn).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Delete All' -button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void deleteAllUsers(){
        try{
            page.locator(deleteAllBtn).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Delete All' -button not found or not visible: " + e.getMessage());
        }
    }

    public boolean isPasswordResetIconVisible(){
        try{
            page.locator(passwordResetIcon)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Password reset icon not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void requestPasswordReset(String tableRow){
        try{
            String passwordResetIcon = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-users[1]/" +
                    "blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/table[1]/tbody[1]/tr[" + tableRow + "]/td[6]/mat-icon[2]\n";
            page.locator(passwordResetIcon).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Password reset icon not visible or not found: " + e.getMessage());
        }
    }

    public boolean isPasswordResetDialogOpen(){
        try {
            page.locator(passwordResetDialog)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Password reset dialog not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void confirmToResetPassword(){
        try{
            page.locator(yesButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Yes' -button not visible or not found: " + e.getMessage());
        }
    }

    public boolean isUserSearchBarVisible(){
        try{
            page.locator(searchBar)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isUserSearchBarEnabled(){
        try{
            return page.locator(searchBar).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isUserSearchBarEmpty(){
        try{
            String searchPath = page.locator(searchBar).inputValue();
            return searchPath == null || searchPath.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Search bar not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void searchUser(String userCredentials){
        try{
            page.locator(searchBar).click();
            page.locator(searchBar).fill(userCredentials);
        }catch (PlaywrightException e){
            System.out.println("Search bar not visible or not found: " + e.getMessage());
        }
    }

    public String getSearchedValue(){
        try{
            return page.locator(searchBar).inputValue();
        }catch (PlaywrightException e){
            System.out.println("Search bar not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public void clearSearchBar(){
        try{
            page.locator(searchBar).clear();
        }catch (PlaywrightException e){
            System.out.println("Search bar not visible or not found: " + e.getMessage());
        }
    }

    public boolean isUserFound(String username){
        try{
            String userNamePath = "(//td[normalize-space()='" + username + "'])[1]";
            page.locator(userNamePath)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("User not found or may not be visible: " + e.getMessage());
            return false;
        }
    }
}