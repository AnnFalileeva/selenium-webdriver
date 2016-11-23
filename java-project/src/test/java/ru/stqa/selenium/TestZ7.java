package ru.stqa.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;

public class TestZ7 extends TestBase {

    @Test
    public void loginAndClickMenu(){

        driver.get("http://localhost/litecart/admin/");

        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        int kL1 = driver.findElements(By.cssSelector("#box-apps-menu > li")).size();

        for (int i = 1; i<=kL1; i++){

            String locatorMenuL1 = "#box-apps-menu > li:nth-child("+i+")";
            String locatorTitle = "td#content > h1";

            // элемент меню первого уровня
            driver.findElement(By.cssSelector(locatorMenuL1)).click();
            assertTrue(isElementPresent(By.cssSelector(locatorTitle)));

            WebElement elementMenuL1 = driver.findElement(By.cssSelector(locatorMenuL1));
            int kL2 = elementMenuL1.findElements(By.cssSelector("ul > li")).size();

            for (int j=1;j<=kL2;j++){

                String locatorMenuL2 = "li:nth-child("+j+")";

                if (j > 1){
                    elementMenuL1 = driver.findElement(By.cssSelector(locatorMenuL1));
                }

                elementMenuL1.findElement(By.cssSelector(locatorMenuL2)).click();
                assertTrue(isElementPresent(By.cssSelector(locatorTitle)));

            }
        }

    }

}
