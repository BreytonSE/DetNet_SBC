package com.detnet.stepdefinitions.blastCardManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.BlastCardsPageObjectModel;
import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.pageObjects.LoginPageObjectModel;
import com.detnet.pageObjects.SettingsPageObjectModel;
import com.detnet.utilities.EncryptionUtils;
import com.detnet.utilities.LoginConstantUtils;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.BlastCardsValidation;
import com.detnet.validations.blastWebValidations.DashboardValidation;
import com.detnet.validations.blastWebValidations.SettingsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//Scenario: Verify that user can add a blast, active, and timed blast on the system.
public class BlastCardAdd_StepDefn {
    private Page page;
    private final PageObjectManager pageObjectManager;
    private final LoginPageObjectModel loginPageObjectModel;
    private final DashboardPageObjectModel dashboardPageObjectModel;
    private final DashboardValidation dashboardValidation;
    private final SettingsPageObjectModel settingsPageObjectModel;
    private final SettingsValidation settingsValidation;
    private final BlastCardsPageObjectModel blastCardsPageObjectModel;
    private final BlastCardsValidation blastCardsValidation;

    public BlastCardAdd_StepDefn() {
        this.page = PlaywrightManager.getPage();
        this.pageObjectManager = PageObjectManager.getInstance(page);
        this.loginPageObjectModel = pageObjectManager.getLoginPageObjectModel();
        this.dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        this.dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        this.settingsPageObjectModel = pageObjectManager.getSettingsPageObjectModel();
        this.settingsValidation = new SettingsValidation(settingsPageObjectModel);
        this.blastCardsPageObjectModel = pageObjectManager.getBlastCardsPageObjectModel();
        this.blastCardsValidation = new BlastCardsValidation(blastCardsPageObjectModel);
    }

    @Given("the user has entered valid BlastWeb login credentials")
    public void the_user_has_entered_valid_blast_web_login_credentials() throws Exception {
        String username = LoginConstantUtils.getDecryptedUsername();
        loginPageObjectModel.setUsername(username);
        String password = LoginConstantUtils.getDecryptedPassword();
        loginPageObjectModel.setPassword(password);
        loginPageObjectModel.logIn();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Given("the NFC reader is connected to the computer or laptop")
    public void the_nfc_reader_is_connected_to_the_computer_or_laptop() {
//        TODO: Get an NFC reader (Email developers to complete this step)
    }
    @When("the user opens the navigation menu by clicking the current system user's name")
    public void the_user_opens_the_navigation_menu_by_clicking_the_current_system_user_s_name() {
        dashboardPageObjectModel.openNavigationMenu();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user navigates to the Settings page")
    public void the_user_navigates_to_the_settings_page() {
        dashboardValidation.validateSettingsButtonVisibility();
        dashboardValidation.validateSettingsButtonClick();
        dashboardPageObjectModel.openSettings();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user navigates to the {string} section")
    public void the_user_navigates_to_the_section(String string) {
        settingsValidation.validateSettingsURL("http://localhost:8080/en/settings/networks");
        settingsValidation.validateSettingsLabelVisibility();
        settingsValidation.validateSettingsLabelName("Settings");
        settingsValidation.validateBlastCardButtonVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user navigates to the {string} tab")
    public void the_user_navigates_to_the_tab(String string) {
        settingsValidation.validateBlastCardClick();
        settingsPageObjectModel.viewActiveBlastCards();
        blastCardsValidation.validateActiveBlastCardsURL("http://localhost:8080/en/settings/activeCards");
        blastCardsValidation.validateActiveBlastCardsVisibility();
        blastCardsValidation.validateActiveBlastCardLabelName("Active Cards");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String string) {
        blastCardsValidation.validateAddBlastCardButtonVisibility();
        blastCardsValidation.validateAddBlastCardClick();
        blastCardsPageObjectModel.addBlastCard();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @Then("the user taps the blast card on the NFC reader when the {string} popup is displayed")
    public void the_user_taps_the_blast_card_on_the_nfc_reader_when_the_popup_is_displayed(String string) {
//        TODO: Requires a blast card and NFC reader to complete this scenario
    }
}