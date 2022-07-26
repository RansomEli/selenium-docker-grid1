package com.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationConfirmationPage {
    private WebDriver driver;
  
    
    public RegistrationConfirmationPage(WebDriver driver) {
        this.driver = driver;
        utils.waitForPageToLoad(driver, By.id("flight-link"));
        
    }
    
   
    
    public void clickLink_Flights() {
        driver.findElement(By.linkText("Flights")).click();
    }
    
    
}
