package ru.stqa.selenium;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class TestZ13 extends TestBase{

    @Test
    public void cart(){

        for (int i =1; i<=3;i++){

            driver.get("http://localhost/litecart/en/");
            driver.findElement(By.cssSelector("#box-most-popular li.product:nth-child("+i+")")).click();

            // проверяем, есть ли на странице товара список с выбором размера
            if (driver.findElements(By.cssSelector("option")).size() > 0){
                Select size = new Select(driver.findElement(By.cssSelector("[name='options[Size]']")));
                size.selectByValue("Small");
            }

            String count = driver.findElement(By.cssSelector("#cart .quantity")).getAttribute("textContent");

            driver.findElement(By.cssSelector("[name=add_cart_product]")).click();
            wait.until(not(attributeToBe(By.cssSelector("#cart .quantity"),"textContent",count)));
        }

        driver.findElement(By.cssSelector("#cart .link")).click();

        int rows = driver.findElements(By.cssSelector(".dataTable tr")).size() - 5;
        for (int i=1;i<=rows;i++){

            WebElement table = driver.findElement(By.cssSelector(".dataTable"));
            driver.findElement(By.cssSelector("[name=remove_cart_item]")).click();

            wait.until(stalenessOf(table));

            // не проверяем после удаления последнего элемента, так как таблицы нет
            if (i!=rows){
                wait.until(visibilityOfElementLocated(By.cssSelector(".dataTable")));
            }

        }


    }
}
