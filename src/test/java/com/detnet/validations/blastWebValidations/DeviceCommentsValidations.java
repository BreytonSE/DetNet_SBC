package com.detnet.validations.blastWebValidations;

import com.detnet.pageObjects.DeviceCommentsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

public class DeviceCommentsValidations {
    private final SoftAssertions softly;
    private final DeviceCommentsPageObjectModel deviceCommentsPageObjectModel;

    public DeviceCommentsValidations(DeviceCommentsPageObjectModel deviceCommentsPageObjectModel) {
        this.deviceCommentsPageObjectModel = deviceCommentsPageObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateCommentsPageVisibility(){
        boolean isVisible = deviceCommentsPageObjectModel.isDeviceCommentsPageVisible();
        softly.assertThat(isVisible)
                .as("Device comments screen should be displaying after opening the comments page.")
                .isTrue();
    }

    public void validateCommentsPageURL(String expectedURL){
        String actualURL = deviceCommentsPageObjectModel.getCommentsPageURL();
        softly.assertThat(actualURL)
                .as("Actual URL does not match expected URL.")
                .matches(expectedURL);
    }

    public void validateAddCommentButtonVisibility(){
        boolean isVisible = deviceCommentsPageObjectModel.isAddCommentButtonVisible();
        softly.assertThat(isVisible)
                .as("'Add Comment' -button should be displaying on the device comments page.")
                .isTrue();
    }

    public void validateAddCommentButtonState(){
        boolean isEnabled = deviceCommentsPageObjectModel.isAddCommentButtonEnabled();
        softly.assertThat(isEnabled)
                .as("Add Comment button should be enabled on the device comments page.")
                .isTrue();
    }

    public void validateButtonName(String expectedButtonName){
        String actualButtonName = deviceCommentsPageObjectModel.getButtonName();
        softly.assertThat(actualButtonName)
                .as("Actual button name does not match expected button name.")
                .isEqualTo(expectedButtonName);
    }

    public void validateCommentsWindowVisibility(){
        boolean isVisible = deviceCommentsPageObjectModel.isCommentPromptWindowOpen();
        softly.assertThat(isVisible)
                .as("Comments prompt window should be displaying when user clicks on 'Add Comment' -button")
                .isTrue();
    }

    public void validateCommentsInputFieldVisibility(){
        boolean isVisible = deviceCommentsPageObjectModel.isCommentsInputFieldVisible();
        softly.assertThat(isVisible)
                .as("Comments input field should be displaying on the comments dialog window.")
                .isTrue();
    }

    public void validateCommentsInputFieldState(){
        boolean isEnabled = deviceCommentsPageObjectModel.isCommentsInputFieldEnabled();
        softly.assertThat(isEnabled)
                .as("Comments input field should be enabled on the comments dialog window.")
                .isTrue();
    }

    public void validateCommentText(String expectedComment){
        String actualComment = deviceCommentsPageObjectModel.getComment();
        softly.assertThat(actualComment)
                .as("Actual comment does not match expected comment.")
                .isEqualTo(expectedComment);
    }

    public void validateCommentSaveButtonVisibility(){
        boolean isVisible = deviceCommentsPageObjectModel.isAddCommentButton2Visible();
        softly.assertThat(isVisible)
                .as("'Add Comment' -button should be displaying.")
                .isTrue();
    }

    public void validateCommentSaveButtonState(){
        boolean isEnabled = deviceCommentsPageObjectModel.isAddCommentButton2ButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'Add Comment' -button should be enabled.")
                .isTrue();
    }

    public void validateIfCommentIsPosted(){
        boolean isPosted = deviceCommentsPageObjectModel.isCommentPosted();
        softly.assertThat(isPosted)
                .as("Comment should be displaying after comment is created.")
                .isTrue();
    }

    public void validateCommentsDateVisibility(){
        boolean isVisible = deviceCommentsPageObjectModel.isCommentsFilteredByDate();
        softly.assertThat(isVisible)
                .as("Comment date should be displaying in ascending order")
                .isTrue();
    }

    public void validateEditIconVisibility(){
        boolean isVisible = deviceCommentsPageObjectModel.isEditIconVisible();
        softly.assertThat(isVisible)
                .as("Edit icon should be displaying before user can edit a comment.")
                .isTrue();
    }

    public void validateEditIconState(){
        boolean isEnabled = deviceCommentsPageObjectModel.isEditIconEnabled();
        softly.assertThat(isEnabled)
                .as("Edit icon should be enabled before user can edit a comment.")
                .isTrue();
    }

    public void validateEditCommentPromptWindowVisibility(){
        boolean isVisible = deviceCommentsPageObjectModel.isCommentEditPromptOpen();
        softly.assertThat(isVisible)
                .as("Comment edit popup prompt should be displaying.")
                .isTrue();
    }

    public void validateEditTextAreaState(){
        boolean isEnabled = deviceCommentsPageObjectModel.isCommentEditTextAreaEnabled();
        softly.assertThat(isEnabled)
                .as("Comment edit text area should be enabled.")
                .isTrue();
    }

    public void validateEditCommentButtonPresence(){
        boolean isVisible = deviceCommentsPageObjectModel.isEditCommentButtonVisible();
        softly.assertThat(isVisible)
                .as("Edit Comment button should be displaying on the edit comment prompt popup.")
                .isTrue();
    }

    public void validateEditCommentButtonState(){
        boolean isEnabled = deviceCommentsPageObjectModel.isEditCommentButtonEnabled();
        softly.assertThat(isEnabled)
                .as("Edit Comment button should be enabled on the edit comment prompt popup.")
                .isTrue();
    }

    public void validateEditCommentButtonName(String expectedName){
        String actualName = deviceCommentsPageObjectModel.getEditCommentButtonName();
        softly.assertThat(actualName)
                .as("Actual button name does not match expected button name.")
                .isEqualTo(expectedName);
    }

    public void validateIfCommentIsUpdated(String comment){
        boolean isEdit = deviceCommentsPageObjectModel.isCommentEdited(comment);
        softly.assertThat(isEdit)
                .as("Comment should be updated.")
                .isTrue();
    }

    public void validateIfEditedDateIsVisible(){
        boolean isVisible = deviceCommentsPageObjectModel.isEditedDateVisible();
        softly.assertThat(isVisible)
                .as("Edited date should be displaying after user updated the comment.")
                .isTrue();
    }

    public void validateDeleteIconVisibility(){
        boolean isVisible = deviceCommentsPageObjectModel.isDeleteIconVisible();
        softly.assertThat(isVisible)
                .as("Delete icon should be displaying on the device comments section.")
                .isTrue();
    }

    public void validateDeleteIconState(){
        boolean isEnabled = deviceCommentsPageObjectModel.isDeleteIconEnabled();
        softly.assertThat(isEnabled)
                .as("Delete icon should be enabled on the device comments section.")
                .isTrue();
    }

    public void validateDeleteCommentsDialogWindowVisibility(){
        boolean isVisible = deviceCommentsPageObjectModel.isCommentDeleteDialogWindowOpen();
        softly.assertThat(isVisible)
                .as("Deletion window should be displaying after user clicked on the bin icon.")
                .isTrue();
    }

    public void validateDeleteConfirmationButtonVisibility(){
        boolean isVisible = deviceCommentsPageObjectModel.isDeleteConfirmationButtonVisible();
        softly.assertThat(isVisible)
                .as("'Yes' button should be displaying on delete dialog window.")
                .isTrue();
    }

    public void validateDeleteConfirmationButtonState(){
        boolean isEnabled = deviceCommentsPageObjectModel.isDeleteConfirmationButtonEnabled();
        softly.assertThat(isEnabled)
                .as("'Yes' button should be enabled on delete dialog window.")
                .isTrue();
    }

    public void validateDeleteConfirmationButtonText(String expectedButtonName){
        String actualButtonName = deviceCommentsPageObjectModel.getButtonConfirmationName();
        softly.assertThat(actualButtonName)
                .as("Actual button name does not match expected button name.")
                .isEqualTo(expectedButtonName);
    }

    public void validateIfCommentsIsCleared(){
        boolean isCleared = deviceCommentsPageObjectModel.isCommentsCleared();
        softly.assertThat(isCleared)
                .as("'No Comments Found' -text should be displaying if there are no comments.")
                .isTrue();
    }
}