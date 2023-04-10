package objects;

import org.openqa.selenium.By;

public interface InventoryPageElements {

    By productNameInput = By.xpath("//*[@id='o_field_input_734']");
    By updateQuantityButton = By.xpath("//*[@name='action_update_quantity_on_hand']");
    By locationDropdown = By.xpath("//*[@name='location_id']");
    By packageInput = By.xpath("//*[@name='package_id']");
    String locationItemXpath = "//*[@class='ui-menu-item']/*[contains(text(), '%s')]";
    By inventoryQuantityInput = By.xpath("//*[@name='inventory_quantity']");
    String colorSelected = "/html/body/div[1]/div/div/div/div[4]/div[1]/ul/li[1]/span";
    String sizeSelected = "/html/body/div[1]/div/div/div/div[4]/div[2]/ul/li[2]/span";
    String quantitySelected = "/html/body/div[1]/div/div/div/div[5]/div/span[2]/i";
    String addToCart = "/html/body/div[1]/div/div/div/div[5]/a";
    String checkOut = "//*[@id=\"header\"]/div[1]/div[2]/div/div/div/div[3]/div/div[4]/div/div/div[3]/div[1]/p/a[2]";
}