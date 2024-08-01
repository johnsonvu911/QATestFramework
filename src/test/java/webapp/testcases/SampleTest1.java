package webapp.testcases;

import actions.*;
import core.base.TestBase;
import data.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.NameGenerator;
import utils.SeleniumHelper;

public class SampleTest1 extends TestBase {

    SeleniumHelper seleniumHelper = new SeleniumHelper();
    LoginPageActions loginPage = new LoginPageActions();
    CommonActions commonActions = new CommonActions();
    HomePageActions homePage = new HomePageActions();
    InventoryPageActions inventoryPage = new InventoryPageActions();
    ManufacturingPageActions manufacturingPage = new ManufacturingPageActions();

    @Test
    public void test1() {
        String productName = NameGenerator.generateRandomName(12);

        seleniumHelper.navigateTo(Constants.testSite);
        loginPage.login(Constants.loginEmail, Constants.loginPassword);
        // Navigate to Inventory page 
        homePage.clickMenuItemButton(Constants.MenuItem.get("inventory"));
        // Navigate to Products page via menu bar 
        commonActions.navigateToProductsPage();
        // Create a new product 
        inventoryPage.createProduct(productName);
        commonActions.waitForPageDisplayed("Update Quantity");
        // Update the product's quantity 
        inventoryPage.updateQuantity(Constants.productQuantity);
        
        // Go back to home page 
        commonActions.clickMenuToggle();

        // Navigate to Manufacturing page 
        homePage.clickMenuItemButton(Constants.MenuItem.get("manufacturing"));
        // Create a manufacturing order 
        manufacturingPage.createOrder(productName, "1");
        // Get manufacturing order name and product name for verification later 
        String orderNameBefore = manufacturingPage.getOrderName();
        String productNameBefore = manufacturingPage.getProductName();
        // Update the manufacturing order to Done from draft. 
        manufacturingPage.updateNewOrderToDone(orderNameBefore);

        // CHECKPOINT: Verify the newly-created manufacturing order with order name and product name. 
        Assert.assertTrue(manufacturingPage.validateOrder(orderNameBefore, productNameBefore));

    }

}
