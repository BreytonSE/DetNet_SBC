package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

public class DevicePageObjectModel {
    private final Page page;
    private final String addDeviceButton = "//button[@class=\"addBtn ng-star-inserted\"]";
    private final String addDeviceForm = "//h2[normalize-space()=\"Add Device\"]";
    private final String deviceIdInput = "//input[@id=\"id\"]";
    private final String deviceLocationInput = "//input[@id=\"location\"]";
    private final String deviceNetworkDropdown = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/add-device[1]/div[1]/form[1]/div[1]/div[1]/mat-form-field[3]/div[1]/div[2]/div[1]/mat-select[1]/div[1]/div[1]/span[1]";
    private final String deviceNetworkPanel = "//div[@id=\"networkId-panel\"]";
    private final String deviceNetworkInterfaceDropDown = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/add-device[1]/div[1]/form[1]/div[1]/div[1]/mat-form-field[4]/div[1]/div[2]/div[1]/mat-select[1]/div[1]/div[1]";
    private final String deviceNetworkInterfacePanel = "//div[@id=\"method-panel\"]";
    private final String deviceTypeField = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/add-device[1]/div[1]/form[1]/div[1]/div[1]/mat-form-field[5]/div[1]/div[2]/div[1]/mat-select[1]/div[1]/div[1]";
    private final String deviceTypePanel = "//div[@id=\"deviceType-panel\"]";
    private final String ipInputField = "//input[@id=\"ipAddress\"]";
    private final String addDeviceSubmitButton = "//button[@id=\"addDeviceSubmitButton\"]//span[@class=\"mat-mdc-button-touch-target\"]";

    public DevicePageObjectModel(Page page) {
        this.page = page;
    }

    public boolean isAddDeviceButtonVisible(){
        return page.locator(addDeviceButton).isVisible();
    }

    public boolean isAddDeviceButtonEnabled(){
        return page.locator(addDeviceButton).isEnabled();
    }

    public void addNewDevice(){
     page.locator(addDeviceButton).click();
    }

    public String getDevicesURL(){
        page.waitForURL("**/settings/devices");
        return page.url();
    }

    public boolean isAddDeviceFormOpen(){
        return page.locator(addDeviceForm).isVisible();
    }

    public boolean isDeviceIdFieldVisible(){
        return page.locator(deviceIdInput).isVisible();
    }

    public boolean isDeviceIdFieldEnabled(){
        return page.locator(deviceIdInput).isEnabled();
    }

    public boolean isDeviceIdFieldEmpty(){
        String deviceIdInputField = page.locator(deviceIdInput).inputValue();
        return deviceIdInputField == null || deviceIdInputField.trim().isEmpty();
    }

    public void setDeviceId(String deviceId){
        page.locator(deviceIdInput).click();
        page.locator(deviceIdInput).fill(deviceId);
    }

    public String getDeviceId(){
        return page.locator(deviceIdInput).inputValue();
    }

    public boolean isLocationFieldVisible(){
        return page.locator(deviceLocationInput).isVisible();
    }

    public boolean isLocationFieldEnabled(){
        return page.locator(deviceLocationInput).isEnabled();
    }

    public boolean isLocationFieldEmpty(){
        String deviceLocationField = page.locator(deviceLocationInput).inputValue();
        return deviceLocationField == null || deviceLocationField.trim().isEmpty();
    }

    public void setLocation(String deviceLocation){
        page.locator(deviceLocationInput).click();
        page.locator(deviceLocationInput).fill(deviceLocation);
    }

    public String getDeviceLocation(){
        return page.locator(deviceLocationInput).inputValue();
    }

    public boolean isNetworkFieldVisible(){
        return page.locator(deviceNetworkDropdown).isVisible();
    }

    public boolean isNetworkFieldEnabled(){
        return page.locator(deviceNetworkDropdown).isEnabled();
    }

    public void openDeviceNetworkDropDown(){
        page.locator(deviceNetworkDropdown).click();
    }

    public boolean isDeviceNetworkDropDownOpen(){
        try{
            page.locator(deviceNetworkPanel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public void selectNetwork(String network) {
        String networkRow = "(//span[@class='mdc-list-item__primary-text'][normalize-space()='" + network + "'])[1]";
        page.locator(networkRow).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isNetworkInterfaceFieldVisible(){
        return page.locator(deviceNetworkInterfaceDropDown).isVisible();
    }

    public boolean isNetworkInterfaceFieldEnabled(){
        return page.locator(deviceNetworkInterfaceDropDown).isEnabled();
    }

    public void openNetworkInterfaceDropDown(){
        page.locator(deviceNetworkInterfaceDropDown).click();
    }

    public boolean isNetworkInterfaceDropDownOpen(){
        try{
            page.locator(deviceNetworkInterfacePanel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public void selectNetworkInterface(String networkInterface){
        String interfaceRow = "(//span[normalize-space()='" + networkInterface + "'])[1]";
        page.locator(interfaceRow).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isDeviceTypeFieldVisible(){
        return page.locator(deviceTypeField).isVisible();
    }

    public boolean isDeviceTypeFieldEnabled(){
        return page.locator(deviceTypeField).isEnabled();
    }

    public void openDeviceTypeDropDown(){
        page.locator(deviceTypeField).click();
    }

    public boolean isDeviceDropDownOpen(){
        try{
            page.locator(deviceTypePanel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public void selectDeviceType(String device){
        String deviceType = "(//span[normalize-space()='" + device + "'])[1]";
        page.locator(deviceType).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isIpAddressFieldVisible(){
        return page.locator(ipInputField).isVisible();
    }

    public boolean isIpAddressFieldEnabled(){
        return page.locator(ipInputField).isEnabled();
    }

    public void setIpAddress(String ipAddress){
        page.locator(ipInputField).click();
        page.locator(ipInputField).clear();
        page.locator(ipInputField).fill(ipAddress);
    }

    public boolean isIpAddressFieldEmpty(){
        String ipField = page.locator(ipInputField).inputValue();
        return ipField == null || ipField.trim().isEmpty();
    }

    public String getIpAddress(){
        return page.locator(ipInputField).inputValue();
    }

    public boolean isAddDeviceSubmitButtonVisible(){
        return page.locator(addDeviceSubmitButton).isVisible();
    }

    public boolean isSubmitButtonEnabled(){
        return page.locator(addDeviceSubmitButton).isEnabled();
    }

    public void addDevice(){
        page.locator(addDeviceSubmitButton).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isDeviceAdded(String ip){
        String deviceIp = "(//td[normalize-space()='" + ip + "'])[1]";
        try{
            page.locator(deviceIp)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }
}