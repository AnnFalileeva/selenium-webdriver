package ru.stqa.selenium;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class TestZ15 {

    public WebDriver driver;
    //public WebDriver driver2;
    @Before
    public void start() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
       // caps.setCapability("browserName", "internet explorer");
        //caps.setCapability("platform", "WINDOWS");
        caps.setCapability("browserName", "chrome");
        caps.setCapability("platform", "WIN8_1");
        driver = new RemoteWebDriver(new URL("http://192.168.101.66:4444/wd/hub"), caps);
        //driver2 = new RemoteWebDriver(new URL("http://192.168.101.66:4444/wd/hub"), caps);
    }

    @After
    public void stop(){
        driver.quit();
        driver=null;
        //driver2.quit();
        //driver2=null;
    }

    @Test
    public void myTest(){

        driver.get("https://www.yandex.ru/");
        //driver2.get("https://www.yandex.ru/");
    }
}
