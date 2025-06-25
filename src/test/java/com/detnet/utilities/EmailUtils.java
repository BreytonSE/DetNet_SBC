package com.detnet.utilities;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class EmailUtils {

    public static void sendEmail(){
        try{
            Thread.sleep(1500);
            emailReport();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void emailReport(){
        try{
            File allureReportFile = locateTestReport();
            if(allureReportFile == null){
                System.out.println("No Allure report found. Skipping email.");
                return;
            }

//            Upload the Allure report and get the shared link
            String allureReportLink = GoogleDriveUtils.uploadReportToDrive(allureReportFile.getPath(),"text/html");

            List<String> recipientsEmails = Arrays.asList(
                    "breytonseanernstzen1224@gmail.com",
                    "breyton.ernstzen@testheroes.co.za",
                    "moosaa@detnet.com",
                    "maysond@detnet.com",
                    "kydh@detnet.com",
                    "coetseet@detnet.com"
            );
            sendEmailWithAttachment(recipientsEmails,
                    "BlastWeb Test Report",
                    "Hi. Please see the provided download link to get the latest BlastWeb test report results.",
                    allureReportLink);
        }catch (Exception e){
            throw new RuntimeException("Failed to send test report email: " + e.getMessage(),e);
        }
    }

    private static File locateTestReport(){
        String baseDir = System.getProperty("user.dir");
        File testReportDir = new File(baseDir,"allure-report");
        File originalHtmlFile = new File(testReportDir,"index.html");

        if(!originalHtmlFile.exists()){
            System.out.println("BlastWeb report index.html not found");
            return null;
        }

        String newHtmlFileName = "BlastWeb_TestReport_" +
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".html";
        File renamedHtmlFile = new File(testReportDir,newHtmlFileName);

        if(!originalHtmlFile.renameTo(renamedHtmlFile)){
            System.out.println("Failed to rename BlastWeb report file.");
            return null;
        }
        return renamedHtmlFile;
    }

    private static void sendEmailWithAttachment(List<String> toEmails, String subject, String body, String sharedLink){
        Session session = createEmailSession();

        try{
            Message message = new MimeMessage(session);
            String senderEmail = LoginConstantUtils.getDecryptedEmailAddress();
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(String.join(",", toEmails)));
            message.setSubject(subject);

            String emailBody = body + "\n\nDownload BlastWeb test report at: " + sharedLink;

            Multipart multipart = new MimeMultipart();
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(emailBody);
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);
            Transport.send(message);
            System.out.println("*****Email sent successfully*****");
        }catch (Exception e){
            throw new RuntimeException("Failed to send email: " + e.getMessage(),e);
        }
    }

    private static Session createEmailSession(){
        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.starttls.enable","true");

        return Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                try{
                    return new PasswordAuthentication(
                            LoginConstantUtils.getDecryptedEmailAddress(),
                            LoginConstantUtils.getDecryptedEmailPassword()
                    );
                }catch (Exception e){
                    throw new RuntimeException("Email authentication failed: " + e.getMessage(),e);
                }
            }
        });
    }

//    Generic email request sender - reused by control/alert methods
    private static void sendDeviceRequestEmail(String toEmail, List<String> ccEmails, String subject, String body){
        Session session = createEmailSession();

        try{
            Message message = new MimeMessage(session);
            String senderEmail = LoginConstantUtils.getDecryptedEmailAddress();
            message.setFrom(new InternetAddress(senderEmail));

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));

            if(ccEmails != null && !ccEmails.isEmpty()){
                InternetAddress[] ccAddress = ccEmails.stream()
                        .map(email -> {
                            try{
                                return new InternetAddress(email);
                            }catch (AddressException e){
                                throw new RuntimeException("Invalid CC email: " + email,e);
                            }
                })
                        .toArray(InternetAddress[]::new);
                message.setRecipients(Message.RecipientType.CC, ccAddress);
            }

            message.setSubject(subject);

            Multipart multipart = new MimeMultipart();
            BodyPart messageBodypart = new MimeBodyPart();
            messageBodypart.setText(body);
            multipart.addBodyPart(messageBodypart);

            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Request email sent successfully");
        }catch (Exception e){
            throw new RuntimeException("Failed to send request email: " + e.getMessage(),e);
        }
    }

//    Device state change request
    public static void sendDeviceControlRequest(String toEmail, List<String> ccEmails,String deviceName,
                                                String expectedState, int waitMinutes){
       String subject = "Device State Change";
       String body = String.format(
               "Hi,\n\nPlease change state of device '%s' to '%s' within the next %d minutes.\n\nRegards,\nTest Hero Bot",
               deviceName,expectedState,waitMinutes);
       sendDeviceRequestEmail(toEmail,ccEmails,subject,body);
    }

//    Device alert change request
    public static void sendDeviceAlertRequest(String toEmail, List<String> ccEmails, String deviceName,
                                              String expectedAlert, int waitMinutes){
        String subject = "Device Alert Change";
        String body = String.format(
                "Hi,\n\nPlease change alert of device '%s' to '%s' within the next %d minutes.\n\nRegards,\nTest Hero Bot",
                deviceName,expectedAlert,waitMinutes);
        sendDeviceRequestEmail(toEmail,ccEmails,subject,body);
    }

//    Device alert removal request
    public static void sendDeviceAlertRemovalRequest(String toEmail, List<String> ccEmails, String deviceName,
                                                     int waitMinutes){
        String subject = "Device Alert Removal";
        String body = String.format(
                "Hi,\n\nPlease activated alerts of device '%s' within the next %d minutes.\n\nRegards,\nTest Hero Bot",
                deviceName,waitMinutes);
        sendDeviceRequestEmail(toEmail,ccEmails,subject,body);
    }
}