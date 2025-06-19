package tests;


import base.BaseAnnotation;
import org.testng.annotations.Test;
import utils.ConfigReader;


public class CheckOutTest extends BaseAnnotation {
    @Test
    public void placeOrder() throws InterruptedException {
        String user = ConfigReader.getProperty("username");
        String pass = ConfigReader.getProperty("password");
        String card=ConfigReader.getProperty("creditCardNumber");
        String cvvNumber=ConfigReader.getProperty("cvvCode");
        String nameCard=ConfigReader.getProperty("nameOnCard");
        String coupanText=ConfigReader.getProperty("couponData");
        String shipEmail=ConfigReader.getProperty("shipEmailTestData");
        String countryIntialName=ConfigReader.getProperty("countryInitialNameTestData");
        String countryName=ConfigReader.getProperty("countryName");
        loginPage.login(user, pass);
        String addedProductName = homePage.addItemToCart();
        homePage.addItemToCart();
        homePage.click_Cart();
        cartPage.productname(addedProductName);
        cartPage.clickCheckOutButton();
        checkOutPage.verifyCheckOutPage();
        checkOutPage.enterPersonalInformation(card,cvvNumber,nameCard,coupanText);
        checkOutPage.applyCouponButton();
        checkOutPage.shippingInformation(shipEmail,countryIntialName);
        checkOutPage.selectValueFromCountryDropDown(countryName);

    }


}
