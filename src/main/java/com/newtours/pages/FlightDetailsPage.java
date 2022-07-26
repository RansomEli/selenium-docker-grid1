package com.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FlightDetailsPage {
    
    private WebDriver driver;
    
  
    
    @FindBy(name = "findFlights")
    private WebElement submitBtn;
    
    public FlightDetailsPage(WebDriver driver) {
        this.driver = driver;
        utils.waitForPageToLoad(driver, By.id("findFlights"));
    }
    
   /* public  void selectPassengers(String noOfPassengers) {
        System.out.println("  In selectPassengers - waiting for 'name=passcount' to be avail");
        this.wait.until(ExpectedConditions.elementToBeClickable(passengers));
        System.out.println("     Found it. Will now set passengers tp '" + passengers + "'");
        Select select = new Select(passengers);
        select.selectByValue(noOfPassengers);
    }*/
    
    public void setNbrOfPassenger(String nbrPassengers) {
        Select nbrPassengersList = new Select(driver.findElement(By.name("passCount")));
        nbrPassengersList.selectByValue(nbrPassengers);
        System.out.println("Passengers set to '" + nbrPassengers + "' passengers");
    }
    
    public String getNbrOfPassengers() {
        Select nbrPassengersList = new Select(driver.findElement(By.name("passCount")));
        String result = nbrPassengersList.getFirstSelectedOption().getText();
        return result;
    }
    
    public void clickContinue() {
        driver.findElement(By.id("findFlights")).click();
    }
    
    
}
