package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DashboardPageObjectModel {
    private final Page page;
    private final String userRoleLabel = "//p[@class='userRole']";
    private final String navigationMenu = "#mat-menu-panel-2";
    private final String logoutButton = "//span[contains(text(),'Logout')]";
    private final String settingsButton = "//span[contains(text(),'Settings')]";
    private final String dashboardButton = "//span[contains(text(),\"Dashboard\")]";
    private final String deviceDetailsButton = "//body[1]/app-root[1]/dashboard[1]/blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/div[2]/div[1]/div[1]/bcu-card-high-detail[1]/mat-card[1]/div[5]\n";
    private final String newDevice = "(//span[normalize-space()='Cape Town'])[1]";
    private final String eventsButton = "//button[@class=\"fixedButton mdc-button mdc-button--unelevated mat-mdc-unelevated-button mat-primary mat-mdc-button-base\"]//span[@class=\"mat-mdc-button-touch-target\"]";
    private final String eventsLog = "//tr[@class=\"mat-mdc-header-row mdc-data-table__header-row cdk-header-row ng-star-inserted\"]";
    private final String offsetToolTip = "//img[@class=\"mat-mdc-tooltip-trigger offsetButton ng-star-inserted\"]";
    private final String offsetHeader = "//h3[normalize-space()=\"Offset Channels\"]";
    private final String saveButton = "//button[@type=\"submit\"]";
    private final String groupByDropDown = "xpath=/html[1]/body[1]/app-root[1]/dashboard[1]/blastweb-spinner[1]/div[1]/div[1]/div[2]/form[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[2]";
    private final String groupByDropDownPanel = "//div[@id=\"deviceGroupingFunctionSelector-panel\"]";
    private final String alertDropdownButton = "//body[1]/app-root[1]/blastweb-navbar[1]/mat-toolbar[1]/mat-toolbar-row[1]/button[3]/span[2]/mat-toolbar-row[1]";
    private final String reportsTab = "//span[normalize-space()=\"Reports\"]";
    private final String eventsReportButton = "//span[contains(text(),\"Events report\")]";
    private final String keyElement = "(//span[normalize-space()='-  Key'])[1]";
    private final String networkElement = "(//span[normalize-space()='-  Network'])[1]";
    private final String stateElement = "(//span[normalize-space()='-  State'])[1]";
    private final String firmwareElement = "(//span[normalize-space()='-  Firmware'])[1]";
    private final String customElement = "(//span[normalize-space()='-  Custom'])[1]";
    private final String selectedElement = "(//span[normalize-space()='-  Selected'])[1]";
    private final String aliveElement = "(//span[normalize-space()='-  Alive'])[1]";
    private final String typeLocator = "(//span[normalize-space()='-  Type'])[1]";
    private final String selectAllCheckbox = "xpath=/html[1]/body[1]/app-root[1]/dashboard[1]/blastweb-spinner[1]/div[1]/div[1]/div[2]/form[1]/div[3]/mat-toolbar-row[1]/mat-checkbox[1]/div[1]/div[1]/input[1]";
    private final String plusIcon = "xpath=/html[1]/body[1]/app-root[1]/dashboard[1]/blastweb-spinner[1]/div[1]/div[1]/div[3]/action-panel[1]/speed-dial-fab[1]/div[1]/button[1]/span[5]";
    private final String actionPanel = "//div[@class=\"column ng-trigger ng-trigger-speedDialStagger\"]";
    private final String armSelectedButton = "xpath=/html[1]/body[1]/app-root[1]/dashboard[1]/blastweb-spinner[1]/div[1]/div[1]/div[3]/action-panel[1]/speed-dial-fab[1]/div[2]/div[1]/div[1]/div[1]/button[1]/span[5]\n";
    private final String armSelectedLabel = "//button[normalize-space()=\"Arm Selected (1)\"]";
    private final String readyToBlastElement = "//span[contains(text(),\"READY TO BLAST\")]\n";

    public DashboardPageObjectModel(Page page) {
        this.page = page;
    }

    public boolean isDashboardPageOpen() {
        try {
            page.locator(dashboardButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public String getDashboardLabelName() {
        return page.locator(dashboardButton).textContent();
    }

    public String getDashboardURL() {
        page.waitForURL("**/dashboard");
        return page.url();
    }

    public boolean isUserRoleLabelVisible() {
        return page.locator(userRoleLabel).isVisible();
    }

    public String getUserRoleLabel() {
        return page.locator(userRoleLabel).textContent();
    }

    public void openNavigationMenu() {
        page.locator(userRoleLabel).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isNavigationMenuOpen() {
        return page.locator(navigationMenu).isVisible();
    }

    public boolean isLogoutButtonVisible() {
        return page.locator(logoutButton).isVisible();
    }

    public boolean isLogoutButtonEnabled() {
        return page.locator(logoutButton).isEnabled();
    }

    public void logOut() {
        page.locator(logoutButton).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public void openSettings() {
        page.locator(settingsButton).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isSettingsButtonVisible() {
        return page.locator(settingsButton).isVisible();
    }

    public boolean isSettingsButtonEnabled() {
        return page.locator(settingsButton).isEnabled();
    }

    public boolean isDashboardButtonEnabled() {
        return page.locator(dashboardButton).isEnabled();
    }

    public void goToDashboard() {
        page.locator(dashboardButton).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isViewDeviceDetailsButtonVisible() {
        try {
            page.locator(deviceDetailsButton).waitFor(new Locator.WaitForOptions().setTimeout(5000));
            return page.locator(deviceDetailsButton).isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isViewDetailsButtonEnabled() {
        return page.locator(deviceDetailsButton).isEnabled();
    }

    public void viewDeviceDetails(int deviceNumber) {
        String device = "//body[1]/app-root[1]/dashboard[1]/blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/div[2]/div[" +
                "1]/div[" + deviceNumber + "]/bcu-card-high-detail[1]/mat-card[1]/div[5]";
        page.locator(device).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isNewDeviceOnDashboard() {
        return page.locator(newDevice).isVisible();
    }

    public boolean isEventsButtonVisible() {
        try {
            page.locator(eventsButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public void openEventLogs() {
        page.locator(eventsButton).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isEventsLogOpen() {
        try {
            page.locator(eventsLog)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public String getDeviceCurrentState() {
        List<String> possibleStates = Arrays.asList("IDLE", "UNKNOWN", "READY TO BLAST", "READY TO ARM");

        List<String> matchedStates = page
                .locator("//span[contains(text(), 'IDLE') or contains(text(), 'UNKNOWN') or contains(text(), " +
                        "'READY TO BLAST') or contains(text(), 'READY TO ARM') or contains(text(), 'AWAITING GRACE')]")
                .allTextContents()
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());

        for (String expectedState : possibleStates) {
            if (matchedStates.contains(expectedState)) {
                System.out.println("Found device state: " + expectedState);
                return expectedState; // ✅ return here
            }
        }

        // Optional: if no match found, return null or throw exception
        return null;
    }

    public boolean isOffsetToolTipVisible() {
        try {
            page.locator(offsetToolTip)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public boolean isOffsetToolTipEnabled() {
        return page.locator(offsetToolTip).isEnabled();
    }

    public void openOffsetChannelWindow() {
        page.locator(offsetToolTip).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isChannelOffsetWindowOpen() {
        try {
            page.locator(offsetHeader)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public boolean isSixChannelFieldsVisible(String channelNumber) {
        String channelPath = "(//span[normalize-space()='" + channelNumber + "'])[1]";
        try {
            page.locator(channelPath)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public boolean isChannelOffsetDelayFieldVisible(String channelOffsetDelayField) {
        String offsetDelayField = "xpath=/html[1]/body[1]/div[3]/div[2]/div[1]/mat-dialog-container[1]/div[1]/div[1]/app-" +
                "channel-offset-dialog[1]/div[1]/div[2]/div[" + channelOffsetDelayField + "]/div[3]/input[1]\n";
        try {
            page.locator(offsetDelayField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public boolean isChannelOffsetDelayFieldEnabled(String channelOffsetDelayField) {
        String offsetDelayField = "xpath=/html[1]/body[1]/div[3]/div[2]/div[1]/mat-dialog-container[1]/div[1]/div[1]/app-" +
                "channel-offset-dialog[1]/div[1]/div[2]/div[" + channelOffsetDelayField + "]/div[3]/input[1]\n";
        return page.locator(offsetDelayField).isEnabled();
    }

    public void setOffSetDelay(String channelNumber, int delay) {
        String offsetDelayField = "xpath=/html[1]/body[1]/div[3]/div[2]/div[1]/mat-dialog-container[1]/div[1]/div[1]/" +
                "app-channel-offset-dialog[1]/div[1]/div[2]/div[" + channelNumber + "]/div[3]/input[1]\n";
        page.locator(offsetDelayField).click();
        page.locator(offsetDelayField).clear();
        page.locator(offsetDelayField).fill(String.valueOf(delay));
    }

    public boolean isSaveButtonVisible() {
        try {
            page.locator(saveButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public boolean isSaveButtonEnabled() {
        return page.locator(saveButton).isEnabled();
    }

    public void saveOffsetChannel() {
        page.locator(saveButton).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isGroupByDropDownVisible() {
        try {
            page.locator(groupByDropDown)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public boolean isGroupByDropDownEnabled() {
        return page.locator(groupByDropDown).isEnabled();
    }

    public void openGroupByDropDown() {
        page.locator(groupByDropDown).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isGroupByDownOpen() {
        try {
            page.locator(groupByDropDownPanel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public void selectGroupByOption(String group){
        String groupBy = "(//span[normalize-space()='-  " + group + "'])[1]";
        page.locator(groupBy).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isAlertDropDownButtonVisible() {
        try {
            page.locator(alertDropdownButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public boolean isAlertDropDownButtonEnabled() {
        return page.locator(alertDropdownButton).isEnabled();
    }

    public void openAlertDropDown() {
        page.locator(alertDropdownButton).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public List<String> getAllCurrentDeviceAlerts() {
        List<String> knownAlerts = Arrays.asList(
                "Short Circuits", "High Leakage", "High Current", "Low Battery", "Acknowledge Alert", "Device Not Available",
                "Last Detonator Bad", "Last Detonator Bad Voltage", "Harness Break", "Programming Error",
                "Test Mode", "TX Error Preventing Blast");

//        Build xpath dynamically using 'or' conditions
        String dynamicConditions = knownAlerts.stream()
                .map(alert -> "normalize-space()='" + alert + "'")
                .collect(Collectors.joining(" or "));

        String deviceAlertXpath = "//span[@class='titlecase' or " + dynamicConditions + "]";

        List<String> rawAlerts = page.locator(deviceAlertXpath).allTextContents();

        return rawAlerts.stream()
                .map(String::trim)
                .filter(knownAlerts::contains)
                .collect(Collectors.toList());
    }

    public void refreshBrowserTab() {
        page.reload();
    }

    public boolean isReportTabVisible() {
        try {
            page.locator(reportsTab)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }

    public boolean isReportTabEnabled(){
        return page.locator(reportsTab).isEnabled();
    }

    public void openReportTab(){
        page.locator(reportsTab).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isReportsDropDownOpen(){
        try{
            page.locator(eventsReportButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public void openEventsReport(){
        page.locator(eventsReportButton).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isErrorPresentOnEventsReport(String event){
        String error = "(//p[normalize-space()='" + event + "'])[1]";
        try{
            page.locator(error)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isAlertRemoved(String alert){
        String alertPath = "(//span[normalize-space()='" + alert + "'])[1]";
        try{
            page.locator(alertPath)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.HIDDEN)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isDeviceGroupedByKey(){
        try{
            page.locator(keyElement)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isDeviceGroupedByNetwork(){
        try{
            page.locator(networkElement)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isDeviceGroupedByState(){
        try{
            page.locator(stateElement)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isDeviceGroupedByFirmware(){
        try{
            page.locator(firmwareElement)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isDeviceGroupedByCustom(){
        try{
            page.locator(customElement)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isDeviceGroupedBySelected(){
        try{
            page.locator(selectedElement)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isDeviceGroupedByAlive(){
        try{
            page.locator(aliveElement)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isDeviceGroupedByType(){
        try{
            page.locator(typeLocator)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isDeviceCheckBoxVisible(int checkboxNumber){
        String checkBoxPath = "xpath=/html[1]/body[1]/app-root[1]/dashboard[1]/blastweb-spinner[1]/blastweb-zero-data[1]" +
                "/div[1]/div[2]/div[1]/div[" + checkboxNumber + "]/bcu-card-high-detail[1]/mat-card[1]/div[1]/div[1]/mat-checkbox[1]/div[1]/" +
                "div[1]/input[1]";
        try{
            page.locator(checkBoxPath)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isDeviceCheckboxEnabled(int checkBoxNumber){
        String checkBoxPath = "xpath=/html[1]/body[1]/app-root[1]/dashboard[1]/blastweb-spinner[1]/blastweb-zero-data[1]" +
                "/div[1]/div[2]/div[1]/div[" + checkBoxNumber + "]/bcu-card-high-detail[1]/mat-card[1]/div[1]/div[1]/mat-checkbox[1]/div[1]/" +
                "div[1]/input[1]";
        return page.locator(checkBoxPath).isEnabled();
    }

    public void selectOrDeselectDevice(int checkboxNumber){
        String checkBoxPath = "xpath=/html[1]/body[1]/app-root[1]/dashboard[1]/blastweb-spinner[1]/blastweb-zero-data[1]" +
                "/div[1]/div[2]/div[1]/div[" + checkboxNumber + "]/bcu-card-high-detail[1]/mat-card[1]/div[1]/div[1]/mat-checkbox[1]/div[1]/" +
                "div[1]/input[1]";
        page.locator(checkBoxPath).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isDeviceSelected(int checkboxNumber){
        String checkBoxPath = "xpath=/html[1]/body[1]/app-root[1]/dashboard[1]/blastweb-spinner[1]/blastweb-zero-data[1]" +
                "/div[1]/div[2]/div[1]/div[" + checkboxNumber + "]/bcu-card-high-detail[1]/mat-card[1]/div[1]/div[1]/mat-checkbox[1]/div[1]/" +
                "div[1]/input[1]";
        return page.locator(checkBoxPath).isChecked();
    }

    public boolean isDeviceDeselected(int checkBoxNumber){
        String checkBoxPath = "xpath=/html[1]/body[1]/app-root[1]/dashboard[1]/blastweb-spinner[1]/blastweb-zero-data[1]" +
                "/div[1]/div[2]/div[1]/div[" + checkBoxNumber + "]/bcu-card-high-detail[1]/mat-card[1]/div[1]/div[1]/mat-checkbox[1]/div[1]/" +
                "div[1]/input[1]";
        return !page.locator(checkBoxPath).isChecked();
    }

    public boolean isSelectAllCheckBoxVisible(){
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

    public boolean isSelectAllCheckBoxEnabled(){
        return page.locator(selectAllCheckbox).isEnabled();
    }

    public void selectAllDevices(){
        page.locator(selectAllCheckbox).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isAllDevicesChecked(){
        return page.locator(selectAllCheckbox).isChecked();
    }

    public boolean isOffsetActive(){
        Locator offsetImage = page.locator(offsetToolTip);
        String src = offsetImage.getAttribute("src");
        return src != null && src.contains("active");
    }

    public boolean isPlusIconVisible(){
        try{
            page.locator(plusIcon)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isPlusIconEnabled(){
        return page.locator(plusIcon).isEnabled();
    }

    public void openActionPanel(){
        page.locator(plusIcon).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isActionPanelOpen(){
        try{
            page.locator(actionPanel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isArmSelectedButtonVisible(){
        try{
            page.locator(armSelectedLabel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));

            page.locator(armSelectedButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public void armSelectedDevice(){
        page.locator(armSelectedButton).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isDeviceReadyToBlast(){
        try{
            page.locator(readyToBlastElement)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }
}