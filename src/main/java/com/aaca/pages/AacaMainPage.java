package com.aaca.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AacaMainPage {
    
    private WebDriver driver;
    private List<WebElement> topics ;
    
    public AacaMainPage(WebDriver driver) {
        this.driver = driver;
        waitForPageToLoad() ;
       // topics = driver.findElements(By.cssSelector("div[class='ipsDataItem_main']"));
    }
    
    
    
    private void waitForPageToLoad() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void goToTopic(String topicName) {
        driver.findElement(By.linkText(topicName)).click();
    }
    
}
