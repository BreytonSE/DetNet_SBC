package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

public class UsersPageObjectModel {
    private final Page page;
    private final String usersLabel = "//h2[normalize-space()='Users']";
    private final String user = "//tr[@class='mat-mdc-row mdc-data-table__row cdk-row ng-star-inserted']";
    private final String addButton = "//button[@class='addBtn ng-star-inserted']";
    private final String addUserLabel = "//h2[normalize-space()='Add User']";
    private final String userNameInputField = "//input[@id='addUserUsername']";
    private final String emailInputField = "//input[@id='addUserEmail']";
    private final String nameInputField = "//input[@id='addUserFirstName']";
    private final String surnameInputField = "//input[@id='addUserSurname']";
    private final String role = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/app-add-user[1]/div[1]/div[1]/div[1]/form[1]/mat-form-field[5]/div[1]/div[2]/div[1]/mat-select[1]/div[1]/div[1]/span[1]";
    private final String roleDropDown = "//div[@id='addUserRole-panel']";
    private final String selectedRole = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/app-add-user[1]/div[1]/div[1]/div[1]/form[1]/mat-form-field[5]/div[1]/div[2]/div[1]/mat-select[1]/div[1]/div[1]/span[1]/span[1]";
    private final String addUserSubmitButton = "//button[@id='addUserSubmitButton']";
    private final String username = "//td[normalize-space()='JohnD']";
    private final String editIcon = "//tbody/tr[1]/td[6]/mat-icon[1]";
    private final String editUserLabel = "//h2[normalize-space()='Edit User']";
    private final String saveButton = "//button[@type='submit']//span[@class='mat-mdc-button-persistent-ripple mdc-button__ripple']";
    private final String editSurnameInputField = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/app-edit-user[1]/div[1]/div[1]/div[1]/form[1]/mat-form-field[4]/div[1]/div[2]/div[1]/input[1]";
    private final String deleteAlertBox = "//div[@class='mat-mdc-dialog-surface mdc-dialog__surface']";
    private final String yesButton = "//button[@class='yesBtn']";
    private final String deleteAllCheckBox = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-users[1]/blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/table[1]/thead[1]/tr[1]/th[1]/mat-checkbox[1]/div[1]/div[1]/input[1]";
    private final String deleteAllBtn = "//button[@class=\"deleteAllBtn\"]";
    private final String passwordResetIcon = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-users[1]/blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/mat-icon[2]";
    private final String passwordResetDialog = "//div[@class=\"mat-mdc-dialog-surface mdc-dialog__surface\"]";
    private final String searchBar = "//input[@placeholder=\"Search using Username, First name, Surname\"]";

    public UsersPageObjectModel(Page page) {
        this.page = page;
    }

    public String getUsersURL() {
        page.waitForURL("**/settings/users");
        return page.url();
    }

    public boolean isUsersLabelVisible() {
        return page.locator(usersLabel).isVisible();
    }

    public String getUsersLabel() {
        return page.locator(usersLabel).textContent();
    }

    public boolean isUserVisible() {
        return page.locator(user).isVisible();
    }

    public boolean isAddUserButtonVisible() {
        return page.locator(addButton).isVisible();
    }

    public boolean isAddUserButtonEnabled() {
        return page.locator(addButton).isEnabled();
    }

    public void AddNewUser() {
        page.locator(addButton).click();
    }

    public boolean isAddUserFormOpen() {
        return page.locator(addUserLabel).isVisible();
    }

    public String getAddUserURL() {
        page.waitForURL("**/settings/users/add");
        return page.url();
    }

    public String getAddUserLabel() {
        return page.locator(addUserLabel).textContent();
    }

    public boolean isUsernameInputFieldVisible() {
        return page.locator(userNameInputField).isVisible();
    }

    public boolean isUsernameInputFieldEnabled() {
        return page.locator(userNameInputField).isEnabled();
    }

