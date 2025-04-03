package com.detnet.runners;

import com.detnet.utilities.AllureReportUtils;

public class AllureReportRunner {

    public static void main(String[] args) {
        System.out.println("Triggering Allure Report Generation...");
        AllureReportUtils.generateAllureReport();
    }
}
