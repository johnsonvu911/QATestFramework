package webapp.pages;

import com.aventstack.extentreports.Status;
import webapp.testdata.Constants;
import objects.CommonElements;
import org.openqa.selenium.By;
import tests.TestBase;
import core.base.SeleniumHelper;

public class CommonPage {

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
