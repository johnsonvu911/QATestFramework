package core.base;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import core.data.Constants;

import java.time.Duration;
import java.util.List;

public class ElementActions extends TestBase{

    public WebElement getWebElement(String elementType, String elementValue) {
        switch (elementType) {
            case "id":
                return driver.findElement(By.id(elementValue));
            case "css":
                return driver.findElement(By.cssSelector(elementValue));
            case "tagname":
                return driver.findElement(By.tagName(elementValue));
            case "xpath":
                return driver.findElement(By.xpath(elementValue));
            case "classname":
                return driver.findElement(By.className(elementValue));
            case "name":
                return driver.findElement(By.name(elementValue));
            case "linktext":
                return driver.findElement(By.linkText(elementValue));
            default: return null;
        }
    }
    public List<WebElement> getWebElements(String elementType, String elementValue) {
        switch (elementType) {
            case "id":
                return driver.findElements(By.id(elementValue));
            case "css":
                return driver.findElements(By.cssSelector(elementValue));
            case "tagname":
                return driver.findElements(By.tagName(elementValue));
            case "xpath":
                return driver.findElements(By.xpath(elementValue));
            case "classname":
                return driver.findElements(By.className(elementValue));
            case "name":
                return driver.findElements(By.name(elementValue));
            case "linktext":
                return driver.findElements(By.linkText(elementValue));
            default: return null;
        }
    }
    public void click(By element) {
        waitForElementDisplayed(element, Constants.DEFAULT_TIMEOUT);
        driver.findElement(element).click();
        logger.log(Status.INFO, String.format("Clicked element: %s", element));
    }
    public void clickByText(String elementXpath, String text) {
        By element = By.xpath(String.format(elementXpath, text));
        waitForElementDisplayed(element, Constants.LONG_TIMEOUT);
        driver.findElement(element).click();
        logger.log(Status.INFO, String.format("Clicked text: %s", text));
    }
    public void clickByText(String textToClick) {
        By element = By.xpath(String.format("//*[contains(text(), '%s')]", textToClick));
        waitForElementDisplayed(element, Constants.LONG_TIMEOUT);
        driver.findElement(element).click();
        logger.log(Status.INFO, String.format("Clicked text: %s", textToClick));
    }
    public void clickButton(String buttonName) {
        driver.findElement(By.xpath(String.format("//button[contains(text(),'%s')]", buttonName))).click();
        logger.log(Status.INFO, String.format("Clicked button: %s", buttonName));
    }
    public void navigateTo(String url) {
        driver.navigate().to(url);
        logger.log(Status.INFO, String.format("Navigated to url: %s", url));
    }
    public void textBoxInput(By element, String value) {
        waitForElementDisplayed(element, Constants.DEFAULT_TIMEOUT);
        WebElement textbox = driver.findElement(element);
        textbox.clear();
        textbox.sendKeys(value);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.log(Status.INFO, String.format("Input: %s", value));
    }

    public void selectOption(By element, String option) {
        waitForElementDisplayed(element, Constants.DEFAULT_TIMEOUT);
        Select select = new Select(driver.findElement(element));
        select.selectByVisibleText(option);
    }
    public String getText(By element) {
        waitForElementDisplayed(element, Constants.LONG_TIMEOUT);
        return driver.findElement(element).getText();
    }
    public boolean isElementDisplayed(By element) {
        waitForElementDisplayed(element, Constants.LONG_TIMEOUT);
        return driver.findElement(element).isDisplayed();
    }
    public void waitForElementDisplayed(By element, int timeoutInMillis) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeoutInMillis));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public void pressKey(By element, String keyToPress) {
        WebElement webElement = driver.findElement(element);
        switch (keyToPress) {
            case "Tab": webElement.sendKeys(Keys.TAB);
            case "Enter":
                if (System.getProperty("os.name").contains("Mac")) {
                    webElement.sendKeys(Keys.RETURN);
                }
                else {
                    webElement.sendKeys(Keys.ENTER);
                }
        }

    }

}
