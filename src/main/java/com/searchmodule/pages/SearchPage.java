package com.searchmodule.pages;

import com.newtours.pages.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Thread.*;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    private final String duckDuck = "https://duckduckgo.com";
    private final By searchBox =  By.name("q");
    private final By searchButton = By.id("search_button_homepage");
    
  
  
    
    @FindBy(css = "div[class='tile__media']")
    private List<WebElement> allVideos;
    
    public SearchPage(WebDriver driver) {
        this.driver = driver;
       utils.waitForPageToLoad(driver, searchBox);
    }
    
    public void goTo() {
        this.driver.get("https://duckduckgo.com");
    }
    
    public void doSearch(String keyword){
        driver.findElement(searchBox).sendKeys(keyword);
        clickSearch();
    }
    
    public void goToVideos() {
        String videoLink = "Videos";
        utils.waitForPageToLoad(driver, By.linkText(videoLink));
        driver.findElement(By.linkText(videoLink)).click();
        
//        utils.waitForPageToLoad(driver, By.);
    }
    
    public int getResult() {
    
        int size = 0;
        while(size <= 0) {
            try {
                sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            size = driver.findElements(By.cssSelector("div[class*='tile--vid']")).size();
        }
        System.out.println("Search Results: " + size);
        return size;
    }
    
  
    
    public void clickSearch() {
        driver.findElement(searchButton).click();
    }
    
}
