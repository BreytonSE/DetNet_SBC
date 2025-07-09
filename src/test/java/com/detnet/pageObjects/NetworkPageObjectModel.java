package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.detnet.locators.NetworkPageLocators.*;

public class NetworkPageObjectModel {
    private final Page page;

    public NetworkPageObjectModel(Page page) {
        this.page = page;
    }

    public boolean isNetworksLabelPresent(){
        return page.locator(networkLabel).isVisible();
    }

    public String getNetworkText(){
        return page.locator(networkLabel).textContent();
    }

    public boolean isAddNetworkButtonVisible(){
        return page.locator(addNetworkButton).isVisible();
    }

    public boolean isAddNetworkButtonEnabled(){
        return page.locator(addNetworkButton).isEnabled();
    }

    public void addNetwork(){
        page.locator(addNetworkButton).click();
    }

    public boolean isNetworkPresent(){
        return page.locator(network).isVisible();
    }

    public String getNetworkName(){
        return page.locator(networkName).textContent();
    }

    public boolean isResourceNameFieldVisible(){
        return page.locator(resourceNameInputField).isVisible();
    }

    public boolean isResourceNameInputFieldEnabled(){
        return page.locator(resourceNameInputField).isEnabled();
    }

    public boolean isResourceNameInputFieldEmpty(){
        String inputField = page.locator(resourceNameInputField).inputValue();
        return inputField == null || inputField.trim().isEmpty();
    }

    public void setResourceName(String resourceName){
        page.locator(resourceNameInputField).fill(resourceName);
    }

    public String getResourceName(){
        return page.locator(resourceNameInputField).inputValue();
    }

    public boolean isMessageGapFieldVisible(){
        return page.locator(messageGapInputField).isVisible();
    }

    public boolean isMessageGapFieldEnabled(){
        return page.locator(messageGapInputField).isEnabled();
    }

    public boolean isMessageGapFieldEmpty(){
        String inputField = page.locator(messageGapInputField).inputValue();
        return inputField == null || inputField.trim().isEmpty();
    }

    public void setNewMessageGap(String messageGap){
        page.locator(messageGapInputField).click();
        page.locator(messageGapInputField).clear();
        page.locator(messageGapInputField).fill(messageGap);
    }

    public String getMessageGap(){
        return page.locator(messageGapInputField).inputValue();
    }

    public boolean isDelayFieldVisible(){
        return page.locator(delayInputField).isVisible();
    }

    public boolean isDelayFieldEnabled(){
        return page.locator(delayInputField).isEnabled();
    }

    public boolean isDelayFieldEmpty(){
        String inputField = page.locator(delayInputField).inputValue();
        return inputField == null || inputField.trim().isEmpty();
    }

    public void setDelay(String delay){
        page.locator(delayInputField).click();
        page.locator(delayInputField).clear();
        page.locator(delayInputField).fill(delay);
    }

    public String getDelay(){
        return page.locator(delayInputField).inputValue();
    }

    public boolean isBaudRateFieldVisible(){
        return page.locator(baudRateInputField).isVisible();
    }

    public boolean isBaudRateFieldEnabled(){
        return page.locator(baudRateInputField).isEnabled();
    }

    public boolean isBaudRateFieldEmpty(){
        String input = page.locator(baudRateInputField).inputValue();
        return input == null || input.trim().isEmpty();
    }

    public void setBaudRate(String baudRate){
        page.locator(baudRateInputField).fill(baudRate);
    }

    public String getBaudRate(){
        return page.locator(baudRateInputField).inputValue();
    }

    public boolean isReportDetonatorsCheckBoxVisible(){
        return page.locator(reportDetonatorsLabel).isVisible();
    }

    public boolean isReportDetonatorsCheckBoxEnabled(){
        return page.locator(reportDetonatorsLabel).isEnabled();
    }

    public void reportDetonators(){
        page.locator(reportDetonatorsLabel).click();
    }

    public void inUse(){
        page.locator(inUseLabel).click();
    }

    public boolean isSaveNewNetworkButtonVisible(){
        return page.locator(saveNewNetwork).isVisible();
    }

    public boolean isSaveNewNetworkButtonEnabled(){
        return page.locator(saveNewNetwork).isEnabled();
    }

    public void saveNewNetwork(){
        page.locator(saveNewNetwork).click();
    }

