package com.detnet.validations.databaseValidations;

import com.detnet.pageObjects.DatabaseObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

import java.util.List;
import java.util.Map;

public class DatabaseGroupsValidations {
    private final DatabaseObjectModel databaseObjectModel;
    private final SoftAssertions softly;

    public DatabaseGroupsValidations(DatabaseObjectModel databaseObjectModel) {
        this.databaseObjectModel = databaseObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateIfGroupExistByName(String name){
        List<Map<String,Object>> groupRecords = databaseObjectModel.findGroupByName(name);
        softly.assertThat(groupRecords)
                .as("Group with '%s' should exist in the database",name)
                .isNotNull()
                .isNotEmpty();
        databaseObjectModel.getAllGroups().forEach(System.out::println);
    }

    public void validateGroupsExistsInDatabase(){
        boolean hasGroups = databaseObjectModel.hasGroups();
        softly.assertThat(hasGroups)
                .as("Groups should exist on the 'device_groups' -table")
                .isTrue();
        databaseObjectModel.getAllGroups().forEach(System.out::println);
    }
}