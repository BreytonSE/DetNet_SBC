package com.detnet.stepdefinitions.deviceDetails;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DeviceCommentsPageObjectModel;
import com.detnet.pageObjects.DeviceDetailsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DeviceCommentsValidations;
import com.detnet.validations.blastWebValidations.DeviceDetailsValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that the device details comments components loads with appropriate data.
public class DeviceDetailsComments_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DeviceDetailsComments_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the the user navigates to the device details comments page")
    public void the_the_user_navigates_to_the_device_details_comments_page() {
        DeviceDetailsPageObjectModel deviceDetailsPageObjectModel = pageObjectManager.getDeviceDetailsPageObjectModel();
        DeviceDetailsValidation deviceDetailsValidation = new DeviceDetailsValidation(deviceDetailsPageObjectModel);
        deviceDetailsValidation.validateCommentsTabVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        deviceDetailsPageObjectModel.openDeviceComments();

        DeviceCommentsPageObjectModel deviceCommentsPageObjectModel = pageObjectManager.getDeviceCommentsPageObjectModel();
        DeviceCommentsValidations deviceCommentsValidations = new DeviceCommentsValidations(deviceCommentsPageObjectModel);
        deviceCommentsValidations.validateCommentsPageVisibility();
        deviceCommentsValidations.validateCommentsPageURL("http://localhost:8080/en/device-details/502/comments");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user clicks the Add Comment button")
    public void the_user_clicks_the_add_comment_button() {
        DeviceCommentsPageObjectModel deviceCommentsPageObjectModel = pageObjectManager.getDeviceCommentsPageObjectModel();
        DeviceCommentsValidations deviceCommentsValidations = new DeviceCommentsValidations(deviceCommentsPageObjectModel);
        deviceCommentsValidations.validateAddCommentButtonVisibility();
        deviceCommentsValidations.validateAddCommentButtonState();
        deviceCommentsValidations.validateButtonName(" Add Comment ");
        SoftAssertionUtils.getSoftAssertions().assertAll();
        deviceCommentsPageObjectModel.openCommentPromptWindow();
    }

    @When("the user enters a comment to be added to the device")
    public void the_user_enters_a_comment_to_be_added_to_the_device() {
        DeviceCommentsPageObjectModel deviceCommentsPageObjectModel = pageObjectManager.getDeviceCommentsPageObjectModel();
        DeviceCommentsValidations deviceCommentsValidations = new DeviceCommentsValidations(deviceCommentsPageObjectModel);
        deviceCommentsValidations.validateCommentsWindowVisibility();
        deviceCommentsValidations.validateCommentsInputFieldVisibility();
        deviceCommentsValidations.validateCommentsInputFieldState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        deviceCommentsPageObjectModel.setComment("This is BCU 502");
        deviceCommentsValidations.validateCommentText("This is BCU 502");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user saves the comment")
    public void the_user_saves_the_comment() {
        DeviceCommentsPageObjectModel deviceCommentsPageObjectModel = pageObjectManager.getDeviceCommentsPageObjectModel();
        DeviceCommentsValidations deviceCommentsValidations = new DeviceCommentsValidations(deviceCommentsPageObjectModel);
        deviceCommentsValidations.validateCommentSaveButtonVisibility();
        deviceCommentsValidations.validateCommentSaveButtonState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        deviceCommentsPageObjectModel.saveComment();
    }

    @Then("the comment should be displayed on the comments page")
    public void the_comment_should_be_displayed_on_the_comments_page() {
        DeviceCommentsPageObjectModel deviceCommentsPageObjectModel = pageObjectManager.getDeviceCommentsPageObjectModel();
        DeviceCommentsValidations deviceCommentsValidations = new DeviceCommentsValidations(deviceCommentsPageObjectModel);
        deviceCommentsValidations.validateIfCommentIsPosted();
        deviceCommentsValidations.validateCommentsDateVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}