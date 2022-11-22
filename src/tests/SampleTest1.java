package tests;
import java.util.ArrayList;
import actions.*;
import actions.Filter.FilterActions;
import actions.Filter.WishlistActions;
import data.Constants;
import data.Wishlist_Data;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.NameGenerator;
import utils.SeleniumHelper;


import java.util.ArrayList;

public class SampleTest1 extends TestBase {

    SeleniumHelper seleniumHelper = new SeleniumHelper();
    LoginPageActions loginPage = new LoginPageActions();
    CommonActions commonActions = new CommonActions();
    HomePageActions homePage = new HomePageActions();
    InventoryPageActions inventoryPage = new InventoryPageActions();
    ManufacturingPageActions manufacturingPage = new ManufacturingPageActions();
    FilterActions Filter_Product = new FilterActions();
    WishlistActions Wishlist = new WishlistActions();
    @Test
    public void Verify_ProductInRange_StartEnd() throws InterruptedException {
        seleniumHelper.navigateTo(Constants.testSite);
        loginPage.login_shop(Constants.loginEmail, Constants.loginPassword);
        // User select start price and end price in filter
        Filter_Product.Filter_Start_End(Constants.Start,Constants.End);
        // Get range price is selected by user
        Float start_price = Filter_Product.Get_StartPrice();
        Float end_price = Filter_Product.Get_EndPrice();
        // Get list price is returned by system
        ArrayList<WebElement> list = Filter_Product.ListElement();
        //6. Check list price with range price is selected by user
        // Verify All price in List Price is returned by system must be within the range of values filtered by user
        Assert.assertTrue(Filter_Product.Check_PriceInRange_StartEnd(list, start_price, end_price));
    }
    // Verify that system show message when user add a favorite product in Wishlist
    @Test
    public void Verify_User_Could_Tym_Product() throws InterruptedException {
        seleniumHelper.navigateTo(Constants.testSite);
        loginPage.login_shop(Constants.loginEmail, Constants.loginPassword);
        // Click a "CLOTHING" category
        Wishlist.Click_A_Category(Wishlist_Data.Category[0]);
        // User click tym icon in a product
        Wishlist.Click_Icon_Tym();
        // User navigate to Wishlist
        Wishlist.Go_To_Wishlist();
        // User search product is clicked in Wishlist and get product name
        String ProductName = Wishlist.Get_Find_Favorite_Product();

        // CHECKPOINT: Verify Product display in Wishlist same Product Name is clicked by user
        Assert.assertEquals("Patient Ninja",ProductName);

    }
    @Test
    public void Verify_Product_In_Wishlist() throws  InterruptedException{
        //1. At "Home" Screen
        seleniumHelper.navigateTo(Constants.testSite);
        loginPage.login_shop(Constants.loginEmail, Constants.loginPassword);
        // 2. Click a "CLOTHING" category
        Wishlist.Click_A_Category(Wishlist_Data.Category[0]);
        // 3. Click tym icon in 2 product
        Wishlist.Tym_List_Product(Wishlist_Data.List_Product_Name);
        // 4. Navigate to "Wishlist" Screen
        Wishlist.Navigate_WishListPage();
        // 5. Search product is tymed in Step 3
        Boolean result= Wishlist.Find_Product_InWishList(Wishlist_Data.List_Product_Name);
        // 6. Compare result in Step 5
        // CHECKPOINT: Verify Product display in Wishlist same Product Name is clicked by user
        Assert.assertEquals(result.booleanValue(),true);
    }
    @Test
    public void Verify_Sort_LowToHigh() throws InterruptedException {
        // 1. At "Home" Screen
        seleniumHelper.navigateTo(Constants.testSite);
        loginPage.login_shop(Constants.loginEmail, Constants.loginPassword);
        // 2. Click a "CLOTHING" category
        Wishlist.Click_A_Category(Wishlist_Data.Category[0]);
        // 3. Click "Default setting" dropdown list
        // 4. Select option "Sort by price: low to high"
        Filter_Product.select_option();
        //5. Get price of all products is returned by step 4
        ArrayList<Float> ListPrice = Filter_Product.Get_List_Price();
        //6. Checking that list products is sorted low to high correctly
        Boolean result = Filter_Product.Check_Sort_LowToHigh(ListPrice);
        //7. Compare result in Step 5 with true
        Assert.assertEquals(result.booleanValue(),true);
    }
    @Test
    public void Verify_Search_Product() throws InterruptedException {
        // 1. At "Home" Screen
        seleniumHelper.navigateTo(Constants.testSite);
        loginPage.login_shop(Constants.loginEmail, Constants.loginPassword);
        //2. User input keyword "Jeans"
        Filter_Product.Input_Keyword();
        //3. Get Names of all products is returned by system
        ArrayList<WebElement> List_Product_Name = Filter_Product.List_Product_Name();
        //4. Find keyword "Jeans" in Product Name
        Boolean result = Filter_Product.Find_Keyword(List_Product_Name, Constants.keyword);
        //5. Compare result in Step 4 with true
        Assert.assertEquals(result.booleanValue(),true);
    }
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
        //inventoryPage.createProduct(productName);
        commonActions.waitForPageDisplayed("Update Quantity");
        // Update the product's quantity
        //inventoryPage.updateQuantity(Constants.productQuantity);

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
