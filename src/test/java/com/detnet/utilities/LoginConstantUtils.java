package com.detnet.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class LoginConstantUtils {
    private static final String CREDENTIALS_FILE = "src/test/resources/credentials.properties";
    private static final Properties properties = new Properties();
    private static final boolean isCI = System.getenv("GITHUB_ACTIONS") != null;

    static {
        if(!isCI){
            try{
                properties.load(Files.newInputStream(Paths.get(CREDENTIALS_FILE)));
            }catch (IOException e) {
                throw new RuntimeException("Failed to load credentials file", e);
            }
        }
    }

    private static String getEncryptedValue(String key, String envVar){
        if(isCI){
            String value = System.getenv(envVar);
            if (value == null) throw new RuntimeException("Missing environment variable: " + envVar);
            return value.trim();
        }else {
            return properties.getProperty(key).trim();
        }
    }

    public static String getDecryptedUsername() throws Exception {
        return EncryptionUtils.decrypt(getEncryptedValue("encrypted.username","BLASTWEB_USERNAME"));
    }

    public static String getDecryptedPassword() throws Exception {
        return EncryptionUtils.decrypt(getEncryptedValue("encrypted.password","BLASTWEB_PASSWORD"));
    }

    public static String getDecryptedServerConfigPassword() throws Exception {
        return EncryptionUtils.decrypt(getEncryptedValue("encrypted.configPassword","BLASTWEB_SERVER_CONFIG_PASSWORD"));
    }

    public static String getDecryptedEmailAddress() throws Exception {
        return EncryptionUtils.decrypt(getEncryptedValue("encrypted.emailAddress","TESTER_EMAIL_ADDRESS"));
    }

    public static String getDecryptedEmailPassword() throws Exception {
        return EncryptionUtils.decrypt(getEncryptedValue("encrypted.emailPassword","TESTER_EMAIL_APP_PASSWORD"));
    }

    public static String getDecryptedDatabaseUsername() throws Exception {
        return EncryptionUtils.decrypt(properties.getProperty("encrypted.databaseUsername"));
    }

    public static String getDecryptedDatabasePassword() throws Exception {
        return EncryptionUtils.decrypt(properties.getProperty("encrypted.databasePassword"));
    }
}