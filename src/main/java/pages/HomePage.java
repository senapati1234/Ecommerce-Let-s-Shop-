package pages;

import base.ActionHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.JsonDataReader;

import java.util.List;

public  class HomePage extends ActionHelper {

    WebDriver driver;
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".container b")
    List<WebElement> products;
    @FindBy(xpath="//div[contains(@class,\"col-lg-4\")]//b[text()='IPHONE 13 PRO']//ancestor::div[3]//i[@class=\"fa fa-shopping-cart\"]")
    WebElement produc_AddToCart_Button;
    @FindBy(xpath="//div[@aria-label=\"Product Added To Cart\"]")
    WebElement successmessage;
    @FindBy(xpath = "//button[@routerlink=\"/dashboard/cart\"]")
    WebElement Home_Cart_Button;
    @FindBy(xpath="//h1[text()='My Cart']")
    WebElement My_Cart_Text;

    public String addItemToCart() {
        String productNameToAdd = JsonDataReader.getTestData().productToAddCart.trim();
        System.out.println("Looking for product: " + productNameToAdd);

        for (WebElement product : products) {
            String productName = product.getText().trim();
            if (productName.equalsIgnoreCase(productNameToAdd)) {
                // Build dynamic XPath for matching product
                WebElement dynamicAddToCartButton = driver.findElement(By.xpath(
                        "//div[contains(@class,'col-lg-4')]//b[text()='" + productName + "']//ancestor::div[3]//i[@class='fa fa-shopping-cart']"
                ));
                dynamicAddToCartButton.click();
                waitForVisibility(successmessage);
                System.out.println(productName);
                return productName;

            }
        }

        throw new RuntimeException("Product not found: " + productNameToAdd);
    }
    public void click_Cart() throws InterruptedException {
        Thread.sleep(5000);
       clickElement(Home_Cart_Button,"Click on Cart button");
       waitForVisibility(My_Cart_Text);
    }
}


