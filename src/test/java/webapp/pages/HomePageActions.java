package webapp.pages;

import objects.HomePageElements;
import org.openqa.selenium.By;
import core.base.SeleniumHelper;


public class HomePageActions {
    SeleniumHelper seleniumHelper = new SeleniumHelper();;

    public void clickMenuItemButton(String itemName) {
        seleniumHelper.click(By.xpath(String.format(HomePageElements.menuItemButton, itemName)));
    }

}
