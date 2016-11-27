package ru.stqa.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;




import static org.junit.Assert.assertEquals;


public class TestZ10 extends TestBase {

    @Test
    public void checkProduct(){

        driver.get("http://localhost/litecart/en/");

        // товар на главной странице
        WebElement product = driver.findElement(By.cssSelector("#box-campaigns .product"));

        String productLink = product.findElement(By.cssSelector(".link")).getAttribute("href");
        String productName = product.findElement(By.cssSelector(".name")).getAttribute("textContent");

        WebElement regularPrice = product.findElement(By.cssSelector(".regular-price"));
        WebElement campaignPrice = product.findElement(By.cssSelector(".campaign-price"));

        String regularPriceValue = regularPrice.getAttribute("textContent");
        String campaignPriceValue = campaignPrice.getAttribute("textContent");
        String regularPriceClass = regularPrice.getAttribute("class");
        String campaignPriceClass = campaignPrice.getAttribute("class");
        // по тегу определяется жирность и зачеркнутость, так как в классе определены только цвет и размер шрифта
        String regularPriceTag = regularPrice.getAttribute("tagName");
        String campaignPriceTag = campaignPrice.getAttribute("tagName");

        product.click();

        // страница товара
        String productLinkP = driver.findElement(By.cssSelector("link[rel=canonical")).getAttribute("href");
        String productNameP = driver.findElement(By.cssSelector("#box-product .title")).getAttribute("textContent");

        WebElement regularPriceP = driver.findElement(By.cssSelector("#box-product .regular-price"));
        WebElement campaignPriceP = driver.findElement(By.cssSelector("#box-product .campaign-price"));

        String regularPriceValueP = regularPriceP.getAttribute("textContent");
        String campaignPriceValueP = campaignPriceP.getAttribute("textContent");
        String regularPriceClassP = regularPriceP.getAttribute("class");
        String campaignPriceClassP = campaignPriceP.getAttribute("class");
        String regularPriceTagP = regularPriceP.getAttribute("tagName");
        String campaignPriceTagP = campaignPriceP.getAttribute("tagName");


        assertEquals(productLink, productLinkP);
        assertEquals(productName, productNameP);
        assertEquals(regularPriceValue, regularPriceValueP);
        assertEquals(campaignPriceValue, campaignPriceValueP);
        assertEquals(regularPriceClass, regularPriceClassP);
        assertEquals(campaignPriceClass, campaignPriceClassP);
        assertEquals(regularPriceTag, regularPriceTagP);
        assertEquals(campaignPriceTag, campaignPriceTagP);
          }
}
