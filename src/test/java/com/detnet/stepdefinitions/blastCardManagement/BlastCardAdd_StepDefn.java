package com.detnet.stepdefinitions.blastCardManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.BlastCardsPageObjectModel;
import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.pageObjects.LoginPageObjectModel;
import com.detnet.pageObjects.SettingsPageObjectModel;
import com.detnet.utilities.LoginConstantUtils;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.BlastCardsValidation;
import com.detnet.validations.blastWebValidations.DashboardValidation;
import com.detnet.validations.blastWebValidations.SettingsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//Scenario: Verify that user can add a blast, active, and timed blast on the system.
public class BlastCardAdd_StepDefn {
    private final PageObjectManager pageObjectManager;

    public BlastCardAdd_StepDefn() { // Ensure it is called after the page is ready
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Given("the user has entered valid BlastWeb login credentials")
    public void the_user_has_entered_valid_blast_web_login_credentials() throws Exception {
        LoginPageObjectModel loginPageObjectModel = pageObjectManager.getLoginPageObjectModel();
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
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.openNavigationMenu();
    }
    @When("the user navigates to the Settings page")
    public void the_user_navigates_to_the_settings_page() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateSettingsButtonVisibility();
        dashboardValidation.validateSettingsButtonClick();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        dashboardPageObjectModel.openSettings();
    }
    @When("the user navigates to the Blast Cards section")
    public void the_user_navigates_to_the_blast_cards_section() {
        SettingsPageObjectModel settingsPageObjectModel = pageObjectManager.getSettingsPageObjectModel();
        SettingsValidation settingsValidation = new SettingsValidation(settingsPageObjectModel);
        settingsValidation.validateSettingsURL("http://localhost:8080/en/settings/networks");
        settingsValidation.validateSettingsLabelVisibility();
        settingsValidation.validateSettingsLabelName("Settings");
        settingsValidation.validateBlastCardButtonVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user navigates to the Active Cards tab")
    public void the_user_navigates_to_the_active_cards_tab() {
        SettingsPageObjectModel settingsPageObjectModel = pageObjectManager.getSettingsPageObjectModel();
        SettingsValidation settingsValidation = new SettingsValidation(settingsPageObjectModel);
        settingsValidation.validateBlastCardClick();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        settingsPageObjectModel.viewActiveBlastCards();

        BlastCardsPageObjectModel blastCardsPageObjectModel = pageObjectManager.getBlastCardsPageObjectModel();
        BlastCardsValidation blastCardsValidation = new BlastCardsValidation(blastCardsPageObjectModel);
        blastCardsValidation.validateActiveBlastCardsURL("http://localhost:8080/en/settings/activeCards");
        blastCardsValidation.validateActiveBlastCardsVisibility();
        blastCardsValidation.validateActiveBlastCardLabelName("Active Cards");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user clicks on the Add Blast Card button")
    public void the_user_clicks_on_the_add_blast_card_button() {
        BlastCardsPageObjectModel blastCardsPageObjectModel = pageObjectManager.getBlastCardsPageObjectModel();
        BlastCardsValidation blastCardsValidation = new BlastCardsValidation(blastCardsPageObjectModel);
        blastCardsValidation.validateAddBlastCardButtonVisibility();
        blastCardsValidation.validateAddBlastCardClick();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        blastCardsPageObjectModel.addBlastCard();
    }
    @Then("the user taps the blast card on the NFC reader when the Add Blast Card popup is displayed")
    public void the_user_taps_the_blast_card_on_the_nfc_reader_when_the_add_blast_card_popup_is_displayed() {
//        TODO: Requires a blast card and NFC reader to complete this scenario
    }
}