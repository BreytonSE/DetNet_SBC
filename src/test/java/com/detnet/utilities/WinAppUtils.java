package com.detnet.utilities;

import com.detnet.managers.WinAppManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WinAppUtils {

    @Before("@desktop")
    public void launchBlastWeb(){
        WinAppManager.startWinAppDriver();
        WinAppManager.setUp();
    }

    @After("@desktop")
    public void closeBlastWeb(){
        WinAppManager.tearDown();
    }
}