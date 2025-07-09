package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.detnet.locators.EmailRecipientsPageLocators.*;

public class EmailRecipientsPageObjectModel {
    private final Page page;

    public EmailRecipientsPageObjectModel(Page page) {
        this.page = page;
    }

    public String getEmailRecipientPageURL() {
        page.waitForURL("**/settings/emailRecipient");
        return page.url();
    }

    public boolean isRecipientListHeadingVisible() {
        try {
            page.locator(recipientListHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public String getHeadingText() {
        return page.locator(recipientListHeading).textContent();
    }

    public boolean isRecipientListEmpty() {
        try {
            page.locator(noRecipientsText)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public boolean isAddRecipientButtonVisible() {
        try {
            page.locator(addRecipientBtn)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public boolean isAddRecipientButtonEnabled() {
        return page.locator(addRecipientBtn).isEnabled();
    }

    public void createEmailRecipient() {
        page.locator(addRecipientBtn).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isAddRecipientFormVisible() {
        try {
            page.locator(addRecipientHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public boolean isEmailAddressFieldVisible() {
        try {
            page.locator(emailAddressField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public boolean isEmailAddressFieldEnabled() {
        return page.locator(emailAddressField).isEnabled();
    }

    public boolean isEmailAddressFieldEmpty() {
        String emailAddressInputField = page.locator(emailAddressField).inputValue();
        return emailAddressInputField == null || emailAddressInputField.trim().isEmpty();
    }

    public void setEmailAddress(String emailAddress) {
        page.locator(emailAddressField).click();
        page.locator(emailAddressField).fill(emailAddress);
    }

    public String getEmailAddress() {
        return page.locator(emailAddressField).inputValue();
    }

    public boolean isFirstNameFieldVisible() {
        try {
            page.locator(firstNameField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public boolean isFirstNameFieldEnabled() {
        return page.locator(firstNameField).isEnabled();
    }

    public boolean isFirstNameFieldEmpty() {
        String firstNameInputField = page.locator(firstNameField).inputValue();
        return firstNameInputField == null || firstNameInputField.trim().isEmpty();
    }

    public void setFirstName(String firstName) {
        page.locator(firstNameField).click();
        page.locator(firstNameField).fill(firstName);
    }

    public String getFirstName() {
        return page.locator(firstNameField).inputValue();
    }

    public boolean isLastnameFieldVisible() {
        try {
            page.locator(lastNameField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public boolean isLastNameFieldEnabled() {
        return page.locator(lastNameField).isEnabled();
    }

    public boolean isLastNameFieldEmpty() {
        String lastNameInputField = page.locator(lastNameField).inputValue();
        return lastNameInputField == null || lastNameInputField.trim().isEmpty();
    }

    public void setLastName(String lastName) {
        page.locator(lastNameField).click();
        page.locator(lastNameField).fill(lastName);
    }

    public String getLastName() {
        return page.locator(lastNameField).inputValue();
    }

    public boolean isSeverityLevelsVisible() {
        try {
            page.locator(severityLevel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public void selectSeverityLevel(String severity){
        String severityLvl = "(//label[normalize-space()='" + severity + "'])[1]";
        page.locator(severityLvl).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public String getSelectedSeverity(){
        return page.locator(moderateSeverityElement).textContent();
    }

    public boolean isSaveRecipientButtonVisible(){
        try{
            page.locator(addRecipientButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isSaveRecipientButtonEnabled(){
        return page.locator(addRecipientButton).isEnabled();
    }

    public void saveNewRecipient(){
        page.locator(addRecipientButton).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isRecipientAdded(String recipientUserName){
        String recipient = "(//td[normalize-space()='" + recipientUserName + "'])[1]";
        try {
            page.locator(recipient)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isEditIconVisible(){
        try{
            page.locator(editIcon)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isEditIconEnabled(){
        return page.locator(editIcon).isEnabled();
    }

    public void openEditRecipientPage(int row){
        String editIcon = "(//mat-icon[@role='img'][normalize-space()='edit'])[" + row + "]";
        page.locator(editIcon).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isEditRecipientPageOpen(){
        try{
            page.locator(editRecipientHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isEditSubmitButtonVisible(){
        try{
            page.locator(editRecipientSubmitBtn)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isEditSubmitButtonEnabled(){
        return page.locator(editRecipientSubmitBtn).isEnabled();
    }

    public void updateRecipientDetails(){
        page.locator(editRecipientSubmitBtn).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isModerateSeverityLevelSelected(int row){
        String tableRow = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/app-email-recipient[1]/blastweb-spinner" +
                "[1]/blastweb-zero-data[1]/div[1]/table[1]/tbody[1]/tr[" + row + "]/td[5]/div[1]/mat-checkbox[2]/div[1]/div[1]/input[1]";
        return page.locator(tableRow).isChecked();
    }

    public boolean isSearchBarVisible(){
        try{
            page.locator(searchBar)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isSearchBarEnabled(){
        return page.locator(searchBar).isEnabled();
    }

    public boolean isSearchBarEmpty(){
        String searchInput = page.locator(searchBar).inputValue();
        return searchInput == null || searchInput.trim().isEmpty();
    }

    public void search(String recipient){
        page.locator(searchBar).click(new Locator.ClickOptions().setTimeout(5000));
        page.locator(searchBar).clear();
        page.locator(searchBar).fill(recipient);
    }

    public boolean isIntervalDropdownVisible(){
        try{
            page.locator(intervalDropDown)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isIntervalDropDownEnabled(){
        return page.locator(intervalDropDown).isEnabled();
    }

    public boolean isIntervalDropDownPanelOpen(){
        try{
            page.locator(intervalDropDownPanel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public void openIntervalPanel(){
        page.locator(intervalDropDown).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public void selectInterval(String interval){
        String intervalElement = "(//span[contains(text(),'" + interval + "')])[1]";
        page.locator(intervalElement).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isDeleteIconVisible(int rowNumber){
        String row = "(//span[@class='mat-mdc-tooltip-trigger material-symbols-outlined'][normalize-space()='delete'])[" + rowNumber + "]";
        try{
            page.locator(row)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public void deleteRecipient(int rowNumber){
        String row = "(//span[@class='mat-mdc-tooltip-trigger material-symbols-outlined'][normalize-space()='delete'])[" + rowNumber + "]";
        page.locator(row).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isDeleteDialogVisible(){
        try{
            page.locator(deleteDialog)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public void confirmToDeleteRecipient(){
        page.locator(yesButton).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isRecipientDeleted(String recipientEmail){
        String recipient = "(//td[normalize-space()='" + recipientEmail + "'])[1]";
        try{
            page.locator(recipient)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.HIDDEN)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isCheckboxVisible(){
        try{
            page.locator(checkBox)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isCheckBoxEnabled(){
        return page.locator(checkBox).isEnabled();
    }

    public void selectAllRecipients(){
        page.locator(checkBox).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public void selectOrDeselectRecipients(int row){
        String rowPath = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/app-email-recipient[1]/" +
                "blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/table[1]/tbody[1]/tr[" + row + "]/td[1]/mat-checkbox[1]" +
                "/div[1]/div[1]/input[1]";
        page.locator(rowPath).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isDeleteAllRecipientsButtonVisible(){
        try{
            page.locator(deleteAllButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isDeleteAllRecipientsButtonEnabled(){
        return page.locator(deleteAllButton).isEnabled();
    }

    public void deleteAllRecipients(){
        page.locator(deleteAllButton).click(new Locator.ClickOptions().setTimeout(5000));
    }
}