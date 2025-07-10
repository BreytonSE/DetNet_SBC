package com.detnet.runners;

import com.detnet.utilities.AllureReportUtils;
import com.detnet.utilities.EmailUtils;

public class ReportSender {
    public static void main(String[] args) {
        try{
            System.out.println("Generating Allure report...");
            AllureReportUtils.generateAllureReport();

            System.out.println("Sending email with report...");
            EmailUtils.sendEmail();

            System.out.println("Report generation and email sending complete.");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error generating report or sending email: " + e.getMessage());
        }
    }
}