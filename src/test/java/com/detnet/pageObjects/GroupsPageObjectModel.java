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
}