    public boolean isUsernameInputFieldEmpty() {
        String usernameInputField = page.locator(userNameInputField).inputValue();
        return usernameInputField == null || usernameInputField.trim().isEmpty();
    }

    public void setUsername(String username) {
        page.locator(userNameInputField).click();
        page.locator(userNameInputField).fill(username);
    }

    public String getUsername() {
        return page.locator(userNameInputField).inputValue();
    }

    public boolean isEmailInputFieldVisible() {
        return page.locator(emailInputField).isVisible();
    }

    public boolean isEmailInputFieldEnabled() {
        return page.locator(emailInputField).isEnabled();
    }

    public boolean isEmailInputFieldEmpty() {
        String emailInput = page.locator(emailInputField).inputValue();
        return emailInput == null || emailInput.trim().isEmpty();
    }

    public void setEmail(String email) {
        page.locator(emailInputField).click();
        page.locator(emailInputField).fill(email);
    }

    public String getEmail() {
        return page.locator(emailInputField).inputValue();
    }

    public boolean isFirstNameInputFieldVisible() {
        return page.locator(nameInputField).isVisible();
    }

    public boolean isFirstNameInputFieldEnabled() {
        return page.locator(nameInputField).isEnabled();
    }

    public boolean isFirstNameInputFieldEmpty() {
        String firstnameInput = page.locator(nameInputField).inputValue();
        return firstnameInput == null || firstnameInput.trim().isEmpty();
    }

    public void setFirstname(String firstname) {
        page.locator(nameInputField).click();
        page.locator(nameInputField).fill(firstname);
    }

    public String getFirstName() {
        return page.locator(nameInputField).inputValue();
    }

    public boolean isSurnameInputFieldVisible() {
        return page.locator(surnameInputField).isVisible();
    }

    public boolean isSurnameInputFieldEnabled() {
        return page.locator(surnameInputField).isEnabled();
    }

    public boolean isSurnameInputFieldEmpty() {
        String surnameInput = page.locator(surnameInputField).inputValue();
        return surnameInput == null || surnameInput.trim().isEmpty();
    }

    public void setSurname(String surname) {
        page.locator(surnameInputField).click();
        page.locator(surnameInputField).fill(surname);
    }

    public String getSurname() {
        return page.locator(surnameInputField).inputValue();
    }

    public boolean isRoleFieldVisible() {
        return page.locator(role).isVisible();
    }

    public boolean isRoleFieldEnabled() {
        return page.locator(role).isEnabled();
    }

