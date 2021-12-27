package actions;

import com.aventstack.extentreports.Status;
import data.Constants;
import objects.CommonElements;
import org.openqa.selenium.By;
import tests.TestBase;
import utils.SeleniumHelper;

public class CommonActions {

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
}
