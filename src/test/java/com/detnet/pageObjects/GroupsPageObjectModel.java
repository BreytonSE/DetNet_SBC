package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

public class GroupsPageObjectModel {
    private final Page page;

    private final String groupsHeading = "//h2[normalize-space()=\"Groups\"]";
    private final String noGroupsLabel = "//h2[normalize-space()=\"No Groups Present\"]";
    private final String addGroupBtn = "//button[@class=\"addBtn ng-star-inserted\"]";
    private final String addGroupHeading = "//h2[normalize-space()=\"Add Group\"]";
    private final String groupNameInput = "//input[@id=\"name\"]";
    private final String colorPicker = "//input[@class=\"colorPicker\"]";
    private final String colorPickerTray = "//div[@class=\"color-picker open\"]";
    private final String colorPickerDownArrow = "//color-picker[@class=\"ng-star-inserted\"]//span[2]";
    private final String redInputField = "div[class=\"rgba-text ng-star-inserted\"] input:nth-child(1)";
    private final String greenInputField = "div[class=\"rgba-text ng-star-inserted\"] input:nth-child(2)";
    private final String blueInputField = "div[class=\"rgba-text ng-star-inserted\"] input:nth-child(3)";
    private final String rgbField = "//div[@class=\"rgba-text ng-star-inserted\"]";
    private final String saveGroup = "//span[contains(text(),\"Add Group\")]";
    private final String group = "//tr[@class=\"mat-mdc-row mdc-data-table__row cdk-row ng-star-inserted\"]";
    private final String editHeading = "//h2[normalize-space()=\"Edit Group\"]";
    private final String updateGroupBtn = "//button[@id=\"addNetworkSubmitButton\"]//span[@class=\"mat-mdc-button-touch-target\"]";
    private final String searchBar = "//input[@placeholder=\"Search using ID, Name\"]";

    public GroupsPageObjectModel(Page page) {
        this.page = page;
    }

    public String getGroupsURL(){
        page.waitForURL("**/settings/groups");
        return page.url();
    }

