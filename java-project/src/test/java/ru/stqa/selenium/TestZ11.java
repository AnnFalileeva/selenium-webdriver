package ru.stqa.selenium;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class TestZ11 extends TestBase{

    @Test
    public void regist(){

        driver.get("http://localhost/litecart/en/");

        String email = "qa_st_12312@yandex.ru";
        String password = "111111";

        registration(email,password);
        logout();
        login(email,password);
        logout();

    }

    private void registration(String email,String password){
        driver.findElement(By.cssSelector("#box-account-login a")).click();

        driver.findElement(By.cssSelector("[name=tax_id]")).sendKeys("12331324");
        driver.findElement(By.cssSelector("[name=company]")).sendKeys("IT Company");
        driver.findElement(By.cssSelector("[name=firstname]")).sendKeys("Anna");
        driver.findElement(By.cssSelector("[name=lastname]")).sendKeys("Falileeva");
        driver.findElement(By.cssSelector("[name=address1]")).sendKeys("г. Ростов-на-Дону, ул. Б.-Садовая,55");
        driver.findElement(By.cssSelector("[name=address2]")).sendKeys("г. Ростов-на-Дону, пр. Стачки, 44");
        driver.findElement(By.cssSelector("[name=postcode]")).sendKeys("35501-6789");
        driver.findElement(By.cssSelector("[name=city]")).sendKeys("Ростов-на-Дону");

        Select country = new Select(driver.findElement(By.cssSelector("select[name=country_code]")));
        country.selectByValue("US");

        wait.until(textToBePresentInElementLocated(By.cssSelector("select[name=zone_code]"),"Alabama"));
        Select zone = new Select(driver.findElement(By.cssSelector("select[name=zone_code]")));
        zone.selectByValue("AK");

        driver.findElement(By.cssSelector("[name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("[name=phone]")).sendKeys("+19612223344");

        driver.findElement(By.cssSelector("[name=newsletter]")).click();

        driver.findElement(By.cssSelector("[name=password]")).sendKeys(password);
        driver.findElement(By.cssSelector("[name=confirmed_password]")).sendKeys(password);

        driver.findElement(By.cssSelector("[name=create_account]")).click();

        wait.until(presenceOfElementLocated(By.cssSelector("#box-account li:last-child")));

    }

    private void login(String email,String password){

        driver.findElement(By.cssSelector("[name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("[name=password]")).sendKeys(password);
        driver.findElement(By.cssSelector("[name=login]")).click();
        wait.until(presenceOfElementLocated(By.cssSelector("#box-account li:last-child")));

    }

    private void logout(){

        driver.findElement(By.cssSelector("#box-account li:last-child a")).click();
        wait.until(presenceOfElementLocated(By.cssSelector("[name=email]")));
    }



}

