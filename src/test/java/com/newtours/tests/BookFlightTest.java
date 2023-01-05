package com.newtours.tests;

import com.newtours.pages.*;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {
    
    private String noOfPassengers;
    private String expectedPrice;
    
    
    @BeforeTest
    @Parameters({"noOfPassengers", "expectedPrice"})
    public void setupParameters(String noOfPassengers, String expectedPrice) {
            this.noOfPassengers = noOfPassengers;
            this.expectedPrice = expectedPrice;
 
        driver.navigate().to("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        
    }
    
    @Test
    public void registrationPage() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterUserDetails("selenium", "docker");
        registrationPage.enterUserCredentials("selenium", "docker");
        registrationPage.clickSubmit();
    }
    
    @Test (dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage() {
        RegistrationConfirmationPage registrationConfirmationPage =
                new RegistrationConfirmationPage(driver) ;
        registrationConfirmationPage.clickLink_Flights();
    }
    
    @Test (dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage() {
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.setNbrOfPassenger(noOfPassengers);
        flightDetailsPage.clickContinue();
    }
    
    @Test (dependsOnMethods = "flightDetailsPage")
    public void selectFlightDepartureReturn() {
        SelectFlightDepartureReturnPage selectFlightDepartureReturnPage =
                new SelectFlightDepartureReturnPage(driver);
        selectFlightDepartureReturnPage.clickContinue();
    }
    
    @Test (dependsOnMethods = "selectFlightDepartureReturn")
    public void enterBillingAddress() {
        EnterBillingAddressPage enterBillingAddressPage = new EnterBillingAddressPage(driver);
        enterBillingAddressPage.clickContinue();
    }
    
    @Test (dependsOnMethods = "enterBillingAddress")
    public void printConfirmation() {
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        String actualPrice = flightConfirmationPage.getPrice();
        Assert.assertEquals(actualPrice, expectedPrice);
        
    }
    
   
    

    
    
    

    
  
    
    
}
