package com.detnet.stepdefinitions.deviceComms;

import com.detnet.managers.WinAppManager;
import com.detnet.pageObjects.ServerConfigPageObjectModel;
import com.detnet.utilities.LoginConstantUtils;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.serverConfigValidations.ServerConfigValidation;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import io.cucumber.java.en.*;

public class backupFile_StepDefn {
    private final WindowsDriver<WindowsElement> driver;
    private final ServerConfigPageObjectModel serverConfigPageObjectModel;
    private final ServerConfigValidation serverConfigValidation;

    public backupFile_StepDefn() {
        this.driver = WinAppManager.getDriver();
        this.serverConfigPageObjectModel = new ServerConfigPageObjectModel(driver);
        this.serverConfigValidation = new ServerConfigValidation(serverConfigPageObjectModel);
    }

    @Given("the user stops the server and web server if they are running")
    public void the_user_stops_the_server_and_web_server_if_they_are_running() {
        serverConfigValidation.validateStopWebServerButtonVisibility();
        serverConfigPageObjectModel.stopWebServer();
        serverConfigValidation.validateStopWebServerButtonIsDisabledByDefault();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user clicks {string} on the server configuration interface")
    public void the_user_clicks_on_the_server_configuration_interface(String string) {
        serverConfigValidation.validateRestoreFromBackupButtonVisibility();
        serverConfigValidation.validateRestoreFromBackupButtonState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        serverConfigPageObjectModel.restoreFromBackup();
    }
    @When("the user selects the backup file")
    public void the_user_selects_the_backup_file() {
        serverConfigValidation.validateFileNameAndExtension("quickshot",".backup");
        serverConfigPageObjectModel.searchFile("quickshot_202504081318.backup");
        serverConfigValidation.validateFileName("quickshot_202504081318.backup");
        SoftAssertionUtils.getSoftAssertions().assertAll();
        serverConfigPageObjectModel.loadBackupFile();
        serverConfigPageObjectModel.confirmDatabaseRestore();
    }
    @When("the user saves the configuration")
    public void the_user_saves_the_configuration() throws Exception {
        serverConfigPageObjectModel.closeRestoreAlertWindow();
        serverConfigValidation.validateSaveConfigurationButtonVisibility();
        serverConfigValidation.validateSaveConfigurationButtonState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        serverConfigPageObjectModel.saveConfiguration();
        String configPassword = LoginConstantUtils.getDecryptedServerConfigPassword();
        serverConfigValidation.validateIfConfigPasswordInputFieldIsEmpty();
        SoftAssertionUtils.getSoftAssertions().assertAll();

        serverConfigPageObjectModel.setConfigurationPassword(configPassword);
        serverConfigValidation.validateDialogOKButtonVisibility();
        serverConfigValidation.validateDialogOkButtonIsEnabled();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        serverConfigPageObjectModel.confirmPassword();
    }
    @When("the user starts the server")
    public void the_user_starts_the_server() {
        serverConfigValidation.validateIfStartServerButtonIsVisible();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        serverConfigPageObjectModel.startServer();
    }
    @Then("the user starts the web server")
    public void the_user_starts_the_web_server() {
        serverConfigPageObjectModel.startWebServer();
        serverConfigValidation.validateStopWebServerButtonIsEnabledAfterStart();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}