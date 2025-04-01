package com.detnet.managers;

import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.pageObjects.LoginPageObjectModel;
import com.microsoft.playwright.Page;

public class PageObjectManager {
    private static PageObjectManager instance;
    private final Page page;

    private LoginPageObjectModel loginPageObjectModel;
    private DashboardPageObjectModel dashboardPageObjectModel;

    private PageObjectManager(Page page) {
        this.page = page;
    }

    public static PageObjectManager getInstance(Page page){
        if(instance == null){
            instance = new PageObjectManager(page);
        }
        return instance;
    }

    public LoginPageObjectModel getLoginPageObjectModel(){
        if(loginPageObjectModel == null){
            loginPageObjectModel = new LoginPageObjectModel(page);
        }
        return loginPageObjectModel;
    }

    public DashboardPageObjectModel getDashboardPageObjectModel(){
        if (dashboardPageObjectModel == null){
            dashboardPageObjectModel = new DashboardPageObjectModel(page);
        }
        return dashboardPageObjectModel;
    }
}