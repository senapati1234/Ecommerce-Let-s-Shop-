package pages;

import base.ActionHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class LoginPage extends ActionHelper {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="userEmail")
    WebElement username;

    @FindBy(id="userPassword")
    WebElement password;

    @FindBy(id="login")
    WebElement loginBtn;


   // ActionHelper action = new ActionHelper(driver);

    public void login(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        clickByJS(loginBtn, "Submit Button");
    }
}