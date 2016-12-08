package ru.stqa.selenium;


import org.junit.Test;

public class TestZ14 extends TestBase {

    @Test
    public void checkRef(){

        loginToLitecartAdmin();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");


    }
}
