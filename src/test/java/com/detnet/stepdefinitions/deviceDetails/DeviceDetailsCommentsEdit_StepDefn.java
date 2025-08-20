package com.detnet.stepdefinitions.deviceDetails;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DeviceCommentsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DeviceCommentsValidations;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that device comments can be edited from the system.
public class DeviceDetailsCommentsEdit_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DeviceDetailsCommentsEdit_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user clicks the pencil icon for the comment")
    public void the_user_clicks_the_pencil_icon_for_the_comment() {
        DeviceCommentsPageObjectModel deviceCommentsPageObjectModel = pageObjectManager.getDeviceCommentsPageObjectModel();
        DeviceCommentsValidations deviceCommentsValidations = new DeviceCommentsValidations(deviceCommentsPageObjectModel);
        deviceCommentsValidations.validateEditIconVisibility();
        deviceCommentsValidations.validateEditIconState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        deviceCommentsPageObjectModel.openEditCommentsWindow();
    }

    @Then("a popup prompt should be displayed for comment editing")
    public void a_popup_prompt_should_be_displayed_for_comment_editing() throws InterruptedException {
        DeviceCommentsPageObjectModel deviceCommentsPageObjectModel = pageObjectManager.getDeviceCommentsPageObjectModel();
        DeviceCommentsValidations deviceCommentsValidations = new DeviceCommentsValidations(deviceCommentsPageObjectModel);
        deviceCommentsValidations.validateEditCommentPromptWindowVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user edits the comment and clicks the {string} button")
    public void the_user_edits_the_comment_and_clicks_the_button(String buttonName) {
        DeviceCommentsPageObjectModel deviceCommentsPageObjectModel = pageObjectManager.getDeviceCommentsPageObjectModel();
        DeviceCommentsValidations deviceCommentsValidations = new DeviceCommentsValidations(deviceCommentsPageObjectModel);
        deviceCommentsValidations.validateEditTextAreaState();
        deviceCommentsValidations.validateEditCommentButtonPresence();
        deviceCommentsValidations.validateEditCommentButtonState();
        deviceCommentsValidations.validateEditCommentButtonName(buttonName);
        SoftAssertionUtils.getSoftAssertions().assertAll();
        deviceCommentsPageObjectModel.editComment("This comment has been updated!");
        deviceCommentsPageObjectModel.editComment();
    }

    @Then("the comment should be updated successfully")
    public void the_comment_should_be_updated_successfully() {
        DeviceCommentsPageObjectModel deviceCommentsPageObjectModel = pageObjectManager.getDeviceCommentsPageObjectModel();
        DeviceCommentsValidations deviceCommentsValidations = new DeviceCommentsValidations(deviceCommentsPageObjectModel);
        deviceCommentsValidations.validateIfCommentIsUpdated("This comment has been updated!");
        deviceCommentsValidations.validateIfEditedDateIsVisible();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}