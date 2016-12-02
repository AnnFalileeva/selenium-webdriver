package ru.stqa.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class TestZ12 extends TestBase {

    @Test
    public void createProduct(){

        loginToLitecartAdmin();

        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");

        driver.findElement(By.cssSelector("#content a.button:last-child")).click();

        // General
        driver.findElement(By.cssSelector("[name=status][value='1']")).click();
        driver.findElement(By.cssSelector("[name*=name]")).sendKeys("Новая уточка");
        driver.findElement(By.cssSelector("[name=code]")).sendKeys("123");
        driver.findElement(By.cssSelector("[name*=categories][value='1']")).click();
        driver.findElement(By.cssSelector("[value='1-2']")).click();

        driver.findElement(By.cssSelector("[name=quantity]")).clear();
        driver.findElement(By.cssSelector("[name=quantity]")).sendKeys("1.50");

        Select soldOut = new Select(driver.findElement(By.cssSelector("[name=sold_out_status_id]")));
        soldOut.selectByValue("2");

        driver.findElement(By.cssSelector("[type=file]")).sendKeys((new File("/1.jpg").getAbsolutePath()));

        driver.findElement(By.cssSelector("[name=date_valid_from]")).sendKeys("12-14-2016");
        driver.findElement(By.cssSelector("[name=date_valid_to]")).sendKeys("12-27-2016");
       
        driver.findElement(By.cssSelector("[name=save]")).click();
        wait.until(presenceOfElementLocated(By.cssSelector(".dataTable")));

        // Information

        // Prices

    }

    //public void setDatepicker(String cssSelector, String date) {

    //    JavascriptExecutor.class.cast(driver).executeScript(String.format("$('%s').datepicker('setDate', '%s')", cssSelector, date));
    //}



}
