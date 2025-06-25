package com.detnet.stepdefinitions.dashBoard;

import com.detnet.managers.PageObjectManager;
import com.detnet.managers.PlaywrightManager;
import com.detnet.pageObjects.DashboardPageObjectModel;
import com.detnet.utilities.EmailUtils;
import com.detnet.utilities.SoftAssertionUtils;
import com.detnet.validations.blastWebValidations.DashboardValidation;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

import java.util.Arrays;
import java.util.List;

//   Scenario: Verify system alerts and event logs reflect, and clear device error conditions correctly for Blastweb 1
public class SystemAlerts_StepDefn {
    private final PageObjectManager pageObjectManager;

    public SystemAlerts_StepDefn() {
        Page page = PlaywrightManager.getPage();
        pageObjectManager = PageObjectManager.getInstance(page);
    }

    @Given("the user is on the dashboard page")
    public void the_user_is_on_the_dashboard_page() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateDashboardLabelVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Given("the user opens the alert dropdown")
    public void the_user_opens_the_alert_dropdown() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateAlertDropDownButtonVisibility();
        dashboardValidation.validateAlertDropDownButtonState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        dashboardPageObjectModel.openAlertDropDown();
    }

    @When("the user creates a condition that triggers the Device Not Available alert")
    public void the_user_creates_a_condition_that_triggers_the_device_not_available_alert() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateCurrentDeviceAlert("Device Not Available");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user refreshes the page after verifying the Device Not Available alert")
    public void the_user_refreshes_the_page_after_verifying_the_device_not_available_alert() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.refreshBrowserTab();
    }

    @When("the user creates a condition that triggers the Short Circuit alert")
    public void the_user_creates_a_condition_that_triggers_the_short_circuit_alert() {
       DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
       DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
       dashboardPageObjectModel.openAlertDropDown();

       String expectedAlert = "Short Circuits";
       boolean alertAlreadyPresent = dashboardPageObjectModel.getAllCurrentDeviceAlerts()
               .stream()
               .anyMatch(alert -> alert.equalsIgnoreCase(expectedAlert));

       if(!alertAlreadyPresent) {
//           Sends a control request to colleague
           String toEmail = "breyton.ernstzen@testheroes.co.za";
           List<String> ccEmails = Arrays.asList(
                   "breytonseanernstzen1224@gmail.com",
                "coetseet@detnet.com"/*,
                "maysond@detnet.com",
                "moosaa@detnet.com",
                "mbhalatil@detnet0.onmicrosoft.com"*/);

           String deviceName = "Device 502";
           int waitMinutes = 10;
           int pollIntervalsSeconds = 30;
           int maxWaitSeconds = waitMinutes * 60;
           int elapsed = 0;
           boolean alertMatched = false;

           EmailUtils.sendDeviceAlertRequest(toEmail, ccEmails, deviceName, expectedAlert, waitMinutes);

           while (elapsed < maxWaitSeconds) {
               List<String> currentState = dashboardPageObjectModel.getAllCurrentDeviceAlerts();
               if (currentState.stream().anyMatch(alert -> alert.equalsIgnoreCase(expectedAlert))) {
                   alertMatched = true;
                   System.out.printf("Device alert updated to '%s' after '%d' seconds.\n", expectedAlert, elapsed);
                   break;
               }

               try {
                   Thread.sleep(pollIntervalsSeconds * 1000L);
               } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
                   throw new RuntimeException("Polling interrupted", e);
               }

               elapsed += pollIntervalsSeconds;
               System.out.println("Waiting... (" + elapsed + "s elapsed");
           }

           if (!alertMatched) {
               throw new AssertionError("Device alert did not change to '" + expectedAlert + "' within " +
                       waitMinutes + " minutes.");
           }

       }else {
           System.out.printf("Alert '%s' is already visible - skipping email request.%n",expectedAlert);
       }

