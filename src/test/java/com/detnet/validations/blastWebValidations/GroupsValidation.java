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

    public void validateAddGroupPageURL(String expectedURL){
        String actualURL = groupsPageObjectModel.getAddGroupPageURL();
        softly.assertThat(actualURL)
                .as("Actual URL does not match expected URL")
                .isEqualTo(expectedURL);
    }

    public void validateAddGroupFormVisibility(){
        boolean isVisible = groupsPageObjectModel.isAddGroupFormVisible();
        softly.assertThat(isVisible)
                .as("Add Group form should be visible")
                .isTrue();
    }

    public void validateAddGroupHeadingText(String expectedText){
        String actualText = groupsPageObjectModel.getAddGroupHeadingText();
        softly.assertThat(actualText)
                .as("Actual text does not match expected text.")
                .isEqualTo(expectedText);
    }

    public void validateGroupNameFieldVisibility(){
        boolean isVisible = groupsPageObjectModel.isGroupNameInputFieldVisible();
        softly.assertThat(isVisible)
                .as("Group name input field should be visible.")
                .isTrue();
    }

    public void validateGroupNameFieldState(){
        boolean isEnabled = groupsPageObjectModel.isGroupNameFieldEnabled();
        softly.assertThat(isEnabled)
                .as("Group name input field should be enabled.")
                .isTrue();
    }

    public void validateGroupNameFieldIfEmpty(){
        boolean isEmpty = groupsPageObjectModel.isGroupNameFieldEmpty();
        softly.assertThat(isEmpty)
                .as("Group name field should be empty by default")
                .isTrue();
    }

    public void validateGroupNameFieldIfFilled(){
        boolean isFilled = groupsPageObjectModel.isGroupNameFieldFilled();
        softly.assertThat(isFilled)
                .as("Group name field should be filled")
                .isTrue();
    }

    public void validateGroupName(String expectedGroupName){
        String actualGroupName = groupsPageObjectModel.getGroupName();
        softly.assertThat(actualGroupName)
                .as("Actual group name does not match expected group name.")
                .isEqualTo(expectedGroupName);
    }

    public void validateColorPickerVisibility(){
        boolean isVisible = groupsPageObjectModel.isColorPickerVisible();
        softly.assertThat(isVisible)
                .as("Color picker should be visible")
                .isTrue();
    }

    public void validateColorPickerState(){
        boolean isEnabled = groupsPageObjectModel.isColorPickerEnabled();
        softly.assertThat(isEnabled)
                .as("Color picker should be enabled.")
                .isTrue();
    }

    public void validateIfColorPickerOpen(){
        boolean isOpen = groupsPageObjectModel.isColorPickerOpen();
        softly.assertThat(isOpen)
                .as("Color picker should be open.")
                .isTrue();
    }

    public void validateRGBFieldVisibility(){
        boolean isVisible = groupsPageObjectModel.isRGBFieldsVisible();
        softly.assertThat(isVisible)
                .as("RGB fields should be visible.")
                .isTrue();
    }

    public void validateRGBColorCode(String expectedRed, String expectedGreen, String expectedBlue){
        String actualRGB = groupsPageObjectModel.getRGBColorCode();
        String expectedRGB = expectedRed + "," + expectedGreen + "," + expectedBlue;
        softly.assertThat(actualRGB)
                .as("Actual RGB color code does not match expected RGB color code")
                .isEqualTo(expectedRGB);
    }

    public void validateSaveGroupButtonVisibility(){
        boolean isVisible = groupsPageObjectModel.isSaveGroupButtonVisible();
        softly.assertThat(isVisible)
                .as("Add Group button should be visible")
                .isTrue();
    }

    public void validateSaveGroupButtonState(){
        boolean isEnabled = groupsPageObjectModel.isSaveGroupButtonEnabled();
        softly.assertThat(isEnabled)
                .as("Add Group button should be enabled")
                .isTrue();
    }

    public void validateIfGroupIsAdded(){
        boolean isAdded = groupsPageObjectModel.isGroupAddedToInterface();
        softly.assertThat(isAdded)
                .as("Group should be visible on the interface table.")
                .isTrue();
    }

    public void validateEditIconVisibility(int row){
        boolean isVisible = groupsPageObjectModel.isEditIconVisible(row);
        softly.assertThat(isVisible)
                .as("Edit icon should be visible.")
                .isTrue();
    }

    public void validateEditGroupsPageHeadingVisibility(){
        boolean isVisible = groupsPageObjectModel.isEditGroupsHeadingVisible();
        softly.assertThat(isVisible)
                .as("Edit Groups heading should be visible")
                .isTrue();
    }

    public void validateEditGroupsHeading(String expectedText){
        String actualText = groupsPageObjectModel.getEditGroupsHeading();
        softly.assertThat(actualText)
                .as("Actual text does not match expected text")
                .isEqualTo(expectedText);
    }

    public void validateUpdateButtonVisibility(){
        boolean isVisible = groupsPageObjectModel.isUpdateButtonVisible();
        softly.assertThat(isVisible)
                .as("Update button (Save) should be visible.")
                .isTrue();
    }

    public void validateUpdateButtonButtonState(){
        boolean isEnabled = groupsPageObjectModel.isUpdateButtonEnabled();
        softly.assertThat(isEnabled)
                .as("Save button should be enabled before user can update a group")
                .isTrue();
    }

    public void validateUpdateGroupNameVisibility(String groupName){
        boolean isUpdated = groupsPageObjectModel.isGroupNameUpdated(groupName);
        softly.assertThat(isUpdated)
                .as("Group name should have changed after group name update")
                .isTrue();
    }

    public void validateSearchBarVisibility(){
        boolean isVisible = groupsPageObjectModel.isSearchBarVisible();
        softly.assertThat(isVisible)
                .as("Search bar should be visible.")
                .isTrue();
    }

    public void validateSearchBarState(){
        boolean isEnabled = groupsPageObjectModel.isSearchBarEnabled();
        softly.assertThat(isEnabled)
                .as("Searchbar should be enabled by default")
                .isTrue();
    }

    public void validateIfSearchbarIsEmpty(){
        boolean isEmpty = groupsPageObjectModel.isSearchbarEmpty();
        softly.assertThat(isEmpty)
                .as("Search bar should be empty")
                .isTrue();
    }

    public void validateIfSearchedGroupIsFound(String group){
        boolean isFound = groupsPageObjectModel.isSearchedGroupFound(group);
        softly.assertThat(isFound)
                .as("Searched group should appear in the list")
                .isTrue();
    }

    public void validateDeleteIconVisibility(){
        boolean isVisible = groupsPageObjectModel.isDeleteIconVisible();
        softly.assertThat(isVisible)
                .as("Delete icon should be visible")
                .isTrue();
    }

    public void validateDeleteIconState(){
        boolean isEnabled = groupsPageObjectModel.isDeleteIconEnabled();
        softly.assertThat(isEnabled)
                .as("Delete icon should be enabled")
                .isTrue();
    }

    public void validateDeleteDialogWindowVisibility(){
        boolean isOpen = groupsPageObjectModel.isDeleteDialogWindowOpen();
        softly.assertThat(isOpen)
                .as("Delete dialog window should be visible.")
                .isTrue();
    }

    public void validateCheckBoxVisibility(){
        boolean isVisible = groupsPageObjectModel.isCheckBoxVisible();
        softly.assertThat(isVisible)
                .as("Checkbox should be visible.")
                .isTrue();
    }

    public void validateDeleteAllButtonVisibility(){
        boolean isVisible = groupsPageObjectModel.isDeleteAllGroupsButtonVisible();
        softly.assertThat(isVisible)
                .as("'Delete Groups' -button should be visible")
                .isTrue();
    }

    public void validateDeleteAllButtonState(){
        boolean isEnabled = groupsPageObjectModel.isDeleteGroupsButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'Delete Groups' button should be enabled")
                .isTrue();
    }

    public void validateIfGroupIsDeleted(String groupName){
        boolean isDeleted = groupsPageObjectModel.isSelectedGroupsDeleted(groupName);
        softly.assertThat(isDeleted)
                .as("Selected groups should be deleted")
                .isTrue();
    }
}