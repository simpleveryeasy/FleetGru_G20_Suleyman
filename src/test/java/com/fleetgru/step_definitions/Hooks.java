package com.fleetgru.step_definitions;

import com.fleetgru.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before()
    public void setUp(){
        //driver = Driver.get();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void teardownScenario(Scenario scenario){

        //scenario.isFailed() ==> if scenario fails this method will return TRUE boolean value
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        if(scenario.isFailed()){
           final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }
        Driver.closeDriver();


    }



}
