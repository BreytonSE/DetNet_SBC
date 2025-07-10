package com.detnet.managers;

import io.appium.java_client.windows.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

public class WinAppManager {

    private static WindowsDriver<WindowsElement> driver;

    public static void setUp(){
        try{
            startWinAppDriver();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app","C:\\Detnet\\BlastWeb\\serverconfig.exe");
            capabilities.setCapability("ms:appWorkingDir","C:\\Detnet\\BlastWeb\\");
            capabilities.setCapability("platformName", "Windows");
            capabilities.setCapability("deviceName", "WindowsPC");
            capabilities.setCapability("automationName", "Windows");

            driver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"),capabilities);
        }catch (MalformedURLException e){
            throw new RuntimeException("Invalid WinAppDriver URL", e);
        }catch (Exception e){
            throw new RuntimeException("Failed to launch the Windows app", e);
        }
    }

    public static WindowsDriver<WindowsElement> getDriver(){
        if(driver == null){
            throw new IllegalStateException("Windows driver not initialized. Call setUp() first.");
        }
        return driver;
    }

    public static void tearDown(){
        System.out.println("👋 Called tearDown()");

        if(driver != null){
            try{
                driver.quit();
            }catch (Exception e){
                System.out.println("⚠\uFE0F Error while quitting driver: " + e.getMessage());
            }finally {
                driver = null;
                stopWinAppDriver();
            }
        }
    }

//    Newly added logic to cater for CI/CD
    private static boolean shouldSkipWinAppDriverStartup(){
//        Explicitly skip only if told to
        String skip = System.getenv("CI_SKIP_WINAPP");
        return skip != null && skip.equalsIgnoreCase("true");
    }

    public static void startWinAppDriver(){
        if(shouldSkipWinAppDriverStartup()){
            System.out.println("Skipping WinAppDriver startup due to CI_SKIP_WINAPP=true");
            return;
        }
        try {
            System.out.println("Starting WinAppDriver...");
            Runtime.getRuntime().exec("cmd /c start \"\" \"C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe\"");

//            Wait for it to start up
            int retries = 5;
            while (!isWinAppDriverRunning() && retries--> 0){
                System.out.println("Waiting for WinAppDriver to start...");
                Thread.sleep(2000);
            }
            if(!isWinAppDriverRunning()){
                throw new RuntimeException("WinAppDriver did not start on port 4723.");
            }
            System.out.println("WinAppDriver is now running and ready.");
        }catch (IOException | InterruptedException e){
            throw new RuntimeException("Could not start WinAppDriver",e);
        }
    }

    private static void stopWinAppDriver(){
//        Skip stopping in CI/CD environments
        if(isRunningInCI()){
            System.out.println("⚙\uFE0F Detected CI/CD environment — skipping WinAppDriver shutdown.");
            return;
        }
        try{
//            Kill the WinAppDriver.exe process
            Runtime.getRuntime().exec("taskkill /F /IM WinAppDriver.exe");
            System.out.println("\uD83D\uDED1 WinAppDriver stopped successfully.");
        }catch (IOException e){
            throw new RuntimeException("Could not stop WinAppDriver", e);
        }
    }

    private static boolean isRunningInCI(){
        String ciEnv = System.getenv("GITHUB_ACTIONS");
        return ciEnv != null && ciEnv.equalsIgnoreCase("true");
    }

//    Check if the port is open for connections
    private static boolean isWinAppDriverRunning(){
        try(Socket socket = new Socket()){
            socket.connect(new InetSocketAddress("127.0.0.1",4723),2000);
            return true;
        }catch (IOException e){
            return false;
        }
    }
}