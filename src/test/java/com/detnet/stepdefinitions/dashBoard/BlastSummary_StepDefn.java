package com.detnet.stepdefinitions.dashBoard;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.BlastReportPageObjectModel;
import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.BlastReportValidation;
import com.detnet.validations.blastWebValidations.DashboardValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that you can view blast summary after blast is successfully completed
public class BlastSummary_StepDefn {
    private final PageObjectManager pageObjectManager;

    public BlastSummary_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user opens the {string} tab")
    public void the_user_opens_the_tab(String string) {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.openReportTab();
    }

    @Then("a dropdown should open with three different report types")
    public void a_dropdown_should_open_with_three_different_report_types() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateReportDropDownVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user selects the Blast Report option")
    public void the_user_selects_the_blast_report_option() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.openBlastReport();
    }

    @Then("the blast summary should be visible after the successful blast")
    public void the_blast_summary_should_be_visible_after_the_successful_blast() {
        BlastReportPageObjectModel blastReportPageObjectModel = pageObjectManager.getBlastReportPageObjectModel();
        BlastReportValidation blastReportValidation = new BlastReportValidation(blastReportPageObjectModel);
        blastReportValidation.validateBlastReportPageVisibility();
        blastReportValidation.validateBlastReportPageURL("http://localhost:8080/en/reports/blast");
//        TODO: Verify that the blast summary is visible here...
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}