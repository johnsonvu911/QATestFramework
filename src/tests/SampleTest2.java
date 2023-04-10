package tests;

import actions.*;
import data.Constants;
import lombok.SneakyThrows;
import objects.CheckOutElements;
import objects.CommonElements;
import objects.HomePageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.SeleniumHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SampleTest2 extends TestBase {

    SeleniumHelper seleniumHelper = new SeleniumHelper();
    CommonActions commonActions = new CommonActions();
    HomePageActions homePage = new HomePageActions();
    InventoryPageActions inventoryPage = new InventoryPageActions();
    ManufacturingPageActions manufacturingPage = new ManufacturingPageActions();

    @Test
    public void test2() {
        try {
            seleniumHelper.navigateTo(Constants.testSite2);
            // Click on "Quick View" of the 2nd item on Hot Collection
            homePage.clickQuickViewButton(driver);
            // Get Price for verification later
            float price = CommonActions.getValueNumber(HomePageElements.price);
            // Select Color
            commonActions.selectColor();
            // Select Size
            commonActions.selectSize();
            // Select Quantity > 1
            commonActions.selectQuantity();
            // Click on "Add to Cart" button
            commonActions.clickAddToCart();
            // Get Color for verification
            String colorSelected = commonActions.getText(HomePageElements.colorSelected);
            // Get Size for verification
            String sizeSelected = commonActions.getText(HomePageElements.sizeSelected);
            // Click "Checkout" button
            commonActions.clickCheckout();
            // Fill Checkout form with all required fields
            CheckOutActions.fillOutBilling();
            // Checkpoint: Verify subtotal equal to price x quantity
            float quantity = CommonActions.getNumber(CheckOutElements.quantity);
            float subTotal = CommonActions.getValueNumber(CheckOutElements.subTotal);
            float demand = (price * quantity);
            Assert.assertEquals(subTotal,demand, "Subtotal is NOT equal to price x quantity");
            // Checkpoint: Verify color
            String colorCheckOut = commonActions.getText(CheckOutElements.colorCheckout);
            Assert.assertEquals(colorSelected, colorCheckOut, "Color is NOT matched");
            // Checkpoint: Verify size
            String sizeCheckOut = commonActions.getText(CheckOutElements.sizeCheckout);
            Assert.assertEquals(sizeSelected, sizeCheckOut, "Size is NOT matched");

        } catch (Exception ex) {
            System.out.println(ex.fillInStackTrace());
        }
    }
}
