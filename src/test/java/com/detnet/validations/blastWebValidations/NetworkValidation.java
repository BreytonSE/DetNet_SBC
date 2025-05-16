package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.NetworkPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class NetworkValidation {
    private final NetworkPageObjectModel networkPageObjectModel;
    private final SoftAssertions softly;

    public NetworkValidation(NetworkPageObjectModel networkPageObjectModel) {
        this.networkPageObjectModel = networkPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateNetworkLabelVisibility(){
        boolean isVisible = networkPageObjectModel.isNetworksLabelPresent();
        softly.assertThat(isVisible)
                .as("'Networks' -label should be visible")
                .isTrue();
    }

    public void validateNetworkLabelText(String expectedText){
        String actualText = networkPageObjectModel.getNetworkText();
        softly.assertThat(actualText)
                .as("Actual text does not match expected text")
                .isEqualTo(expectedText);
    }

    public void validateIfNetworkIsPresent(){
        boolean isPresent = networkPageObjectModel.isNetworkPresent();
        softly.assertThat(isPresent)
                .as("A network should be present on the network interface.")
                .isTrue();
    }

    public void validateNetworkName(String expectedNetworkName){
        String actualNetworkName = networkPageObjectModel.getNetworkName();
        softly.assertThat(actualNetworkName)
                .as("Actual network name does not match expected network name.")
                .isEqualTo(expectedNetworkName);
    }

    public void validateAddNetworkButtonVisibility(){
        boolean isVisible = networkPageObjectModel.isAddNetworkButtonVisible();
        softly.assertThat(isVisible)
                .as("'Add Network' -button should be visible")
                .isTrue();
    }

    public void validateAddNetworkButtonState(){
        boolean isEnabled = networkPageObjectModel.isAddNetworkButtonEnabled();
        softly.assertThat(isEnabled)
                .as("Add Network button should be enabled by default.")
                .isTrue();
    }

    public void validateResourceNameInputFieldVisibility(){
        boolean isVisible = networkPageObjectModel.isResourceNameFieldVisible();
        softly.assertThat(isVisible)
                .as("Resource name input field should be visible")
                .isTrue();
    }

    public void validateResourceNameInputFieldState(){
        boolean isEnabled = networkPageObjectModel.isResourceNameInputFieldEnabled();
        softly.assertThat(isEnabled)
                .as("Resource name input field should be enabled by default")
                .isTrue();
    }

    public void validateIfResourceNameFieldIsEmpty(){
        boolean isEmpty = networkPageObjectModel.isResourceNameInputFieldEmpty();
        softly.assertThat(isEmpty)
                .as("Resource name input field should be empty")
                .isTrue();
    }

    public void validateEnteredResourceName(String expectedResourceName){
        String actualResourceName = networkPageObjectModel.getResourceName();
        softly.assertThat(actualResourceName)
                .as("Actual resource name does not match expected resource name.")
                .isEqualTo(expectedResourceName);
    }

    public void validateMessageGapFieldVisibility(){
        boolean isVisible = networkPageObjectModel.isMessageGapFieldVisible();
        softly.assertThat(isVisible)
                .as("Message gap input field should be visible.")
                .isTrue();
    }

    public void validateMessageGapFieldState(){
        boolean isEnabled = networkPageObjectModel.isMessageGapFieldEnabled();
        softly.assertThat(isEnabled)
                .as("Message gap input field should be enabled by default.")
                .isTrue();
    }

    public void validateIfMessageGapFieldIsEmpty(){
        boolean isEmpty = networkPageObjectModel.isMessageGapFieldEmpty();
        softly.assertThat(isEmpty)
                .as("'Message Gap' -input field should not be empty by default.")
                .isFalse();
    }

    public void validateEnteredGapMessage(String expectedGapMessage){
        String actualGapMessage = networkPageObjectModel.getMessageGap();
        softly.assertThat(actualGapMessage)
                .as("Actual message gap does not match expected message gap.")
                .isEqualTo(expectedGapMessage);
    }

    public void validateDelayInputFieldVisibility(){
        boolean isVisible = networkPageObjectModel.isDelayFieldVisible();
        softly.assertThat(isVisible)
                .as("Delay input field should be visible.")
                .isTrue();
    }

    public void validateDelayInputFieldState(){
        boolean isEnabled = networkPageObjectModel.isDelayFieldEnabled();
        softly.assertThat(isEnabled)
                .as("Delay input field should be enabled")
                .isTrue();
    }

    public void validateIfDelayInputFieldIsEmpty(){
        boolean isEmpty = networkPageObjectModel.isDelayFieldEmpty();
        softly.assertThat(isEmpty)
                .as("Delay input field should already been filled with a value.")
                .isFalse();
    }

    public void validateEnteredDelayValue(String expectedDelayValue){
        String actualDelayValue = networkPageObjectModel.getDelay();
        softly.assertThat(actualDelayValue)
                .as("Actual delay value does not match expected value.")
                .isEqualTo(expectedDelayValue);
    }

    public void validateBaudRateFieldVisibility(){
        boolean isVisible = networkPageObjectModel.isBaudRateFieldVisible();
        softly.assertThat(isVisible)
                .as("Baud Rate input field should be visible.")
                .isTrue();
    }

    public void validateBaudRateFieldState(){
        boolean isEnabled = networkPageObjectModel.isBaudRateFieldEnabled();
        softly.assertThat(isEnabled)
                .as("Baud Rate input field should be enabled.")
                .isTrue();
    }

    public void validateIfBaudRateFieldIsEmpty(){
        boolean isEmpty = networkPageObjectModel.isBaudRateFieldEmpty();
        softly.assertThat(isEmpty)
                .as("Baud Rate input should contain a pre-set default value.")
                .isFalse();
    }

    public void validateEnteredBaudRate(String expectedBaudRate){
        String actualBaudRate = networkPageObjectModel.getBaudRate();
        softly.assertThat(actualBaudRate)
                .as("Actual baud rate does not match expected baud rate.")
                .isEqualTo(expectedBaudRate);
    }

    public void validateReportDetonatorsCheckBoxVisibility(){
        boolean isVisible = networkPageObjectModel.isReportDetonatorsCheckBoxVisible();
        softly.assertThat(isVisible)
                .as("'Report Detonators' -checkbox and its corresponding label should be visible.")
                .isTrue();
    }

    public void validateReportDetonatorsCheckBoxState(){
        boolean isEnabled = networkPageObjectModel.isReportDetonatorsCheckBoxEnabled();
        softly.assertThat(isEnabled)
                .as("'Report Detonators' -checkbox and its corresponding label should be enabled by default.")
                .isTrue();
    }

    public void validateSaveButtonVisibility(){
        boolean isVisible = networkPageObjectModel.isSaveNewNetworkButtonVisible();
        softly.assertThat(isVisible)
                .as("Save button should be visible on the network 'Add Network' -form")
                .isTrue();
    }

    public void validateSaveButtonState(){
        boolean isEnabled = networkPageObjectModel.isSaveNewNetworkButtonEnabled();
        softly.assertThat(isEnabled)
                .as("Save button should be enabled on the 'Add Network' -form")
                .isTrue();
    }

    public void validateIfNewNetworkIsAdded(){
        boolean isAdded = networkPageObjectModel.isNewNetworkAdded();
        softly.assertThat(isAdded)
                .as("New network should be added on the networks interface")
                .isTrue();
    }

    public void validateEditIconVisibility(){
        boolean isVisible = networkPageObjectModel.isEditIconPresent();
        softly.assertThat(isVisible)
                .as("Edit icon should be visible on the network interface.")
                .isTrue();
    }

    public void validateEditIconState(){
        boolean isEnabled = networkPageObjectModel.isEditIconEnabled();
        softly.assertThat(isEnabled)
                .as("Edit icon should be enabled on the network interface")
                .isTrue();
    }

    public void validateSaveUpdateButtonVisibility(){
        boolean isVisible = networkPageObjectModel.isSaveUpdateButtonVisible();
        softly.assertThat(isVisible)
                .as("'Save' -button should be visible.")
                .isTrue();
    }

    public void validateSaveUpdateButtonState(){
        boolean isEnabled = networkPageObjectModel.isSaveUpdateButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'Save' -button should be enabled.")
                .isTrue();
    }

    public void validateIfMessageGapUpdated(String expectedMessageGap){
        String actualMessageGap = networkPageObjectModel.getUpdatedMessageGap();
        softly.assertThat(actualMessageGap)
                .as("Actual message gap does not match expected message gap")
                .isNotEqualTo(expectedMessageGap);
    }

    public void validateIfDelayUpdated(String expectedDelay){
        String actualDelay = networkPageObjectModel.getUpdatedDelay();
        softly.assertThat(actualDelay)
                .as("Actual delay does not match expected ")
                .isNotEqualTo(expectedDelay);
    }

    public void validateDeleteIconVisibility(){
        boolean isVisible = networkPageObjectModel.isDeleteIconVisible();
        softly.assertThat(isVisible)
                .as("Delete icon should be visible.")
                .isTrue();
    }

    public void validateDeleteIconState(){
        boolean isEnabled = networkPageObjectModel.isDeleteIconEnabled();
        softly.assertThat(isEnabled)
                .as("Delete icon should be enabled")
                .isTrue();
    }

    public void validateDeleteNetworkYesButtonVisibility(){
        boolean isVisible = networkPageObjectModel.isYesButtonVisible();
        softly.assertThat(isVisible)
                .as("'Yes' button should be visible.")
                .isTrue();
    }

    public void validateDeleteNetworkYesButtonState(){
        boolean isEnabled = networkPageObjectModel.isYesButtonEnabled();
        softly.assertThat(isEnabled)
                .as("Yes button on deleter alert should be visible")
                .isTrue();
    }

    public void validateIfNetworkIsDeleted(){
        boolean isDeleted = networkPageObjectModel.isNetworkDeleted();
        softly.assertThat(isDeleted)
                .as("Network should be deleted from the network interface")
                .isTrue();
    }

    public void validateCheckBoxVisibility(){
        boolean isPresent = networkPageObjectModel.isCheckboxVisible();
        softly.assertThat(isPresent)
                .as("Checkbox should be visible on the network page.")
                .isTrue();
    }

    public void validateCheckboxState(){
        boolean isEnabled = networkPageObjectModel.isCheckBoxEnabled();
        softly.assertThat(isEnabled)
                .as("Checkbox should be enabled on the network page.")
                .isTrue();
    }

    public void validateSearchBarVisibility(){
        boolean isVisible = networkPageObjectModel.isSearchBarVisible();
        softly.assertThat(isVisible)
                .as("Search bar should be visible")
                .isTrue();
    }

    public void validateSearchBarState(){
        boolean isEnabled = networkPageObjectModel.isSearchBarEnabled();
        softly.assertThat(isEnabled)
                .as("Search bar should be enabled.")
                .isTrue();
    }

    public void validateIfSearchBarIsEmpty(){
        boolean isEmpty = networkPageObjectModel.isSearchBarEmpty();
        softly.assertThat(isEmpty)
                .as("Search bar should be empty by default")
                .isTrue();
    }

    public void validateIfNetworkIsPresentFromSearch(String id){
        boolean isFound = networkPageObjectModel.isSearchedNetworkAvailable(id);
        softly.assertThat(isFound)
                .as("Network should be showing based on search criteria.")
                .isTrue();
    }

    public void validateDeleteDialogVisibility(){
        boolean isDisplayed = networkPageObjectModel.isDeleteDialogVisible();
        softly.assertThat(isDisplayed)
                .as("Delete dialog box should be visible.")
                .isTrue();
    }

    public void validateDeleteDialogClosed(){
        boolean isClosed = networkPageObjectModel.isDeleteDialogClosedAfterDeletion();
        softly.assertThat(isClosed)
                .as("Delete dialog box should close after user confirm or cancel delete action.")
                .isTrue();
    }

    public void validateDeleteButtonVisibility(){
        boolean isVisible = networkPageObjectModel.isDeleteAllButtonVisible();
        softly.assertThat(isVisible)
                .as("'Delete All Networks' -button should be visible")
                .isTrue();
    }

    public void validateDeleteButtonState(){
        boolean isEnabled = networkPageObjectModel.isDeleteAllButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'Delete All Networks' -button should be enabled")
                .isTrue();
    }

    public void validateIfSelectedNetworksIsDeleted(String networkName){
        boolean isDeleted = networkPageObjectModel.isSelectedNetworksDeleted(networkName);
        softly.assertThat(isDeleted)
                .as("Selected networks should be deleted.")
                .isTrue();
    }
}