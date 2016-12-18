package ru.stqa.selenium;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestZ18 {
    public WebDriver driver;
    public BrowserMobProxy proxy;

    @Test
    public void MyTest(){

        proxy.newHar();
        driver.get("http://www.selenium2.ru");

        Har har = proxy.endHar();

        har.getLog().getEntries().forEach(l-> System.out.println(l.getResponse().getStatus() + ":"
                + l.getRequest().getUrl()));

    }


    @Before
    public void start(){


        proxy = new BrowserMobProxyServer();
        proxy.start(0);
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        //Proxy proxy1 = new Proxy();
        //proxy1.setHttpProxy("localhost:8888");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
        //capabilities.setCapability(CapabilityType.PROXY, proxy1);
        driver = new ChromeDriver(capabilities);

    }

    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}
