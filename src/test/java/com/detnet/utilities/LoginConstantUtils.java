package com.detnet.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class LoginConstantUtils {
    private static final String CREDENTIALS_FILE = "src/test/resources/credentials.properties";
    private static final Properties properties = new Properties();

    static {
        try{
            properties.load(Files.newInputStream(Paths.get(CREDENTIALS_FILE)));
        }catch (IOException e){
            throw new RuntimeException("Failed to load credentials file");
        }
    }

    public static String getDecryptedUsername() throws Exception {
        return EncryptionUtils.decrypt(properties.getProperty("encrypted.username").trim());
    }

    public static String getDecryptedPassword() throws Exception {
        return EncryptionUtils.decrypt(properties.getProperty("encrypted.password")).trim();
    }

    public static String getDecryptedServerConfigPassword() throws Exception {
        return EncryptionUtils.decrypt(properties.getProperty("encrypted.configPassword")).trim();
    }

    public static String getDecryptedEmailAddress() throws Exception {
        return EncryptionUtils.decrypt(properties.getProperty("encrypted.emailAddress")).trim();
    }

    public static String getDecryptedEmailPassword() throws Exception {
        return EncryptionUtils.decrypt(properties.getProperty("encrypted.emailPassword")).trim();
    }

    public static String getDecryptedDatabaseUsername() throws Exception {
        return EncryptionUtils.decrypt(properties.getProperty("encrypted.databaseUsername"));
    }

    public static String getDecryptedDatabasePassword() throws Exception {
        return EncryptionUtils.decrypt(properties.getProperty("encrypted.databasePassword"));
    }
}