    public boolean isNewNetworkAdded(){
        try{
            page.locator(newNetworkPath).waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setTimeout(5000)); // timeout in milliseconds
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isEditIconPresent(){
        return page.locator(editIcon).isVisible();
    }

    public boolean isEditIconEnabled(){
        return page.locator(editIcon).isEnabled();
    }

    public void editNetwork(String index){
        String rowIndex = "(//mat-icon[@role='img'][normalize-space()='edit'])[" + index + "]";
        page.locator(rowIndex).click();
    }

    public boolean isSaveUpdateButtonVisible(){
        return page.locator(saveButton2).isVisible();
    }

    public boolean isSaveUpdateButtonEnabled(){
        return page.locator(saveButton2).isEnabled();
    }

    public void updateNetwork(){
        page.locator(saveButton2).click();
    }

    public String getUpdatedMessageGap(){
        String updatedMessageGap = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-networks[1]/" +
                "blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/table[1]/tbody[1]/tr[2]/td[4]";
        return page.locator(updatedMessageGap).textContent();
    }

    public String getUpdatedDelay(){
        String updatedDelay = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-networks[1]/" +
                "blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/table[1]/tbody[1]/tr[2]/td[5]";
        return page.locator(updatedDelay).textContent();
    }

    public boolean isDeleteIconVisible(){
        return page.locator(deleteIcon).isVisible();
    }

    public boolean isDeleteIconEnabled(){
        return page.locator(deleteIcon).isEnabled();
    }

    public void deleteNetwork(String index){
        String rowIndex = "//body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-networks[1]/blastweb-spinner[1]/" +
                "blastweb-zero-data[1]/div[1]/table[1]/tbody[1]/tr[" + index + "]/td[8]/span[1]";
        page.locator(rowIndex).click();
    }

    public boolean isYesButtonVisible(){
        return page.locator(yesButton).isVisible();
    }

    public boolean isYesButtonEnabled(){
        return page.locator(yesButton).isEnabled();
    }

    public void confirmToDeleteNetwork(){
        page.locator(yesButton).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isNetworkDeleted(){
        String network = "//td[normalize-space()=\"ETHER002-DUMMY\"]";
        try{
//            Wait for row to be deleted from the networks table
            page.locator(network)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.HIDDEN)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isCheckboxVisible(){
        return page.locator(selectAllCheckBox).isVisible();
    }

    public boolean isCheckBoxEnabled(){
        return page.locator(selectAllCheckBox).isEnabled();
    }

    public void deselectNetwork(String rowNumber){
        String individualCheckBox = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-networks[1]/" +
                "blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/table[1]/tbody[1]/tr[" + rowNumber + "]/td[1]/" +
                "mat-checkbox[1]/div[1]/div[1]/input[1]";
        page.locator(individualCheckBox).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public void selectAllNetworks() {
        page.locator(selectAllCheckBox).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isSearchBarVisible(){
        return page.locator(searchBar).isVisible();
    }

    public boolean isSearchBarEnabled(){
        return page.locator(searchBar).isEnabled();
    }

    public boolean isSearchBarEmpty(){
        String input = page.locator(searchBar).inputValue();
        return input == null || input.trim().isEmpty();
    }

    public void searchId(String id){
        page.locator(searchBar).fill(id);
    }

    public void openSearchBar(){
        page.locator(searchBar).click();
    }

    public boolean isSearchedNetworkAvailable(String id){
        String network = "//td[normalize-space()=" + id + "]";
        try{
            page.locator(network)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isDeleteDialogVisible(){
        return page.locator(deleteDialog).isVisible();
    }

    public boolean isDeleteDialogClosedAfterDeletion(){
        try{
//            Wait for the dialog to be detached from the DOM
            page.locator(deleteDialog)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.DETACHED)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isDeleteAllButtonVisible(){
        return page.locator(deleteAllBtn).isVisible();
    }

    public boolean isDeleteAllButtonEnabled(){
        return page.locator(deleteAllBtn).isEnabled();
    }

    public void deleteAll(){
        page.locator(deleteAllBtn).click();
    }

    public boolean isSelectedNetworksDeleted(String networkName){
        String row = "(//td[normalize-space()='" + networkName + "'])[1]";
        try{
            page.locator(row)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.HIDDEN)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }
}