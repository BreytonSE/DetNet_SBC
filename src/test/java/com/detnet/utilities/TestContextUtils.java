package com.detnet.utilities;

import io.cucumber.java.Scenario;

public class TestContextUtils {
    private static TestContextUtils instance;
    private Scenario scenario;

//    Private constructor to enforce the singleton pattern
    private TestContextUtils() {
    }

    public static synchronized TestContextUtils getInstance(){
        if(instance == null){
            instance = new TestContextUtils();
        }
        return instance;
    }

    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    public Scenario getScenario(){
        return scenario;
    }
}