    public void openRoleDropDown() {
        page.locator(role).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isRoleDropDownOpen() {
        return page.locator(roleDropDown).isVisible();
    }

    public void selectRole(String roleOption) {
        String role = "//span[normalize-space()='" + roleOption + "']";
        page.locator(role).click();
    }

    public String getSelectedRole() {
        return page.locator(selectedRole).textContent();
    }

    public boolean isSubmitButtonVisible() {
        return page.locator(addUserSubmitButton).isVisible();
    }

    public boolean isSubmitButtonEnabled() {
        return page.locator(addUserSubmitButton).isEnabled();
    }

    public void submitUserData() {
        page.locator(addUserSubmitButton).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isNewUserAdded(int rowNumber) {
        String row = "//body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-users[1]/blastweb-spinner[1]/blastweb-" +
                "zero-data[1]/div[1]/table[1]/tbody[1]/tr[" + rowNumber + "]";
        try {
            page.locator(row).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public String getNewUserName() {
        return page.locator(username).textContent();
    }

    public boolean isEditIconVisible() {
        return page.locator(editIcon).isVisible();
    }

    public void editUserData(int rowNumber) {
        String rowEditIcon = "(//mat-icon[@role='img'][normalize-space()='edit'])[" + rowNumber + "]";
        page.locator(rowEditIcon).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isEditUserFormOpen() {
        return page.locator(editUserLabel).isVisible();
    }

    public String getEditUserLabel() {
        return page.locator(editUserLabel).textContent();
    }

    public boolean isSaveButtonPresent() {
        return page.locator(saveButton).isVisible();
    }

    public boolean isSaveButtonEnabled() {
        return page.locator(saveButton).isEnabled();
    }

    public void saveUpdatedUserInformation() {
        page.locator(saveButton).click();
    }

    public void setNewSurname(String surname) {
        page.locator(editSurnameInputField).click();
        page.locator(editSurnameInputField).clear();
        page.locator(editSurnameInputField).fill(surname);
    }

    public String getUpdatedSurname() {
        String updatedSurname = "//td[normalize-space()='Johnson']";
        return page.locator(updatedSurname).textContent();
    }

    public boolean isDeleteIconVisible(int rowNumber) {
        String row = "(//span[@class='mat-mdc-tooltip-trigger material-symbols-outlined ng-star-inserted'])[" + rowNumber + "]";
        try{
            page.locator(row)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
        }catch (PlaywrightException e){
            return false;
        }
        return page.locator(row).isVisible();
    }

    public void deleteUser(int rowNumber) {
        String row = "(//span[@class='mat-mdc-tooltip-trigger material-symbols-outlined ng-star-inserted'])[" + rowNumber + "]";
        page.locator(row).click();
    }

    public boolean isDeleteDialogBoxOpen() {
        return page.locator(deleteAlertBox).isVisible();
    }

    public boolean isYesButtonPresent() {
        return page.locator(yesButton).isVisible();
    }

    public void confirmToDelete() {
        page.locator(yesButton).click();
    }

    public boolean isUserDeleted(String userName) {
        String user = "(//td[normalize-space()='" + userName + "'])[1]";
        try {
            page.locator(user)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.HIDDEN)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public boolean isDeleteAllCheckboxVisible() {
        return page.locator(deleteAllCheckBox).isVisible();
    }

    public boolean isDeleteAllCheckboxEnabled() {
        return page.locator(deleteAllCheckBox).isEnabled();
    }

    public void selectAllUsers() {
        page.locator(deleteAllCheckBox).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public void selectOrDeselectUsers(String rowNumber) {
        String row = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-users[1]/blastweb-spinner[1]/" +
                "blastweb-zero-data[1]/div[1]/table[1]/tbody[1]/tr[" + rowNumber + "]/td[1]/mat-checkbox[1]/div[1]/div[1]" +
                "/input[1]";
        page.locator(row).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isDeleteUsersButtonVisible() {
        return page.locator(deleteAllBtn).isVisible();
    }

    public boolean isDeleteUsersButtonEnabled(){
        return page.locator(deleteAllBtn).isEnabled();
    }

    public void deleteAllUsers(){
        page.locator(deleteAllBtn).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isPasswordResetIconVisible(){
        return page.locator(passwordResetIcon).isVisible();
    }

    public void requestPasswordReset(String tableRow){
        String passwordResetIcon = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-users[1]/" +
                "blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/table[1]/tbody[1]/tr[" + tableRow + "]/td[6]/mat-icon[2]\n";
        page.locator(passwordResetIcon).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isPasswordResetDialogOpen(){
        try {
            page.locator(passwordResetDialog)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public void confirmToResetPassword(){
        page.locator(yesButton).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isUserSearchBarVisible(){
        return page.locator(searchBar).isVisible();
    }

    public boolean isUserSearchBarEnabled(){
        return page.locator(searchBar).isEnabled();
    }

    public boolean isUserSearchBarEmpty(){
        String searchPath = page.locator(searchBar).inputValue();
        return searchPath == null || searchPath.trim().isEmpty();
    }

    public void searchUser(String userCredentials){
        page.locator(searchBar).click();
        page.locator(searchBar).fill(userCredentials);
    }

    public String getSearchedValue(){
        return page.locator(searchBar).inputValue();
    }

    public void clearSearchBar(){
        page.locator(searchBar).clear();
    }

    public boolean isUserFound(String username){
        String userNamePath = "(//td[normalize-space()='" + username + "'])[1]";
        return page.locator(userNamePath).isVisible();
    }
}