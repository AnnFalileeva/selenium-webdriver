package ru.stqa.selenium;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    public WebDriverWait wait;

    public boolean isElementPresent(By locator){

        try {

            wait.until((WebDriver d)-> d.findElement(locator));
            return true;

        } catch (NoSuchElementException ex){

            return false;

        }

    }

    //public boolean areElementsPresent(By locator){
    //    try{
    //    return driver.findElements(locator).size()>0;
    //    } catch (InvalidSelectorException ex) {
    //        return false;
    //    }
    //}

    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
    }

    @After
    public void stop(){
        driver.quit();
        driver=null;
    }





}