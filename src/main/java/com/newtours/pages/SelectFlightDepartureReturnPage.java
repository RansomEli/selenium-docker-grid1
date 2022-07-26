package com.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// this is also the Flight Details Page
public class SelectFlightDepartureReturnPage {
    private WebDriver driver;
    
    private final By continueButton = By.id("reserveFlights") ;
    
    public SelectFlightDepartureReturnPage(WebDriver driver) {
        this.driver = driver;
        utils.waitForPageToLoad(driver, continueButton);
    }
    
    public void clickContinue() {
        driver.findElement(continueButton).click();
    }
}
