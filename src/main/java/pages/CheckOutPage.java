package pages;

import base.ActionHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class CheckOutPage extends ActionHelper {
    WebDriver driver;
    public CheckOutPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[text()='Place Order ']")
    WebElement placeOrderbutton;
    @FindBy(xpath = "(//input[@class=\"input txt text-validated\"])[1]")
    WebElement cartNumberField;
    @FindBy(xpath = "(//select[@class=\"input ddl\"])[1]")
    WebElement expireDate;
    @FindBy(xpath = "(//select[@class=\"input ddl\"])[2]")
    WebElement expireYear;
    @FindBy(xpath="//div[text()=\"CVV Code \"]//ancestor::div[@class=\"field small\"]//input[@class=\"input txt\"]")
    WebElement cvvCode;
    @FindBy(xpath="//div[text()=\"Name on Card \"]//ancestor::div[@class=\"field\"]//input[@class=\"input txt\"]")
    WebElement nameOnCard;
    @FindBy(xpath = "//div[text()='Apply Coupon ']/following-sibling::input")
    WebElement applyCouponInputBox;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement couponButtonLocator;
    @FindBy(xpath = "//p[text()='* Coupon Applied']")
    WebElement couponToastMessageLocator;
    @FindBy(xpath = "//div[@class=\"user__name mt-5\"]//input[@type=\"text\"]")
    WebElement shipEmailId;
    @FindBy(xpath="//input[@placeholder=\"Select Country\"]")
    WebElement selectCountryLocator;
    @FindBy(xpath = "//section[@class=\"ta-results list-group ng-star-inserted\"]//button[@type=\"button\"]")
    List<WebElement> countryDropdownOptions;

    public void verifyCheckOutPage(){
        isElementDisplayed(placeOrderbutton);
    }
    public void enterPersonalInformation( String CardNumber,String cvv, String Name, String coupon){
        enterText(cartNumberField,CardNumber,"Card Number Field");
        clickElement(expireDate,"expire date button");
        selectDropdownByIndex(expireDate,5,"Filled expire date field");
        selectDropdownByIndex(expireYear,29,"Filled expire month field");
        enterText(cvvCode,cvv,"Filled Cvv code");
        enterText(nameOnCard,Name,"Filled name on card");
        enterText(applyCouponInputBox,coupon,"Filled Coupon input box");

    }
    public void applyCouponButton(){
        clickElement(couponButtonLocator,"apply coupon button");
        waitForVisibility(couponToastMessageLocator);
    }
    public void shippingInformation(String email,String country){
        enterText(shipEmailId,email,"email field");
        enterText(selectCountryLocator,country,"country field");
    }
    public void selectValueFromCountryDropDown(String country){
        for (WebElement option : countryDropdownOptions) {
            if (option.getText().trim().equalsIgnoreCase(country)) {
                option.click();
                break;
            }
        }


    }

}
