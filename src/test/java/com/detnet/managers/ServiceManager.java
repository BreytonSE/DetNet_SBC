package com.detnet.managers;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ServiceManager {
    private static Process process;

    public static void startBlastWebService(){
        String servicePath = "C:\\Detnet\\BlastWeb\\blastweb_service.exe";

        if(isServiceRunning("localhost",8080)){
            System.out.println("Blastweb service is already running. Skipping start.");
            return;
        }

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

    public static void startWebServer(){
        String webServerPath = "C:\\Detnet\\BlastWeb\\backend\\blastweb_golang.exe";

        if(isServiceRunning("localhost",8080)){
            System.out.println("Blastweb webserver is already running. SKipping start.");
            return;
        }

        try{
            File webServerDir = new File("C:\\Detnet\\BlastWeb\\backend");
            ProcessBuilder processBuilder = new ProcessBuilder(webServerPath);
            processBuilder.directory(webServerDir);
            processBuilder.redirectErrorStream(true);
            process = processBuilder.start();
            System.out.println("Blastweb webserver started successfully");
        }catch (IOException e){
            System.err.println("Failed to start Blastweb webserver: " + e.getMessage());
        }
    }

    private static boolean isServiceRunning(String host, int port){
        try(Socket socket = new Socket()){
            socket.connect(new InetSocketAddress(host,port),2000); // 2 second timeout
            return true;
        }catch (IOException e){
            return false; // If the connection fails, service is not running
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

    public static void startBlastWeb(){
        String blastWebPath = "C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\BlastWeb\\BlastWeb.exe";

        try{
//            Start BlastWeb as Administrator
            ProcessBuilder pb = new ProcessBuilder(
                    "powershell",
                    "-Command",
                    "Start-Process '" + blastWebPath + "' -Verb RunAs");
            pb.redirectErrorStream(true);
            pb.start();
            System.out.println("BlastWeb GUI started as Administrator,");
        }catch (IOException e){
            System.err.println("Failed to start BlastWeb GUI as Administrator: " + e.getMessage());
        }
    }
}