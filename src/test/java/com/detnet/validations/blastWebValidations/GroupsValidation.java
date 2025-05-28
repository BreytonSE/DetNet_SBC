package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.GroupsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class GroupsValidation {
    private final GroupsPageObjectModel groupsPageObjectModel;
    private SoftAssertions softly;

    public GroupsValidation(GroupsPageObjectModel groupsPageObjectModel) {
        this.groupsPageObjectModel = groupsPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateGroupPageHeadingVisibility(){
        boolean isVisible = groupsPageObjectModel.isGroupsHeadingVisible();
        softly.assertThat(isVisible)
                .as("Groups heading should be visible on the Groups page")
                .isTrue();
    }

    public void validateGroupPageHeadingText(String expectedText){
        String actualText = groupsPageObjectModel.getHeadingText();
        softly.assertThat(actualText)
                .as("Actual heading text does not match expected heading text")
                .isEqualTo(expectedText);
    }

    public void validateGroupPageURL(String expectedURL){
        String actualURL = groupsPageObjectModel.getGroupsURL();
        softly.assertThat(actualURL)
                .as("Actual URL does not match expected URL")
                .isEqualTo(expectedURL);
    }

    public void validateIfNoGroupsPresent(){
        boolean notPresent = groupsPageObjectModel.hasNoGroups();
        softly.assertThat(notPresent)
                .as("No group should exist by default")
                .isTrue();
    }

    public void validateNoGroupsText(String expectedText){
        String actualText = groupsPageObjectModel.getNoGroupsText();
        softly.assertThat(actualText)
                .as("Actual text does not match expected text")
                .isEqualTo(expectedText);
    }

    public void validateAddGroupButtonVisibility(){
        boolean isVisible = groupsPageObjectModel.isAddGroupButtonVisible();
        softly.assertThat(isVisible)
                .as("'+Add Group' -button should be visible")
                .isTrue();
    }

    public void validateAddGroupButtonState(){
        boolean isEnabled = groupsPageObjectModel.isAddGroupButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'+Add Group' -button should be enabled")
                .isTrue();
    }
}