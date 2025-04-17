package com.detnet.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class LoginConstantUtils {
    private static final String CREDENTIALS_FILE = "src/test/resources/credentials.properties";

    public static String getDecryptedUsername() throws Exception {
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get(CREDENTIALS_FILE)));
        return EncryptionUtils.decrypt(properties.getProperty("encrypted.username").trim());
    }

    public static String getDecryptedPassword() throws Exception {
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get(CREDENTIALS_FILE)));
        return EncryptionUtils.decrypt(properties.getProperty("encrypted.password")).trim();
    }

    public static String getDecryptedServerConfigPassword() throws Exception {
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get(CREDENTIALS_FILE)));
        return EncryptionUtils.decrypt(properties.getProperty("encrypted.configPassword")).trim();
    }

    public static String getDecryptedEmailAddress() throws Exception {
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get(CREDENTIALS_FILE)));
        return EncryptionUtils.decrypt(properties.getProperty("encrypted.emailAddress")).trim();

    }

    public static String getDecryptedEmailPassword() throws Exception {
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get(CREDENTIALS_FILE)));
        return EncryptionUtils.decrypt(properties.getProperty("encrypted.emailPassword")).trim();
    }
}