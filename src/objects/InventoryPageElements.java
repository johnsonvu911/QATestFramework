package objects;

import org.openqa.selenium.By;

public interface InventoryPageElements {

    By productNameInput = By.xpath("//*[@id='o_field_input_734']");
    By updateQuantityButton = By.xpath("//*[@name='action_update_quantity_on_hand']");
    By locationDropdown = By.xpath("//*[@name='location_id']");
    By packageInput = By.xpath("//*[@name='package_id']");
    String locationItemXpath = "//*[@class='ui-menu-item']/*[contains(text(), '%s')]";
    By inventoryQuantityInput = By.xpath("//*[@name='inventory_quantity']");


}