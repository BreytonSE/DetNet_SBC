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
        try{
            page.waitForURL("**/settings/emailRecipient");
            return page.url();
        }catch (PlaywrightException e){
            System.out.println("URL not found or invalid: " + e.getMessage());
            return null;
        }
    }

    public boolean isRecipientListHeadingVisible() {
        try {
            page.locator(recipientListHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Recipients list heading not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public String getHeadingText() {
        try{
            return page.locator(recipientListHeading).textContent();
        }catch (PlaywrightException e){
            System.out.println("Recipient list heading not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public boolean isRecipientListEmpty() {
        try {
            page.locator(noRecipientsText)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("No recipients text not visible or not found: " + e.getMessage());
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
            System.out.println("Add Recipient button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isAddRecipientButtonEnabled() {
        try{
            return page.locator(addRecipientBtn).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Add Recipient button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void createEmailRecipient() {
        try{
            page.locator(addRecipientBtn).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Add Recipient button not found or not visible: " + e.getMessage());
        }
    }

    public boolean isAddRecipientFormVisible() {
        try {
            page.locator(addRecipientHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Add recipient heading not found or not visible: " + e.getMessage());
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
            System.out.println("Email address field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isEmailAddressFieldEnabled() {
        try{
            return page.locator(emailAddressField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Email address field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isEmailAddressFieldEmpty() {
        try{
            String emailAddressInputField = page.locator(emailAddressField).inputValue();
            return emailAddressInputField == null || emailAddressInputField.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Email address field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void setEmailAddress(String emailAddress) {
        try{
            page.locator(emailAddressField).click();
            page.locator(emailAddressField).fill(emailAddress);
        }catch (PlaywrightException e){
            System.out.println("Email address field not found or not visible: " + e.getMessage());
        }
    }

    public String getEmailAddress() {
        try{
            return page.locator(emailAddressField).inputValue();
        }catch (PlaywrightException e){
            System.out.println("Email address field not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public boolean isFirstNameFieldVisible() {
        try {
            page.locator(firstNameField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("First name input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isFirstNameFieldEnabled() {
        try{
            return page.locator(firstNameField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("First name input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isFirstNameFieldEmpty() {
        try{
            String firstNameInputField = page.locator(firstNameField).inputValue();
            return firstNameInputField == null || firstNameInputField.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("First name input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void setFirstName(String firstName) {
        try{
            page.locator(firstNameField).click();
            page.locator(firstNameField).fill(firstName);
        }catch (PlaywrightException e){
            System.out.println("First name input field not found or not visible: " + e.getMessage());
        }
    }

    public String getFirstName() {
        try{
            return page.locator(firstNameField).inputValue();
        }catch (PlaywrightException e){
            System.out.println("First name input field not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public boolean isLastnameFieldVisible() {
        try {
            page.locator(lastNameField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Last name input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isLastNameFieldEnabled() {
        try{
            return page.locator(lastNameField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Last name input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isLastNameFieldEmpty() {
        try{
            String lastNameInputField = page.locator(lastNameField).inputValue();
            return lastNameInputField == null || lastNameInputField.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Last name input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void setLastName(String lastName) {
        try{
            page.locator(lastNameField).click();
            page.locator(lastNameField).fill(lastName);
        }catch (PlaywrightException e){
            System.out.println("Last name input field not found or not visible: " + e.getMessage());
        }
    }

    public String getLastName() {
        try{
            return page.locator(lastNameField).inputValue();
        }catch (PlaywrightException e){
            System.out.println("Last name input field not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public boolean isSeverityLevelsVisible() {
        try {
            page.locator(severityLevel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Severity level not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void selectSeverityLevel(String severity){
        try{
            String severityLvl = "(//label[normalize-space()='" + severity + "'])[1]";
            page.locator(severityLvl).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Severity level not found or not visible: " + e.getMessage());
        }
    }

    public String getSelectedSeverity(){
        try{
            return page.locator(moderateSeverityElement).textContent();
        }catch (PlaywrightException e){
            System.out.println("Moderate severity element not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public boolean isSaveRecipientButtonVisible(){
        try{
            page.locator(addRecipientButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'Add Recipient' -button button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSaveRecipientButtonEnabled(){
        try{
            return page.locator(addRecipientButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Add Recipient button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void saveNewRecipient(){
        try{
            page.locator(addRecipientButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Add Recipient button not found or not visible: " + e.getMessage());
        }
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
            System.out.println("Recipient not found or not visible: " + e.getMessage());
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
        try{
            page.locator(searchBar).click(new Locator.ClickOptions().setTimeout(5000));
            page.locator(searchBar).clear();
            page.locator(searchBar).fill(recipient);
        }catch (PlaywrightException e){
            System.out.println("Search bar not visible or not found: " + e.getMessage());
        }
    }

    public boolean isIntervalDropdownVisible(){
        try{
            page.locator(intervalDropDown)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Interval dropdown not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isIntervalDropDownEnabled(){
        try{
            return page.locator(intervalDropDown).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Interval dropdown not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isIntervalDropDownPanelOpen(){
        try{
            page.locator(intervalDropDownPanel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Interval dropdown panel not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void openIntervalPanel(){
        try{
            page.locator(intervalDropDown).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Interval dropdown not found or not visible: " + e.getMessage());
        }
    }

    public void selectInterval(String interval){
        try{
            String intervalElement = "(//span[contains(text(),'" + interval + "')])[1]";
            page.locator(intervalElement).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Interval element not found or not visible: " + e.getMessage());
        }
    }

    public boolean isDeleteIconVisible(int rowNumber){
        String row = "(//span[@class='mat-mdc-tooltip-trigger material-symbols-outlined'][normalize-space()='delete'])["
                + rowNumber + "]";
        try{
            page.locator(row)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Row number not visible or not found on email recipients dashboard: " + e.getMessage());
            return false;
        }
    }

    public void deleteRecipient(int rowNumber){
        try{
            String row = "(//span[@class='mat-mdc-tooltip-trigger material-symbols-outlined'][normalize-space()='delete'])["
                    + rowNumber + "]";
            page.locator(row).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Row not found or not visible: " + e.getMessage());
        }
    }

    public boolean isDeleteDialogVisible(){
        try{
            page.locator(deleteDialog)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Delete dialog not found or not visible on the email recipient dialog: " + e.getMessage());
            return false;
        }
    }

    public void confirmToDeleteRecipient(){
        try{
            page.locator(yesButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Yes button not found or not visible: " + e.getMessage());
        }
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
            System.out.println("Checkbox not found or not visible on the email recipient dashboard: " + e.getMessage());
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
            System.out.println("Checkbox not found or not visible on the email recipient dashboard: " + e.getMessage());
            return false;
        }
    }

    public boolean isCheckBoxEnabled(){
        try{
            return page.locator(checkBox).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Checkbox not found or not visible on the email recipient dashboard: " + e.getMessage());
            return false;
        }
    }

    public void selectAllRecipients(){
        try{
            page.locator(checkBox).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Checkbox not found or not visible on the email recipient dashboard: " + e.getMessage());
        }
    }

    public void selectOrDeselectRecipients(int row){
        try{
            String rowPath = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/app-email-recipient[1]/" +
                    "blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/table[1]/tbody[1]/tr[" + row + "]/td[1]/mat-checkbox[1]" +
                    "/div[1]/div[1]/input[1]";
            page.locator(rowPath).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Row path not found or not visible on the email recipient dashboard: " + e.getMessage());
        }
    }

    public boolean isDeleteAllRecipientsButtonVisible(){
        try{
            page.locator(deleteAllButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Delete All button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeleteAllRecipientsButtonEnabled(){
        try{
            return page.locator(deleteAllButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Delete All' -button not found or not visible:");
            return false;
        }
    }

    public void deleteAllRecipients(){
        try{
            page.locator(deleteAllButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Delete All button not found or not visible: " + e.getMessage());
        }
    }
}