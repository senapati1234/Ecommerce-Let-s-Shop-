package pages;

import base.ActionHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage extends ActionHelper{

    WebDriver driver;
    public CartPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".cartSection h3")
    WebElement cart_Product_Name;
    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement checkout_Button;

    public void productname(String expectedProduct) throws InterruptedException {
        Thread.sleep(10000);
        String actual = cart_Product_Name.getText().trim();
        System.out.println(actual);
        Assert.assertEquals(actual, expectedProduct);
    }
    public void clickCheckOutButton(){
        clickElement(checkout_Button,"Checkout Button");
    }

}
