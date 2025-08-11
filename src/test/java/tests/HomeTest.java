package tests;

import base.BaseAnnotation;
import org.testng.annotations.Test;
import utils.JsonDataReader;

public class HomeTest extends BaseAnnotation {
    @Test(description = "Verify to add the product on Cart from Home Page")
    public void add_Product_Cart() throws InterruptedException {

        // Read username and password from config
        String user = JsonDataReader.getTestData().username;
        String pass = JsonDataReader.getTestData().password;
        loginPage.login(user, pass);
        homePage.addItemToCart();
        homePage.click_Cart();
        logOut.SignOut();

    }
}
