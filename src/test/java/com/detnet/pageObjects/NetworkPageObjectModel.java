package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

public class NetworkPageObjectModel {
    private final Page page;
    private final String addNetworkButton = "//button[@class='addBtn ng-star-inserted']//span[contains(text(),'Add Network')]";
    private final String network = "//tr[@class='mat-mdc-row mdc-data-table__row cdk-row ng-star-inserted']";
    private final String networkLabel = "//h2[normalize-space()='Networks']";
    private final String networkName = "//td[normalize-space()='ETHER001-DUMMY']";
    private final String resourceNameInputField = "//input[@id='addNetworkResourceName']";
    private final String messageGapInputField = "//input[@id='networkMessageGap']";
    private final String delayInputField = "//input[@id='networkDelay']";
    private final String baudRateInputField = "//input[@id='baudRate']";
    private final String reportDetonatorsLabel = "//label[normalize-space()='Report Detonators']";
    private final String inUseLabel = "//label[normalize-space()='In Use']";
    private final String saveNewNetwork = "//button[@id='addNetworkSubmitButton']//span[@class='mat-mdc-button-touch-target']";
    private final String newNetworkPath = "//td[normalize-space()=\"146\"]";
    private final String editIcon = "tbody tr:nth-child(2) td:nth-child(8) mat-icon:nth-child(1)";
    private final String saveButton2 = "//button[@type='submit']//span[@class='mat-mdc-button-persistent-ripple mdc-button__ripple']";
    private final String deleteIcon = "//tbody/tr[1]/td[8]/span[1]";
    private final String yesButton = "//button[@class='yesBtn']";
    private final String selectAllCheckBox = "mat-mdc-checkbox-1";
    private final String searchBar = "//input[@placeholder=\"Search using ID, Name\"]";

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
        String rowIndex = "(//span[@class='mat-mdc-tooltip-trigger material-symbols-outlined'][normalize-space()='delete'])[" + index + "]";
        page.locator(rowIndex).click();
    }

    public boolean isYesButtonVisible(){
        return page.locator(yesButton).isVisible();
    }

    public boolean isYesButtonEnabled(){
        return page.locator(yesButton).isEnabled();
    }

    public void confirmToDeleteNetwork(){
        page.locator(yesButton).click();
    }

    public boolean isNetworkDeleted(){
        try{
            page.locator(newNetworkPath).waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.HIDDEN)
                    .setTimeout(5000)); // timeout in milliseconds
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

    public void selectNetwork(String rowNumber){
        String row = "mat-mdc-checkbox-" + rowNumber;
        page.locator(row).click();
    }

    public void selectAllNetworks(){
        page.locator(selectAllCheckBox).click();
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
        return page.locator(network).isVisible();
    }
}