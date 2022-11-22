package actions.Filter;
import objects.FilterElements;
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

    public void select_option()throws InterruptedException{
        seleniumHelper.selectOption(FilterElements.Select_Sort,"Sort by price: low to high");
    }
    public ArrayList<Float> Get_List_Price()throws InterruptedException{
        ArrayList<Float> list_Price = new ArrayList<Float>();
        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(FilterElements.Div_Price);
        for(WebElement element : list) {
            String temp = element.getText().replaceAll("[.]", "").replaceAll(",", ".");
            Float max_Price = 0.0F;
            if (temp.indexOf(" – ") != -1) {
                max_Price = Float.valueOf(temp.substring(temp.indexOf(" – ") + 4));
                list_Price.add(max_Price);
            }
            else if (temp.indexOf(" ") != -1){
                max_Price = Float.valueOf(temp.substring(temp.indexOf(" ") + 2));
                list_Price.add(max_Price);
            }
            else {
                max_Price = Float.valueOf(temp.substring(1));
                list_Price.add(max_Price);
            }
        }
        return list_Price;
    }

    public Boolean Check_Sort_LowToHigh(ArrayList<Float> list_Price)throws InterruptedException{
        Boolean result = true;
        for (Integer i =0; i< list_Price.size()-1; i++){
            Float temp = 0.0F;
            for (Integer j = i + 1; j< list_Price.size(); j++){
                if(list_Price.get(i) < list_Price.get(j)){
                    result = true;
                }
            }

        }
        System.out.println(result);
        return result;
    }

    public void Input_Keyword() throws InterruptedException {
        seleniumHelper.click(FilterElements.Search_Icon);
        Thread.sleep(600);
        seleniumHelper.textBoxInput(FilterElements.Input_Search,"Jeans");
        Thread.sleep(100);
        seleniumHelper.pressKey(FilterElements.Input_Search,"Enter");
        Thread.sleep(1000);
    }
    public ArrayList<WebElement> List_Product_Name() throws InterruptedException {
        seleniumHelper.click(FilterElements.Filter);
        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(FilterElements.Div_Name);
        //str1.contains("example"
        //System.out.println(list);
        return list ;
    }
    public Boolean Find_Keyword(ArrayList<WebElement> List_Product_Name, String keyword)throws InterruptedException{
        Boolean result = true;
        for(WebElement element : List_Product_Name) {
            if(element.getText().contains(keyword)){
                result =true;
            }
            else {
                result = false;
            }
        }
        return  result;
    }
}
