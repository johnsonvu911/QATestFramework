package utils;

import com.aventstack.extentreports.Status;
import data.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.TestBase;

import java.time.Duration;
import java.util.List;

import static tests.TestBase.driver;

public class SeleniumHelper {

    public WebElement getWebElement(String elementType, String elementValue) {
        switch (elementType) {
            case "id":
                return TestBase.driver.findElement(By.id(elementValue));
            case "css":
                return TestBase.driver.findElement(By.cssSelector(elementValue));
            case "tagname":
                return TestBase.driver.findElement(By.tagName(elementValue));
            case "xpath":
                return TestBase.driver.findElement(By.xpath(elementValue));
            case "classname":
                return TestBase.driver.findElement(By.className(elementValue));
            case "name":
                return TestBase.driver.findElement(By.name(elementValue));
            case "linktext":
                return TestBase.driver.findElement(By.linkText(elementValue));
            default: return null;
        }
    }
    public List<WebElement> getWebElements(String elementType, String elementValue) {
        switch (elementType) {
            case "id":
                return TestBase.driver.findElements(By.id(elementValue));
            case "css":
                return TestBase.driver.findElements(By.cssSelector(elementValue));
            case "tagname":
                return TestBase.driver.findElements(By.tagName(elementValue));
            case "xpath":
                return TestBase.driver.findElements(By.xpath(elementValue));
            case "classname":
                return TestBase.driver.findElements(By.className(elementValue));
            case "name":
                return TestBase.driver.findElements(By.name(elementValue));
            case "linktext":
                return TestBase.driver.findElements(By.linkText(elementValue));
            default: return null;
        }
    }
    public void click(By element) {
        waitForElementDisplayed(element, Constants.defaultTimeout);
        TestBase.driver.findElement(element).click();
        TestBase.logger.log(Status.INFO, String.format("Clicked element: %s", element));
    }
    public void clickByText(String elementXpath, String text) {
        By element = By.xpath(String.format(elementXpath, text));
        waitForElementDisplayed(element, Constants.longTimeout);
        TestBase.driver.findElement(element).click();
        TestBase.logger.log(Status.INFO, String.format("Clicked text: %s", text));
    }
    public void clickByText(String textToClick) {
        By element = By.xpath(String.format("//*[contains(text(), '%s')]", textToClick));
        waitForElementDisplayed(element, Constants.longTimeout);
        TestBase.driver.findElement(element).click();
        TestBase.logger.log(Status.INFO, String.format("Clicked text: %s", textToClick));
    }
    public void clickButton(String buttonName) {
        TestBase.driver.findElement(By.xpath(String.format("//button[contains(text(),'%s')]", buttonName))).click();
        TestBase.logger.log(Status.INFO, String.format("Clicked button: %s", buttonName));
    }
    public void navigateTo(String url) {
        TestBase.driver.navigate().to(url);
        TestBase.logger.log(Status.INFO, String.format("Navigated to url: %s", url));
    }
    public void textBoxInput(By element, String value) {
        waitForElementDisplayed(element, Constants.defaultTimeout);
        WebElement textbox = TestBase.driver.findElement(element);
        textbox.clear();
        textbox.sendKeys(value);
        TestBase.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        TestBase.logger.log(Status.INFO, String.format("Input: %s", value));
    }

    public void selectOption(By element, String option) {
        waitForElementDisplayed(element, Constants.defaultTimeout);
        Select select = new Select(TestBase.driver.findElement(element));
        select.selectByVisibleText(option);
    }

    public String getText(By element) {
        waitForElementDisplayed(element, Constants.longTimeout);
        return TestBase.driver.findElement(element).getText();
    }
    public boolean isElementDisplayed(By element) {
        waitForElementDisplayed(element, Constants.longTimeout);
        return TestBase.driver.findElement(element).isDisplayed();
    }
    public void waitForElementDisplayed(By element, int timeoutInMillis) {
        WebDriverWait wait = new WebDriverWait(TestBase.driver, Duration.ofMillis(timeoutInMillis));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public void pressKey(By element, String keyToPress) {
        WebElement webElement = TestBase.driver.findElement(element);
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
    public void Drag_Filter(By start_element, By end_element, int begin_distance, int end_distance) throws InterruptedException {
        Actions act = new Actions(driver);
        WebElement start = driver.findElement(start_element);
        act.dragAndDropBy(start, begin_distance, 0).build().perform();
        Thread.sleep(600);
        WebElement end = driver.findElement(end_element);
        act.dragAndDropBy(end, end_distance, 0).build().perform();
        Thread.sleep(600);

    }
    public void Move_Element(By element) {
        waitForElementDisplayed(element, Constants.defaultTimeout);
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(driver.findElement(element)).perform();
    }
    public Integer getQuantity(By element, String cate) {
        List <WebElement> allSearchElements = TestBase.driver.findElements(element);
        int howManyElements = allSearchElements.size();
        System.out.println("Day la ket qua "+ cate + ": "+ howManyElements);
        return  howManyElements;
    }



}
