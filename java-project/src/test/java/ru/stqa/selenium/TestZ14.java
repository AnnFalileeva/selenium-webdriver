package ru.stqa.selenium;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;
import java.util.Set;

public class TestZ14 extends TestBase {

    @Test
    public void checkRef(){

        loginToLitecartAdmin();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

        driver.findElement(By.cssSelector("#content .button")).click();
        List<WebElement> refs = driver.findElements(By.cssSelector("#content table:not(#table-zones) a:not(#address-format-hint)"));

        for (WebElement ref:refs){
            String orWindow = driver.getWindowHandle();
            Set<String> exWindows = driver.getWindowHandles();
            ref.click();
            String newWindow = wait.until(anyOtherWindow(exWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(orWindow);
        }


    }

    public ExpectedCondition<String> anyOtherWindow(Set<String> oldWindows){
        return new ExpectedCondition<String>() {
            //@Override
            public String apply(WebDriver driver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size()>0?handles.iterator().next():null;
            }
        };

    }
}
