package actions;

import com.aventstack.extentreports.Status;
import data.Constants;
import objects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tests.TestBase;
import utils.SeleniumHelper;
import org.openqa.selenium.Keys;

import static tests.TestBase.driver;

public class CommonActions {

    public static CommonActions commonActions;
    SeleniumHelper seleniumHelper = new SeleniumHelper();

    public boolean isMenuBarDisplayed() {
        return seleniumHelper.isElementDisplayed(CommonElements.inventoryMenuBar);
    }

    public void navigateToProductsPage() {
        if (isMenuBarDisplayed()) {
            seleniumHelper.click(CommonElements.productsMenuItem);
            seleniumHelper.click(CommonElements.productsMenuSubItem);
        } else {
            TestBase.logger.log(Status.FAIL, "Menu bar not display");
        }
    }

    public void waitForPageDisplayed(String pageName) {
        seleniumHelper.waitForElementDisplayed(By.xpath(String.format(CommonElements.navigationActiveItem, pageName)), Constants.defaultTimeout);
    }

    public void clickMenuToggle() {
        seleniumHelper.click(CommonElements.menuToggle);
    }

    //Scroll down to an element
    public void scrollDown(String findElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(findElement));
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void selectColor() {
        scrollDown(CommonElements.colorOption);
        seleniumHelper.click(By.xpath(InventoryPageElements.colorSelected));
    }

    public void selectSize() {
        seleniumHelper.click(By.xpath(InventoryPageElements.sizeSelected));
    }

    public void selectQuantity() {
        seleniumHelper.click(By.xpath(InventoryPageElements.quantitySelected));
    }

    public void clickAddToCart() {
        seleniumHelper.click(By.xpath(InventoryPageElements.addToCart));
    }

    public void clickCheckout() {
        seleniumHelper.click(By.xpath(InventoryPageElements.checkOut));
    }

    public static float getValueNumber(String wholeValue) {
        WebElement value = driver.findElement(By.xpath(wholeValue));
        String value_num = value.getText().substring(1); //using substring(1) to remove the $ currency
        Float floatValue = Float.parseFloat(value_num.replace(",", "")); //Using parseFloat because of the number is displayed as x,000.00
        System.out.println(floatValue);
        return 0;
    }

    public static float getNumber(String number) {
        WebElement value = driver.findElement(By.xpath(number));
        String value_num = value.getText().substring(2); //using substring(2) to remove 'x' and 'number' before actual quantity
        Float floatValue = Float.valueOf(value_num);
        System.out.println(floatValue);
        return 0;
    }

    public String getText(String value) {
        WebElement findElement = driver.findElement(By.xpath(value));
        String textValue = findElement.getAttribute("textContent"); //in some case the value of text is hidden (not visible) so need to getAttribute("textContent")
        return textValue;
    }

}


