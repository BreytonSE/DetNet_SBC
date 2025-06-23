package com.detnet.stepdefinitions.dashBoard;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DashboardValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that dashboard grouping functionality works as expected
public class DeviceGrouping_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DeviceGrouping_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Then("the {string} dropdown should be visible")
    public void the_dropdown_should_be_visible(String string) {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateGroupByDropDownVisibility();
        dashboardValidation.validateGroupByDropDownState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user opens the Group By dropdown")
    public void the_user_opens_the_group_by_dropdown() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardPageObjectModel.openGroupByDropDown();
        dashboardValidation.validateGroupByDropDownPanelVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
    @When("the user selects Key as the grouping option")
    public void the_user_selects_key_as_the_grouping_option() {

    }
    @When("the user selects Network as the grouping option")
    public void the_user_selects_network_as_the_grouping_option() {

    }
    @When("the user selects State as the grouping option")
    public void the_user_selects_state_as_the_grouping_option() {

    }
    @When("the user selects Firmware as the grouping option")
    public void the_user_selects_firmware_as_the_grouping_option() {

    }
    @When("the user selects Custom as the grouping option")
    public void the_user_selects_custom_as_the_grouping_option() {

    }
    @When("the user selects Selected as the grouping option")
    public void the_user_selects_selected_as_the_grouping_option() {

    }
    @When("the user selects Alive as the grouping option")
    public void the_user_selects_alive_as_the_grouping_option() {

    }
    @When("the user selects Type as the grouping option")
    public void the_user_selects_type_as_the_grouping_option() {

    }
}