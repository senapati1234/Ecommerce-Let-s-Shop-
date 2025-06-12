package tests;

import base.BaseAnnotation;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

public class HomeTest extends BaseAnnotation {
    @Test
    public void add_Product_Cart() throws InterruptedException {

        // Read username and password from config
        String user = ConfigReader.getProperty("username");
        String pass = ConfigReader.getProperty("password");
        loginPage.login(user, pass);
        homePage.addItemToCart();
        homePage.click_Cart();

    }
}
