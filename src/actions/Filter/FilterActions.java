package actions.Filter;
import objects.FilterElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.SeleniumHelper;
import java.util.ArrayList;
import static tests.TestBase.driver;


public class FilterActions {
    SeleniumHelper seleniumHelper = new SeleniumHelper();
    public void Filter_Start_End(Integer Start, Integer End) throws InterruptedException {
        Thread.sleep(1000);
        seleniumHelper.Drag_Filter(FilterElements.Start, FilterElements.End, Start,End);
        Thread.sleep(600);
        seleniumHelper.click(FilterElements.Filter);
    }

    public Float Get_StartPrice() throws InterruptedException {
        Float start_price = Float.valueOf(seleniumHelper.getText(FilterElements.Price_Start)
                .substring(1).replaceAll("[.]", "").replaceAll(",","."));
        return start_price;
    }
    public Float Get_EndPrice() throws InterruptedException {
        Float end_price = Float.valueOf(seleniumHelper.getText(FilterElements.Price_End)
                .substring(1).replaceAll("[.]", "").replaceAll(",","."));
        return end_price;
    }
    public ArrayList<WebElement> ListElement() throws InterruptedException {
        seleniumHelper.click(FilterElements.Filter);
        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(FilterElements.Div_Price);
        return  list;
    }
    public Boolean Check_PriceInRange_StartEnd(ArrayList<WebElement> list,Float start_price, Float end_price) throws InterruptedException {
        Boolean result = true;
        for(WebElement element : list) {
            System.out.println(element.getText());
            String temp = element.getText().replaceAll("[.]", "").replaceAll(",", ".");
            if (temp.indexOf(" – ") != -1) {
                Float min_Price = Float.valueOf(temp.substring(1, temp.indexOf(" – ")));
                Float max_Price = Float.valueOf(temp.substring(temp.indexOf(" – ") + 4));
                if ((min_Price > start_price && min_Price < end_price) || (max_Price > start_price && max_Price < end_price)) {
                    result = true;
                } else {
                    result = false;
                }
            } else {
                if (Float.valueOf(temp.substring(1)) < end_price && Float.valueOf(temp.substring(1)) > start_price) {
                    result = true;
                } else {
                    result = false;
                }
            }
        }
        return  result;
    }

}
