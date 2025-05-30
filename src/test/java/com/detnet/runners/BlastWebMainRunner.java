package com.detnet.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/web",
                    "src/test/resources/features/desktop"}, // comment out if pipeline works 100%
//        features = "src/test/resources/features/web/a_Login.feature", // remove if pipeline is fixed
        glue = {"com.detnet.stepdefinitions","com.detnet.utilities"},
        plugin = {"pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        tags = "@web or @desktop",
        monochrome = true
)
public class BlastWebMainRunner extends AbstractTestNGCucumberTests {
}