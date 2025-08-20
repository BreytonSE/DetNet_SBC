package com.detnet.stepdefinitions.eventsReports;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.EventsReportPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.EventsReportValidations;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that user can retrieve a report and view its page contents
public class EventReportRetrieval_StepDefn {
    private final PageObjectManager pageObjectManager;

    public EventReportRetrieval_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Then("the report contents should be displayed")
    public void the_report_contents_should_be_displayed() {
        EventsReportPageObjectModel eventsReportPageObjectModel = pageObjectManager.getEventsReportPageObjectModel();
        EventsReportValidations eventsReportValidations = new EventsReportValidations(eventsReportPageObjectModel);
        eventsReportValidations.validateEventsReportVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the events report should be paginated")
    public void the_events_report_should_be_paginated() {
        EventsReportPageObjectModel eventsReportPageObjectModel = pageObjectManager.getEventsReportPageObjectModel();
        EventsReportValidations eventsReportValidations = new EventsReportValidations(eventsReportPageObjectModel);
        eventsReportValidations.validateIfEventsReportIsPaginated();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the events report should be sortable")
    public void the_events_report_should_be_sortable() {
//        TODO: Verify that the events report is sortable
    }

    @Then("the events report should be filterable by device")
    public void the_events_report_should_be_filterable_by_device() {
//        TODO: Verify that the events report is filterable by device
    }

    @Then("the events report should be filterable by event category")
    public void the_events_report_should_be_filterable_by_event_category() {
//        TODO: Events report should be filterable by event category
    }
}