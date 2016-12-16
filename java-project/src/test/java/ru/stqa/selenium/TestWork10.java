package ru.stqa.selenium;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class TestWork10 {

    public EventFiringWebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start(){
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new MyListener());
        wait = new WebDriverWait(driver,10);
    }

    @After
    public void stop(){
        driver.quit();
        driver=null;
    }

    @Test
    public void login(){
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(presenceOfElementLocated(By.id("sidebar")));

    }



}
