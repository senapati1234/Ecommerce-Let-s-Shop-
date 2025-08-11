/*
package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import pages.*;
import utils.ConfigReader;
import utils.ScreenshotUtil;
import utils.VideoRecorderUtil;

public class BaseAnnotation extends DriverManager implements ITestListener {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected CartPage cartPage;
    protected CheckOutPage checkOutPage;
    protected LogOut logOut;
    private static final Logger logger = LogManager.getLogger(BaseAnnotation.class);

    private void initializeTestSetup() {
        String browser = "chrome"; // or ConfigReader.getProperty("browser")
        driver = DriverManager.initializeDriver(browser);
        logger.info("Initializing WebDriver for browser: " + browser);

        String url = ConfigReader.getProperty("app.url");
        logger.info("Navigating to URL: " + url);
        driver.get(url);

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        checkOutPage = new CheckOutPage(driver);
        logOut = new LogOut(driver);
    }

    @BeforeMethod
    public void beforeTestSetup() {
        initializeTestSetup();
    }


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            logger.info("Closing browser");
            driver.close();
            driver = null;
        }
    }
}
*/
package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.annotations.*;

import pages.*;
import utils.JsonDataReader;
import utils.TestData;

public class BaseAnnotation extends DriverManager implements ITestListener {
    protected WebDriver driver;
    protected LoginPage loginPage;   // Common page object
    protected HomePage homePage;
    protected CartPage cartPage;
    protected CheckOutPage checkOutPage;
    protected LogOut logOut;
    protected TestData data;         // JSON test data
    private static final Logger logger = LogManager.getLogger(BaseAnnotation.class);

    @BeforeMethod
    public void beforeTestSetup() {
        // Load JSON test data
        data = JsonDataReader.getTestData();

        // Initialize WebDriver with browser from JSON
        driver = DriverManager.initializeDriver(data.browser);
        logger.info("Initializing WebDriver for browser: " + data.browser);

        // Navigate to URL from JSON
        logger.info("Navigating to URL: " + data.appUrl);
        driver.get(data.appUrl);

        // Initialize common page objects
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        logOut=new LogOut(driver);
        cartPage= new CartPage(driver);
        checkOutPage =new CheckOutPage(driver);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            logger.info("Closing browser");
            driver.quit();
            driver = null;
        }
    }
}
