package tests;

import actions.*;
import data.Constants;
import lombok.SneakyThrows;
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

    @SneakyThrows
    @Test
    public void test1() {
        String productName = NameGenerator.generateRandomName(12);

//        openBrowser("chrome");
        seleniumHelper.navigateTo(Constants.testSite);
        loginPage.login(Constants.loginEmail, Constants.loginPassword);

        homePage.clickMenuItemButton(Constants.MenuItem.get("inventory"));
        commonActions.navigateToProductsPage();
        inventoryPage.createProduct(productName);
        commonActions.waitForPageDisplayed("Update Quantity");
        inventoryPage.updateQuantity(Constants.productQuantity);

        commonActions.clickMenuToggle();

        homePage.clickMenuItemButton(Constants.MenuItem.get("manufacturing"));
        manufacturingPage.createOrder(productName, "1");
        String orderNameBefore = manufacturingPage.getOrderName();
        String productNameBefore = manufacturingPage.getProductName();
        manufacturingPage.updateNewOrderToDone(orderNameBefore);

        Assert.assertTrue(manufacturingPage.validateOrder(orderNameBefore, productNameBefore));

    }

}
