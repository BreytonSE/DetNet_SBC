package com.detnet.locators;

public class BlastConfirmationPageLocators {
    public static final String confirmBlastHeading = "//h2[normalize-space()=\"Confirm Blast\"]";
    public static final String proceedButton = "//button[@class=\"mdc-button mdc-button--raised mat-mdc-raised-button mat-positive mat-mdc-button-base\"]//span[@class=\"mat-mdc-button-touch-target\"]";
    public static final String dialogTitle = "//h1[normalize-space()=\"Confirm Blast\"]";
    public static final String passwordPromptWindow = "//div[@class=\"mat-mdc-dialog-surface mdc-dialog__surface\"]";
    public static final String passwordInputField = "xpath=/html[1]/body[1]/div[2]/div[2]/div[1]/mat-dialog-container[1]/div[1]/div[1]/blastweb-password-confirmation-dialog[1]/div[1]/form[1]/mat-form-field[1]/div[1]/div[2]/div[1]/input[2]";
    public static final String continueButton = "//button[@class=\"confirmBtn\"]";
    public static final String superVisorCredentialsPromptWindow = "//h2[normalize-space()=\"Supervisor details are required to continue\"]";
    public static final String supervisorUsernameInputField = "xpath=/html[1]/body[1]/div[2]/div[2]/div[1]/mat-dialog-container[1]/div[1]/div[1]/blastweb-password-confirmation-dialog[1]/div[1]/form[1]/mat-form-field[1]/div[1]/div[2]/div[1]/input[1]";
    public static final String supervisorPasswordInputField = "xpath=/html[1]/body[1]/div[2]/div[2]/div[1]/mat-dialog-container[1]/div[1]/div[1]/blastweb-password-confirmation-dialog[1]/div[1]/form[1]/mat-form-field[2]/div[1]/div[2]/div[1]/input[2]";
    public static final String startBlastButton = "//button[@class=\"confirmBtn\"]";
}