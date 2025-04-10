package com.detnet.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

import java.io.File;

// For Desktop App scenario
public class ServerConfigPageObjectModel {
    private final WindowsDriver<WindowsElement> driver;

    private final String webServerStopButton = "NetConfig.stopWeb";
    private final String restoreFromBackupButton = "NetConfig.restore_";
    private final String openButton = "Open";
    private final String yesButton = "Yes";
    private final String saveConfigurationButton = "NetConfig.saveConfigButton";
    private final String fileNameInputField = "Edit";
    private final String okayButton = "OK";
    private final String startServerButton = "Start Server";
    private final String webServerStartButton = "Start Web Server";
    private final String configPasswordInputField = "NetConfig.passwordDlg.lineEdit";
    private final String passwordDialogOKButton = "NetConfig.passwordDlg.okButton";

    public ServerConfigPageObjectModel(WindowsDriver<WindowsElement> driver) {
        this.driver = driver;
    }

    public boolean isStopWebServerButtonVisible(){
        return driver.findElementByAccessibilityId(webServerStopButton).isDisplayed();
    }

    public boolean isStopWebServerButtonDisabled(){
        return !driver.findElementByAccessibilityId(webServerStopButton).isEnabled();
    }

    public boolean isStopWebServerButtonEnabled(){
        return driver.findElementByAccessibilityId(webServerStopButton).isEnabled();
    }

    public void stopWebServer(){
        driver.findElementByAccessibilityId(webServerStopButton).click();
    }

    public boolean isRestoreFromBackupButtonVisible(){
        return driver.findElementByAccessibilityId(restoreFromBackupButton).isDisplayed();
    }

    public boolean isRestoreFromBackupButtonEnabled(){
        return driver.findElementByAccessibilityId(restoreFromBackupButton).isEnabled();
    }

    public void restoreFromBackup(){
        driver.findElementByAccessibilityId(restoreFromBackupButton).click();
    }

    public boolean isBackupFilePresent(String fileName, String fileExtension){
        File databaseBackupFolderPath = new File("C:\\database_backup");

        if(!databaseBackupFolderPath.exists() || !databaseBackupFolderPath.isDirectory()){
            return false;
        }
        File[] matchingFiles = databaseBackupFolderPath.listFiles(file ->
                file.isFile() &&
                file.getName().toLowerCase().contains(fileName.toLowerCase()) &&
                file.getName().toLowerCase().contains(fileExtension.toLowerCase())
        );
        return matchingFiles != null && matchingFiles.length > 0;
    }

    public void searchFile(String fileName){
        driver.findElementByClassName(fileNameInputField).sendKeys(fileName);
    }

    public String getFileName(){
        return driver.findElementByClassName(fileNameInputField).getText();
    }

    public void closeRestoreAlertWindow(){
        driver.findElementByName(okayButton).click();
    }

    public void loadBackupFile(){
        driver.findElementByName(openButton).click();
    }

    public void confirmDatabaseRestore(){
        driver.findElementByName(yesButton).click();
    }

    public boolean isSaveConfigurationButtonVisible(){
        return driver.findElementByAccessibilityId(saveConfigurationButton).isDisplayed();
    }

    public boolean isSaveConfigurationButtonEnabled(){
        return driver.findElementByAccessibilityId(saveConfigurationButton).isEnabled();
    }

    public void saveConfiguration(){
        driver.findElementByAccessibilityId(saveConfigurationButton).click();
    }

    public void startServer(){
        driver.findElementByName(startServerButton).click();
    }

    public void startWebServer(){
        driver.findElementByName(webServerStartButton).click();
    }

    public boolean isConfigurationPasswordFieldEmpty(){
        String value = driver.findElementByAccessibilityId(configPasswordInputField).getText();
        return value == null || value.trim().isEmpty();
    }

    public void setConfigurationPassword(String password){
        driver.findElementByAccessibilityId(configPasswordInputField).sendKeys(password);
    }

    public void confirmPassword(){
        driver.findElementByAccessibilityId(passwordDialogOKButton).click();
    }

    public boolean isDialogOKButtonVisible(){
        return driver.findElementByAccessibilityId(passwordDialogOKButton).isDisplayed();
    }

    public boolean isDialogOKButtonEnabled(){
        return driver.findElementByAccessibilityId(passwordDialogOKButton).isEnabled();
    }

    public boolean isStartServerButtonVisible(){
        return driver.findElementByName(startServerButton).isDisplayed();
    }

    public boolean isStartServerButtonEnabledByDefault(){
        return driver.findElementByName(startServerButton).isEnabled();
    }
}