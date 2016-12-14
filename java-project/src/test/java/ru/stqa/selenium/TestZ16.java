package ru.stqa.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class TestZ16 {

    public static final String USERNAME = "anna711";
    public static final String AUTOMATE_KEY = "GZ4DzsqwMVWxvg72YPV8";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public WebDriver driver;
    @Before
    public void start() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        // caps.setCapability("browserName", "internet explorer");
        //caps.setCapability("platform", "WINDOWS");
        caps.setCapability("browserName", "chrome");
        caps.setCapability("platform", "WIN8");
        caps.setCapability("version", "54");
        caps.setCapability("browserstack.debug", "true");
        driver = new RemoteWebDriver(new URL(URL), caps);

    }

    @After
    public void stop(){
        driver.quit();
        driver=null;
        }

    @Test
    public void myTest(){

        driver.get("https://www.yandex.ru/");
        driver.get("https://www.google.com/");
    }
}
