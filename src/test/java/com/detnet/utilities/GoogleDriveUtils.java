package com.detnet.utilities;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.Permission;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

public class GoogleDriveUtils {
    private static final String APPLICATION_NAME = "BlastWeb SBC";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String CREDENTIALS_FILE_PATH = "src/test/resources/blastweb-b89900d13439.json"; // Add credentials file path here
    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);

//    Initialize the Google Drive Services
    public static Drive getDriveServices() throws GeneralSecurityException, IOException {
        InputStream inputStream = Files.newInputStream(Paths.get(CREDENTIALS_FILE_PATH));
        GoogleCredential credential = GoogleCredential.fromStream(inputStream)
                .createScoped(SCOPES);
        return new Drive.Builder(GoogleNetHttpTransport.newTrustedTransport(),JSON_FACTORY,credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

//    Uploads the test report to Google Drive
    public static String uploadReportToDrive(String filePath, String mimeType) throws IOException, GeneralSecurityException {
        Drive service = getDriveServices();
        File fileMetaData = new File();
        fileMetaData.setName("blastweb-report");

        java.io.File filePathOnDisk = new java.io.File(filePath);
        FileContent mediaContent = new FileContent(mimeType,filePathOnDisk);
        File file = service.files().create(fileMetaData,mediaContent)
                .setFields("id")
                .execute();

//        Sets the file publicly accessible
        Permission permission = new Permission();
        permission.setType("anyone");
        permission.setRole("reader");
        service.permissions().create(file.getId(),permission).execute();

        return "https://drive.google.com/uc?id=" + file.getId();
    }
}