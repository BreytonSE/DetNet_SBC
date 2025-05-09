package com.detnet.validations.databaseValidations;

import com.detnet.pageObjects.DatabaseObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

import java.util.List;
import java.util.Map;

// Validate networks stored in the backend
public class DatabaseNetworksValidations {
    private final DatabaseObjectModel databaseObjectModel;
    private final SoftAssertions softly;

    public DatabaseNetworksValidations(DatabaseObjectModel databaseObjectModel) {
        this.databaseObjectModel = databaseObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateNetworkExistenceInDatabase(){
        boolean hasNetworks = databaseObjectModel.hasNetworks();
        softly.assertThat(hasNetworks)
                .as("Same network(s) should be present in the database as shown on the BlastWeb interface")
                .isTrue();
        databaseObjectModel.getAllNetworks().forEach(System.out::println);
    }

    public void validateNetworkExistById(int id){
        List<Map<String, Object>> networkRecords = databaseObjectModel.findNetworkById(id);
        softly.assertThat(networkRecords)
                .as("Network with ID '%s' should exist in database",id)
                .isNotNull()
                .isNotEmpty();
        databaseObjectModel.getAllUsers().forEach(System.out::println);
    }

    public void validateIfNetworkMessageGapUpdated(int expectedMessageGap, int id){
        List<Map<String,Object>> networkRecords = databaseObjectModel.findNetworkById(id);
        softly.assertThat(networkRecords)
                .as("Network with id '%s' should exist in the database",id)
                .isNotEmpty();
        int actualMessageGap = (int) networkRecords.get(0).get("messagegap");
        softly.assertThat(actualMessageGap)
                .as("Expected message gap to be updated to '%s' but was '%s'",expectedMessageGap,actualMessageGap)
                .isEqualTo(expectedMessageGap);
    }

    public void validateIfNetworkDelayUpdated(int expectedDelay,int id){
        List<Map<String,Object>> networkRecords = databaseObjectModel.findNetworkById(id);
        softly.assertThat(networkRecords)
                .as("Network with id '%s' should exist in the database",id)
                .isNotEmpty();
        int actualDelay = (int) networkRecords.get(0).get("netdelay");
        softly.assertThat(actualDelay)
                .as("Expected delay to be updated to '%s' but was '%s'",expectedDelay,actualDelay)
                .isEqualTo(expectedDelay);
    }
}