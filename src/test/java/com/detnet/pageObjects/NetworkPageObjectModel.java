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
        try{
            return page.locator(networkLabel).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Network label not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public String getNetworkText(){
        try{
            return page.locator(networkLabel).textContent();
        }catch (PlaywrightException e){
            System.out.println("Network label not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public boolean isAddNetworkButtonVisible(){
        try{
            return page.locator(addNetworkButton).isVisible();
        }catch (PlaywrightException e){
            System.out.println("'Add Network' -button not visible or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isAddNetworkButtonEnabled(){
        try{
            return page.locator(addNetworkButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Add Network' -button not visible or not visible: " + e.getMessage());
            return false;
        }
    }

    public void addNetwork(){
        try{
            page.locator(addNetworkButton).click();
        }catch (PlaywrightException e){
            System.out.println("'Add Network' -button not visible or not visible: " + e.getMessage());
        }
    }

    public boolean isNetworkPresent(){
        try{
            return page.locator(network).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Network element not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public String getNetworkName(){
        try{
            return page.locator(networkName).textContent();
        }catch (PlaywrightException e){
            System.out.println("Network name not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public boolean isResourceNameFieldVisible(){
        try{
            return page.locator(resourceNameInputField).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Resource name input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isResourceNameInputFieldEnabled(){
        try{
            return page.locator(resourceNameInputField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Resource name input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isResourceNameInputFieldEmpty(){
        try{
            String inputField = page.locator(resourceNameInputField).inputValue();
            return inputField == null || inputField.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Resource name input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void setResourceName(String resourceName){
        try{
            page.locator(resourceNameInputField).fill(resourceName);
        }catch (PlaywrightException e){
            System.out.println("Resource name input field not visible or not found: " + e.getMessage());
        }
    }

    public String getResourceName(){
        try{
            return page.locator(resourceNameInputField).inputValue();
        }catch (PlaywrightException e){
            System.out.println("Resource name input field not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public boolean isMessageGapFieldVisible(){
        try{
            return page.locator(messageGapInputField).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Message gap input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isMessageGapFieldEnabled(){
        try{
            return page.locator(messageGapInputField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Message gap input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isMessageGapFieldEmpty(){
        try{
            String inputField = page.locator(messageGapInputField).inputValue();
            return inputField == null || inputField.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Message gap input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void setNewMessageGap(String messageGap){
        try{
            page.locator(messageGapInputField).click();
            page.locator(messageGapInputField).clear();
            page.locator(messageGapInputField).fill(messageGap);
        }catch (PlaywrightException e){
            System.out.println("Message gap input field not found or not visible: " + e.getMessage());
        }
    }

    public String getMessageGap(){
        try{
            return page.locator(messageGapInputField).inputValue();
        }catch (PlaywrightException e){
            System.out.println("Message gap input field not found or not visible: ");
            return null;
        }
    }

    public boolean isDelayFieldVisible(){
        try{
            return page.locator(delayInputField).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Delay input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isDelayFieldEnabled(){
        try{
            return page.locator(delayInputField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Delay input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isDelayFieldEmpty(){
        try{
            String inputField = page.locator(delayInputField).inputValue();
            return inputField == null || inputField.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Delay input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void setDelay(String delay){
        try{
            page.locator(delayInputField).click();
            page.locator(delayInputField).clear();
            page.locator(delayInputField).fill(delay);
        }catch (PlaywrightException e){
            System.out.println("Delay input field not found or not visible: " + e.getMessage());
        }
    }

    public String getDelay(){
        try{
            return page.locator(delayInputField).inputValue();
        }catch (PlaywrightException e){
            System.out.println("Delay input field not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public boolean isBaudRateFieldVisible(){
        try{
            return page.locator(baudRateInputField).isVisible();
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isBaudRateFieldEnabled(){
        try{
            return page.locator(baudRateInputField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Baud rate input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isBaudRateFieldEmpty(){
        try{
            String input = page.locator(baudRateInputField).inputValue();
            return input == null || input.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Baud rate input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void setBaudRate(String baudRate){
        try{
            page.locator(baudRateInputField).fill(baudRate);
        }catch (PlaywrightException e){
            System.out.println("Baud rate input field not visible or not found: " + e.getMessage());
        }
    }

    public String getBaudRate(){
        try{
            return page.locator(baudRateInputField).inputValue();
        }catch (PlaywrightException e){
            System.out.println("Baud rate input field not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public boolean isReportDetonatorsCheckBoxVisible(){
        try{
            return page.locator(reportDetonatorsLabel).isVisible();
        }catch (PlaywrightException e){
            System.out.println("'Report Detonators' -label not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isReportDetonatorsCheckBoxEnabled(){
        try{
            return page.locator(reportDetonatorsLabel).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Report Detonators' -label not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void reportDetonators(){
        try{
            page.locator(reportDetonatorsLabel).click();
        }catch (PlaywrightException e){
            System.out.println("'Report Detonators' -label not visible or not found: " + e.getMessage());
        }
    }

    public void inUse(){
        try{
            page.locator(inUseLabel).click();
        }catch (PlaywrightException e){
            System.out.println("In Use label not found or not visible: " + e.getMessage());
        }
    }

    public boolean isSaveNewNetworkButtonVisible(){
        try{
            return page.locator(saveNewNetwork).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Save button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSaveNewNetworkButtonEnabled(){
        try{
            return page.locator(saveNewNetwork).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Save button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void saveNewNetwork(){
        try{
            page.locator(saveNewNetwork).click();
        }catch (PlaywrightException e){
            System.out.println("Save button not found or not visible: " + e.getMessage());
        }
    }

    public boolean isNewNetworkAdded(){
        try{
            page.locator(newNetworkPath).waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setTimeout(5000)); // timeout in milliseconds
            return true;
        }catch (PlaywrightException e){
            System.out.println("Network path not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isEditIconPresent(){
        try{
            return page.locator(editIcon).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Edit icon not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isEditIconEnabled(){
        try{
            return page.locator(editIcon).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Edit icon not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void editNetwork(String index){
        try{
            String rowIndex = "(//mat-icon[@role='img'][normalize-space()='edit'])[" + index + "]";
            page.locator(rowIndex).click();
        }catch (PlaywrightException e){
            System.out.println("Row index element not found or not visible: " + e.getMessage());
        }
    }

    public boolean isSaveUpdateButtonVisible(){
        try{
            return page.locator(saveButton2).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Save button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSaveUpdateButtonEnabled(){
        try{
            return page.locator(saveButton2).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Save button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void updateNetwork(){
        try{
            page.locator(saveButton2).click();
        }catch (PlaywrightException e){
            System.out.println("Save button not visible or not found: " + e.getMessage());
        }
    }

    public String getUpdatedMessageGap(){
        try{
            String updatedMessageGap = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-networks[1]/" +
                    "blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/table[1]/tbody[1]/tr[2]/td[4]";
            return page.locator(updatedMessageGap).textContent();
        }catch (PlaywrightException e){
            System.out.println("Update message not found or not displaying: " + e.getMessage());
            return null;
        }
    }

    public String getUpdatedDelay(){
        try{
            String updatedDelay = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-networks[1]/" +
                    "blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/table[1]/tbody[1]/tr[2]/td[5]";
            return page.locator(updatedDelay).textContent();
        }catch (PlaywrightException e){
            System.out.println("Delay element not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public boolean isDeleteIconVisible(){
        try{
            return page.locator(deleteIcon).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Delete icon not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeleteIconEnabled(){
        try{
            return page.locator(deleteIcon).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Delete icon not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void deleteNetwork(String index){
        try{
            String rowIndex = "//body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-networks[1]/blastweb-spinner[1]/" +
                    "blastweb-zero-data[1]/div[1]/table[1]/tbody[1]/tr[" + index + "]/td[8]/span[1]";
            page.locator(rowIndex).click();
        }catch (PlaywrightException e){
            System.out.println("Row index element not visible or not found: " + e.getMessage());
        }
    }

    public boolean isYesButtonVisible(){
        try{
            return page.locator(yesButton).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Yes button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isYesButtonEnabled(){
        try{
            return page.locator(yesButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Yes button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void confirmToDeleteNetwork(){
        try{
            page.locator(yesButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Yes button not found or not visible: " + e.getMessage());
        }
    }

    public boolean isNetworkDeleted(){
        String network = "//td[normalize-space()=\"ETHER002-DUMMY\"]";
        try{
            page.locator(network)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.HIDDEN)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Network element not visible or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isCheckboxVisible(){
        try{
            return page.locator(selectAllCheckBox).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Select all checkbox not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isCheckBoxEnabled(){
        try{
            return page.locator(selectAllCheckBox).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Select all checkbox not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void deselectNetwork(String rowNumber){
        try{
            String individualCheckBox = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-networks[1]/" +
                    "blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/table[1]/tbody[1]/tr[" + rowNumber + "]/td[1]/" +
                    "mat-checkbox[1]/div[1]/div[1]/input[1]";
            page.locator(individualCheckBox).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Network checkbox not found or not visible: " + e.getMessage());
        }
    }

    public void selectAllNetworks() {
        try{
            page.locator(selectAllCheckBox).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Select All checkbox not found or not visible: " + e.getMessage());
        }
    }

    public boolean isSearchBarVisible(){
        try{
            return page.locator(searchBar).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSearchBarEnabled(){
        try{
            return page.locator(searchBar).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSearchBarEmpty(){
        try{
            String input = page.locator(searchBar).inputValue();
            return input == null || input.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void searchId(String id){
        try{
            page.locator(searchBar).fill(id);
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
        }
    }

    public void openSearchBar(){
        try{
            page.locator(searchBar).click();
        }catch (PlaywrightException e){
            System.out.println("Search bar not visible or not found: " + e.getMessage());
        }
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
            System.out.println("Network Id not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeleteDialogVisible(){
        try{
            return page.locator(deleteDialog).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Delete dialog not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeleteDialogClosedAfterDeletion(){
        try{
            page.locator(deleteDialog)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.DETACHED)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Delete dialog element not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeleteAllButtonVisible(){
        try{
            return page.locator(deleteAllBtn).isVisible();
        }catch (PlaywrightException e){
            System.out.println("'Delete All' -button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeleteAllButtonEnabled(){
        try{
            return page.locator(deleteAllBtn).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Delete All' -button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void deleteAll(){
        try{
            page.locator(deleteAllBtn).click();
        }catch (PlaywrightException e){
            System.out.println("'Delete All' -button not found or not visible: " + e.getMessage());
        }
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
            System.out.println("Network name not found or not visible: " + e.getMessage());
            return false;
        }
    }
}