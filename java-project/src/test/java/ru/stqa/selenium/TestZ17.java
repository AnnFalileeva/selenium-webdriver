package ru.stqa.selenium;



import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;


public class TestZ17 extends TestBase {

    @Test
    public void checkBrowserLogs(){

        loginToLitecartAdmin();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");

        int s = driver.findElements(By.cssSelector(".dataTable tr.row")).size();

        ArrayList<LogEntry> logs = new ArrayList<>();

        for (int i=3;i<=s+1;i++){

            WebElement row =  driver.findElement(By.cssSelector(".dataTable .row:nth-child("+i+")"));
            String checkboxName = row.findElement(By.cssSelector("input")).getAttribute("name");

            if (checkboxName.contains("products")){

                row.findElement(By.cssSelector("a")).click();
                logs.addAll(driver.manage().logs().get("browser").getAll());

            }

            driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        }

        assertTrue(areBrowserLogsPresent(logs.size()));


    }
}