//       Continue with validation regardless
        dashboardPageObjectModel.refreshBrowserTab();
        dashboardPageObjectModel.openAlertDropDown();
        dashboardValidation.validateCurrentDeviceAlert("Short Circuits");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user refreshes the page after verifying the Short Circuit alert")
    public void the_user_refreshes_the_page_after_verifying_the_short_circuit_alert() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.refreshBrowserTab();
    }

    @When("the user creates a condition that triggers the High Leakage alert")
    public void the_user_creates_a_condition_that_triggers_the_high_leakage_alert() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardPageObjectModel.openAlertDropDown();

        String expectedAlert = "High Leakage";
        boolean alertAlreadyPresent = dashboardPageObjectModel.getAllCurrentDeviceAlerts()
                .stream()
                .anyMatch(alert -> alert.equalsIgnoreCase(expectedAlert));

        if(!alertAlreadyPresent) {
//           Sends a control request to colleague
            String toEmail = "breyton.ernstzen@testheroes.co.za";
            List<String> ccEmails = Arrays.asList(
                    "breytonseanernstzen1224@gmail.com",
                    "coetseet@detnet.com"/*,
                    "maysond@detnet.com",
                    "moosaa@detnet.com",
                    "mbhalatil@detnet0.onmicrosoft.com"*/);

            String deviceName = "Device 502";
            int waitMinutes = 10;
            int pollIntervalsSeconds = 30;
            int maxWaitSeconds = waitMinutes * 60;
            int elapsed = 0;
            boolean alertMatched = false;

            EmailUtils.sendDeviceAlertRequest(toEmail, ccEmails, deviceName, expectedAlert, waitMinutes);

            while (elapsed < maxWaitSeconds) {
                List<String> currentState = dashboardPageObjectModel.getAllCurrentDeviceAlerts();
                if (currentState.stream().anyMatch(alert -> alert.equalsIgnoreCase(expectedAlert))) {
                    alertMatched = true;
                    System.out.printf("Device alert updated to '%s' after '%d' seconds.\n", expectedAlert, elapsed);
                    break;
                }

                try {
                    Thread.sleep(pollIntervalsSeconds * 1000L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Polling interrupted", e);
                }

                elapsed += pollIntervalsSeconds;
                System.out.println("Waiting... (" + elapsed + "s elapsed");
            }

            if (!alertMatched) {
                throw new AssertionError("Device alert did not change to '" + expectedAlert + "' within " +
                        waitMinutes + " minutes.");
            }

        }else {
            System.out.printf("Alert '%s' is already visible - skipping email request.%n",expectedAlert);
        }

//       Continue with validation regardless
        dashboardPageObjectModel.refreshBrowserTab();
        dashboardPageObjectModel.openAlertDropDown();
        dashboardValidation.validateCurrentDeviceAlert("High Leakage");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user refreshes the page after verifying the High Leakage alert")
    public void the_user_refreshes_the_page_after_verifying_the_high_leakage_alert() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.refreshBrowserTab();
    }

    @When("the user creates a condition that triggers the High Current alert")
    public void the_user_creates_a_condition_that_triggers_the_high_current_alert() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardPageObjectModel.openAlertDropDown();

        String expectedAlert = "High Current";
        boolean alertAlreadyPresent = dashboardPageObjectModel.getAllCurrentDeviceAlerts()
                .stream()
                .anyMatch(alert -> alert.equalsIgnoreCase(expectedAlert));

        if(!alertAlreadyPresent) {
//           Sends a control request to colleague
            String toEmail = "breyton.ernstzen@testheroes.co.za";
            List<String> ccEmails = Arrays.asList(
                    "breytonseanernstzen1224@gmail.com",
                    "coetseet@detnet.com"/*,
                    "maysond@detnet.com",
                    "moosaa@detnet.com",
                    "mbhalatil@detnet0.onmicrosoft.com"*/);

            String deviceName = "Device 502";
            int waitMinutes = 10;
            int pollIntervalsSeconds = 30;
            int maxWaitSeconds = waitMinutes * 60;
            int elapsed = 0;
            boolean alertMatched = false;

            EmailUtils.sendDeviceAlertRequest(toEmail, ccEmails, deviceName, expectedAlert, waitMinutes);

            while (elapsed < maxWaitSeconds) {
                List<String> currentState = dashboardPageObjectModel.getAllCurrentDeviceAlerts();
                if (currentState.stream().anyMatch(alert -> alert.equalsIgnoreCase(expectedAlert))) {
                    alertMatched = true;
                    System.out.printf("Device alert updated to '%s' after '%d' seconds.\n", expectedAlert, elapsed);
                    break;
                }

                try {
                    Thread.sleep(pollIntervalsSeconds * 1000L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Polling interrupted", e);
                }

                elapsed += pollIntervalsSeconds;
                System.out.println("Waiting... (" + elapsed + "s elapsed");
            }

            if (!alertMatched) {
                throw new AssertionError("Device alert did not change to '" + expectedAlert + "' within " +
                        waitMinutes + " minutes.");
            }

        }else {
            System.out.printf("Alert '%s' is already visible - skipping email request.%n",expectedAlert);
        }

//       Continue with validation regardless
        dashboardPageObjectModel.refreshBrowserTab();
        dashboardPageObjectModel.openAlertDropDown();
        dashboardValidation.validateCurrentDeviceAlert("High Current");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user refreshes the page after verifying the High Current alert")
    public void the_user_refreshes_the_page_after_verifying_the_high_current_alert() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.refreshBrowserTab();
    }

    @When("the user refreshes the page after verifying the Acknowledgement Alert alert")
    public void the_user_refreshes_the_page_after_verifying_the_acknowledgement_alert_alert() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.refreshBrowserTab();
    }

    @When("the user creates a condition that triggers the Low Battery alert")
    public void the_user_creates_a_condition_that_triggers_the_low_battery_alert() {
//        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
//        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
//        dashboardPageObjectModel.openAlertDropDown();
//
//        String expectedAlert = "Low Battery";
//        boolean alertAlreadyPresent = dashboardPageObjectModel.getAllCurrentDeviceAlerts()
//                .stream()
//                .anyMatch(alert -> alert.equalsIgnoreCase(expectedAlert));
//
//        if(!alertAlreadyPresent) {
////           Sends a control request to colleague
//            String toEmail = "breyton.ernstzen@testheroes.co.za";
//            List<String> ccEmails = Arrays.asList(
//                    "breytonseanernstzen1224@gmail.com",
//                    "coetseet@detnet.com"/*,
//                    "maysond@detnet.com",
//                    "moosaa@detnet.com",
//                    "mbhalatil@detnet0.onmicrosoft.com"*/);
//
//            String deviceName = "Device 502";
//            int waitMinutes = 10;
//            int pollIntervalsSeconds = 30;
//            int maxWaitSeconds = waitMinutes * 60;
//            int elapsed = 0;
//            boolean alertMatched = false;
//
//            EmailUtils.sendDeviceAlertRequest(toEmail, ccEmails, deviceName, expectedAlert, waitMinutes);
//
//            while (elapsed < maxWaitSeconds) {
//                List<String> currentState = dashboardPageObjectModel.getAllCurrentDeviceAlerts();
//                if (currentState.stream().anyMatch(alert -> alert.equalsIgnoreCase(expectedAlert))) {
//                    alertMatched = true;
//                    System.out.printf("Device alert updated to '%s' after '%d' seconds.\n", expectedAlert, elapsed);
//                    break;
//                }
//
//                try {
//                    Thread.sleep(pollIntervalsSeconds * 1000L);
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                    throw new RuntimeException("Polling interrupted", e);
//                }
//
//                elapsed += pollIntervalsSeconds;
//                System.out.println("Waiting... (" + elapsed + "s elapsed");
//            }
//
//            if (!alertMatched) {
//                throw new AssertionError("Device alert did not change to '" + expectedAlert + "' within " +
//                        waitMinutes + " minutes.");
//            }
//
//        }else {
//            System.out.printf("Alert '%s' is already visible - skipping email request.%n",expectedAlert);
//        }
//
////       Continue with validation regardless
//        dashboardPageObjectModel.refreshBrowserTab();
//        dashboardPageObjectModel.openAlertDropDown();
//        dashboardValidation.validateCurrentDeviceAlert("Low Battery");
//        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user refreshes the page after verifying the Low Battery alert")
    public void the_user_refreshes_the_page_after_verifying_the_low_battery_alert() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.refreshBrowserTab();
    }

    @When("the user creates a condition that triggers the Last Detonator Bad alert")
    public void the_user_creates_a_condition_that_triggers_the_last_detonator_bad_alert() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardPageObjectModel.openAlertDropDown();

        String expectedAlert = "Last Detonator Bad";
        boolean alertAlreadyPresent = dashboardPageObjectModel.getAllCurrentDeviceAlerts()
                .stream()
                .anyMatch(alert -> alert.equalsIgnoreCase(expectedAlert));

        if(!alertAlreadyPresent) {
//           Sends a control request to colleague
            String toEmail = "breyton.ernstzen@testheroes.co.za";
            List<String> ccEmails = Arrays.asList(
                    "breytonseanernstzen1224@gmail.com",
                    "coetseet@detnet.com"/*,
                    "maysond@detnet.com",
                    "moosaa@detnet.com",
                    "mbhalatil@detnet0.onmicrosoft.com"*/);

            String deviceName = "Device 502";
            int waitMinutes = 10;
            int pollIntervalsSeconds = 30;
            int maxWaitSeconds = waitMinutes * 60;
            int elapsed = 0;
            boolean alertMatched = false;

            EmailUtils.sendDeviceAlertRequest(toEmail, ccEmails, deviceName, expectedAlert, waitMinutes);

            while (elapsed < maxWaitSeconds) {
                List<String> currentState = dashboardPageObjectModel.getAllCurrentDeviceAlerts();
                if (currentState.stream().anyMatch(alert -> alert.equalsIgnoreCase(expectedAlert))) {
                    alertMatched = true;
                    System.out.printf("Device alert updated to '%s' after '%d' seconds.\n", expectedAlert, elapsed);
                    break;
                }

                try {
                    Thread.sleep(pollIntervalsSeconds * 1000L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Polling interrupted", e);
                }

                elapsed += pollIntervalsSeconds;
                System.out.println("Waiting... (" + elapsed + "s elapsed");
            }

            if (!alertMatched) {
                throw new AssertionError("Device alert did not change to '" + expectedAlert + "' within " +
                        waitMinutes + " minutes.");
            }

        }else {
            System.out.printf("Alert '%s' is already visible - skipping email request.%n",expectedAlert);
        }

//       Continue with validation regardless
        dashboardPageObjectModel.refreshBrowserTab();
        dashboardPageObjectModel.openAlertDropDown();
        dashboardValidation.validateCurrentDeviceAlert("Last Detonator Bad");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user refreshes the page after verifying the Last Detonator Bad alert")
    public void the_user_refreshes_the_page_after_verifying_the_last_detonator_bad_alert() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.refreshBrowserTab();
    }

    @When("the user creates a condition that triggers the Last Detonator Bad Voltage alert")
    public void the_user_creates_a_condition_that_triggers_the_last_detonator_bad_voltage_alert() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardPageObjectModel.openAlertDropDown();

        String expectedAlert = "Last Detonator Bad Voltage";
        boolean alertAlreadyPresent = dashboardPageObjectModel.getAllCurrentDeviceAlerts()
                .stream()
                .anyMatch(alert -> alert.equalsIgnoreCase(expectedAlert));

        if(!alertAlreadyPresent) {
//           Sends a control request to colleague
            String toEmail = "breyton.ernstzen@testheroes.co.za";
            List<String> ccEmails = Arrays.asList(
                    "breytonseanernstzen1224@gmail.com",
                    "coetseet@detnet.com"/*,
                    "maysond@detnet.com",
                    "moosaa@detnet.com",
                    "mbhalatil@detnet0.onmicrosoft.com"*/);

            String deviceName = "Device 502";
            int waitMinutes = 10;
            int pollIntervalsSeconds = 30;
            int maxWaitSeconds = waitMinutes * 60;
            int elapsed = 0;
            boolean alertMatched = false;

            EmailUtils.sendDeviceAlertRequest(toEmail, ccEmails, deviceName, expectedAlert, waitMinutes);

            while (elapsed < maxWaitSeconds) {
                List<String> currentState = dashboardPageObjectModel.getAllCurrentDeviceAlerts();
                if (currentState.stream().anyMatch(alert -> alert.equalsIgnoreCase(expectedAlert))) {
                    alertMatched = true;
                    System.out.printf("Device alert updated to '%s' after '%d' seconds.\n", expectedAlert, elapsed);
                    break;
                }

                try {
                    Thread.sleep(pollIntervalsSeconds * 1000L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Polling interrupted", e);
                }

                elapsed += pollIntervalsSeconds;
                System.out.println("Waiting... (" + elapsed + "s elapsed");
            }

            if (!alertMatched) {
                throw new AssertionError("Device alert did not change to '" + expectedAlert + "' within " +
                        waitMinutes + " minutes.");
            }

        }else {
            System.out.printf("Alert '%s' is already visible - skipping email request.%n",expectedAlert);
        }

//       Continue with validation regardless
        dashboardPageObjectModel.refreshBrowserTab();
        dashboardPageObjectModel.openAlertDropDown();
        dashboardValidation.validateCurrentDeviceAlert("Last Detonator Bad Voltage");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user refreshes the page after verifying the Last Detonator Bad Voltage alert")
    public void the_user_refreshes_the_page_after_verifying_the_last_detonator_bad_voltage_alert() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.refreshBrowserTab();
    }

    @When("the user creates a condition that triggers the Harness Break alert")
    public void the_user_creates_a_condition_that_triggers_the_harness_break_alert() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardPageObjectModel.openAlertDropDown();

        String expectedAlert = "Harness Break";
        boolean alertAlreadyPresent = dashboardPageObjectModel.getAllCurrentDeviceAlerts()
                .stream()
                .anyMatch(alert -> alert.equalsIgnoreCase(expectedAlert));

        if(!alertAlreadyPresent) {
//           Sends a control request to colleague
            String toEmail = "breyton.ernstzen@testheroes.co.za";
            List<String> ccEmails = Arrays.asList(
                    "breytonseanernstzen1224@gmail.com",
                    "coetseet@detnet.com"/*,
                    "maysond@detnet.com",
                    "moosaa@detnet.com",
                    "mbhalatil@detnet0.onmicrosoft.com"*/
            );

            String deviceName = "Device 502";
            int waitMinutes = 10;
            int pollIntervalsSeconds = 30;
            int maxWaitSeconds = waitMinutes * 60;
            int elapsed = 0;
            boolean alertMatched = false;

            EmailUtils.sendDeviceAlertRequest(toEmail, ccEmails, deviceName, expectedAlert, waitMinutes);

            while (elapsed < maxWaitSeconds) {
                List<String> currentState = dashboardPageObjectModel.getAllCurrentDeviceAlerts();
                if (currentState.stream().anyMatch(alert -> alert.equalsIgnoreCase(expectedAlert))) {
                    alertMatched = true;
                    System.out.printf("Device alert updated to '%s' after '%d' seconds.\n", expectedAlert, elapsed);
                    break;
                }

                try {
                    Thread.sleep(pollIntervalsSeconds * 1000L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Polling interrupted", e);
                }

                elapsed += pollIntervalsSeconds;
                System.out.println("Waiting... (" + elapsed + "s elapsed");
            }

            if (!alertMatched) {
                throw new AssertionError("Device alert did not change to '" + expectedAlert + "' within " +
                        waitMinutes + " minutes.");
            }

        }else {
            System.out.printf("Alert '%s' is already visible - skipping email request.%n",expectedAlert);
        }

//       Continue with validation regardless
        dashboardPageObjectModel.refreshBrowserTab();
        dashboardPageObjectModel.openAlertDropDown();
        dashboardValidation.validateCurrentDeviceAlert("Harness Break");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user refreshes the page after verifying the Harness Break alert")
    public void the_user_refreshes_the_page_after_verifying_the_harness_break_alert() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.refreshBrowserTab();
    }

    @When("the user creates a condition that triggers the Programming Error alert")
    public void the_user_creates_a_condition_that_triggers_the_programming_error_alert() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardPageObjectModel.openAlertDropDown();

        String expectedAlert = "Programming Error";
        boolean alertAlreadyPresent = dashboardPageObjectModel.getAllCurrentDeviceAlerts()
                .stream()
                .anyMatch(alert -> alert.equalsIgnoreCase(expectedAlert));

        if(!alertAlreadyPresent) {
//           Sends a control request to colleague
            String toEmail = "breyton.ernstzen@testheroes.co.za";
            List<String> ccEmails = Arrays.asList(
                    "breytonseanernstzen1224@gmail.com",
                    "coetseet@detnet.com"/*,
                    "maysond@detnet.com",
                    "moosaa@detnet.com",
                    "mbhalatil@detnet0.onmicrosoft.com"*/
            );

            String deviceName = "Device 502";
            int waitMinutes = 10;
            int pollIntervalsSeconds = 30;
            int maxWaitSeconds = waitMinutes * 60;
            int elapsed = 0;
            boolean alertMatched = false;

            EmailUtils.sendDeviceAlertRequest(toEmail, ccEmails, deviceName, expectedAlert, waitMinutes);

            while (elapsed < maxWaitSeconds) {
                List<String> currentState = dashboardPageObjectModel.getAllCurrentDeviceAlerts();
                if (currentState.stream().anyMatch(alert -> alert.equalsIgnoreCase(expectedAlert))) {
                    alertMatched = true;
                    System.out.printf("Device alert updated to '%s' after '%d' seconds.\n", expectedAlert, elapsed);
                    break;
                }

                try {
                    Thread.sleep(pollIntervalsSeconds * 1000L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Polling interrupted", e);
                }

                elapsed += pollIntervalsSeconds;
                System.out.println("Waiting... (" + elapsed + "s elapsed");
            }

            if (!alertMatched) {
                throw new AssertionError("Device alert did not change to '" + expectedAlert + "' within " +
                        waitMinutes + " minutes.");
            }

        }else {
            System.out.printf("Alert '%s' is already visible - skipping email request.%n",expectedAlert);
        }

//       Continue with validation regardless
        dashboardPageObjectModel.refreshBrowserTab();
        dashboardPageObjectModel.openAlertDropDown();
        dashboardValidation.validateCurrentDeviceAlert("Programming Error");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user refreshes the page after verifying the Programming Error alert")
    public void the_user_refreshes_the_page_after_verifying_the_programming_error_alert() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.refreshBrowserTab();
    }

    @When("the user creates a condition that triggers the Test Mode alert")
    public void the_user_creates_a_condition_that_triggers_the_test_mode_alert() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardPageObjectModel.openAlertDropDown();

        String expectedAlert = "Test Mode";
        boolean alertAlreadyPresent = dashboardPageObjectModel.getAllCurrentDeviceAlerts()
                .stream()
                .anyMatch(alert -> alert.equalsIgnoreCase(expectedAlert));

        if(!alertAlreadyPresent) {
//           Sends a control request to colleague
            String toEmail = "breyton.ernstzen@testheroes.co.za";
            List<String> ccEmails = Arrays.asList(
                    "breytonseanernstzen1224@gmail.com",
                    "coetseet@detnet.com"/*,
                    "maysond@detnet.com",
                    "moosaa@detnet.com",
                    "mbhalatil@detnet0.onmicrosoft.com"*/
            );

            String deviceName = "Device 502";
            int waitMinutes = 10;
            int pollIntervalsSeconds = 30;
            int maxWaitSeconds = waitMinutes * 60;
            int elapsed = 0;
            boolean alertMatched = false;

            EmailUtils.sendDeviceAlertRequest(toEmail, ccEmails, deviceName, expectedAlert, waitMinutes);

            while (elapsed < maxWaitSeconds) {
                List<String> currentState = dashboardPageObjectModel.getAllCurrentDeviceAlerts();
                if (currentState.stream().anyMatch(alert -> alert.equalsIgnoreCase(expectedAlert))) {
                    alertMatched = true;
                    System.out.printf("Device alert updated to '%s' after '%d' seconds.\n", expectedAlert, elapsed);
                    break;
                }

                try {
                    Thread.sleep(pollIntervalsSeconds * 1000L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Polling interrupted", e);
                }

                elapsed += pollIntervalsSeconds;
                System.out.println("Waiting... (" + elapsed + "s elapsed");
            }

            if (!alertMatched) {
                throw new AssertionError("Device alert did not change to '" + expectedAlert + "' within " +
                        waitMinutes + " minutes.");
            }

        }else {
            System.out.printf("Alert '%s' is already visible - skipping email request.%n",expectedAlert);
        }

//       Continue with validation regardless
        dashboardPageObjectModel.refreshBrowserTab();
        dashboardPageObjectModel.openAlertDropDown();
        dashboardValidation.validateCurrentDeviceAlert("Test Mode");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user refreshes the page after verifying the Test Mode alert")
    public void the_user_refreshes_the_page_after_verifying_the_test_mode_alert() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.refreshBrowserTab();
    }

    @When("the user creates a condition that triggers the TX Error Preventing Blast alert")
    public void the_user_creates_a_condition_that_triggers_the_tx_error_preventing_blast_alert() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardPageObjectModel.openAlertDropDown();

        String expectedAlert = "TX Error Preventing Blast";
        boolean alertAlreadyPresent = dashboardPageObjectModel.getAllCurrentDeviceAlerts()
                .stream()
                .anyMatch(alert -> alert.equalsIgnoreCase(expectedAlert));

        if(!alertAlreadyPresent) {
//           Sends a control request to colleague
            String toEmail = "breyton.ernstzen@testheroes.co.za";
            List<String> ccEmails = Arrays.asList(
                    "breytonseanernstzen1224@gmail.com",
                    "coetseet@detnet.com"/*,
                    "maysond@detnet.com",
                    "moosaa@detnet.com",
                    "mbhalatil@detnet0.onmicrosoft.com"*/
            );

            String deviceName = "Device 502";
            int waitMinutes = 10;
            int pollIntervalsSeconds = 30;
            int maxWaitSeconds = waitMinutes * 60;
            int elapsed = 0;
            boolean alertMatched = false;

            EmailUtils.sendDeviceAlertRequest(toEmail, ccEmails, deviceName, expectedAlert, waitMinutes);

            while (elapsed < maxWaitSeconds) {
                List<String> currentState = dashboardPageObjectModel.getAllCurrentDeviceAlerts();
                if (currentState.stream().anyMatch(alert -> alert.equalsIgnoreCase(expectedAlert))) {
                    alertMatched = true;
                    System.out.printf("Device alert updated to '%s' after '%d' seconds.\n", expectedAlert, elapsed);
                    break;
                }

                try {
                    Thread.sleep(pollIntervalsSeconds * 1000L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Polling interrupted", e);
                }

                elapsed += pollIntervalsSeconds;
                System.out.println("Waiting... (" + elapsed + "s elapsed");
            }

            if (!alertMatched) {
                throw new AssertionError("Device alert did not change to '" + expectedAlert + "' within " +
                        waitMinutes + " minutes.");
            }

        }else {
            System.out.printf("Alert '%s' is already visible - skipping email request.%n",expectedAlert);
        }

//       Continue with validation regardless
        dashboardPageObjectModel.refreshBrowserTab();
        dashboardPageObjectModel.openAlertDropDown();
        dashboardValidation.validateCurrentDeviceAlert("TX Error Preventing Blast");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @When("the user refreshes the page after verifying the TX Error Preventing Blast alert")
    public void the_user_refreshes_the_page_after_verifying_the_tx_error_preventing_blast_alert() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        dashboardPageObjectModel.refreshBrowserTab();
    }

    @Then("the event log should reflect the resolution of each error condition")
    public void the_event_log_should_reflect_the_resolution_of_each_error_condition() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardValidation.validateReportTabVisibility();
        dashboardValidation.validateReportTabState();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        dashboardPageObjectModel.openReportTab();
        dashboardValidation.validateReportDropDownVisibility();
        SoftAssertionUtils.getSoftAssertions().assertAll();
        dashboardPageObjectModel.openEventsReport();
        dashboardValidation.validateErrorVisibilityOnEventLogReport("Io 3 Short Circuit E:0x00000040");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }

    @Then("the user restores the BCU condition to operate without alerts")
    public void the_user_restores_the_bcu_condition_to_operate_without_alerts() {
        DashboardPageObjectModel dashboardPageObjectModel = pageObjectManager.getDashboardPageObjectModel();
        DashboardValidation dashboardValidation = new DashboardValidation(dashboardPageObjectModel);
        dashboardPageObjectModel.openAlertDropDown();

        List<String> expectedAlertsToBeCleared = Arrays.asList(
                "Short Circuits", "High Leakage", "High Current", "Low Battery", "Acknowledge Alert", "Device Not Available",
                "Last Detonator Bad", "Last Detonator Bad Voltage", "Harness Break", "Programming Error",
                "Test Mode", "TX Error Preventing Blast");

        String toEmail = "breyton.ernstzen@testheroes.co.za";
        List<String> ccEmails = Arrays.asList(
                "breytonseanernstzen1224@gmail.com",
                "coetseet@detnet.com"/*,
                "maysond@detnet.com",
                "moosaa@detnet.com",
                "mbhalatil@detnet0.onmicrosoft.com"*/);

        String deviceName = "Device 502";
        int waitMinutes = 10;
        int pollIntervalSeconds = 30;
        int maxWaitSeconds = waitMinutes * 60;
        int elapsed = 0;
        boolean allCleared = false;

        EmailUtils.sendDeviceAlertRemovalRequest(toEmail,ccEmails,deviceName,waitMinutes);

        while (elapsed < maxWaitSeconds){
            List<String> alerts = dashboardPageObjectModel.getAllCurrentDeviceAlerts();

//            Check if none of the expected alerts still exists
            boolean anyStillPresent = alerts.stream().anyMatch(
                    current -> expectedAlertsToBeCleared.stream()
                            .anyMatch(expected -> current.equalsIgnoreCase(expected)));

            if (!anyStillPresent){
                allCleared = true;
                System.out.printf("All expected device alerts were cleared after %d seconds.%n",elapsed);
                break;
            }

            try{
                Thread.sleep(pollIntervalSeconds * 1000L);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                throw new RuntimeException("Polling interrupted",e);
            }
            elapsed += pollIntervalSeconds;
            System.out.println("Waiting...(" + elapsed + "s elapsed");
        }

        if(!allCleared){
            throw new AssertionError("Device alerts were not cleared within " + waitMinutes + " minutes.");
        }

        dashboardPageObjectModel.refreshBrowserTab();
        dashboardPageObjectModel.openAlertDropDown();
        dashboardValidation.validateIfAlertsAreCleared("Short Circuits","502");
        dashboardValidation.validateIfAlertsAreCleared("High Leakage","502");
        dashboardValidation.validateIfAlertsAreCleared("High Current","502");
//        dashboardValidation.validateIfAlertsAreCleared("Low Battery","502"); // Device needs to be on a low battery in order to cover this
        dashboardValidation.validateIfAlertsAreCleared("Last Detonator Bad","502");
        dashboardValidation.validateIfAlertsAreCleared("Last Detonator Bad Voltage","502");
        dashboardValidation.validateIfAlertsAreCleared("Harness Break","502");
        dashboardValidation.validateIfAlertsAreCleared("Programming Error","502");
        dashboardValidation.validateIfAlertsAreCleared("Test Mode","502");
        dashboardValidation.validateIfAlertsAreCleared("TX Error Preventing Blast","502");
        SoftAssertionUtils.getSoftAssertions().assertAll();
    }
}