package com.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utils {
    
    static public void waitForPageToLoad(WebDriver driver, By by) {
        new WebDriverWait(driver, 30 ).until(ExpectedConditions.elementToBeClickable(by));
    }
}
