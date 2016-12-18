package ru.stqa.selenium.z19.tests;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.selenium.z19.app.Application;

public class TestsBase {

    private WebDriver driver;
    public Application app;

    @Before
    public void start() {
        driver = new ChromeDriver();
        app = new Application(driver);
    }

    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}
