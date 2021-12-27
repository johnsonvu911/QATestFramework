package actions;

import objects.HomePageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utils.SeleniumHelper;


public class HomePageActions {
    SeleniumHelper seleniumHelper = new SeleniumHelper();;

    public void clickMenuItemButton(String itemName) {
        seleniumHelper.click(By.xpath(String.format(HomePageElements.menuItemButton, itemName)));
    }

}
