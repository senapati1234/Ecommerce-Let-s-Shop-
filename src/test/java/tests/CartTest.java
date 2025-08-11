package tests;

import base.BaseAnnotation;
import org.testng.annotations.Test;
import utils.JsonDataReader;

public class CartTest extends BaseAnnotation {
    @Test(description = "Added Product on cart is display properly")
    public void productOnCart() throws InterruptedException {
        String user = JsonDataReader.getTestData().username;
        String pass = JsonDataReader.getTestData().password;
        loginPage.login(user, pass);
        String addedProductName = homePage.addItemToCart();
        System.out.println("Product added to cart: " + addedProductName);
        homePage.addItemToCart();
        homePage.click_Cart();
        cartPage.productname(addedProductName);
        logOut.SignOut();

    }

}
