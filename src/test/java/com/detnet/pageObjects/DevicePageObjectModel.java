package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.detnet.locators.DevicePageLocators.*;

public class DevicePageObjectModel {
    private final Page page;

    public DevicePageObjectModel(Page page) {
        this.page = page;
    }

    public boolean isAddDeviceButtonVisible() {
        try{
            return page.locator(addDeviceButton).isVisible();
        }catch (PlaywrightException e){
            System.out.println("'Add Device' -button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isAddDeviceButtonEnabled() {
        try{
            return page.locator(addDeviceButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Add Device' -button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void addNewDevice() {
        try{
            page.locator(addDeviceButton).click();
        }catch (PlaywrightException e){
            System.out.println("'Add Device' -button not found or not visible: " + e.getMessage());
        }
    }

    public String getDevicesURL() {
        try{
            page.waitForURL("**/settings/devices");
            return page.url();
        }catch (PlaywrightException e){
            System.out.println("URL not found or invalid: " + e.getMessage());
            return null;
        }
    }

    public boolean isAddDeviceFormOpen() {
        try{
            return page.locator(addDeviceForm).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Add device form not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeviceIdFieldVisible() {
        try{
            return page.locator(deviceIdInput).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Device Id input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeviceIdFieldEnabled() {
        try{
            return page.locator(deviceIdInput).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Device Id input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeviceIdFieldEmpty() {
        try{
            String deviceIdInputField = page.locator(deviceIdInput).inputValue();
            return deviceIdInputField == null || deviceIdInputField.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Device Id input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void setDeviceId(String deviceId) {
        try{
            page.locator(deviceIdInput).click();
            page.locator(deviceIdInput).fill(deviceId);
        }catch (PlaywrightException e){
            System.out.println("Device Id input field not found or not visible: " + e.getMessage());
        }
    }

    public String getDeviceId() {
        try{
            return page.locator(deviceIdInput).inputValue();
        }catch (PlaywrightException e){
            System.out.println("Device Id input field not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public boolean isLocationFieldVisible() {
        try{
            return page.locator(deviceLocationInput).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Device location input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isLocationFieldEnabled() {
        try{
            return page.locator(deviceLocationInput).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Device location input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isLocationFieldEmpty() {
        try{
            String deviceLocationField = page.locator(deviceLocationInput).inputValue();
            return deviceLocationField == null || deviceLocationField.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Device location input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void setLocation(String deviceLocation) {
        try{
            page.locator(deviceLocationInput).click();
            page.locator(deviceLocationInput).fill(deviceLocation);
        }catch (PlaywrightException e){
            System.out.println("Device location input field not visible or not found: " + e.getMessage());
        }
    }

    public String getDeviceLocation() {
        try{
            return page.locator(deviceLocationInput).inputValue();
        }catch (PlaywrightException e){
            System.out.println("Device location input field not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public boolean isNetworkFieldVisible() {
        try{
            return page.locator(deviceNetworkDropdown).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Device network dropdown not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isNetworkFieldEnabled() {
        try{
            return page.locator(deviceNetworkDropdown).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Device network dropdown not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void openDeviceNetworkDropDown() {
        try{
            page.locator(deviceNetworkDropdown).click();
        }catch (PlaywrightException e){
            System.out.println("Device network dropdown not visible or not found: " + e.getMessage());
        }
    }

    public boolean isDeviceNetworkDropDownOpen() {
        try {
            page.locator(deviceNetworkPanel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Network panel not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void selectNetwork(String network) {
        try{
            String networkRow = "(//span[@class='mdc-list-item__primary-text'][normalize-space()='" + network + "'])[1]";
            page.locator(networkRow).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Network row not found or not visible: " + e.getMessage());
        }
    }

    public boolean isNetworkInterfaceFieldVisible() {
        try{
            return page.locator(deviceNetworkInterfaceDropDown).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Network interface not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isNetworkInterfaceFieldEnabled() {
        try{
            return page.locator(deviceNetworkInterfaceDropDown).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Network interface not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void openNetworkInterfaceDropDown() {
        try{
            page.locator(deviceNetworkInterfaceDropDown).click();
        }catch (PlaywrightException e){
            System.out.println("Network interface not found or not visible: " + e.getMessage());
        }
    }

    public boolean isNetworkInterfaceDropDownOpen() {
        try {
            page.locator(deviceNetworkInterfacePanel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Network interface panel not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void selectNetworkInterface(String networkInterface) {
        try{
            String interfaceRow = "(//span[normalize-space()='" + networkInterface + "'])[1]";
            page.locator(interfaceRow).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Network interface not found or not not visible: " + e.getMessage());
        }
    }

    public boolean isDeviceTypeFieldVisible() {
        try {
            return page.locator(deviceTypeField).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Device type input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeviceTypeFieldEnabled() {
        try{
            return page.locator(deviceTypeField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Device type input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void openDeviceTypeDropDown() {
        try{
            page.locator(deviceTypeField).click();
        }catch (PlaywrightException e){
            System.out.println("Device type input field not visible or not found: " + e.getMessage());
        }
    }

    public boolean isDeviceDropDownOpen() {
        try {
            page.locator(deviceTypePanel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Device type panel not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void selectDeviceType(String device) {
        try{
            String deviceType = "(//span[normalize-space()='" + device + "'])[1]";
            page.locator(deviceType).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Device type is not found or visible in the dropdown menu: " + e.getMessage());
        }
    }

    public boolean isIpAddressFieldVisible() {
        try{
            return page.locator(ipInputField).isVisible();
        }catch (PlaywrightException e){
            System.out.println("IP address field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isIpAddressFieldEnabled() {
        try{
            return page.locator(ipInputField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("IP input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void setIpAddress(String ipAddress) {
        try{
            page.locator(ipInputField).click();
            page.locator(ipInputField).clear();
            page.locator(ipInputField).fill(ipAddress);
        }catch (PlaywrightException e){
            System.out.println("IP input field not visible or not found: " + e.getMessage());
        }
    }

    public boolean isIpAddressFieldEmpty() {
        try{
            String ipField = page.locator(ipInputField).inputValue();
            return ipField == null || ipField.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("IP input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public String getIpAddress() {
        try{
            return page.locator(ipInputField).inputValue();
        }catch (PlaywrightException e){
            System.out.println("IP input field not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public boolean isAddDeviceSubmitButtonVisible() {
        try{
            return page.locator(addDeviceSubmitButton).isVisible();
        }catch (PlaywrightException e){
            System.out.println("'Add Device' -button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSubmitButtonEnabled() {
        try{
            return page.locator(addDeviceSubmitButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Submit button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void addDevice() {
        try{
            page.locator(addDeviceSubmitButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Device submit button not found or not visible: " + e.getMessage());
        }
    }

    public boolean isDeviceAdded(String ip) {
        String deviceIp = "(//td[normalize-space()='" + ip + "'])[1]";
        try {
            page.locator(deviceIp)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Device IP not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isDevicesVisible(int tableRow) {
        String rowNumberPath = "//body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-devices[1]/blastweb-spinner[1]/" +
                "blastweb-zero-data[1]/div[1]/table[1]/tbody[1]/tr[" + tableRow + "]";
        try {
            page.locator(rowNumberPath)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Row number not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeviceManagerFieldVisible() {
        try {
            page.locator(deviceManagerField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Device manager input field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeviceManageFieldEnabled() {
        try{
            return page.locator(deviceManagerField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Device manager field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void openDeviceManageDropDown() {
        try{
            page.locator(deviceManagerField).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Device manager input field not found or not visible: " + e.getMessage());
        }
    }

    public boolean isDeviceManagerDropDownOpen() {
        try {
            page.locator(deviceManagerDropdownPanel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Device manager dropdown not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void selectManager(String manager) {
        try{
            String panel = "(//span[normalize-space()='" + manager + "'])[1]";
            page.locator(panel).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Manager panel not found or not visible on the dropdown: " + e.getMessage());
        }
    }

    public boolean isParentDeviceFieldVisible() {
        try {
            page.locator(parentDeviceField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Parent device field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isParentDeviceFieldEnabled() {
        try{
            return page.locator(parentDeviceField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Parent device field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void openParentDeviceDropDown() {
        try{
            page.locator(parentDeviceField).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Parent device field not found or not visible: " + e.getMessage());
        }
    }

    public boolean isParentDeviceDropDownOpen() {
        try {
            page.locator(parentDeviceDropDownPanel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Parent device dropdown not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void selectParentDevice(String device) {
        try{
            String parentDevicePath = "(//span[normalize-space()='" + device + "'])[1]";
            page.locator(parentDevicePath).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Parent device path not found or not visible: " + e.getMessage());
        }
    }

    public boolean isDeviceGroupFieldVisible(){
        try{
            page.locator(deviceGroupField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Device group field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeviceGroupFieldEnabled(){
        try{
            return page.locator(deviceGroupField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Device group field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void openDeviceGroupDropDown(){
        try{
            page.locator(deviceGroupField).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Device group field not found or not visible: " + e.getMessage());
        }
    }

    public boolean isDeviceGroupDropDownOpen(){
        try{
            page.locator(deviceGroupDropDown)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Device group dropdown not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void selectDeviceGroup(String deviceGroup){
        try{
            String groupPath = "xpath=/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/mat-option[" + deviceGroup + "]/span[1]";
            page.locator(groupPath).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Device group not found or not visible: " + e.getMessage());
        }
    }

    public boolean isEditIconVisible(){
        try{
            page.locator(editIcon)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Edit icon not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isEditIconEnabled(){
        try{
            return page.locator(editIcon).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Edit icon not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void clickEditIcon(){
        try{
            page.locator(editIcon).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Edit icon not found or not visible: " + e.getMessage());
        }
    }

    public boolean isEditPageVisible(){
        try{
            page.locator(editDeviceTxt)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Edit device page not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public String getEditPageURL(){
        try{
            String url = "**/settings/devices/*/edit";
            page.waitForURL(url);
            return page.url();
        }catch (PlaywrightException e){
            System.out.println("URL not found or not valid: " + e.getMessage());
            return null;
        }
    }

    public boolean isSaveButtonVisible(){
        try {
            page.locator(saveUpdates)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Save button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void updateDeviceDetails(){
        try{
            page.locator(saveUpdates).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Save button not found or not visible: " + e.getMessage());
        }
    }

    public boolean isDeviceLocationUpdated(String location){
       String updatedLocation = "(//td[normalize-space()='" + location + "'])[1]";
       try{
           page.locator(updatedLocation)
                   .waitFor(new Locator.WaitForOptions()
                           .setState(WaitForSelectorState.VISIBLE)
                           .setTimeout(5000));
           return true;
       }catch (PlaywrightException e){
           System.out.println("Location not found or not visible: " + e.getMessage());
           return false;
       }
    }

    public boolean isSearchBarVisible(){
        try{
            page.locator(searchBar)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSearchBarEnabled(){
        try{
            return page.locator(searchBar).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSearchBarEmpty(){
        try{
            String searchBarPath = page.locator(searchBar).inputValue();
            return searchBarPath == null || searchBarPath.trim().isEmpty();
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void searchDeviceById(String id){
        try{
            page.locator(searchBar).click();
            page.locator(searchBar).clear();
            page.locator(searchBar).fill(id);
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
        }
    }

    public String getSearchedDeviceId(){
        try{
            return page.locator(searchBar).inputValue();
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public void searchDeviceByLocation(String location){
        try{
            page.locator(searchBar).click();
            page.locator(searchBar).clear();
            page.locator(searchBar).fill(location);
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
        }
    }

    public String getSearchedDeviceLocation(){
        try{
            return page.locator(searchBar).inputValue();
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public void searchDeviceByIp(String ip){
        try{
            page.locator(searchBar).click();
            page.locator(searchBar).clear();
            page.locator(searchBar).fill(ip);
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
        }
    }

    public String getSearchedDeviceIp(){
        try{
            return page.locator(searchBar).inputValue();
        }catch (PlaywrightException e){
            System.out.println("Search bar not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public boolean isSearchedDeviceFound(String deviceName){
        String devicePath = "(//td[normalize-space()='" + deviceName + "'])[1]";
        try{
            page.locator(devicePath)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Device name not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeleteIconVisible(){
        try{
            page.locator(deleteIcon)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Delete icon not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeleteIconEnabled(){
        try{
            return page.locator(deleteIcon).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Delete icon not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void openDeleteDialog(){
        try{
            page.locator(deleteIcon).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Delete icon not visible or not found: " + e.getMessage());
        }
    }

    public boolean isDeviceDeleteDialogOpen(){
        try{
            page.locator(deleteDialog);
            return true;
        }catch (PlaywrightException e){
            System.out.println("Delete dialog not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void confirmDelete(){
        try{
            page.locator(yesButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Yes' -button not visible or not found: " + e.getMessage());
        }
    }

    public boolean isDeviceDeleted(String deviceLocation){
        String deviceLocationPath = "(//td[normalize-space()='" + deviceLocation + "'])[1]";
        try{
            page.locator(deviceLocationPath)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.HIDDEN)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Device location not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSelectAllCheckboxVisible(){
        try{
            page.locator(selectAllCheckbox)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'Select All' -checkbox not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isCheckboxEnabled(){
        try{
            return page.locator(selectAllCheckbox).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Select All' -checkbox not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void selectAllDevices(){
        try{
            page.locator(selectAllCheckbox).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Select All' -checkbox not found or not visible: " + e.getMessage());
        }
    }

    public void selectOrDeselectDevices(int tableRow){
        try{
            String checkboxRow = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-devices[1]/blastweb-spinner" +
                    "[1]/blastweb-zero-data[1]/div[1]/table[1]/tbody[1]/tr[" + tableRow + "]/td[1]/mat-checkbox[1]/div[1]" +
                    "/div[1]/input[1]";
            page.locator(checkboxRow).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Checkbox is not visible or not found: " + e.getMessage());
        }
    }

    public boolean isDeleteAllButtonVisible(){
        try{
            page.locator(deleteAllButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'Delete All' -button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeleteAllButtonEnabled(){
        try{
            return page.locator(deleteAllButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Delete All' -button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void deleteSelectedDevices(){
        try{
            page.locator(deleteAllButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Delete All' -button not visible or not found: " + e.getMessage());
        }
    }

    public void scrollToBottom(){
        try{
            page.evaluate("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' })");
        }catch (PlaywrightException e){
            System.out.println("Unable to scroll to bottom of the screen. Make sure logic is correct: " + e.getMessage());
        }
    }
}