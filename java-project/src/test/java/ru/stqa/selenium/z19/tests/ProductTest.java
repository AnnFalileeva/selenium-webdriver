package ru.stqa.selenium.z19.tests;


import org.junit.Test;

public class ProductTest extends TestsBase {

    @Test
    public void addRemoveProduct(){

        app.open();
        app.addProductsToCart(3);
        app.goToCart();
        app.removeAddedProducts(app.getAddedProductsQuantity());

    }
}
