package actions.Filter;

import objects.FilterElements;
import objects.WishlistElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.TestBase;
import utils.SeleniumHelper;

import java.util.ArrayList;

import static tests.TestBase.driver;


public class WishlistActions {
    SeleniumHelper seleniumHelper = new SeleniumHelper();
    public void Click_Icon_Tym() throws InterruptedException {
        Thread.sleep(1000);
        seleniumHelper.click(WishlistElements.Product);
        Thread.sleep(400);
        seleniumHelper.click(WishlistElements.tym);
        Thread.sleep(400);
    }
    public String Get_Find_Favorite_Product() throws InterruptedException{
        Thread.sleep(400);
        return seleniumHelper.getText(WishlistElements.Product_Name);
    }
    public void  Go_To_Wishlist(){
        seleniumHelper.click(WishlistElements.Wishlist);
    }

    public void Get_ALL_Product() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(seleniumHelper.getText(WishlistElements.Product));
        Thread.sleep(400);
        seleniumHelper.Move_Element(WishlistElements.Product);
        Thread.sleep(500);
        seleniumHelper.click(WishlistElements.test);
        Thread.sleep(400);
    }
}
