package com.detnet.validations.databaseValidations;

import com.detnet.pageObjects.DatabaseObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

import java.util.List;
import java.util.Map;

public class DatabaseRecipientValidations {
    private final DatabaseObjectModel databaseObjectModel;
    private final SoftAssertions softly;

    public DatabaseRecipientValidations(DatabaseObjectModel databaseObjectModel) {
        this.databaseObjectModel = databaseObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateIfRecipientsExistInDatabase(){
        boolean hasRecipients = databaseObjectModel.hasRecipients();
        softly.assertThat(hasRecipients)
                .as("There should exist at least one recipient in the database. error_recipients -table empty")
                .isTrue();
        databaseObjectModel.getAllRecipients().forEach(System.out::println);
    }

    public void validateIfRecipientExistByEmail(String email){
        List<Map<String,Object>> emailRecords = databaseObjectModel.findRecipientByEmail(email);
        softly.assertThat(emailRecords)
                .as("Recipient with email '%s' should exist in the database",email)
                .isNotNull()
                .isNotEmpty();
    }
}