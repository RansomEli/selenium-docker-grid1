package com.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsHomePage {
    
    private WebDriver driver ;
    
    private static final String cssSUBMIT = "input[value='Submit']";
    
    public FlightsHomePage(WebDriver driver) {
        this.driver = driver;
        
        waitForPageToLoad() ;
    }
    
    private void waitForPageToLoad() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(cssSUBMIT)  ) ) ;
    }
    
    
    public void printConfirmation() {
        System.out.println("Flight number confirmed");
        System.out.println("Price confirmed");
    }
}
