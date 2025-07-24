package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.detnet.locators.GroupsPageLocators.*;

public class GroupsPageObjectModel {
    private final Page page;

    public GroupsPageObjectModel(Page page) {
        this.page = page;
    }

    public String getGroupsURL() {
        try{
            page.waitForURL("**/settings/groups");
            return page.url();
        }catch (PlaywrightException e){
            System.out.println("URL not found or not valid: " + e.getMessage());
            return null;
        }
    }

    public boolean isGroupsHeadingVisible() {
        try {
            page.locator(groupsHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Groups heading not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public String getHeadingText() {
        try{
            return page.locator(groupsHeading).textContent();
        }catch (PlaywrightException e){
            System.out.println("Groups heading not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public boolean hasNoGroups() {
        try {
            page.locator(noGroupsLabel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("'No Groups' text not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public String getNoGroupsText() {
        try{
            return page.locator(noGroupsLabel).textContent();
        }catch (PlaywrightException e){
            System.out.println("'No Groups' text not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public boolean isAddGroupButtonVisible() {
        try{
            return page.locator(addGroupBtn).isVisible();
        }catch (PlaywrightException e){
            System.out.println("'Add Groups' -button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isAddGroupButtonEnabled() {
        try{
            return page.locator(addGroupBtn).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Add Groups' -button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void addGroup() {
        try{
            page.locator(addGroupBtn).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Add Groups' -button not visible or not found: " + e.getMessage());
        }
    }

    public String getAddGroupPageURL() {
        try{
            page.waitForURL("**/groups/add");
            return page.url();
        }catch (PlaywrightException e){
            System.out.println("URL not found or not valid: " + e.getMessage());
            return null;
        }
    }

    public boolean isAddGroupFormVisible() {
        try{
            return page.locator(addGroupHeading).isVisible();
        }catch (PlaywrightException e){
            System.out.println("'Add Group' -heading not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public String getAddGroupHeadingText() {
        try{
            return page.locator(addGroupHeading).textContent();
        }catch (PlaywrightException e){
            System.out.println("'Add Group' -heading not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public boolean isGroupNameInputFieldVisible() {
        try{
            return page.locator(groupNameInput).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Group name input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isGroupNameFieldEnabled() {
        try{
            return page.locator(groupNameInput).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Group name input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isGroupNameFieldEmpty() {
        try{
            String xpath = page.locator(groupNameInput).inputValue();
            return xpath == null || xpath.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Group name input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isGroupNameFieldFilled() {
        try{
            String xpath = page.locator(groupNameInput).inputValue();
            return !(xpath == null || xpath.trim().isEmpty());
        }catch (PlaywrightException e){
            System.out.println("Group name input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void setGroupName(String groupName) {
        try{
            page.locator(groupNameInput).fill(groupName);
        }catch (PlaywrightException e){
            System.out.println("Group name input field not visible or not found: " + e.getMessage());
        }
    }

    public String getGroupName() {
        try{
            return page.locator(groupNameInput).inputValue();
        }catch (PlaywrightException e){
            System.out.println("Group name input field not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public boolean isColorPickerVisible() {
        try{
            return page.locator(colorPicker).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Color picker not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isColorPickerEnabled() {
        try{
            return page.locator(colorPicker).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Color picker not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void openColorPicker() {
        try{
            page.locator(colorPicker).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Color picker not visible or not found: " + e.getMessage());
        }
    }

    public boolean isColorPickerOpen() {
        try {
            page.locator(colorPickerTray)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Color picker tray not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void switchColorCode(int clickCounter) {
        try{
            for (int i = 0; i < clickCounter; i++) {
                page.locator(colorPickerDownArrow).click(new Locator.ClickOptions().setTimeout(5000));
            }
        }catch (PlaywrightException e){
            System.out.println("Color picker dropdown arrow not found or not visible: " + e.getMessage());
        }
    }

    public boolean isRGBFieldsVisible() {
        try {
            page.locator(rgbField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("RGB color picker not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void setRGBColor(String r, String g, String b) {
        try{
            page.locator(redInputField).click();
            page.locator(redInputField).clear();
            page.locator(redInputField).fill(r);

            page.locator(greenInputField).click();
            page.locator(greenInputField).clear();
            page.locator(greenInputField).fill(g);

            page.locator(blueInputField).click();
            page.locator(blueInputField).clear();
            page.locator(blueInputField).fill(b);
        }catch (PlaywrightException e){
            System.out.println("Red, green, blue color input field not found or not visible: " + e.getMessage());
        }
    }

    public String getRGBColorCode() {
        try{
            String red = page.locator(redInputField).inputValue();
            String green = page.locator(greenInputField).inputValue();
            String blue = page.locator(blueInputField).inputValue();
            return red + "," + green + "," + blue;
        }catch (PlaywrightException e){
            System.out.println("Red, green, blue color input field not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public boolean isSaveGroupButtonVisible() {
        try{
            return page.locator(saveGroup).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Save button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isSaveGroupButtonEnabled() {
        try{
            return page.locator(saveGroup).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Save button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void saveGroup() {
        try{
            page.locator(saveGroup).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Save button not visible or not found: " + e.getMessage());
        }
    }

    public boolean isGroupAddedToInterface() {
        try {
            page.locator(group)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Group not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isEditIconVisible(int row) {
        String rowIcon = "(//mat-icon[@role='img'][normalize-space()='edit'])[" + row + "]";
        try {
            page.locator(rowIcon)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Row icon not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void editGroup(int groupNumber) {
        try{
            String rowIcon = "(//mat-icon[@role='img'][normalize-space()='edit'])[" + groupNumber + "]";
            page.locator(rowIcon).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Row icon not found or not visible: " + e.getMessage());
        }
    }

    public boolean isEditGroupsHeadingVisible() {
        try{
            return page.locator(editHeading).isVisible();
        }catch (PlaywrightException e){
            System.out.println("'Edit' -heading not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public String getEditGroupsHeading() {
        try{
            return page.locator(editHeading).textContent();
        }catch (PlaywrightException e){
            System.out.println("'Edit' -heading not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public void editGroupName(String groupName) {
        try{
            page.locator(groupNameInput).click(new Locator.ClickOptions().setTimeout(5000));
            page.locator(groupNameInput).clear();
            page.locator(groupNameInput).fill(groupName);
        }catch (PlaywrightException e){
            System.out.println("Group name input field not visible or not found: " + e.getMessage());
        }
    }

    public boolean isUpdateButtonVisible() {
        try{
            return page.locator(updateGroupBtn).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Update button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isUpdateButtonEnabled() {
        try{
            return page.locator(updateGroupBtn).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Update button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void updateGroupDetails() {
        try{
            page.locator(updateGroupBtn).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Update button not found or not visible: " + e.getMessage());
        }
    }

    public boolean isGroupNameUpdated(String groupName) {
        String group = "(//td[normalize-space()='" + groupName + "'])[1]";
        try {
            page.locator(group)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Group name not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSearchBarVisible() {
        try{
            return page.locator(searchBar).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSearchBarEnabled() {
        try{
            return page.locator(searchBar).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSearchbarEmpty() {
        try{
            String searchField = page.locator(searchBar).inputValue();
            return searchField == null || searchField.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void searchGroup(String group) {
        try{
            page.locator(searchBar).click();
            page.locator(searchBar).clear();
            page.locator(searchBar).fill(group);
        }catch (PlaywrightException e){
            System.out.println("Search bar not visible or not found: " + e.getMessage());
        }
    }

    public boolean isSearchedGroupFound(String group) {
        try{
            String groupName = "(//td[normalize-space()='" + group + "'])[1]";
            return page.locator(groupName).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Group name not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeleteIconVisible() {
        try {
            page.locator(binIcon)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Bin icon not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeleteIconEnabled() {
        try{
            return page.locator(binIcon).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Bin icon not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void deleteSingleGroup(int rowNumber) {
        try{
            String deleteIcon = "(//span[@class='mat-mdc-tooltip-trigger material-symbols-outlined'][normalize-space()='delete'])[" + rowNumber + "]";
            page.locator(deleteIcon).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Delete icon not visible or not found: " + e.getMessage());
        }
    }

    public boolean isDeleteDialogWindowOpen() {
        try {
            page.locator(deleteDialogWindow)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Delete dialog window not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void confirmDelete() {
        try{
            page.locator(yesButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Yes button not visible or not found: " + e.getMessage());
        }
    }

    public boolean isCheckBoxVisible() {
        try {
            page.locator(selectAllCheckbox)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Select All checkbox not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void selectAllGroups() {
        try{
            page.locator(selectAllCheckbox).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Select All checkbox not visible or not found");
        }
    }

    public void selectOrDeselectMultipleGroups(int row) {
        try{
            String checkBox = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-groups[1]/blastweb-spinner" +
                    "[1]/blastweb-zero-data[1]/div[1]/table[1]/tbody[1]/tr[" + row + "]/td[1]/mat-checkbox[1]/div[1]/div[1]/input[1]";
            page.locator(checkBox).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Groups selection checkbox not visible or not found: " + e.getMessage());
        }
    }

    public boolean isDeleteAllGroupsButtonVisible() {
        try {
            page.locator(deleteAllBtn)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Delete All button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeleteGroupsButtonEnabled(){
        try {
            return page.locator(deleteAllBtn).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Delete All' -button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void deleteSelectedGroups(){
        try{
            page.locator(deleteAllBtn).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Delete All' -button not visible or not found: " + e.getMessage());
        }
    }

    public boolean isSelectedGroupsDeleted(String groupName){
        String group = "(//td[normalize-space()='" + groupName + "'])[1]";
        try{
            page.locator(group)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.HIDDEN)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Group name not found or not visible: " + e.getMessage());
            return false;
        }
    }
}