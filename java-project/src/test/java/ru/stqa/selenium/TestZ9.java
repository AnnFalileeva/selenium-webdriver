package ru.stqa.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestZ9 extends TestBase{

    // задание 9 п.1)
    @Test
    public void checkSortCountryList(){

        driver.get("http://localhost/litecart/admin/");

        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

        // проверка сортировки списка стран
        List<WebElement> countriesRows = driver.findElements(By.cssSelector(".dataTable  tr.row"));
        ArrayList<String> countries = new ArrayList<>();

        for (WebElement element:countriesRows){
            String countryName = element.findElement(By.cssSelector("a")).getAttribute("textContent");
            countries.add(countryName);
        }

        assertTrue(isSort(countries));

        // проверка сортировки зон стран

        int kCounties = driver.findElements(By.cssSelector(".dataTable  tr.row")).size();
        for (int i = 2; i <= kCounties + 1;i++){
            String locatorCountry = ".dataTable tr.row:nth-child("+i+")";
            WebElement row = driver.findElement(By.cssSelector(locatorCountry));

            // в лекции говорилось, что при построении локаторов лучше не использовать индексы, но для ячейки количества зон
            // нет никаких атрибутов, поэтому используется индекс
            int kZones =  Integer.parseInt(row.findElement(By.cssSelector("td:nth-child(6)")).getAttribute("textContent"));

            if (kZones > 0){
                row.findElement(By.cssSelector("a")).click();
                List<WebElement> countryZones = driver.findElements(By.cssSelector("#table-zones td[type=hidden][name*=name]"));

                ArrayList<String> zones = new ArrayList<>();
                for(WebElement element:countryZones) {
                    String zoneName = element.getAttribute("value");
                    zones.add(zoneName);
                }
                assertTrue(isSort(zones));
                driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
            }
        }

    }

    // задание 9 п.2)
    @Test
    public void checkSortZoneList(){

        driver.get("http://localhost/litecart/admin/");

        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");

        // проверка сортировки зон стран
        int k = driver.findElements(By.cssSelector(".dataTable  tr.row")).size();

        for (int i = 2; i<=k+1;i++){
            String locatorCountry = ".dataTable tr.row:nth-child("+i+")";
            WebElement row = driver.findElement(By.cssSelector(locatorCountry));
            row.findElement(By.cssSelector("a")).click();

            List<WebElement> countryZones = driver.findElements(By.cssSelector("#table-zones [name*=zone_code]"));
            ArrayList<String> zones = new ArrayList<>();

            for (WebElement element:countryZones){
                String zoneName = element.findElement(By.cssSelector("[selected]")).getAttribute("textContent");
                zones.add(zoneName);

                assertTrue(isSort(zones));
            }

            driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");

        }

    }
}
