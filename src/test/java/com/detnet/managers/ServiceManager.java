package com.detnet.managers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

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

    public static boolean isRunningInDocker() {
        String env = System.getenv("RUNNING_IN_DOCKER");
        if ("true".equalsIgnoreCase(env)) {
            System.out.println("[DEBUG] Docker detected via environment variable.");
            return true;
        }
        try {
            List<String> lines = Files.readAllLines(Paths.get("/proc/1/cgroup"));
            boolean inDocker = lines.stream().anyMatch(line -> line.contains("docker"));
            System.out.println("[DEBUG] Docker detected via /proc/1/cgroup: " + inDocker);
            return inDocker;
        } catch (IOException e) {
            System.out.println("[DEBUG] Could not read /proc/1/cgroup, assuming not in Docker");
            return false;
        }
    }
}