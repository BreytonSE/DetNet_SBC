package com.detnet.locators;

public class PasswordResetPageLocators {
    public static final String passwordResetForm = "//mat-card[@class=\"mat-mdc-card mdc-card\"]";
    public static final String currentPasswordField = "xpath=/html[1]/body[1]/app-root[1]/password-reset[1]/div[1]/div[1]/mat-card[1]/mat-card-content[1]/div[1]/form[1]/mat-form-field[1]/div[1]/div[2]/div[1]/input[1]";
    public static final String newPasswordField = "xpath=/html[1]/body[1]/app-root[1]/password-reset[1]/div[1]/div[1]/mat-card[1]/mat-card-content[1]/div[1]/form[1]/mat-form-field[2]/div[1]/div[2]/div[1]/input[1]";
    public static final String confirmedPasswordField = "xpath=/html[1]/body[1]/app-root[1]/password-reset[1]/div[1]/div[1]/mat-card[1]/mat-card-content[1]/div[1]/form[1]/mat-form-field[3]/div[1]/div[2]/div[1]/input[1]";
    public static final String changePasswordButton = "//span[@class=\"mat-mdc-button-touch-target\"]";
    public static final String currentPasswordVisibilityIcon = "xpath=/html[1]/body[1]/app-root[1]/password-reset[1]/div[1]/div[1]/mat-card[1]/mat-card-content[1]/div[1]/form[1]/mat-form-field[1]/div[1]/div[2]/div[2]/mat-icon[1]\n";
    public static final String newPasswordVisibilityIcon = "xpath=/html[1]/body[1]/app-root[1]/password-reset[1]/div[1]/div[1]/mat-card[1]/mat-card-content[1]/div[1]/form[1]/mat-form-field[2]/div[1]/div[2]/div[2]/mat-icon[1]\n";
    public static final String confirmedPasswordVisibilityIcon = "xpath=/html[1]/body[1]/app-root[1]/password-reset[1]/div[1]/div[1]/mat-card[1]/mat-card-content[1]/div[1]/form[1]/mat-form-field[3]/div[1]/div[2]/div[2]/mat-icon[1]\n";
    public static final String passwordResetUpdateMessage = "//div[@class='mat-mdc-snack-bar-label mdc-snackbar__label']";
}