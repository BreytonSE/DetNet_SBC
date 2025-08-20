package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.EventsReportPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class EventsReportValidations {
    private final EventsReportPageObjectModel eventsReportPageObjectModel;
    private final SoftAssertions softly;

    public EventsReportValidations(EventsReportPageObjectModel eventsReportPageObjectModel) {
        this.eventsReportPageObjectModel = eventsReportPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateEventsReportPageVisibility(){
        boolean isVisible = eventsReportPageObjectModel.isEventsReportPageOpen();
        softly.assertThat(isVisible)
                .as("Events report page should be opened.")
                .isTrue();
    }

    public void validateEventsReportPageURL(String expectedURL){
        String actualURL = eventsReportPageObjectModel.getPageURL();
        softly.assertThat(actualURL)
                .as("Actual URL does not match expected URL.")
                .matches(expectedURL);
    }

    public void validatePageName(String expectedPageName){
        String actualPageName = eventsReportPageObjectModel.getPageName();
        softly.assertThat(actualPageName)
                .as("Actual page name does not match expected page name.")
                .isEqualTo(expectedPageName);
    }

    public void validateIfEventsReportIsPaginated(){
        boolean isPaginated = eventsReportPageObjectModel.isEventsReportPaginated();
        softly.assertThat(isPaginated)
                .as("Event reports should be paginated.")
                .isTrue();
    }

    public void validateEventsReportVisibility(){
        boolean isRetrieved = eventsReportPageObjectModel.isEventsTableVisible();
        softly.assertThat(isRetrieved)
                .as("Events report should be retrieved and visible inside the table.")
                .isTrue();
    }
}