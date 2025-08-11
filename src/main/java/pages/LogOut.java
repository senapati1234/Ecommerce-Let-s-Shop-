package pages;

import base.ActionHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut extends ActionHelper {
    WebDriver driver;

    public LogOut(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//button[text()=' Sign Out ']")
    WebElement Logout;

    public void SignOut(){
        clickElement(Logout,"Logout Successfully");
    }


}
