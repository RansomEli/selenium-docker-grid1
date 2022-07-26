package com.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightConfirmationPage {
    
    private WebDriver driver;
   
    private String nbrTickets;
    private static int TicketPrice = 584 ;
    
    private final By contactLink  = By.linkText("CONTACT");
    
   /* @FindBy(css = "img[src*='featured destination.gif']")
    private WebElement flightConfirmationHeader;
    */
    
    
    
//    public FlightConfirmationPage(WebDriver driver, String nbrTickets) {
    public FlightConfirmationPage(WebDriver driver) {
        this.driver = driver;
//        this.nbrTickets = nbrTickets;
        utils.waitForPageToLoad(driver, contactLink);
    }
    

    
    public String getPrice() {
        
        final String cssFLIGHT_INFO = "form[name='nothing'] > table > tbody > tr > td" ;
        final String cssTOTAL_PRICE = "form[name='nothing'] > table > tbody > tr:nth-of-type(3) > td:nth-of-type(2)";
        // get flight info
        String flightInfo = driver.findElement(By.cssSelector(cssFLIGHT_INFO)).getText();
        String totalPrice = driver.findElement(By.cssSelector(cssTOTAL_PRICE)).getText();
        System.out.println("Flight Info: " + flightInfo);
        System.out.println("Total Price: " + totalPrice);
        
        clickLink_SignOff();
        return totalPrice;
    }
    
    public void clickLink_SignOff() {
        driver.findElement(By.linkText("SIGN-OFF")).click();
    }
    
}
