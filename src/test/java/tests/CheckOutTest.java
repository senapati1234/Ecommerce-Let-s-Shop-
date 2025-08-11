package tests;


import base.BaseAnnotation;
import org.testng.annotations.Test;
import utils.JsonDataReader;


public class CheckOutTest extends BaseAnnotation {
    @Test(description = "Verify Order is able to checkout properly")
    public void placeOrder() throws InterruptedException {
        String user = JsonDataReader.getTestData().username;
        String pass = JsonDataReader.getTestData().password;
        String card=JsonDataReader.getTestData().creditCardNumber;
        String cvvNumber=JsonDataReader.getTestData().cvvCode;
        String nameCard=JsonDataReader.getTestData().nameOnCard;
        String coupanText=JsonDataReader.getTestData().couponData;
        String shipEmail=JsonDataReader.getTestData().shipEmailTestData;
        String countryIntialName=JsonDataReader.getTestData().countryInitialNameTestData;
        String countryName=JsonDataReader.getTestData().countryName;
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
        logOut.SignOut();

    }


}
