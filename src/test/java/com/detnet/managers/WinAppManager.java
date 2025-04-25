package com.detnet.managers;

import io.appium.java_client.windows.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WinAppManager {

    private static WindowsDriver<WindowsElement> driver;

    public static void setUp(){
        try{
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app","C:\\Detnet\\BlastWeb\\serverconfig.exe");
            capabilities.setCapability("ms:appWorkingDir","C:\\Detnet\\BlastWeb\\");
            capabilities.setCapability("platformName", "Windows");
            capabilities.setCapability("deviceName", "WindowsPC");
            capabilities.setCapability("automationName", "Windows");

            driver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"),capabilities);
        }catch (MalformedURLException e){
            throw new RuntimeException("❌ Invalid WinAppDriver URL", e);
        }catch (Exception e){
            throw new RuntimeException("❌ Failed to launch the Windows app", e);
        }
    }

    public static WindowsDriver<WindowsElement> getDriver(){
        if(driver == null){
            throw new IllegalStateException("❌ Windows driver not initialized. Call setUp() first.");
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

    public static void startWinAppDriver(){
//        Skip starting WinAppDriver in CI environments
        if(isRunningInCI()){
            System.out.println("⚙\uFE0F Detected CI/CD environment — skipping WinAppDriver startup.");
            return;
        }
        try{
            Runtime.getRuntime().exec("cmd /c start \"\" \"C:\\Program Files (x86)\\Windows Application Driver\\" +
                    "WinAppDriver.exe\"");
            Thread.sleep(3000); // wait for few seconds for it to start
        }catch (IOException | InterruptedException e){
            throw new RuntimeException("❌ Could not start WinAppDriver", e);
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
            throw new RuntimeException("❌ Could not stop WinAppDriver", e);
        }
    }

    private static boolean isRunningInCI(){
        String ciEnv = System.getenv("GITHUB_ACTIONS");
        return ciEnv != null && ciEnv.equalsIgnoreCase("true");
    }
}