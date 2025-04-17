package com.detnet.utilities;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

public class EncryptionUtils {
    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = loadSecretKey();

    private static String loadSecretKey() {
//        Load from environment variable
        String envKey = System.getenv("ENC_KEY");
        if (envKey != null && !envKey.isEmpty()) {
            return envKey;
        }

//        Fallback to encryption.properties
        try(InputStream inputStream = Files.newInputStream(Paths.get("src/test/resources/encryption.properties"))){
            Properties props = new Properties();
            props.load(inputStream);
            return props.getProperty("encryption.key");
        }catch (IOException e){
            throw new RuntimeException("Encryption key not found in environment or credentials.properties",e);
        }
    }

    public static String encrypt(String data) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(),ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static String decrypt(String encryptedData) throws Exception{
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(),ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE,key);
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedData);
    }

    public static void main(String[] args) throws Exception {
        String username = "";
        String password = "";
        String decryptedUsername = decrypt(username);
        String encryptedUsername = encrypt(username);
        String decryptedPassword = decrypt(password);
        String encryptedPassword = encrypt(password);
        System.out.println("Encrypted Username: " + encryptedUsername);
        System.out.println("Decrypted Username: " + decryptedUsername);
        System.out.println("Encrypted Password: " + encryptedPassword);
        System.out.println("Decrypted Password: " + decryptedPassword);
    }
}