package com.detnet.locators;

public class UsersPageLocators {
    public static final String usersLabel = "//h2[normalize-space()='Users']";
    public static final String user = "//tr[@class='mat-mdc-row mdc-data-table__row cdk-row ng-star-inserted']";
    public static final String addButton = "//button[@class='addBtn ng-star-inserted']";
    public static final String addUserLabel = "//h2[normalize-space()='Add User']";
    public static final String userNameInputField = "//input[@id='addUserUsername']";
    public static final String emailInputField = "//input[@id='addUserEmail']";
    public static final String nameInputField = "//input[@id='addUserFirstName']";
    public static final String surnameInputField = "//input[@id='addUserSurname']";
    public static final String role = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/app-add-user[1]/div[1]/div[1]/div[1]/form[1]/mat-form-field[5]/div[1]/div[2]/div[1]/mat-select[1]/div[1]/div[1]/span[1]";
    public static final String roleDropDown = "//div[@id='addUserRole-panel']";
    public static final String selectedRole = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/app-add-user[1]/div[1]/div[1]/div[1]/form[1]/mat-form-field[5]/div[1]/div[2]/div[1]/mat-select[1]/div[1]/div[1]/span[1]/span[1]";
    public static final String addUserSubmitButton = "//button[@id='addUserSubmitButton']";
    public static final String username = "//td[normalize-space()='JohnD']";
    public static final String editIcon = "//tbody/tr[1]/td[6]/mat-icon[1]";
    public static final String editUserLabel = "//h2[normalize-space()='Edit User']";
    public static final String saveButton = "//button[@type='submit']//span[@class='mat-mdc-button-persistent-ripple mdc-button__ripple']";
    public static final String editSurnameInputField = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/app-edit-user[1]/div[1]/div[1]/div[1]/form[1]/mat-form-field[4]/div[1]/div[2]/div[1]/input[1]";
    public static final String deleteAlertBox = "//div[@class='mat-mdc-dialog-surface mdc-dialog__surface']";
    public static final String yesButton = "//button[@class='yesBtn']";
    public static final String deleteAllCheckBox = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-users[1]/blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/table[1]/thead[1]/tr[1]/th[1]/mat-checkbox[1]/div[1]/div[1]/input[1]";
    public static final String deleteAllBtn = "//button[@class=\"deleteAllBtn\"]";
    public static final String passwordResetIcon = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-users[1]/blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/mat-icon[2]";
    public static final String passwordResetDialog = "//div[@class=\"mat-mdc-dialog-surface mdc-dialog__surface\"]";
    public static final String searchBar = "//input[@placeholder=\"Search using Username, First name, Surname\"]";
}