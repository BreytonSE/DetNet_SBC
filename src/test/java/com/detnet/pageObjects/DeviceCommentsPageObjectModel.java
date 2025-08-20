package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.detnet.locators.DeviceCommentsPageLocators.*;

public class DeviceCommentsPageObjectModel {
    private final Page page;

    public DeviceCommentsPageObjectModel(Page page) {
        this.page = page;
    }

    public boolean isDeviceCommentsPageVisible(){
        try{
            page.locator(commentsHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Comments heading not visible or not found on the device comments page: " + e.getMessage());
            return false;
        }
    }

    public String getCommentsPageURL(){
        try{
            page.waitForURL("**/device-details/*/comments");
            return page.url();
        }catch (PlaywrightException e){
            System.out.println("URL not found or invalid: " + e.getMessage());
            return null;
        }
    }

    public boolean isAddCommentButtonVisible(){
        try{
            page.locator(addCommentButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Comment button not visible or not found on device comments page: " + e.getMessage());
            return false;
        }
    }

    public boolean isAddCommentButtonEnabled(){
        try{
            return page.locator(addCommentButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Comment button not visible or not found on device comments page: " + e.getMessage());
            return false;
        }
    }

    public String getButtonName(){
        try{
            return page.locator(addCommentButton).textContent();
        }catch (PlaywrightException e){
            System.out.println("'Add Comment' -button not visible or not found: " + e.getMessage());
            return null;
        }
    }

    public void openCommentPromptWindow(){
        try{
            page.locator(addCommentButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Add Comment' -button not visible or not found: " + e.getMessage());
        }
    }

    public boolean isCommentPromptWindowOpen(){
        try{
            page.locator(commentsPromptWindow)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Comments prompt window not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isCommentsInputFieldVisible(){
        try{
            page.locator(commentsInputField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Comments input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isCommentsInputFieldEnabled(){
        try{
            return page.locator(commentsInputField).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Comments input field not visible or not found: " + e.getMessage());
            return false;
        }
    }

    public void setComment(String comment){
        try{
            page.locator(commentsInputField).click(new Locator.ClickOptions().setTimeout(5000));
            page.locator(commentsInputField).fill(comment);
        }catch (PlaywrightException e){
            System.out.println("Comment input field not visible or not found: " + e.getMessage());
        }
    }

    public String getComment(){
        try{
            return page.locator(commentTextArea).inputValue();
        }catch (PlaywrightException e){
            System.out.println("No comments found in input dialog or not visible: " + e.getMessage());
            return null;
        }
    }

    public boolean isAddCommentButton2Visible(){
        try{
            page.locator(addCommentButton2)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'Add Comment' -button not visible or not found on comment dialog: " + e.getMessage());
            return false;
        }
    }

    public boolean isAddCommentButton2ButtonEnabled(){
        try {
            return page.locator(addCommentButton2).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Add Comment' -button not visible or not found on comment dialog: " + e.getMessage());
            return false;
        }
    }

    public void saveComment(){
        try{
            page.locator(addCommentButton2).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Add Comment' -button not visible or not found on comment dialog: " + e.getMessage());
        }
    }

    public boolean isCommentPosted(){
        try{
            page.waitForTimeout(5000);
            page.locator(comments)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Comment not found or not visible on the comments screen: " + e.getMessage());
            return false;
        }
    }

    public boolean isCommentsFilteredByDate(){
        try{
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
          String todayDate = LocalDate.now().format(formatter);
          String dateXpath = String.format("//span[contains(normalize-space(), \"%s\")]",todayDate);

            page.locator(dateXpath)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Date and time not found or not visible on the comments: " + e.getMessage());
            return false;
        }
    }

    public boolean isEditIconVisible(){
        try{
            page.waitForTimeout(5000);
            page.locator(pencilIcon)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Edit icon not visible or not found on device comments page: " + e.getMessage());
            return false;
        }
    }

    public boolean isEditIconEnabled(){
        try{
            return page.locator(pencilIcon).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Edit icon not visible or not found on device comments page: " + e.getMessage());
            return false;
        }
    }

    public void openEditCommentsWindow(){
        try{
            page.locator(pencilIcon).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Edit icon not visible or not found on device comments page: " + e.getMessage());
        }
    }

    public boolean isCommentEditPromptOpen(){
        try{
            page.locator(editCommentHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Edit popup prompt not visible or found when user clicked on edit icon: " + e.getMessage());
            return false;
        }
    }

    public boolean isCommentEditTextAreaEnabled(){
        try{
           return page.locator(commentEditTextArea).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Comment edit text area not found or not visible on the comment prompt popup: " + e.getMessage());
            return false;
        }
    }

    public void editComment(String comment){
        try{
            page.locator(commentEditTextArea).click(new Locator.ClickOptions().setTimeout(5000));
            page.locator(commentEditTextArea).clear();
            page.locator(commentEditTextArea).fill(comment);
        }catch (PlaywrightException e){
            System.out.println("Comment text area not visible or not found on the edit comment prompt window: "
                    + e.getMessage());
        }
    }

    public boolean isEditCommentButtonVisible(){
        try{
            page.locator(editCommentButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'Edit Comment' -button not found or not visible on the edit comment prompt popup: " +
                    e.getMessage());
            return false;
        }
    }

    public boolean isEditCommentButtonEnabled(){
        try{
            return page.locator(editCommentButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Edit Comment' -button not found or not visible on the edit comment prompt popup: " +
                    e.getMessage());
            return false;
        }
    }

    public String getEditCommentButtonName(){
        try{
            String editCommentBtnName = "//button[@type=\"submit\"]//span[contains(text(),\"Edit Comment\")]";
            return page.locator(editCommentBtnName).textContent();
        }catch (PlaywrightException e){
            System.out.println("'Edit Comment' -button not found or not visible on the edit comment prompt popup: " +
                    e.getMessage());
            return null;
        }
    }

    public void editComment(){
        try{
            page.locator(editCommentButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Edit Comment' -button not found or not visible on the edit comment prompt popup: " +
                    e.getMessage());
        }
    }

    public boolean isCommentEdited(String comment){
        String commentName = String.format("//span[normalize-space()=\"%s\"]", comment);
        try{
            page.waitForTimeout(5000);
            page.locator(commentName)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Updated comment not found or not visible on the comments page:");
            return false;
        }
    }

    public boolean isEditedDateVisible(){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String todayDate = LocalDate.now().format(formatter);
            String dateXpath = String.format("//span[contains(normalize-space(), \"%s\")]",todayDate);

            page.locator(dateXpath)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            page.locator(editTxt)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Today's date not found or not visible on the edited comments: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeleteIconVisible(){
        try{
            page.waitForTimeout(5000);
            page.locator(deleteIcon)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Delete icon not visible or not found on device comments: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeleteIconEnabled(){
        try{
            return page.locator(deleteIcon).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("Delete icon not visible or not found on device comments: " + e.getMessage());
            return false;
        }
    }

    public void openDeleteDialogWindow(){
        try{
            page.locator(deleteIcon).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("Delete icon not visible or not found on device comments: " + e.getMessage());
        }
    }

    public boolean isCommentDeleteDialogWindowOpen(){
        try{
            page.locator(deleteCommentHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("Delete dialog window not visible or not found after user clicked on bin icon: "
                    + e.getMessage());
            return false;
        }
    }

    public boolean isDeleteConfirmationButtonVisible(){
        try{
            page.locator(deleteYesButton)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'Yes' -button not visible or not found on delete dialog window: " + e.getMessage());
            return false;
        }
    }

    public boolean isDeleteConfirmationButtonEnabled(){
        try{
            return page.locator(deleteYesButton).isEnabled();
        }catch (PlaywrightException e){
            System.out.println("'Yes' -button not visible or not found on delete dialog window: " + e.getMessage());
            return false;
        }
    }

    public String getButtonConfirmationName(){
        try{
            String yesButtonXpath = "//span[normalize-space()=\"Yes\"]";
            return page.locator(yesButtonXpath).textContent();
        }catch (PlaywrightException e){
            System.out.println("'Yes' -button not visible or not found on delete dialog window: " + e.getMessage());
            return null;
        }
    }

    public void deleteComment(){
        try{
            page.locator(deleteYesButton).click(new Locator.ClickOptions().setTimeout(5000));
        }catch (PlaywrightException e){
            System.out.println("'Yes' -button not visible or not found on delete dialog window: " + e.getMessage());
        }
    }

    public boolean isCommentsCleared(){
        try{
            page.locator(noCommentTxt)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            System.out.println("'No comments found' -text not visible or not found on device comments window: " +
                    e.getMessage());
            return false;
        }
    }
}