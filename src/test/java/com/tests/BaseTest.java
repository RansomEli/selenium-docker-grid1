package com.tests;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    
    protected WebDriver driver;
    
    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {
        
        // set path
     /*   System.setProperty("webdriver.chrome.driver", "chromedriver");
        this.driver = new ChromeDriver();*/
        
        // User can give these values
        // BROWSER => chrome / firefox
        // HUB_HOST = localhost / 10.0.1.3 / hostname
        
        
        // Set default values
        String host = "localhost";
//        DesiredCapabilities dc = DesiredCapabilities.firefox();
//        DesiredCapabilities dc = DesiredCapabilities.chrome();
        MutableCapabilities dc;
        
        // If the user has entered a browser, use it. Otherwise, use Chrome
       /* if (System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            dc = new FirefoxOptions();
        } else {
            dc = new ChromeOptions();
        }*/
        
        // Kludge -- for now, use firefox
        boolean testFlag = false;
        if (testFlag) {
            System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver");
            driver = new ChromeDriver() ;
//            dc = new ChromeOptions();
        } else {
    
            dc = new FirefoxOptions() ;
            if (System.getProperty("HUB_HOST") != null) {
                host = System.getProperty("HUB_HOST");
            }
    
            String testName = ctx.getCurrentXmlTest().getName();
    
            String completeUrl = "http://" + host + ":4444/wd/hub";
            dc.setCapability("name", testName);
    
            this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
        }
//       driver = new ChromeDriver();
        int placeHolder = 9;
    }
    
    
    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
    
}
