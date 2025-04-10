package com.detnet.managers;

import io.appium.java_client.windows.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WinAppManager {

    private static WindowsDriver<WindowsElement> driver;

    public static void setUp(){
        try{
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app","C:\\Detnet\\BlastWeb\\serverconfig.exe");
            capabilities.setCapability("platformName", "Windows");
            capabilities.setCapability("deviceName", "WindowsPC");

            driver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"),capabilities);
            System.out.println("✅ Windows application launched successfully.");
        }catch (MalformedURLException e){
            throw new RuntimeException("❌ Invalid WinAppDriver URL", e);
        }catch (Exception e){
            throw new RuntimeException("❌ Failed to launch the Windows app", e);
        }
    }

    public static WindowsDriver<WindowsElement> getDriver(){
        if(driver == null){
            throw new IllegalStateException("Windows drover not initialized. Call setUp() first.");
        }
        return driver;
    }

    public static void tearDown(){
        if(driver != null){
            driver.quit();
            System.out.println("🛑 Windows application closed.");
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

    private static boolean isRunningInCI(){
        String ciEnv = System.getenv("GITHUB_ACTIONS");
        return ciEnv != null && ciEnv.equalsIgnoreCase("true");
    }
}