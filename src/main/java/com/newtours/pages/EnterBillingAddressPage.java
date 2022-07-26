package com.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnterBillingAddressPage {
    private WebDriver driver;
    private final By continueButton = By.id("buyFlights");
    
    public EnterBillingAddressPage(WebDriver driver) {
        this.driver = driver;
        utils.waitForPageToLoad(driver, continueButton);
    }
    
    public void clickContinue() {
        driver.findElement(continueButton).click();
    }
}
