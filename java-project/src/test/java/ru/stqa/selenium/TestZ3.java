package ru.stqa.selenium;


import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
public class TestZ3 extends TestBase {

    //private WebDriver driver;
    //private WebDriverWait wait;


    //@Before
    //public void start(){
        //driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //driver = new InternetExplorerDriver();

        /// старая схема, запуск FF только через Capability
        //DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability(FirefoxDriver.MARIONETTE, false);
        //caps.setCapability("firefox_binary", "C:\\Program Files\\Firefox ESR\\firefox.exe");
        //driver = new FirefoxDriver(caps);
        ///----------------------------------------

        /// второй вариант запуска FF по старой схеме
        //DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability(FirefoxDriver.MARIONETTE, false);
        //FirefoxBinary bin = new FirefoxBinary( new File("C:\\Program Files\\Firefox ESR\\firefox.exe"));
        //driver = new FirefoxDriver(bin, new FirefoxProfile(), caps);
        /// --------------------------------------------------------

        /// запуск Firefox Nightly
        //FirefoxBinary bin = new FirefoxBinary(new File("C:\\Program Files\\Nightly\\firefox.exe"));
        //driver = new FirefoxDriver(bin,new FirefoxProfile());
        ///----------------------------------------------------

        // Options and Capabilities
        //ChromeOptions options = new ChromeOptions();
        //options.setBinary("path");
        //options.addArguments("start-maximized");
        //DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability("unexpectedAlertBehaviour", "dismiss");
        //caps.setCapability(ChromeOptions.CAPABILITY, options);
        //driver = new ChromeDriver(caps);
        ///-----------------------------------------------------------

        //wait = new WebDriverWait(driver,10);
    //}

    @Test
    public void login(){
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(presenceOfElementLocated(By.id("sidebar")));

    }

    @Test
    public void MyTest(){
        driver.get("http://www.google.com");
        //assertFalse(isElementPresent(By.name("fff")));
        assertFalse(isElementPresent(By.xpath("//div[")));
    }

    @Test
    public void waitTest(){
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Webdriver");
        WebElement btnG = driver.findElement(By.name("btnG"));
        btnG.click();
        assertTrue(isElementPresent(By.cssSelector(".rc")));


    }

    //@After
    //public void stop(){
    //    driver.quit();
    //    driver=null;
    //}
}
