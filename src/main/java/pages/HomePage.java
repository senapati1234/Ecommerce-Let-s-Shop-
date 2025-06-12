package pages;

import base.ActionHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

import java.util.List;
import java.util.Objects;

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

    public String addItemToCart(){
        for(WebElement product:products){
            System.out.println(product.getText());
            String productName = product.getText().trim();
            String productNameData = ConfigReader.getProperty("productToAddCart");
            if(productName.equalsIgnoreCase(productNameData)){
                clickElement(produc_AddToCart_Button,"Add to cart button");
                waitForVisibility(successmessage);
                return productName;
            }
        }
        return null;
    }
    public void click_Cart(){
       clickElement(Home_Cart_Button,"Click on Cart button");
       waitForVisibility(My_Cart_Text);
    }
}


