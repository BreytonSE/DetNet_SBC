package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.BlastReportPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class BlastReportValidation {
    private final BlastReportPageObjectModel blastReportPageObjectModel;
    private final SoftAssertions softly;

    public BlastReportValidation(BlastReportPageObjectModel blastReportPageObjectModel) {
        this.blastReportPageObjectModel = blastReportPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateBlastReportPageURL(String expectedURL){
        String actualURL = blastReportPageObjectModel.getPageURL();
        softly.assertThat(actualURL)
                .as("Actual URL does not match expected URL.")
                .isEqualTo(expectedURL);
    }

    public void validateBlastReportPageVisibility(){
        boolean isVisible = blastReportPageObjectModel.isBlastReportPageOpen();
        softly.assertThat(isVisible)
                .as("Blast report page should be open.")
                .isTrue();
    }
}