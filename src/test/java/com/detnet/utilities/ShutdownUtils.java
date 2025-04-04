package com.detnet.utilities;

import com.detnet.managers.ServiceManager;
import org.testng.annotations.AfterSuite;

public class ShutdownUtils {

    @AfterSuite(alwaysRun = true)
    public void finalizeExecution() {
        System.out.println("Finalizing execution and running shutdown logic...");
        AllureReportUtils.generateAllureReport();
        EmailUtils.sendEmail();
        ServiceManager.stopBlastWebService(); // Stops the service when the tests finish
    }
}