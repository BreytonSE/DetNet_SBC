package com.detnet.validations.serverConfigValidations;

import com.detnet.pageObjects.ServerConfigPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class ServerConfigValidation {
    private final ServerConfigPageObjectModel serverConfigPageObjectModel;
    private final SoftAssertions softly;

    public ServerConfigValidation(ServerConfigPageObjectModel serverConfigPageObjectModel) {
        this.serverConfigPageObjectModel = serverConfigPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

//    Verify that 'Stop WebServer' -button is present on the Server Config GUI
    public void validateStopWebServerButtonVisibility(){
        boolean isVisible = serverConfigPageObjectModel.isStopWebServerButtonVisible();
        softly.assertThat(isVisible)
                .as("'Stop Web Server' -button should be visible on the Server Config GUI")
                .isTrue();
    }

//    Verify that the 'Stop WebServer' -button is disabled if the service is not running
    public void validateStopWebServerButtonIsDisabledByDefault(){
        boolean isDisabled = serverConfigPageObjectModel.isStopWebServerButtonDisabled();
        softly.assertThat(isDisabled)
                .as("'Stop Web Server' -button should be disabled on the Server Config GUI if service is not running")
                .isTrue();
    }

//    Verify that the 'Stop WebServer' -button is enabled after the service is running
    public void validateStopWebServerButtonIsEnabledAfterStart(){
        boolean isEnabled = serverConfigPageObjectModel.isStopWebServerButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'Stop Web Server' -button should be enabled on the Server Config GUI if service is running")
                .isTrue();
    }

//    Verify that the 'Restore from backup' -button is visible
    public void validateRestoreFromBackupButtonVisibility(){
        boolean isVisible = serverConfigPageObjectModel.isRestoreFromBackupButtonVisible();
        softly.assertThat(isVisible)
                .as("'Restore from backup' -button should be visible on the Server Config GUI.")
                .isTrue();
    }

//    Verify that the 'Restore from backup' -button is enabled
    public void validateRestoreFromBackupButtonState(){
        boolean isEnabled = serverConfigPageObjectModel.isRestoreFromBackupButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'Restore from backup' -button should be enabled on the Server Config GUI.")
                .isTrue();
    }

//    Verify the actual file name match expected file name
    public void validateFileName(String expectedFileName){
        String actualFileName = serverConfigPageObjectModel.getFileName();
        softly.assertThat(actualFileName)
                .as("Actual file name does not match expected file name")
                .isEqualTo(expectedFileName);
    }

//    Verify that the 'Save Configuration' -button is visible
    public void validateSaveConfigurationButtonVisibility(){
        boolean isVisible = serverConfigPageObjectModel.isSaveConfigurationButtonVisible();
        softly.assertThat(isVisible)
                .as("'Save Configuration' button should be visible on the Server Config GUI")
                .isTrue();
    }

//    Verify that the 'Save Configuration' -button is enabled
    public void validateSaveConfigurationButtonState(){
        boolean isEnabled = serverConfigPageObjectModel.isSaveConfigurationButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'Save Configuration' button should be visible on the Server Config GUI")
                .isTrue();
    }

//    Verify that the password configuration input field is empty by default
    public void validateIfConfigPasswordInputFieldIsEmpty(){
        boolean isEmpty = serverConfigPageObjectModel.isConfigurationPasswordFieldEmpty();
        softly.assertThat(isEmpty)
                .as("Configuration password input field should be empty by default.")
                .isTrue();
    }

//    Verify that the OK button is visible on the dialog box
    public void validateDialogOKButtonVisibility(){
        boolean isVisible = serverConfigPageObjectModel.isDialogOKButtonVisible();
        softly.assertThat(isVisible)
                .as("'OK' -button on dialog box should be visible.")
                .isTrue();
    }

//    Verify that the OK button is enabled on the dialog box
    public void validateDialogOkButtonIsEnabled(){
        boolean isEnabled = serverConfigPageObjectModel.isDialogOKButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'OK' -button on dialog box should be enabled.")
                .isTrue();
    }

//    Verify that the 'Start Server' button is visible
    public void validateIfStartServerButtonIsVisible(){
        boolean isVisible = serverConfigPageObjectModel.isStartServerButtonVisible();
        softly.assertThat(isVisible)
                .as("'Start Server' -button should be visible on the Server Config GUI.")
                .isTrue();
    }

//    Verify that the 'Start Server' button is enabled
    public void validateIfStartServerButtonIsEnabled(){
        boolean isEnabled = serverConfigPageObjectModel.isStartServerButtonEnabledByDefault();
        softly.assertThat(isEnabled)
                .as("'Start Server' -button should be enabled on the Server Config GUI.")
                .isTrue();
    }

    public void validateFileNameAndExtension(String expectedFileName, String expectedExtension){
        boolean actualFileNameAndFormatMatch = serverConfigPageObjectModel.isBackupFilePresent(expectedFileName,expectedExtension);
        softly.assertThat(actualFileNameAndFormatMatch)
                .as("There should be a backup file that contains '%s' and ends with '%s'",expectedFileName,expectedExtension)
                .isTrue();
    }
}