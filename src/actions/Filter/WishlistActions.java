package actions.Filter;

import com.aventstack.extentreports.Status;
import objects.CommonElements;
import objects.FilterElements;
import objects.WishlistElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.TestBase;
import utils.SeleniumHelper;

import java.util.ArrayList;
import java.util.List;

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
    public void Click_A_Category(String Cate_Name) throws InterruptedException {
        seleniumHelper.click(By.xpath("//*[text() = '" + Cate_Name + "']"));
    }
    public void Tym_List_Product(String[] Category) throws InterruptedException {
        Thread.sleep(1000);
        for (Integer cate = 0; cate <= Category.length-1; cate++) {
            seleniumHelper.Move_Element(By.xpath("//*[contains(@class, 'product ') and .//*[contains(text(), '"+Category[cate]+"')]]"));
            Thread.sleep(500);
            seleniumHelper.click(By.xpath("//*[contains(@class, 'box-image') and .//*[contains(@aria-label,'"+Category[cate]+"')]]//button[contains(@class,'wishlist-button')]"));
        }
        Thread.sleep(600);
    }
    public Boolean Find_Product_InWishList(String[] Category)throws InterruptedException {

        Boolean temp = true;
        for (Integer cate = 0; cate <= Category.length-1; cate++) {
            if (driver.findElement(By.xpath("//td//a[contains(text(),'"+Category[cate]+"')]")).isDisplayed())
            {
                temp= true;
            }
            else
            {
                temp= false;
            }
        }
        return temp;
    }
    public void Navigate_WishListPage() throws InterruptedException {
       /* if (driver.findElement(WishlistElements.Wishlist).isDisplayed()) {
            seleniumHelper.click(WishlistElements.Wishlist);
        } else {
            TestBase.logger.log(Status.FAIL, "Wishlist not display");
        }*/
        seleniumHelper.click(WishlistElements.Wishlist);
        Thread.sleep(600);
    }

    public ArrayList<WebElement> ListElement() throws InterruptedException {
        seleniumHelper.click(FilterElements.Filter);
        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(FilterElements.Div_Price);
        return  list;
    }
    public void Check_PriceInRange_StartEnd() throws InterruptedException {

        /*seleniumHelper.click(WishlistElements.Wishlist);
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='shop_table cart wishlist_table wishlist_view traditional responsive   ']/tbody/tr"));
        int count = rows.size();
        System.out.println("ROW COUNT : "+count);*/
        Thread.sleep(400);
        driver.navigate().back();
        Thread.sleep(400);

    }

}
