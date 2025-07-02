package com.detnet.validations.databaseValidations;

import com.detnet.pageObjects.DatabaseObjectModel;
import com.detnet.utilities.SoftAssertionUtils;
import org.assertj.core.api.SoftAssertions;

import java.util.List;
import java.util.Map;

public class DatabaseDevicesValidations {
    private final DatabaseObjectModel databaseObjectModel;
    private final SoftAssertions softly;

    public DatabaseDevicesValidations(DatabaseObjectModel databaseObjectModel) {
        this.databaseObjectModel = databaseObjectModel;
        softly = SoftAssertionUtils.getSoftAssertions();
    }

    public void validateIfDeviceUpdatedInDatabase(int deviceId, String expectedDeviceLocation){
        List<Map<String,Object>> device = databaseObjectModel.findDeviceById(deviceId,expectedDeviceLocation);
        
        if (device.isEmpty()) {
            throw new AssertionError(String.format("Device id '%s' with location '%s' not found in the database.",
                    deviceId, expectedDeviceLocation));
        }

        softly.assertThat(device)
                .as("Device id '%s' with location name '%s' should exist in the database",deviceId,expectedDeviceLocation)
                .isNotEmpty();
        String actualDeviceLocation = (String) device.get(0).get("location");
        softly.assertThat(actualDeviceLocation)
                .as("Actual device location does not match expected device location. Expected '%s', but was '%s'",expectedDeviceLocation,actualDeviceLocation)
                .isEqualTo(expectedDeviceLocation);
    }
}