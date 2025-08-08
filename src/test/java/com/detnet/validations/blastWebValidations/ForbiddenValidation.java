package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.ForbiddenPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class ForbiddenValidation {
    private final ForbiddenPageObjectModel forbiddenPageObjectModel;
    private final SoftAssertions softly;

    public ForbiddenValidation(ForbiddenPageObjectModel forbiddenPageObjectModel) {
        this.forbiddenPageObjectModel = forbiddenPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateForbiddenPageVisibility(){
        boolean isHidden = forbiddenPageObjectModel.isForbiddenPageHidden();
        softly.assertThat(isHidden)
                .as("Forbidden page should not be displaying after user attempts a password reset.")
                .isTrue();
    }
}