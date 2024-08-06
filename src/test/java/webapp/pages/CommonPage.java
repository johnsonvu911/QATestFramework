package webapp.pages;

import com.aventstack.extentreports.Status;
import webapp.testdata.Constants;
import objects.CommonElements;
import org.openqa.selenium.By;
import tests.TestBase;
import core.base.ElementActions;

public class CommonPage {

    ElementActions elementActions = new ElementActions();
    public boolean isMenuBarDisplayed() {
        return elementActions.isElementDisplayed(CommonElements.inventoryMenuBar);
    }
    public void navigateToProductsPage() {
       if (isMenuBarDisplayed()) {
           elementActions.click(CommonElements.productsMenuItem);
           elementActions.click(CommonElements.productsMenuSubItem);
       } else {
           TestBase.logger.log(Status.FAIL, "Menu bar not display");
       }
    }
    public void waitForPageDisplayed(String pageName) {
         elementActions.waitForElementDisplayed(By.xpath(String.format(CommonElements.navigationActiveItem, pageName)), Constants.defaultTimeout);
    }
    public void clickMenuToggle() {
        elementActions.click(CommonElements.menuToggle);
    }
}
