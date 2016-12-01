package ru.stqa.selenium;

import org.junit.Test;
import org.openqa.selenium.By;


public class TestZ12 extends TestBase {

    @Test
    public void createProduct(){

        loginToLitecartAdmin();

        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");

        driver.findElement(By.cssSelector("#content a.button:last-child")).click();

        // General
        driver.findElement(By.cssSelector("[name=status][value='1']")).click();
        driver.findElement(By.cssSelector("[name*=name]")).sendKeys("Новая уточка");
        driver.findElement(By.cssSelector("[name*=code]")).sendKeys("123");

        driver.findElement(By.cssSelector("[name*=categories][value='1']")).click();

        // Information

        // Prices

    }



}
