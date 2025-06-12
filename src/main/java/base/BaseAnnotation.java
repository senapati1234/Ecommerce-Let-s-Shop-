package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

public class BaseAnnotation extends DriverManager {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    private static final Logger logger = LogManager.getLogger(BaseAnnotation.class);

    @BeforeMethod
    public void setup() {
        //String browser = ConfigReader.getProperty("browser");
        String  browser="edge";
        driver = DriverManager.initializeDriver(browser);
        logger.info("Initializing WebDriver for browser: " + browser);
        driver = initializeDriver(browser);

        String url = ConfigReader.getProperty("app.url");
        logger.info("Navigating to URL: " + url);
        driver.get(url);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            logger.info("Closing browser");
            driver.quit();
            driver = null;
        }
    }
}
