package com.detnet.stepdefinitions.networkManagement;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.NetworkPageObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.NetworkValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

public class DeleteNetwork_StepDefn {
    private final PageObjectManager pageObjectManager;

    public DeleteNetwork_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @When("the user clicks on the trash icon associated with the network to be deleted")
    public void the_user_clicks_on_the_trash_icon_associated_with_the_network_to_be_deleted() {
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        NetworkValidation networkValidation = new NetworkValidation(networkPageObjectModel);
        networkValidation.validateDeleteIconVisibility();
        networkValidation.validateDeleteIconState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        networkPageObjectModel.deleteNetwork("3");
    }

    @When("the user confirms the deletion by clicking the Delete button in the popup")
    public void the_user_confirms_the_deletion_by_clicking_the_delete_button_in_the_popup() throws InterruptedException {
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        NetworkValidation networkValidation = new NetworkValidation(networkPageObjectModel);
        networkValidation.validateDeleteDialogVisibility();
        networkValidation.validateDeleteNetworkYesButtonVisibility();
        networkValidation.validateDeleteNetworkYesButtonState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        networkPageObjectModel.confirmToDeleteNetwork();
        networkValidation.validateDeleteDialogClosed();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the network should no longer be visible on the BlastWeb interface")
    public void the_network_should_no_longer_be_visible_on_the_blast_web_interface() {
        NetworkPageObjectModel networkPageObjectModel = pageObjectManager.getNetworkPageObjectModel();
        NetworkValidation networkValidation = new NetworkValidation(networkPageObjectModel);
        networkValidation.validateIfNetworkIsDeleted();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}