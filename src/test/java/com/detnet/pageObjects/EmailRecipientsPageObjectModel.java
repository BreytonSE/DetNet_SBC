package com.detnet.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

public class EmailRecipientsPageObjectModel {
    private final Page page;
    private final String recipientListHeading = "//h2[normalize-space()=\"Recipient List\"]";
    private final String noRecipientsText = "//h2[normalize-space()=\"No Recipient Present\"]";
    private final String addRecipientBtn = "//button[@class=\"addBtn ng-star-inserted\"]";
    private final String addRecipientHeading = "//h2[normalize-space()=\"Add Recipient\"]";
    private final String emailAddressField = "//input[@id=\"addRecipientEmail\"]";
    private final String firstNameField = "xpath=/html[1]/body[1]/app-root[1]/settings[1]/div[1]/div[2]/app-add-email[1]/div[1]/div[1]/div[1]/form[1]/mat-form-field[2]/div[1]/div[2]/div[1]/label[1]/mat-label[1]";

    public EmailRecipientsPageObjectModel(Page page) {
        this.page = page;
    }

    public String getEmailRecipientPageURL(){
        page.waitForURL("**/settings/emailRecipient");
        return page.url();
    }

    public boolean isRecipientListHeadingVisible(){
        try{
            page.locator(recipientListHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public String getHeadingText(){
        return page.locator(recipientListHeading).textContent();
    }

    public boolean isRecipientListEmpty(){
        try{
            page.locator(noRecipientsText)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isAddRecipientButtonVisible(){
        try{
            page.locator(addRecipientBtn)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isAddRecipientButtonEnabled(){
        return page.locator(addRecipientBtn).isEnabled();
    }

    public void createEmailRecipient(){
        page.locator(addRecipientBtn).click(new Locator.ClickOptions().setTimeout(5000));
    }

    public boolean isAddRecipientFormVisible(){
        try{
            page.locator(addRecipientHeading)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isEmailAddressFieldVisible(){
        try{
            page.locator(emailAddressField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isEmailAddressFieldEnabled(){
        return page.locator(emailAddressField).isEnabled();
    }

    public boolean isEmailAddressFieldEmpty(){
        String emailAddressInputField = page.locator(emailAddressField).inputValue();
        return emailAddressInputField == null || emailAddressInputField.trim().isEmpty();
    }

    public void setEmailAddress(String emailAddress){
        page.locator(emailAddressField).click();
        page.locator(emailAddressField).fill(emailAddress);
    }

    public String getEmailAddress(){
        return page.locator(emailAddressField).inputValue();
    }

    public boolean isFirstNameFieldVisible(){
        try{
            page.locator(firstNameField)
                    .waitFor(new Locator.WaitForOptions()
                            .setState(WaitForSelectorState.VISIBLE)
                            .setTimeout(5000));
            return true;
        }catch (PlaywrightException e){
            return false;
        }
    }

    public boolean isFirstNameFieldEnabled(){
        return page.locator(firstNameField).isEnabled();
    }

    public boolean isFirstNameFieldEmpty(){
        String firstNameInputField = page.locator(firstNameField).inputValue();
        return firstNameInputField == null || firstNameInputField.trim().isEmpty();
    }

    public void setFirstName(String firstName){
        page.locator(firstNameField).click();
        page.locator(firstNameField).fill(firstName);
    }

    public String getFirstName(){
        return page.locator(firstNameField).inputValue();
    }
}