package ru.stqa.selenium;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestZ1 {

    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void testZ1(){
        driver.get("https://www.yandex.ru/");
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
