package com.detnet.validations.databaseValidations;

import com.detnet.pageObjects.DatabaseObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

import java.util.List;
import java.util.Map;

// Validate users stored in the backend on the Users -table
public class DatabaseUsersValidations {
    private final DatabaseObjectModel databaseObjectModel;
    private final SoftAssertions softly;

    public DatabaseUsersValidations(DatabaseObjectModel databaseObjectModel) {
        this.databaseObjectModel = databaseObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateUserExistenceInDatabase(){
        boolean hasUsers = databaseObjectModel.hasUsers();
        softly.assertThat(hasUsers)
                .as("Users should exist on the 'users' -table on the database")
                .isTrue();
        databaseObjectModel.getAllUsers().forEach(System.out::println);
    }

    public void validateUserExistsByEmail(String email){
        List<Map<String,Object>> userRecords = databaseObjectModel.findUserByEmail(email);
        softly.assertThat(userRecords)
                .as("User with email '%s' should exist in the database",email)
                .isNotNull()
                .isNotEmpty();
        databaseObjectModel.getAllUsers().forEach(System.out::println);
    }

    public void validateIfUserSurnameUpdated(String expectedSurname,String userEmail){
        List<Map<String,Object>> userRecords = databaseObjectModel.findUserByEmail(userEmail);
        softly.assertThat(userRecords)
                .as("User with email '%s' should exist in the database",userEmail)
                .isNotEmpty();
        String actualSurname = (String) userRecords.get(0).get("surname");
        softly.assertThat(actualSurname)
                .as("Expected surname to be updated to '%s' but was '%s'",expectedSurname,actualSurname)
                .isEqualToIgnoringCase(expectedSurname);
    }

    public void validateIfUserIsDeleted(String email){
        List<Map<String,Object>> userRecords = databaseObjectModel.findUserByEmail(email);
        softly.assertThat(userRecords)
                .as("User with email '%s' should not exist in the database after deletion",email)
                .isEmpty();
    }
}