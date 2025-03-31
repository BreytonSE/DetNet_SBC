package com.detnet.managers;

import java.io.File;
import java.io.IOException;

public class ServiceManager {
    private static Process process;

    public static void startBlastWebService(){
        String servicePath = "C:\\Detnet\\BlastWeb\\blastweb_service.exe";

        try{
            File serviceDir = new File("C:\\Detnet\\BlastWeb");
            ProcessBuilder processBuilder = new ProcessBuilder(servicePath, "-e");
            processBuilder.directory(serviceDir);
            processBuilder.redirectErrorStream(true);
            process = processBuilder.start();
            System.out.println("Blastweb service started successfully");
        }catch (IOException e){
            System.err.println("Failed to start BlastWeb service: " + e.getMessage());
        }
    }

    public static void stopBlastWebService(){
        if(process != null){
            process.destroy();
            System.out.println("BlastWeb service stopped.");
        }
    }
}