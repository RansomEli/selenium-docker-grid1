package com.searchmodule.tests;

import com.searchmodule.pages.SearchPage;
import com.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    
    private final String duckDuck = "https://duckduckgo.com";
    
    
   /* @BeforeTest
    public void setupDriver() {
       *//* // set path
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        this.driver = new ChromeDriver();*//*
//        driver.navigate().to(duckDuck);
    
    }*/
    
    
    @Test
    @Parameters({"keyword"})
    public void search(String keyword) {
        
        driver.navigate().to(duckDuck);
        
        
        SearchPage searchPage = new SearchPage(driver);
        searchPage.doSearch(keyword);
        
        searchPage.goToVideos();
        int size = searchPage.getResult();
        
        Assert.assertTrue(size > 0);
        
    }
    
    
}
