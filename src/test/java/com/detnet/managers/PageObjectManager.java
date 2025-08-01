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
    private DevicePageObjectModel devicePageObjectModel;
    private DeviceSummaryPageObjectModel deviceSummaryPageObjectModel;
    private PasswordResetPageObjectModel passwordResetPageObjectModel;
    private NetworkTreePageObjectModel networkTreePageObjectModel;
    private DeviceDetailsPageObjectModel deviceDetailsPageObjectModel;
    private GroupsPageObjectModel groupsPageObjectModel;
    private EmailRecipientsPageObjectModel emailRecipientsPageObjectModel;
    private BlastConfirmationPageObjectModel blastConfirmationPageObjectModel;
    private BlastReportPageObjectModel blastReportPageObjectModel;
    private DeviceEventsPageObjectModel deviceEventsPageObjectModel;

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

    public DevicePageObjectModel getDevicePageObjectModel(){
        if(devicePageObjectModel == null){
            devicePageObjectModel = new DevicePageObjectModel(page);
        }
        return devicePageObjectModel;
    }

    public DeviceSummaryPageObjectModel getDeviceSummaryPageObjectModel(){
        if(deviceSummaryPageObjectModel == null){
            deviceSummaryPageObjectModel = new DeviceSummaryPageObjectModel(page);
        }
        return deviceSummaryPageObjectModel;
    }

    public PasswordResetPageObjectModel getPasswordResetPageObjectModel(){
        if (passwordResetPageObjectModel == null){
            passwordResetPageObjectModel = new PasswordResetPageObjectModel(page);
        }
        return passwordResetPageObjectModel;
    }

    public NetworkTreePageObjectModel getNetworkTreePageObjectModel(){
        if(networkTreePageObjectModel == null){
            networkTreePageObjectModel = new NetworkTreePageObjectModel(page);
        }
        return networkTreePageObjectModel;
    }

    public DeviceDetailsPageObjectModel getDeviceDetailsPageObjectModel(){
        if(deviceDetailsPageObjectModel == null){
            deviceDetailsPageObjectModel = new DeviceDetailsPageObjectModel(page);
        }
        return deviceDetailsPageObjectModel;
    }

    public GroupsPageObjectModel getGroupsPageObjectModel(){
        if(groupsPageObjectModel == null){
            groupsPageObjectModel = new GroupsPageObjectModel(page);
        }
        return groupsPageObjectModel;
    }

    public EmailRecipientsPageObjectModel getEmailRecipientsPageObjectModel(){
        if(emailRecipientsPageObjectModel == null){
            emailRecipientsPageObjectModel = new EmailRecipientsPageObjectModel(page);
        }
        return emailRecipientsPageObjectModel;
    }

    public BlastConfirmationPageObjectModel getBlastConfirmationPageObjectModel(){
        if(blastConfirmationPageObjectModel == null){
            blastConfirmationPageObjectModel = new BlastConfirmationPageObjectModel(page);
        }
        return blastConfirmationPageObjectModel;
    }

    public BlastReportPageObjectModel getBlastReportPageObjectModel(){
        if(blastReportPageObjectModel == null){
            blastReportPageObjectModel = new BlastReportPageObjectModel(page);
        }
        return blastReportPageObjectModel;
    }

    public DeviceEventsPageObjectModel getDeviceEventsPageObjectModel(){
        if(deviceEventsPageObjectModel == null){
            deviceEventsPageObjectModel = new DeviceEventsPageObjectModel(page);
        }
        return deviceEventsPageObjectModel;
    }
}