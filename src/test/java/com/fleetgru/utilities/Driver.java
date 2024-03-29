package com.fleetgru.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {


    /*
   Creating s private constructor, so we are closing access to the object out of this class
    */
    private Driver(){}


    /*
    We make WebDriver private because we want to close access from outside the class.
    We make it static because we will use it in a static method
     */
    //private static WebDriver driver;

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();


    /*
    Create a re-usable utility method which will return same driver instance when we call it
     */
    public static WebDriver getDriver(){
        if (driverPool.get() == null){

            /*
            We read our browserType from configuration.properties
            This way we can control which browser is opened from outside our code, from configuration.properties
             */
            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        return driverPool.get();

    }



    //driver.quit() --> nosuchsession
    //driver.close() --> sessionidnotmathcing
    //This method make sure our driver value is always null after using quit() method
    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();//this line terminates the current session, value will not be even null
            driverPool.remove();
        }

    }
}
