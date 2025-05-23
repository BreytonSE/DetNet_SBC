package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DashboardPageObjectModel {
    private final Page page;
    private final String userRoleLabel = "//p[@class='userRole']";
    private final String navigationMenu = "#mat-menu-panel-2";
    private final String logoutButton = "//span[contains(text(),'Logout')]";
    private final String settingsButton = "//span[contains(text(),'Settings')]";
    private final String dashboardButton = "//span[contains(text(),\"Dashboard\")]";
    private final String deviceDetailsButton = "//body[1]/app-root[1]/dashboard[1]/blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/div[2]/div[1]/div[1]/bcu-card-high-detail[1]/mat-card[1]/div[5]\n";
    private final String newDevice = "(//span[normalize-space()='Cape Town'])[1]";

    public DashboardPageObjectModel(Page page) {
        this.page = page;
    }

    public boolean isDashboardPageOpen(){
        return page.locator(dashboardButton).isVisible();
    }

    public String getDashboardLabelName(){
        return page.locator(dashboardButton).textContent();
    }

    public String getDashboardURL(){
        page.waitForURL("**/dashboard");
        return page.url();
    }

    public boolean isUserRoleLabelVisible(){
        return page.locator(userRoleLabel).isVisible();
    }

    public String getUserRoleLabel(){
        return page.locator(userRoleLabel).textContent();
    }

    public void openNavigationMenu(){
        page.locator(userRoleLabel).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isNavigationMenuOpen(){
        return page.locator(navigationMenu).isVisible();
    }

    public boolean isLogoutButtonVisible(){
        return page.locator(logoutButton).isVisible();
    }

    public boolean isLogoutButtonEnabled(){
        return page.locator(logoutButton).isEnabled();
    }

    public void logOut(){
        page.locator(logoutButton).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public void openSettings(){
        page.locator(settingsButton).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isSettingsButtonVisible(){
        return page.locator(settingsButton).isVisible();
    }

    public boolean isSettingsButtonEnabled(){
        return page.locator(settingsButton).isEnabled();
    }

    public boolean isDashboardButtonEnabled(){
        return page.locator(dashboardButton).isEnabled();
    }

    public void goToDashboard(){
        page.locator(dashboardButton).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isViewDeviceDetailsButtonVisible(){
        try{
            page.locator(deviceDetailsButton).waitFor(new Locator.WaitForOptions().setTimeout(5000));
            return page.locator(deviceDetailsButton).isVisible();
        }catch (Exception e){
            return false;
        }
    }

    public boolean isViewDetailsButtonEnabled(){
        return page.locator(deviceDetailsButton).isEnabled();
    }

    public void viewDeviceDetails(int deviceNumber){
        String device = "//body[1]/app-root[1]/dashboard[1]/blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/div[2]/div[" +
                "1]/div["+ deviceNumber + "]/bcu-card-high-detail[1]/mat-card[1]/div[5]";
        page.locator(device).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isNewDeviceOnDashboard(){
        return page.locator(newDevice).isVisible();
    }
}