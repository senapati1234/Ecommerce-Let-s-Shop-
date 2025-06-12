package tests;

import base.BaseAnnotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.CartPage;
import utils.ConfigReader;

public class CartTest extends BaseAnnotation {
    @Test
    public void productOnCart() throws InterruptedException {
        String user = ConfigReader.getProperty("username");
        String pass = ConfigReader.getProperty("password");
        loginPage.login(user, pass);
        String addedProductName = homePage.addItemToCart();
        System.out.println("Product added to cart: " + addedProductName);
        homePage.addItemToCart();
        homePage.click_Cart();
        cartPage.productname(addedProductName);

    }

}
