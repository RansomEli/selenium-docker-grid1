package com.test;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    
    protected WebDriver driver;
    
    @BeforeTest
    public void setupDriver() throws MalformedURLException {
        
        // set path
     /*   System.setProperty("webdriver.chrome.driver", "chromedriver");
        this.driver = new ChromeDriver();*/
        
        // BROWSER => chrome / firefox
        // HUB_HOST = localhost / 10.0.1.3 / hostname
        
        
        // Set default values
        String host = "localhost";
//        DesiredCapabilities dc = DesiredCapabilities.firefox();
//        DesiredCapabilities dc = DesiredCapabilities.chrome();
        MutableCapabilities dc;
        
        // If the user has entered a browser, use it
        if (System.getProperty("BROWSER") != null &&
//                System.getProperty("BROWSER").equalsIgnoreCase("chrome")) {
//            dc = DesiredCapabilities.chrome();
                System.getProperty("BROWSER").equalsIgnoreCase("chrome")) {
//            dc = DesiredCapabilities.firefox();
            dc = new ChromeOptions();
        } else {
            dc = new FirefoxOptions();
        }
        
        
        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }
        
        String completeUrl = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
    }
    
    
    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
    
}
