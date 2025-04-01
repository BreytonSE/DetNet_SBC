package com.detnet.pageObjects;

import com.microsoft.playwright.Page;

public class DashboardPageObjectModel {
    private final Page page;
    private final String dashboardLabel = "//span[contains(text(),'Dashboard')]";
    private final String userRoleLabel = "//p[@class='userRole']";
    private final String navigationMenu = "#mat-menu-panel-2";
    private final String logoutButton = "//span[contains(text(),'Logout')]";

    public DashboardPageObjectModel(Page page) {
        this.page = page;
    }

    public boolean isDashboardPageOpen(){
        return page.locator(dashboardLabel).isVisible();
    }

    public String getDashboardLabelName(){
        return page.locator(dashboardLabel).textContent();
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
        page.locator(userRoleLabel).click();
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
        page.locator(logoutButton).click();
    }
}