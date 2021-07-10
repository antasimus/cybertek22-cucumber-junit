package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {}
    /*
    making our 'driver; instance private do that is not reachable from outside of the class
    We make it static, because we want it to run before everything else, and also we ude it in a static method
     */
    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            /*
            We read our browse type from configuration properties using our getProperty method we creating in ConfigurationProperties
             */
            String browserType = ConfigurationReader.getProperty("browser");
              /*
            Depending on the browser type our switch statement will determine
            to open specific type of browser/driver
             */
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();;
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }
        }
        /*
        Same driver instance will be returned every time we call Driver.getDriver();method
         */
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
