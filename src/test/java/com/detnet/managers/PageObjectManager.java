package com.detnet.managers;

import com.detnet.pageObjects.*;
import com.microsoft.playwright.Page;

import java.lang.reflect.Field;

public class PageObjectManager {
    private static PageObjectManager instance;
    private Page page;

    private LoginPageObjectModel loginPageObjectModel;
    private DashboardPageObjectModel dashboardPageObjectModel;
    private SettingsPageObjectModel settingsPageObjectModel;
    private BlastCardsPageObjectModel blastCardsPageObjectModel;
    private UsersPageObjectModel usersPageObjectModel;
    private NetworkPageObjectModel networkPageObjectModel;

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
     this.page = newPage;
     resetCachedPageObjects();
    }

//    Looks for page object model variables in current class (PageObjectManager) that contains the pattern "PageObjectModel", and set them to null automatically
    private void resetCachedPageObjects(){
        Field[] fields = this.getClass().getDeclaredFields();
        for(Field field : fields){
            if (field.getName().endsWith("PageObjectModel")){
                field.setAccessible(true);
            }
            try{
                field.set(this,null);
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }
        }
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

    public SettingsPageObjectModel getSettingsPageObjectModel(){
        if (settingsPageObjectModel == null){
            settingsPageObjectModel = new SettingsPageObjectModel(page);
        }
        return settingsPageObjectModel;
    }

    public BlastCardsPageObjectModel getBlastCardsPageObjectModel(){
        if (blastCardsPageObjectModel == null){
            blastCardsPageObjectModel = new BlastCardsPageObjectModel(page);
        }
        return blastCardsPageObjectModel;
    }

    public UsersPageObjectModel getUsersPageObjectModel(){
        if(usersPageObjectModel == null){
            usersPageObjectModel = new UsersPageObjectModel(page);
        }
        return usersPageObjectModel;
    }

    public NetworkPageObjectModel getNetworkPageObjectModel(){
        if(networkPageObjectModel == null){
            networkPageObjectModel = new NetworkPageObjectModel(page);
        }
        return networkPageObjectModel;
    }
}