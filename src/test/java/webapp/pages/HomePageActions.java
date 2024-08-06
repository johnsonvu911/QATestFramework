package webapp.pages;

import objects.HomePageElements;
import org.openqa.selenium.By;
import core.base.ElementActions;


public class HomePageActions {
    ElementActions elementActions = new ElementActions();;

    public void clickMenuItemButton(String itemName) {
        elementActions.click(By.xpath(String.format(HomePageElements.menuItemButton, itemName)));
    }

}
