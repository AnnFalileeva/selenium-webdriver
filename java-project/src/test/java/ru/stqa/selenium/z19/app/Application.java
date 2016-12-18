package ru.stqa.selenium.z19.app;

import org.openqa.selenium.WebDriver;
import ru.stqa.selenium.z19.pages.CartPage;
import ru.stqa.selenium.z19.pages.MainPage;
import ru.stqa.selenium.z19.pages.ProductPage;
import ru.stqa.selenium.z19.tests.TestsBase;

public class Application extends TestsBase{

    private MainPage mainPage;
    private ProductPage productPage;
    private CartPage cartPage;


    public Application(WebDriver driver){

        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    public void open(){
        mainPage.open();
    }

    private void addProductToCart(){
        mainPage.pickProduct();
        productPage.addToCart();
    }

    public void addProductsToCart(int number){

        for (int i=1; i<=number;i++){
            addProductToCart();

            if (i!=number){
                open();
            }

        }
    }

    public void goToCart(){
        productPage.goToCart();
    }

    public int getAddedProductsQuantity(){
        return cartPage.getProductsQuantityFromTable();
    }

    private void removeProduct(){
        cartPage.removeProduct();
    }

    public void removeAddedProducts(int number){
        for (int i=1; i<=number;i++){
            removeProduct();

            // не проверяем после удаления последнего элемента, так как таблицы нет
            if (i!=number){
                cartPage.waitProductsTableisUpdated();
            }
        }
    }
}
