package com.detnet.stepdefinitions.userDetails;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.pageObjects.UserAccountPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DashboardValidation;
import com.detnet.validations.blastWebValidations.UserAccountValidations;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that user is navigated to the 'My Account Details' -page when clicking on clicking on My Account menu
public class viewUserDetails_StepDefn {
    private final PageObjectManager pageObjectManager;

    public viewUserDetails_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user open the navigation menu")
    public void the_user_open_the_navigation_menu() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.openNavigationMenu();
    }

    @When("click on {string} menu item")
    public void click_on_menu_item(String menuItemButton) {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateMyAccountButtonVisibility();
        dashboardValidation.validateMyAccountMenuItemText(menuItemButton);
        SoftAssertionUtils.getSoftAssertions().assertAll();
        dashboardPageObjectModel.viewMyAccountDetails();
    }

    @Then("verify that user is on user detail page with URL {string}")
    public void verify_that_user_is_on_user_detail_page_with_url(String url) {
        UserAccountPageObjectModel userAccountPageObjectModel = pageObjectManager.getUserAccountPageObjectModel();
        UserAccountValidations userAccountValidations = new UserAccountValidations(userAccountPageObjectModel);
        userAccountValidations.validateIfUserDetailsPageVisibility();
        userAccountValidations.validateUserDetailsPageURL(url);
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}