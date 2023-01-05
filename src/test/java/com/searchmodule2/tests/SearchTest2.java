package com.searchmodule2.tests;

import com.aaca.pages.AacaMainPage;
import com.aaca.pages.AacaNextPage;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest2  extends BaseTest {
    public static final String AACA_ORG = "https://forums.aaca.org/";
  /*
    @BeforeTest
    public void setupDriver() {
        // set path
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver");
        this.driver = new ChromeDriver() ;
        int placeHolder =8;
    }*/
    
 /*   @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
    */
    @Test
    @Parameters({"keyword"})
    public void search2(String keyword) {
        driver.navigate().to(AACA_ORG);
        AacaMainPage aaca = new AacaMainPage(driver);
        
        aaca.goToTopic(keyword);
        int placeHolder = 8;
        
        AacaNextPage nextPage = new AacaNextPage(driver);
        int count = nextPage.countTopics();
        System.out.println("Number of topics in " + keyword + " sub-forum: " + count);
        Assert.assertTrue(count > 1);
        

    }
    
    
    
    
    
    
}
