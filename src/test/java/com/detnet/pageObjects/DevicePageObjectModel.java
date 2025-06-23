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
    private final String deviceManagerField = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/add-device[1]/div[1]/form[1]/div[1]/div[1]/mat-form-field[6]/div[1]/div[2]/div[1]/mat-select[1]/div[1]/div[1]";
    private final String deviceManagerDropdownPanel = "//div[@id=\"managerId-panel\"]";
    private final String parentDeviceField = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/add-device[1]/div[1]/form[1]/div[1]/div[1]/mat-form-field[7]/div[1]/div[2]/div[1]/mat-select[1]/div[1]";
    private final String parentDeviceDropDownPanel = "//div[@id=\"parentId-panel\"]";
    private final String deviceGroupField = "//span[normalize-space()=\"Default Group\"]";
    private final String deviceGroupDropDown = "//div[@id=\"groupId-panel\"]";
    private final String editIcon = "//tbody/tr[4]/td[11]/div[1]/mat-icon[1]";
    private final String editDeviceTxt = "//h2[normalize-space()=\"Edit Device\"]";
    private final String saveUpdates = "//button[@id=\"addDeviceSubmitButton\"]//span[@class=\"mat-mdc-button-touch-target\"]";
    private final String searchBar = "//input[@placeholder=\"Search using ID, Location, IP\"]";
    private final String deleteIcon = "(//span[@class='mat-mdc-tooltip-trigger material-symbols-outlined ng-star-inserted'][normalize-space()='delete'])[1]";
    private final String deleteDialog = "//blastweb-confirmation-dialog[@class=\"ng-star-inserted\"]";
    private final String yesButton = "//button[@class=\"yesBtn\"]";
    private final String selectAllCheckbox = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-devices[1]/blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/table[1]/thead[1]/tr[1]/th[1]/mat-checkbox[1]/div[1]/div[1]/input[1]";
    private final String deleteAllButton = "//button[@class=\"deleteAllBtn\"]";

    public DevicePageObjectModel(Page page) {
        this.page = page;
    }

    public boolean isAddDeviceButtonVisible() {
        return page.locator(addDeviceButton).isVisible();
    }

    public boolean isAddDeviceButtonEnabled() {
        return page.locator(addDeviceButton).isEnabled();
    }

    public void addNewDevice() {
        page.locator(addDeviceButton).click();
    }

    public String getDevicesURL() {
        page.waitForURL("**/settings/devices");
        return page.url();
    }

    public boolean isAddDeviceFormOpen() {
        return page.locator(addDeviceForm).isVisible();
    }

    public boolean isDeviceIdFieldVisible() {
        return page.locator(deviceIdInput).isVisible();
    }

    public boolean isDeviceIdFieldEnabled() {
        return page.locator(deviceIdInput).isEnabled();
    }

    public boolean isDeviceIdFieldEmpty() {
        String deviceIdInputField = page.locator(deviceIdInput).inputValue();
        return deviceIdInputField == null || deviceIdInputField.trim().isEmpty();
    }

    public void setDeviceId(String deviceId) {
        page.locator(deviceIdInput).click();
        page.locator(deviceIdInput).fill(deviceId);
    }

    public String getDeviceId() {
        return page.locator(deviceIdInput).inputValue();
    }

    public boolean isLocationFieldVisible() {
        return page.locator(deviceLocationInput).isVisible();
    }

    public boolean isLocationFieldEnabled() {
        return page.locator(deviceLocationInput).isEnabled();
    }

    public boolean isLocationFieldEmpty() {
        String deviceLocationField = page.locator(deviceLocationInput).inputValue();
        return deviceLocationField == null || deviceLocationField.trim().isEmpty();
    }

    public void setLocation(String deviceLocation) {
        page.locator(deviceLocationInput).click();
        page.locator(deviceLocationInput).fill(deviceLocation);
    }

    public String getDeviceLocation() {
        return page.locator(deviceLocationInput).inputValue();
    }

    public boolean isNetworkFieldVisible() {
        return page.locator(deviceNetworkDropdown).isVisible();
    }

    public boolean isNetworkFieldEnabled() {
        return page.locator(deviceNetworkDropdown).isEnabled();
    }

    public void openDeviceNetworkDropDown() {
        page.locator(deviceNetworkDropdown).click();
    }

    public boolean isDeviceNetworkDropDownOpen() {
        try {
            page.locator(deviceNetworkPanel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public void selectNetwork(String network) {
        String networkRow = "(//span[@class='mdc-list-item__primary-text'][normalize-space()='" + network + "'])[1]";
        page.locator(networkRow).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isNetworkInterfaceFieldVisible() {
        return page.locator(deviceNetworkInterfaceDropDown).isVisible();
    }

    public boolean isNetworkInterfaceFieldEnabled() {
        return page.locator(deviceNetworkInterfaceDropDown).isEnabled();
    }

    public void openNetworkInterfaceDropDown() {
        page.locator(deviceNetworkInterfaceDropDown).click();
    }

    public boolean isNetworkInterfaceDropDownOpen() {
        try {
            page.locator(deviceNetworkInterfacePanel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public void selectNetworkInterface(String networkInterface) {
        String interfaceRow = "(//span[normalize-space()='" + networkInterface + "'])[1]";
        page.locator(interfaceRow).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isDeviceTypeFieldVisible() {
        return page.locator(deviceTypeField).isVisible();
    }

    public boolean isDeviceTypeFieldEnabled() {
        return page.locator(deviceTypeField).isEnabled();
    }

    public void openDeviceTypeDropDown() {
        page.locator(deviceTypeField).click();
    }

    public boolean isDeviceDropDownOpen() {
        try {
            page.locator(deviceTypePanel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public void selectDeviceType(String device) {
        String deviceType = "(//span[normalize-space()='" + device + "'])[1]";
        page.locator(deviceType).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isIpAddressFieldVisible() {
        return page.locator(ipInputField).isVisible();
    }

    public boolean isIpAddressFieldEnabled() {
        return page.locator(ipInputField).isEnabled();
    }

    public void setIpAddress(String ipAddress) {
        page.locator(ipInputField).click();
        page.locator(ipInputField).clear();
        page.locator(ipInputField).fill(ipAddress);
    }

    public boolean isIpAddressFieldEmpty() {
        String ipField = page.locator(ipInputField).inputValue();
        return ipField == null || ipField.trim().isEmpty();
    }

    public String getIpAddress() {
        return page.locator(ipInputField).inputValue();
    }

    public boolean isAddDeviceSubmitButtonVisible() {
        return page.locator(addDeviceSubmitButton).isVisible();
    }

    public boolean isSubmitButtonEnabled() {
        return page.locator(addDeviceSubmitButton).isEnabled();
    }

    public void addDevice() {
        page.locator(addDeviceSubmitButton).click(new Locator.ClickOptions().setTimeout(5000));
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
            return false;
        }
    }

    public boolean isDeviceManageFieldEnabled() {
        return page.locator(deviceManagerField).isEnabled();
    }

    public void openDeviceManageDropDown() {
        page.locator(deviceManagerField).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isDeviceManagerDropDownOpen() {
        try {
            page.locator(deviceManagerDropdownPanel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public void selectManager(String manager) {
        String panel = "(//span[normalize-space()='" + manager + "'])[1]";
        page.locator(panel).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isParentDeviceFieldVisible() {
        try {
            page.locator(parentDeviceField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public boolean isParentDeviceFieldEnabled() {
        return page.locator(parentDeviceField).isEnabled();
    }

    public void openParentDeviceDropDown() {
        page.locator(parentDeviceField).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isParentDeviceDropDownOpen() {
        try {
            page.locator(parentDeviceDropDownPanel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public void selectParentDevice(String device) {
        String parentDevicePath = "(//span[normalize-space()='" + device + "'])[1]";
        page.locator(parentDevicePath).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isDeviceGroupFieldVisible(){
        try{
            page.locator(deviceGroupField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isDeviceGroupFieldEnabled(){
        return page.locator(deviceGroupField).isEnabled();
    }

    public void openDeviceGroupDropDown(){
        page.locator(deviceGroupField).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isDeviceGroupDropDownOpen(){
        try{
            page.locator(deviceGroupDropDown)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public void selectDeviceGroup(String deviceGroup){
        String groupPath = "xpath=/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/mat-option[" + deviceGroup + "]/span[1]";
        page.locator(groupPath).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isEditIconVisible(){
        try{
            page.locator(editIcon)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isEditIconEnabled(){
        return page.locator(editIcon).isEnabled();
    }

    public void clickEditIcon(){
        page.locator(editIcon).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isEditPageVisible(){
        try{
            page.locator(editDeviceTxt)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public String getEditPageURL(){
        String url = "**/settings/devices/*/edit";
        page.waitForURL(url);
        return page.url();
    }

    public boolean isSaveButtonVisible(){
        try {
            page.locator(saveUpdates)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public void updateDeviceDetails(){
        page.locator(saveUpdates).click(new Locator.ClickOptions().setTimeout(5000));
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
            return false;
        }
    }

    public boolean isSearchBarEnabled(){
        return page.locator(searchBar).isEnabled();
    }

    public boolean isSearchBarEmpty(){
        String searchBarPath = page.locator(searchBar).inputValue();
        return searchBarPath == null || searchBarPath.trim().isEmpty();
    }

    public void searchDeviceById(String id){
        page.locator(searchBar).click();
        page.locator(searchBar).clear();
        page.locator(searchBar).fill(id);
    }

    public String getSearchedDeviceId(){
        return page.locator(searchBar).inputValue();
    }

    public void searchDeviceByLocation(String location){
        page.locator(searchBar).click();
        page.locator(searchBar).clear();
        page.locator(searchBar).fill(location);
    }

    public String getSearchedDeviceLocation(){
        return page.locator(searchBar).inputValue();
    }

    public void searchDeviceByIp(String ip){
        page.locator(searchBar).click();
        page.locator(searchBar).clear();
        page.locator(searchBar).fill(ip);
    }

    public String getSearchedDeviceIp(){
        return page.locator(searchBar).inputValue();
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
            return false;
        }
    }

    public boolean isDeleteIconEnabled(){
        return page.locator(deleteIcon).isEnabled();
    }

    public void openDeleteDialog(){
        page.locator(deleteIcon).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isDeviceDeleteDialogOpen(){
        try{
            page.locator(deleteDialog);
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public void confirmDelete(){
        page.locator(yesButton).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isDeviceDeleted(int deviceId){
        String deviceIdPath = "(//a[normalize-space()='" + deviceId + "'])[1]";
        try{
            page.locator(deviceIdPath)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.HIDDEN)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
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
            return false;
        }
    }

    public boolean isCheckboxEnabled(){
        return page.locator(selectAllCheckbox).isEnabled();
    }

    public void selectAllDevices(){
        page.locator(selectAllCheckbox).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public void selectOrDeselectDevices(int tableRow){
        String checkboxRow = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/settings-devices[1]/blastweb-spinner" +
                "[1]/blastweb-zero-data[1]/div[1]/table[1]/tbody[1]/tr[" + tableRow + "]/td[1]/mat-checkbox[1]/div[1]" +
                "/div[1]/input[1]";
        page.locator(checkboxRow).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isDeleteAllButtonVisible(){
        try{
            page.locator(deleteAllButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isDeleteAllButtonEnabled(){
        return page.locator(deleteAllButton).isEnabled();
    }

    public void deleteSelectedDevices(){
        page.locator(deleteAllButton).click(new Locator.ClickOptions().setTimeout(5000));
    }
}