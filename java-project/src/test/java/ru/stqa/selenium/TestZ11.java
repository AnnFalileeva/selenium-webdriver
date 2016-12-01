package ru.stqa.selenium;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class TestZ11 extends TestBase{

    @Test
    public void regist(){
        driver.get("http://localhost/litecart/en/");

        registration();
        //logout();
        //login();
        //logout();

    }

    public void registration(){
        driver.findElement(By.cssSelector("#box-account-login a")).click();

        driver.findElement(By.cssSelector("[name=firstname]")).clear();
        driver.findElement(By.cssSelector("[name=firstname]")).sendKeys("Anna");

        driver.findElement(By.cssSelector("[name=lastname]")).clear();
        driver.findElement(By.cssSelector("[name=lastname]")).sendKeys("Falileeva");

        driver.findElement(By.cssSelector("[name=address1]")).clear();
        driver.findElement(By.cssSelector("[name=address1]")).sendKeys("г. Ростов-на-Дону, ул. Б.-Садовая,55");

        driver.findElement(By.cssSelector("[name=postcode]")).clear();
        driver.findElement(By.cssSelector("[name=postcode]")).sendKeys("355010");

        driver.findElement(By.cssSelector("[name=city]")).clear();
        driver.findElement(By.cssSelector("[name=city]")).sendKeys("Ростов-на-Дону");

        Select country = new Select(driver.findElement(By.cssSelector("select[name=country_code]")));
        //country.selectByValue("US");
        country.selectByVisibleText("United States");

        wait.until(presenceOfElementLocated(By.cssSelector("select[name=zone_code]")));
        Select zone = new Select(driver.findElement(By.cssSelector("select[name=zone_code]")));
        //zone.selectByValue("AK");
        zone.selectByVisibleText("Arizona");

        driver.findElement(By.cssSelector("[name=email]")).clear();
        driver.findElement(By.cssSelector("[name=email]")).sendKeys("qa_st_1235@yandex.ru");

        driver.findElement(By.cssSelector("[name=phone]")).clear();
        driver.findElement(By.cssSelector("[name=phone]")).sendKeys("+79612223344");

        driver.findElement(By.cssSelector("[name=password]")).clear();
        driver.findElement(By.cssSelector("[name=password]")).sendKeys("11111111");

        driver.findElement(By.cssSelector("[name=confirmed_password]")).clear();
        driver.findElement(By.cssSelector("[name=confirmed_password]")).sendKeys("11111111");

        //driver.findElement(By.cssSelector("[name=create_account]")).click();
    }

    public void login(){
        wait.until(presenceOfElementLocated(By.cssSelector("[name=email]")));
        driver.findElement(By.cssSelector("[name=email]")).clear();
        driver.findElement(By.cssSelector("[name=email]")).sendKeys("qa_st_123@yandex.ru");
        driver.findElement(By.cssSelector("[name=password]")).clear();
        driver.findElement(By.cssSelector("[name=password]")).sendKeys("11111111");
        driver.findElement(By.cssSelector("[name=login]")).click();
    }

    public void logout(){
        wait.until(presenceOfElementLocated(By.cssSelector("#box-account li:last-child")));
        driver.findElement(By.cssSelector("#box-account li:last-child a")).click();
    }


}

