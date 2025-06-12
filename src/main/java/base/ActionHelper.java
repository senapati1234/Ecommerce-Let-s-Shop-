package base;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class ActionHelper extends BaseAnnotation{
    WebDriver driver;

    public ActionHelper(WebDriver driver) {
        this.driver = driver;
    }

    // Wait until element is visible
    public WebElement waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Click using WebDriver wait
    public void clickElement(WebElement element, String elementName) {
        waitForVisibility(element).click();
        System.out.println("Clicked on:" +elementName);
    }

    // Click using JS
    public void clickByJS(WebElement element,String elementName) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        System.out.println("Manual Clicked on:" +elementName);
    }

    // Send keys with wait
    public void enterText(WebElement element, String text,String textBoxName) {
        WebElement el = waitForVisibility(element);
        el.clear();
        el.sendKeys(text);
        System.out.println(textBoxName+ "field fill successfully");
    }

    // Get text from element
    public String getElementText(WebElement element) {
        return waitForVisibility(element).getText();
    }

    // Hover on element
    public void hoverOnElement(WebElement element) {
        Actions actions =new Actions(driver);
        actions.moveToElement(waitForVisibility(element)).perform();
    }

    // Scroll to element
    public void scrollToElement(WebElement element,String elementName) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        System.out.println("Scrolling successfully" +elementName);
    }

    // Select dropdown by visible text
    public void selectDropdownByText(WebElement dropdown, String text,String textName) {
        new Select(waitForVisibility(dropdown)).selectByVisibleText(text);
        System.out.println(textName+ "selected successfully from dropdown");
    }

    // Select dropdown by value
    public void selectDropdownByValue(WebElement dropdown, String value, String textName) {
        new Select(waitForVisibility(dropdown)).selectByValue(value);
        System.out.println(textName+ "selected successfully from dropdown");
    }

    // Select dropdown by index
    public void selectDropdownByIndex(WebElement dropdown, int index,String textName) {
        new Select(waitForVisibility(dropdown)).selectByIndex(index);
        System.out.println(textName+ "selected successfully from dropdown");
    }

    // Drag and drop
    public void dragAndDrop(WebElement source, WebElement target) {
        Actions actions =new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();
        System.out.println("Successfully drag and drop completed");
    }

    // Check if element is displayed
    public boolean isElementDisplayed(WebElement element) {
        try {
            return waitForVisibility(element).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    // Wait for element to be clickable
    public WebElement waitForClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Click with retry (for flaky elements)
    public void clickWithRetry(WebElement element, int attempts,String elementName) {
        int count = 0;
        while (count < attempts) {
            try {
                clickElement(element,elementName);
                break;
            } catch (Exception e) {
                count++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    // Scroll by pixels
    public void scrollBy(int x, int y) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    // Send keys using JS
    public void setValueByJS(WebElement element, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + value + "';", element);
    }

    // Wait for element to disappear
    public void waitForInvisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    // Get list of visible elements
    public List<WebElement> getVisibleElements(List<WebElement> elements) {
        return elements.stream().filter(WebElement::isDisplayed).toList();
    }
}

