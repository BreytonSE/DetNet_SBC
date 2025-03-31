package com.detnet.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class AllureReportUtils {

    public static void generateAllureReport(){
        if(!isAllureResultsAvailable()){
            System.out.println("No Allure results found. Skipping report generation");
            return;
        }

        String allureCommand = getAllureCommand();
        if(allureCommand == null){
            System.err.println("Allure command not found for this OS. Skipping report generation.");
            return;
        }

        if(!isAllureInstalled(allureCommand)){
            System.err.println("Allure is not installed or not accessible from the command line.");
            return;
        }

        if(executeCommand(allureCommand + " generate --single-file allure-results -o allure-report")){
            System.out.println("Allure report generated successfully.");
        }else {
            System.err.println("Failed to generate Allure report.");
        }
    }

    private static boolean isAllureResultsAvailable(){
        File resultDir = new File("allure-results");
        return resultDir.exists() && Objects.requireNonNull(resultDir.list()).length > 0;
    }

    private static String getAllureCommand(){
        String osName = System.getProperty("os.name").toLowerCase();
        if(osName.contains("win")){
            return "C:\\Users\\" + System.getenv("USERNAME") + "\\scoop\\apps\\allure\\current\\bin\\allure.bat";
        } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("mac")) {
            return "/usr/local/bin/allure";
        }
        return null;
    }

    private static boolean isAllureInstalled(String allureCommand){
        return executeCommand(allureCommand + " --version");
    }

    private static boolean executeCommand(String command){
        try{
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            return process.exitValue() == 0;
        }catch (IOException | InterruptedException e){
            System.err.println("Command execution failed: " +e.getMessage());
            return false;
        }
    }
}