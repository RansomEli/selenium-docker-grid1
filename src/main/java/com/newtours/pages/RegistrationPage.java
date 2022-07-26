package com.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    
    private WebDriver driver;
  
    
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
       // waitForPageToLoad();
        utils.waitForPageToLoad(driver, By.id("register-btn"));
    }
    
    private void waitForPageToLoad() {
    
    }
    
    public void goTo() {
//        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
//        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameText));
    }
    
    public void enterUserDetails(String firstName, String lastName) {
        driver.findElement(By.name("firstName")).sendKeys(firstName);
        driver.findElement(By.name("lastName")).sendKeys(lastName);
    }
    
    public void enterUserCredentials(String username, String password) {
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }
    
    public void clickSubmit() {
        driver.findElement(By.id("register-btn")).click();
    }
    
}
