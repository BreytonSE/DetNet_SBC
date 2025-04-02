package com.detnet.managers;

import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.pageObjects.LoginPageObjectModel;
import com.microsoft.playwright.Page;

public class PageObjectManager {
    private static PageObjectManager instance;
    private Page page;

    private LoginPageObjectModel loginPageObjectModel;
    private DashboardPageObjectModel dashboardPageObjectModel;

    private PageObjectManager(Page page) {
        this.page = page;
    }

    public static synchronized PageObjectManager getInstance(Page page){
        if(instance == null || page.isClosed()){
            instance = new PageObjectManager(page);
        }
        return instance;
    }

    public void updatePage(Page newPage){
     this.page = newPage; // Allow updating page when Playwright restart
     loginPageObjectModel = null; // Reset cached page objects
     dashboardPageObjectModel = null;
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