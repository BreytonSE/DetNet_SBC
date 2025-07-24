package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;

import static com.detnet.locators.SettingsPageLocators.*;

public class SettingsPageObjectModel {
    private final Page page;

    public SettingsPageObjectModel(Page page) {
        this.page = page;
    }

    public String getSettingsURL(){
        try{
            page.waitForURL("**/settings/networks");
            return page.url();
        }catch (PlaywrightException e){
            System.out.println("URL not found or invalid: " + e.getMessage());
            return null;
        }
    }

    public boolean isSettingsLabelVisible(){
        try{
            return page.locator(settingsLabel).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Settings label not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public String getSettingsLabel(){
        try{
            return page.locator(settingsLabel).textContent();
        }catch (PlaywrightException e){
            System.out.println("Settings label not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public boolean isBlastCardButtonVisible(){
        try{
            return page.locator(blastCardsButton).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Blast card button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isBlastCardButtonEnabled(){
        try{
            return page.locator(blastCardsButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Blast card button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void viewActiveBlastCards(){
        try{
            page.locator(blastCardsButton).click();
        }catch (PlaywrightException e){
            System.out.println("Blast card button not found or not visible: " + e.getMessage());
        }
    }

    public boolean isUserButtonVisible(){
        try{
            return page.locator(usersButton).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Users button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isUserButtonEnabled(){
        try{
            return page.locator(usersButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Users button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public String getUsersLabel(){
        try{
            return page.locator(usersButton).textContent();
        }catch (PlaywrightException e){
            System.out.println("Users button not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public void viewUsers(){
        try{
            page.locator(usersButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Users button not found or not visible: " + e.getMessage());
        }
    }

    public boolean isNetworksTabPresent(){
        try{
            return page.locator(networksButton).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Networks button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void goToNetworks(){
        try{
            page.locator(networksButton).click();
        }catch (PlaywrightException e){
            System.out.println("Networks button not visible or not found: " + e.getMessage());
        }
    }

    public boolean isDeviceTabPresent(){
        try{
            return page.locator(devicesTab).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Device tab not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeviceTabEnabled(){
        try {
            return page.locator(devicesTab).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Device tab not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public String getDeviceTabText(){
        try{
            return page.locator(devicesTab).textContent();
        }catch (PlaywrightException e){
            System.out.println("Device tab not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public void viewDevices(){
        try{
            page.locator(devicesTab).click();
        }catch (PlaywrightException e){
            System.out.println("Device tab not found or not visible: " + e.getMessage());
        }
    }

    public boolean isNetworkTreeTabVisible(){
        try{
            return page.locator(networkTreeTab).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Network Tree tab not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public String getNetworkTreeText(){
        try{
            return page.locator(networkTreeTab).textContent();
        }catch (PlaywrightException e){
            System.out.println("Network Tree tab not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public void openNetworkTree(){
        try{
            page.locator(networkTreeTab).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Network tree tab not found or not visible: " + e.getMessage());
        }
    }

    public boolean isGroupsTabVisible(){
        try{
            return page.locator(groupsTab).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Groups tab not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public String getGroupsTabText(){
        try{
            return page.locator(groupsTab).textContent();
        }catch (PlaywrightException e){
            System.out.println("Groups -tab not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public void openGroups(){
        try{
            page.locator(groupsTab).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Groups -tab not found or not visible: " + e.getMessage());
        }
    }

    public boolean isEmailRecipientsTabVisible(){
        try{
            return page.locator(emailRecipientsTab).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Email recipients tab not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isEmailRecipientsTabEnabled(){
        try{
            return page.locator(emailRecipientsTab).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Email recipients tab not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public String getEmailRecipientsTabText(){
        try{
            return page.locator(emailRecipientsTab).textContent();
        }catch (PlaywrightException e){
            System.out.println("Email recipients tab not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public void viewEmailRecipients(){
        try{
            page.locator(emailRecipientsTab).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Email recipients tab not found or not visible: " + e.getMessage());
        }
    }
}