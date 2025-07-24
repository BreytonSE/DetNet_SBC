package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.detnet.locators.DashboardPageLocators.*;

public class DashboardPageObjectModel {
    private final Page page;

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
        try{
            return page.locator(dashboardButton).textContent();
        }catch (PlaywrightException e){
            System.out.println("Dashboard button not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public String getDashboardURL() {
        try{
            page.waitForURL("**/dashboard");
            return page.url();
        }catch (PlaywrightException e){
            System.out.println("URL for dashboard page not found or not visible: " + e.getMessage());
            return null;
        }
    }

    public boolean isUserRoleLabelVisible() {
        try {
            return page.locator(userRoleLabel).isVisible();
        }catch (PlaywrightException e){
            System.out.println("User role label not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public String getUserRoleLabel() {
        try{
            return page.locator(userRoleLabel).textContent();
        }catch (PlaywrightException e){
            System.out.println("User role label not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public void openNavigationMenu() {
        try{
            page.locator(userRoleLabel).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("User role label not found or not visible: " + e.getMessage());
        }
    }

    public boolean isNavigationMenuOpen() {
        try{
            return page.locator(navigationMenu).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Navigation menu not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isLogoutButtonVisible() {
        try{
            return page.locator(logoutButton).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Logout button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isLogoutButtonEnabled() {
        try{
            return page.locator(logoutButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Logout button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void logOut() {
        try{
            page.locator(logoutButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Logout button not found or not visible: " + e.getMessage());
        }
    }

    public void openSettings() {
        try{
            page.locator(settingsButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch(PlaywrightException e){
            System.out.println("Settings button not found or not visible: " + e.getMessage());
        }
    }

    public boolean isSettingsButtonVisible() {
        try{
            return page.locator(settingsButton).isVisible();
        }catch (PlaywrightException e){
            System.out.println("Settings button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSettingsButtonEnabled() {
        try{
            return page.locator(settingsButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Settings button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isDashboardButtonEnabled() {
        try{
            return page.locator(dashboardButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Dashboard button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void goToDashboard() {
        try{
            page.locator(dashboardButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Dashboard button not found or not visible: " + e.getMessage());
        }
    }

    public boolean isViewDeviceDetailsButtonVisible() {
        try {
            page.locator(deviceDetailsButton).waitFor(new Locator.WaitForOptions().setTimeout(5000));
            return page.locator(deviceDetailsButton).isVisible();
        } catch (Exception e) {
            System.out.println("Device details button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isViewDetailsButtonEnabled() {
        try{
            return page.locator(deviceDetailsButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Device details button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void viewDeviceDetails(int deviceNumber) {
        try{
            String device = "//body[1]/app-root[1]/dashboard[1]/blastweb-spinner[1]/blastweb-zero-data[1]/div[1]/div[2]/div[" +
                    "1]/div[" + deviceNumber + "]/bcu-card-high-detail[1]/mat-card[1]/div[5]";
            page.locator(device).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Device not found or not visible: " + e.getMessage());
        }
    }

    public boolean isNewDeviceOnDashboard() {
        try{
            return page.locator(newDevice).isVisible();
        }catch (PlaywrightException e){
            System.out.println("New device not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isEventsButtonVisible() {
        try {
            page.locator(eventsButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Events button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void openEventLogs() {
        try{
            page.locator(eventsButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Events button not found or not visible: " + e.getMessage());
        }
    }

    public boolean isEventsLogOpen() {
        try {
            page.locator(eventsLog)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Events log not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public String getDeviceCurrentState() {
        try{
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
            return null;
        }catch (PlaywrightException e){
            System.out.println("Failed to get device state caused by: " + e.getMessage());
            return null;
        }
    }

    public boolean isOffsetToolTipVisible() {
        try {
            page.locator(offsetToolTip)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Offset tool tip not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isOffsetToolTipEnabled() {
        try{
            return page.locator(offsetToolTip).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Offset tool tip not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void openOffsetChannelWindow() {
        try{
            page.locator(offsetToolTip).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Offset tool tip not found or not visible: " + e.getMessage());
        }
    }

    public boolean isChannelOffsetWindowOpen() {
        try {
            page.locator(offsetHeader)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Offset header not found or not visible: " + e.getMessage());
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
            System.out.println("Channel path not found or not visible: " + e.getMessage());
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
            System.out.println("Offset delay field not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isChannelOffsetDelayFieldEnabled(String channelOffsetDelayField) {
        try{
            String offsetDelayField = "xpath=/html[1]/body[1]/div[3]/div[2]/div[1]/mat-dialog-container[1]/div[1]/div[1]/app-" +
                    "channel-offset-dialog[1]/div[1]/div[2]/div[" + channelOffsetDelayField + "]/div[3]/input[1]\n";
            return page.locator(offsetDelayField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Offset delay field not visible or not visible: " + e.getMessage());
            return false;
        }
    }

    public void setOffSetDelay(String channelNumber, int delay) {
        try{
            String offsetDelayField = "xpath=/html[1]/body[1]/div[3]/div[2]/div[1]/mat-dialog-container[1]/div[1]/div[1]/" +
                    "app-channel-offset-dialog[1]/div[1]/div[2]/div[" + channelNumber + "]/div[3]/input[1]\n";
            page.locator(offsetDelayField).click();
            page.locator(offsetDelayField).clear();
            page.locator(offsetDelayField).fill(String.valueOf(delay));
        }catch (PlaywrightException e){
            System.out.println("Offset delay field not visible or not found: " + e.getMessage());
        }
    }

    public boolean isSaveButtonVisible() {
        try {
            page.locator(saveButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("'Save' button not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isSaveButtonEnabled() {
        try{
            return page.locator(saveButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Save button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void saveOffsetChannel() {
        try{
            page.locator(saveButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Save button not found or not visible: " + e.getMessage());
        }
    }

    public boolean isGroupByDropDownVisible() {
        try {
            page.locator(groupByDropDown)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Group by dropdown not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isGroupByDropDownEnabled() {
        try{
            return page.locator(groupByDropDown).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Group by dropdown not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void openGroupByDropDown() {
        try{
            page.locator(groupByDropDown).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Group by dropdown not found or not visible: " + e.getMessage());
        }
    }

    public boolean isGroupByDownOpen() {
        try {
            page.locator(groupByDropDownPanel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Group by dropdown panel not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void selectGroupByOption(String group){
        try{
            String groupBy = "(//span[normalize-space()='-  " + group + "'])[1]";
            page.locator(groupBy).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Group by option not found or not visible: " + e.getMessage());
        }
    }

    public boolean isAlertDropDownButtonVisible() {
        try {
            page.locator(alertDropdownButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Alert dropdown not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isAlertDropDownButtonEnabled() {
        try{
            return page.locator(alertDropdownButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Alert dropdown not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void openAlertDropDown() {
        try{
            page.locator(alertDropdownButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Alert dropdown button not found or not visible: " + e.getMessage());
        }
    }

    public List<String> getAllCurrentDeviceAlerts() {
        try{
            List<String> knownAlerts = Arrays.asList(
                    "Short Circuits", "High Leakage", "High Current", "Low Battery", "Acknowledge Alert", "Device Not Available",
                    "Last Detonator Bad", "Last Detonator Bad Voltage", "Harness Break", "Programming Error",
                    "Test Mode", "TX Error Preventing Blast");

            String dynamicConditions = knownAlerts.stream()
                    .map(alert -> "normalize-space()='" + alert + "'")
                    .collect(Collectors.joining(" or "));

            String deviceAlertXpath = "//span[@class='titlecase' or " + dynamicConditions + "]";

            List<String> rawAlerts = page.locator(deviceAlertXpath).allTextContents();

            return rawAlerts.stream()
                    .map(String::trim)
                    .filter(knownAlerts::contains)
                    .collect(Collectors.toList());
        }catch (PlaywrightException e){
            System.out.println("Failed to fetch current device alerts: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public void refreshBrowserTab() {
        try{
            page.reload();
        }catch (PlaywrightException e){
            System.out.println("Could not refresh browser tab. Caused by: " + e.getMessage());
        }
    }

    public boolean isReportTabVisible() {
        try {
            page.locator(reportsTab)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        } catch (PlaywrightException e) {
            System.out.println("Reports tab not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isReportTabEnabled(){
        try{
            return page.locator(reportsTab).isEnabled();
        }catch (PlaywrightException e){
            return false;
        }
    }

    public void openReportTab(){
        try {
            page.locator(reportsTab).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Reports tab not found or not visible: " + e.getMessage());
        }
    }

    public boolean isReportsDropDownOpen(){
        try{
            page.locator(eventsReportButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Events report button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void openEventsReport(){
        try{
            page.locator(eventsReportButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Events report button not found or not visible: " + e.getMessage());
        }
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
            System.out.println("Error not found or not visible: " + e.getMessage());
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
            System.out.println("Alert not found or not visible: " + e.getMessage());
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
            System.out.println("Key element not found or not visible: " + e.getMessage());
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
            System.out.println("Network element not visible or not found");
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
            System.out.println("State element not found or not visible: " + e.getMessage());
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
            System.out.println("Firmware element not found or not visible: " + e.getMessage());
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
            System.out.println("Custom element not visible or not found: " + e.getMessage());
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
            System.out.println("Selected element not visible or not found: " + e.getMessage());
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
            System.out.println("Alive element not found or not visible: " + e.getMessage());
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
            System.out.println("Type locator not found or not visible: " + e.getMessage());
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
            System.out.println("Checkbox not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeviceCheckboxEnabled(int checkBoxNumber){
        try{
            String checkBoxPath = "xpath=/html[1]/body[1]/app-root[1]/dashboard[1]/blastweb-spinner[1]/blastweb-zero-data[1]" +
                    "/div[1]/div[2]/div[1]/div[" + checkBoxNumber + "]/bcu-card-high-detail[1]/mat-card[1]/div[1]/div[1]/mat-checkbox[1]/div[1]/" +
                    "div[1]/input[1]";
            return page.locator(checkBoxPath).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Checkbox not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void selectOrDeselectDevice(int checkboxNumber){
        try{
            String checkBoxPath = "xpath=/html[1]/body[1]/app-root[1]/dashboard[1]/blastweb-spinner[1]/blastweb-zero-data[1]" +
                    "/div[1]/div[2]/div[1]/div[" + checkboxNumber + "]/bcu-card-high-detail[1]/mat-card[1]/div[1]/div[1]/mat-checkbox[1]/div[1]/" +
                    "div[1]/input[1]";
            page.locator(checkBoxPath).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Checkbox path not found or not visible: " + e.getMessage());
        }
    }

    public boolean isDeviceSelected(int checkboxNumber){
        try{
            String checkBoxPath = "xpath=/html[1]/body[1]/app-root[1]/dashboard[1]/blastweb-spinner[1]/blastweb-zero-data[1]" +
                    "/div[1]/div[2]/div[1]/div[" + checkboxNumber + "]/bcu-card-high-detail[1]/mat-card[1]/div[1]/div[1]/mat-checkbox[1]/div[1]/" +
                    "div[1]/input[1]";
            return page.locator(checkBoxPath).isChecked();
        }catch (PlaywrightException e){
            System.out.println("Checkbox path not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeviceDeselected(int checkBoxNumber){
        try{
            String checkBoxPath = "xpath=/html[1]/body[1]/app-root[1]/dashboard[1]/blastweb-spinner[1]/blastweb-zero-data[1]" +
                    "/div[1]/div[2]/div[1]/div[" + checkBoxNumber + "]/bcu-card-high-detail[1]/mat-card[1]/div[1]/div[1]/mat-checkbox[1]/div[1]/" +
                    "div[1]/input[1]";
            return !page.locator(checkBoxPath).isChecked();
        }catch (PlaywrightException e){
            System.out.println("Checkbox path not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSelectAllCheckBoxVisible(){
        try{
            page.locator(selectAllCheckbox)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Select All checkbox not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSelectAllCheckBoxEnabled(){
        try{
            return page.locator(selectAllCheckbox).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Select All checkbox not found or not visible: ");
            return false;
        }
    }

    public void selectAllDevices(){
        try{
            page.locator(selectAllCheckbox).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Selected All checkbox not found or not visible: " + e.getMessage());
        }
    }

    public boolean isAllDevicesChecked(){
        try{
            return page.locator(selectAllCheckbox).isChecked();
        }catch (PlaywrightException e){
            System.out.println("Select All checkbox not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isOffsetActive(){
        try{
            Locator offsetImage = page.locator(offsetToolTip);
            String src = offsetImage.getAttribute("src");
            return src != null && src.contains("active");
        }catch (PlaywrightException e){
            System.out.println("Offset tool tip not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isPlusIconVisible(){
        try{
            page.locator(plusIcon)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Offset tool tip not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isPlusIconEnabled(){
        try{
            return page.locator(plusIcon).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Plus icon not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void openActionPanel(){
        try{
            page.locator(plusIcon).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Plus icon not found or not visible: " + e.getMessage());
        }
    }

    public boolean isActionPanelOpen(){
        try{
            page.locator(actionPanel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Action panel not found or not visible: " + e.getMessage());
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
            System.out.println("Arm Selected element not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void armSelectedDevice(){
        try{
            page.locator(armSelectedButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Arm Selected element not found or not visible: " + e.getMessage());
        }
    }

    public boolean isDeviceReadyToBlast(){
        try{
            page.locator(readyToBlastElement)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Ready to Blast element not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isBlastSelectedOptionAvailable(){
        try{
            page.locator(blastSelectedLabel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));

            page.locator(blastSelectedButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Blast Selected element not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void blastSelectDevice(){
        try{
            page.locator(blastSelectedButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Blast Selected' -button not found or not visible: " + e.getMessage());
        }
    }

    public void openBlastReport(){
        try{
            page.locator(blastReportButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Blast Report button not visible or not found: " + e.getMessage());
        }
    }

    public boolean isArmAllReadyOptionAvailable(){
        try{
            page.locator(armAllReadyLabel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            page.locator(armAllReadyButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Arm All Ready -element not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void armAllReady(){
        try{
            page.locator(armAllReadyButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Arm All Ready button not found or not visible: " + e.getMessage());
        }
    }

    public boolean isNoDeviceToArmSnackBarHidden(){
        try{
            page.locator(noDeviceToArmSnackBar)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.HIDDEN)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Snack bar not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isArmWirelessSelectedOptionAvailable(){
        try{
            page.locator(armWirelessSelectedLabel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            page.locator(armWirelessSelectedButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Arm Wireless Selected -element not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void armWirelessSelected(){
        try{
            page.locator(armWirelessSelectedButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Arm Wireless Selected -element not found or not visible: " + e.getMessage());
        }
    }

    public boolean isCyberDetDialogOpen(){
        try{
            page.locator(cyberDetImage)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Cyberdet image not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isBlastGroupDropDownVisible(){
        try{
            page.locator(blastGroupDropDown)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Blast group dropdown not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isBlastGroupDropDownEnabled(){
        try{
            return page.locator(blastGroupDropDown).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Blast group dropdown not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void openBlastGroupDropDown(){
        try{
            page.locator(blastGroupDropDown).click(new Locator.ClickOptions().setForce(true).setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Blast group dropdown not found or not visible: " + e.getMessage());
        }
    }

//    Created groups does not appear in dropdown during automation.
    public void selectBlastGroup(String blastGroup){
        try{
          page.selectOption("select",new SelectOption().setLabel(blastGroup));
        }catch (PlaywrightException e){
            System.out.println("Blast group element not found or not visible in dropdown: " + e.getMessage());
        }
    }

    public boolean isReBlastCheckBoxVisible(){
        try{
            page.locator(reBlastCheckbox)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Re-blast checkbox not found or not visible on the Cyberdet dialogue window: " + e.getMessage());
            return false;
        }
    }

    public boolean isReBlastCheckBoxEnabled(){
        try{
            return page.locator(reBlastCheckbox).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Re-blast checkbox not found or not visible on the Cyberdet dialogue window: " + e.getMessage());
            return false;
        }
    }

    public void reBlastDevice(){
        try{
            page.locator(reBlastCheckbox).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Re-blast checkbox not found or not visible on the Cyberdet dialogue window: " + e.getMessage());
        }
    }

    public boolean isDeviceSelectedToReBlast(){
        try{
            return page.locator(reBlastCheckbox).isChecked();
        }catch (PlaywrightException e){
            System.out.println("Re-blast checkbox not found or not visible on the Cyberdet dialogue window: " + e.getMessage());
            return false;
        }
    }

    public boolean isCyberDetOkButtonVisible(){
        try{
            page.locator(cyberDetOkButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'OK' button not found or not visible on Cyberdet dialog window: " + e.getMessage());
            return false;
        }
    }

    public boolean isCyberDetOkButtonEnabled(){
        try{
            return page.locator(cyberDetOkButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'OK' button not found or not visible on Cyberdet dialog window: " + e.getMessage());
            return false;
        }
    }

    public void applyBlastGroupToDevice(){
        try{
            page.locator(cyberDetOkButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'OK' button not found or not visible on Cyberdet dialog window: " + e.getMessage());
        }
    }

    public boolean isSortByDropDownVisible(){
        try{
            page.locator(sortByDropdown)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Sort by dropdown not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public boolean isSortByDropDownEnabled(){
        try{
            return page.locator(sortByDropdown).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Sort by dropdown not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void openSortByDropDown(){
        try{
            page.locator(sortByDropdown).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Sort by dropdown button not found or not visible: " + e.getMessage());
        }
    }

    public void sortBy(String sortBy){
        try{
            String sortElement = "(//span[normalize-space()='-  " + sortBy +"'])[1]";
            page.locator(sortElement).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Sort by element not found or not visible: " +e.getMessage());
        }
    }

    public boolean isBlastAllReadyOptionAvailable(){
        try{
            page.locator(blastAllReadyLabel)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            page.locator(blastAllReadyButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'Blast all Ready' -label and button not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public void blastAllReady(){
        try{
            page.locator(blastAllReadyButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Blast All Ready' -button not found or not visible: " + e.getMessage());
        }
    }
}