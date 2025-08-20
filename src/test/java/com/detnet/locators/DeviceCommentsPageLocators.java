package com.detnet.locators;

public class DeviceCommentsPageLocators {
    public static final String commentsHeading = "//span[@class=\"titlecase\"][normalize-space()=\"Comments\"]";
    public static final String addCommentButton = "//span[@class=\"mdc-button__label\"][normalize-space()=\"Add Comment\"]";
    public static final String commentsPromptWindow = "//h1[normalize-space()=\"Add Comment\"]";
    public static final String commentsInputField = "xpath=/html[1]/body[1]/div[2]/div[2]/div[1]/mat-dialog-container[1]/div[1]/div[1]/add-comment-dialog[1]/div[1]/form[1]/mat-form-field[1]/div[1]/div[2]/div[1]/label[1]/mat-label[1]";
    public static final String commentTextArea = "xpath=/html[1]/body[1]/div[2]/div[2]/div[1]/mat-dialog-container[1]/div[1]/div[1]/add-comment-dialog[1]/div[1]/form[1]/mat-form-field[1]/div[1]/div[2]/div[1]/textarea[1]";
    public static final String addCommentButton2 = "//button[@class=\"addComment\"]";
    public static final String comments = "//body/app-root/device-details[@class=\"ng-star-inserted\"]/div[@class=\"sideMenuContainer\"]/div[@class=\"content\"]/device-comments[@class=\"ng-star-inserted\"]/div[@class=\"short-container\"]/blastweb-spinner[@label=\"Loading Device Comments\"]/blastweb-zero-data[@class=\"ng-star-inserted\"]/div[@class=\"ng-star-inserted\"]/comment/blastweb-spinner[@label=\"Loading Device Comments\"]/div[1]";
    public static final String pencilIcon = "//mat-icon[@class=\"mat-icon notranslate mat-mdc-tooltip-trigger spaced-icon mat-accent material-icons mat-ligature-font ng-star-inserted\"]";
    public static final String editCommentHeading = "//h1[normalize-space()=\"Edit Comment\"]";
    public static final String commentEditTextArea = "xpath=/html[1]/body[1]/div[3]/div[2]/div[1]/mat-dialog-container[1]/div[1]/div[1]/app-edit-comment-dialog[1]/div[1]/form[1]/mat-form-field[1]/div[1]/div[2]/div[1]/textarea[1]\n";
    public static final String editCommentButton = "//button[@class=\"editComment\"]";
    public static final String editTxt = "//span[@class=\"editedTxt ng-star-inserted\"]";
    public static final String deleteIcon = "//span[@class=\"mat-mdc-tooltip-trigger material-symbols-rounded delComment ng-star-inserted\"]";
    public static final String deleteCommentHeading = "//h1[normalize-space()=\"Delete Comment?\"]";
    public static final String deleteYesButton = "//button[@class=\"yesBtn\"]";
    public static final String noCommentTxt = "//h2[normalize-space()=\"No Comments Found\"]";
}