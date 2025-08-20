package com.detnet.stepdefinitions.eventsReports;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.pageObjects.EventsReportPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DashboardValidation;
import com.detnet.validations.blastWebValidations.EventsReportValidations;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//   Scenario: Verify that user can view events reports
public class ViewEventsReports_StepDefn {
    private final PageObjectManager pageObjectManager;

    public ViewEventsReports_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user opens the {string} dropdown on the navigation bar")
    public void the_user_opens_the_dropdown_on_the_navigation_bar(String dropDownName) {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateReportsTabText(dropDownName);
        SoftAssertionUtils.getSoftAssertions().assertAll();
        dashboardPageObjectModel.openReportTab();

    }

    @When("the user selects {string} from the dropdown list")
    public void the_user_selects_from_the_dropdown_list(String tabName) {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateEventsReportTabVisibility();
        dashboardValidation.validateEventsReportTabText(tabName);
        SoftAssertionUtils.getSoftAssertions().assertAll();
        dashboardPageObjectModel.openEventsReport();
    }

    @Then("the user should be directed to the {string} page in the reports section")
    public void the_user_should_be_directed_to_the_page_in_the_reports_section(String pageName) {
        EventsReportPageObjectModel eventsReportPageObjectModel = pageObjectManager.getEventsReportPageObjectModel();
        EventsReportValidations eventsReportValidations = new EventsReportValidations(eventsReportPageObjectModel);
        eventsReportValidations.validateEventsReportPageVisibility();
        eventsReportValidations.validatePageName(pageName);
        eventsReportValidations.validateEventsReportPageURL("http://localhost:8080/en/reports/events");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}