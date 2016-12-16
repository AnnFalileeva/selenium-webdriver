package ru.stqa.selenium;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;


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

    public boolean isOneElementPresent(WebElement element, By locator){
        return element.findElements(locator).size()==1;
    }

    public boolean areBrowserLogsPresent(int logSize){

        if (logSize > 0){
            System.out.println("Логи есть.");
        }
        else{
            System.out.println("Логов нет.");
        }

        return logSize>0;

    }

    public boolean isSort(ArrayList list){

        ArrayList<String> sortList = new ArrayList<String>();
        sortList.addAll(list);
        Collections.sort(sortList);

        boolean isRightSort = true;
        for (int i=0;i<list.size();i++){
            if (!list.get(i).equals(sortList.get(i))){
                isRightSort=false;
                break;
            }
        }

        return isRightSort;
    }


    public void loginToLitecartAdmin(){

        driver.get("http://localhost/litecart/admin/");

        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

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