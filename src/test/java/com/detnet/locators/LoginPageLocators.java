package com.detnet.locators;

public class LoginPageLocators {
    public static final String userNameInputField = "//input[@id='loginUsername']";
    public static final String passwordInputField = "//input[@id='loginPassword']";
    public static final String loginButton = "//button[@id='loginButton']";
    public static final String visibilityIcon = "//mat-icon[@role='img']";
    public static final String passwordErrorLabel = "[id^='mat-mdc-error-']";
    public static final String unauthorizedLabel = "//span[normalize-space()='Dismiss']";
}