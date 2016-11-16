package ru.stqa.selenium;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestZ1 {

    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);

    }

    @Test
    public void TestZ1(){
        driver.get("https://www.yandex.ru/");
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
