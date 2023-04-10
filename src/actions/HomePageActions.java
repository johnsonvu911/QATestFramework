package actions;

import data.Constants;
import objects.HomePageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.SeleniumHelper;


public class HomePageActions {
    SeleniumHelper seleniumHelper = new SeleniumHelper();;
    CommonActions commonActions = new CommonActions();

    public void clickMenuItemButton(String itemName) {
        seleniumHelper.click(By.xpath(String.format(HomePageElements.menuItemButton, itemName)));
    }
    public void clickQuickViewButton(WebDriver driver) {
        commonActions.scrollDown(HomePageElements.menuItemButton2);
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath(HomePageElements.secondItem));
        builder.moveToElement(element).build().perform();
        seleniumHelper.click(By.xpath(HomePageElements.quickViewButton));
    }
}