package com.detnet.pageObjects;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Set;

import static com.detnet.locators.ServerConfigPageLocators.*;

// For Desktop App scenario
public class ServerConfigPageObjectModel {
    private final WindowsDriver<WindowsElement> driver;

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

    private void switchToFileChooserDialog(){
        //        Store the current window handle before the dialog opens
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String handle : allWindows){
            if(!handle.equals(mainWindow)){
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public void searchFile(String fileName){
//        Wait a bit for the file dialog to open
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Switch to the file chooser dialog
       switchToFileChooserDialog();

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className(fileNameInputField)));
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