    public boolean isGroupsHeadingVisible(){
        try{
            page.locator(groupsHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public String getHeadingText(){
        return page.locator(groupsHeading).textContent();
    }

    public boolean hasNoGroups(){
        try{
            page.locator(noGroupsLabel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

   public String getNoGroupsText(){
        return page.locator(noGroupsLabel).textContent();
   }

   public boolean isAddGroupButtonVisible(){
        return page.locator(addGroupBtn).isVisible();
   }

   public boolean isAddGroupButtonEnabled(){
        return page.locator(addGroupBtn).isEnabled();
   }

   public void addGroup(){
        page.locator(addGroupBtn).click(new Locator.ClickOptions().setTimeout(5000));
   }

   public String getAddGroupPageURL(){
        page.waitForURL("**/groups/add");
        return page.url();
   }

   public boolean isAddGroupFormVisible(){
        return page.locator(addGroupHeading).isVisible();
   }

   public String getAddGroupHeadingText(){
        return page.locator(addGroupHeading).textContent();
   }

   public boolean isGroupNameInputFieldVisible(){
        return page.locator(groupNameInput).isVisible();
   }

   public boolean isGroupNameFieldEnabled(){
        return page.locator(groupNameInput).isEnabled();
   }

   public boolean isGroupNameFieldEmpty(){
        String xpath = page.locator(groupNameInput).inputValue();
        return xpath == null || xpath.trim().isEmpty();
   }

   public boolean isGroupNameFieldFilled(){
        String xpath = page.locator(groupNameInput).inputValue();
        return !(xpath == null || xpath.trim().isEmpty());
   }

   public void setGroupName(String groupName){
        page.locator(groupNameInput).fill(groupName);
   }

   public String getGroupName(){
        return page.locator(groupNameInput).inputValue();
   }

   public boolean isColorPickerVisible(){
        return page.locator(colorPicker).isVisible();
   }

   public boolean isColorPickerEnabled(){
        return page.locator(colorPicker).isEnabled();
   }

   public void openColorPicker(){
        page.locator(colorPicker).click(new Locator.ClickOptions().setTimeout(5000));
   }

   public boolean isColorPickerOpen(){
        try{
            page.locator(colorPickerTray)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
   }

   public void switchColorCode(int clickCounter){
        for(int i=0;i<clickCounter;i++){
            page.locator(colorPickerDownArrow).click(new Locator.ClickOptions().setTimeout(5000));
        }
   }

   public boolean isRGBFieldsVisible(){
        try{
            page.locator(rgbField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
   }

   public void setRGBColor(String r, String g, String b){
        page.locator(redInputField).click();
        page.locator(redInputField).clear();
        page.locator(redInputField).fill(r);

       page.locator(greenInputField).click();
       page.locator(greenInputField).clear();
       page.locator(greenInputField).fill(g);

       page.locator(blueInputField).click();
       page.locator(blueInputField).clear();
       page.locator(blueInputField).fill(b);
   }

   public String getRGBColorCode(){
       String red = page.locator(redInputField).inputValue();
       String green = page.locator(greenInputField).inputValue();
       String blue = page.locator(blueInputField).inputValue();
       return red + "," + green + "," + blue;
   }

   public boolean isSaveGroupButtonVisible(){
        return page.locator(saveGroup).isVisible();
   }

   public boolean isSaveGroupButtonEnabled(){
        return page.locator(saveGroup).isEnabled();
   }

   public void saveGroup(){
        page.locator(saveGroup).click(new Locator.ClickOptions().setTimeout(5000));
   }

   public boolean isGroupAddedToInterface(){
        try {
            page.locator(group)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
   }

   public boolean isEditIconVisible(int row){
        String rowIcon = "(//mat-icon[@role='img'][normalize-space()='edit'])[" + row + "]";
       try {
           page.locator(rowIcon)
                   .waitFor(new Locator.WaitForOptions()
                           .setState(WaitForSelectorState.VISIBLE)
                           .setTimeout(5000));
           return true;
       }catch (PlaywrightException e){
           return false;
       }
   }

   public void editGroup(int groupNumber){
       String rowIcon = "(//mat-icon[@role='img'][normalize-space()='edit'])[" + groupNumber + "]";
       page.locator(rowIcon).click(new Locator.ClickOptions().setTimeout(5000));
   }

   public boolean isEditGroupsHeadingVisible(){
        return page.locator(editHeading).isVisible();
   }

   public String getEditGroupsPageURL(){
        page.waitForURL("**/settings/groups/*/edit");
        return page.url();
   }

   public String getEditGroupsHeading(){
        return page.locator(editHeading).textContent();
   }

   public void editGroupName(String groupName){
        page.locator(groupNameInput).click(new Locator.ClickOptions().setTimeout(5000));
        page.locator(groupNameInput).clear();
        page.locator(groupNameInput).fill(groupName);
   }

   public boolean isUpdateButtonVisible(){
        return page.locator(updateGroupBtn).isVisible();
   }

   public boolean isUpdateButtonEnabled(){
        return page.locator(updateGroupBtn).isEnabled();
   }

   public void updateGroupDetails(){
        page.locator(updateGroupBtn).click(new Locator.ClickOptions().setTimeout(5000));
   }

   public boolean isGroupNameUpdated(String groupName){
        String group = "(//td[normalize-space()='" + groupName + "'])[1]";
        try{
            page.locator(group)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
   }

   public boolean isSearchBarVisible(){
        return page.locator(searchBar).isVisible();
   }

   public boolean isSearchBarEnabled(){
        return page.locator(searchBar).isEnabled();
   }

   public boolean isSearchbarEmpty(){
        String searchField = page.locator(searchBar).inputValue();
        return searchField == null || searchField.trim().isEmpty();
   }

   public void searchGroup(String group){
        page.locator(searchBar).click();
        page.locator(searchBar).clear();
        page.locator(searchBar).fill(group);
   }
    public boolean isSearchedGroupFound(String group){
        String groupName = "(//td[normalize-space()='" + group + "'])[1]";
        return page.locator(groupName).isVisible();
    }
}