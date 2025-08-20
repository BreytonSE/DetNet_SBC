package com.detnet.stepdefinitions.deviceDetails;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DeviceCommentsPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DeviceCommentsValidations;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

//   Scenario: Verify that device comments can be deleted from the system
public class DeviceDetailsCommentsDelete_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DeviceDetailsCommentsDelete_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("user click the delete icon to delete the comment")
    public void user_click_the_delete_icon_to_delete_the_comment() {
        DeviceCommentsPageObjectModel deviceCommentsPageObjectModel = pageObjectManager.getDeviceCommentsPageObjectModel();
        DeviceCommentsValidations deviceCommentsValidations = new DeviceCommentsValidations(deviceCommentsPageObjectModel);
        deviceCommentsValidations.validateDeleteIconVisibility();
        deviceCommentsValidations.validateDeleteIconState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        deviceCommentsPageObjectModel.openDeleteDialogWindow();
    }

    @Then("a popup prompt should display for comment deletion")
    public void a_popup_prompt_should_display_for_comment_deletion() {
        DeviceCommentsPageObjectModel deviceCommentsPageObjectModel = pageObjectManager.getDeviceCommentsPageObjectModel();
        DeviceCommentsValidations deviceCommentsValidations = new DeviceCommentsValidations(deviceCommentsPageObjectModel);
        deviceCommentsValidations.validateDeleteCommentsDialogWindowVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user delete the comment by clicking the {string} button")
    public void the_user_delete_the_comment_by_clicking_the_button(String buttonName) {
        DeviceCommentsPageObjectModel deviceCommentsPageObjectModel = pageObjectManager.getDeviceCommentsPageObjectModel();
        DeviceCommentsValidations deviceCommentsValidations = new DeviceCommentsValidations(deviceCommentsPageObjectModel);
        deviceCommentsValidations.validateDeleteConfirmationButtonVisibility();
        deviceCommentsValidations.validateDeleteConfirmationButtonState();
        deviceCommentsValidations.validateDeleteConfirmationButtonText(buttonName);
        SoftAssertionUtils.getSoftAssertions().assertAll();
        deviceCommentsPageObjectModel.deleteComment();
    }

    @Then("the comment should be deleted successfully")
    public void the_comment_should_be_deleted_successfully() {
        DeviceCommentsPageObjectModel deviceCommentsPageObjectModel = pageObjectManager.getDeviceCommentsPageObjectModel();
        DeviceCommentsValidations deviceCommentsValidations = new DeviceCommentsValidations(deviceCommentsPageObjectModel);
        deviceCommentsValidations.validateIfCommentsIsCleared();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}