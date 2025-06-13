package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DeviceSummaryPageObjectModel {
    private final Page page;
    private final String deviceStateLabel = "//body/app-root/device-details[@class=\"ng-star-inserted\"]/div[@class=\"sideMenuContainer\"]/div[@class=\"content\"]/app-device-summary[@class=\"ng-star-inserted\"]/blastweb-spinner[@label=\"Loading Device Summary\"]/blastweb-zero-data[@class=\"ng-star-inserted\"]/div[@class=\"container ng-star-inserted\"]/div[@fxlayout=\"row\"]/div[@class=\"header-div\"]/blastweb-subheading[@class=\"subheading-div\"]/h2/div[@fxlayout=\"row\"]/div[@class=\"subheader-details-div\"]/div[@fxlayout=\"column\"]/span[1]";

    public DeviceSummaryPageObjectModel(Page page) {
        this.page = page;
    }

    public boolean isDeviceStateVisible(){
        try{
            page.locator(deviceStateLabel).waitFor(new Locator.WaitForOptions().setTimeout(5000));
            return page.locator(deviceStateLabel).isVisible();
        }catch (Exception e){
            return false;
        }
    }

    public String getCurrentDeviceState() {
        Locator stateLocator = page.locator("//span[@class='text' and (normalize-space()='Idle' or normalize-space()='Ready to blast' or normalize-space()='Unknown')]");
        return stateLocator.textContent().trim();
    }
}