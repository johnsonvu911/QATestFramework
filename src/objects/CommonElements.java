package objects;

import org.openqa.selenium.By;

public interface CommonElements {

    By inventoryMenuBar = By.xpath("//*[@class='o_menu_sections']");
    By productsMenuItem = By.xpath("//*[@data-menu-xmlid='stock.menu_stock_inventory_control']");
    By productsMenuSubItem = By.xpath("//*[@data-menu-xmlid='stock.menu_product_variant_config_stock']");
    String navigationActiveItem = "//*[contains(@class, 'breadcrumb-item active') and normalize-space(text()) = '%s']";
    By menuToggle = By.xpath("//*[contains(@class, 'o_menu_toggle')]");
    String colorOption = "/html/body/div[1]/div/div/div/div[4]/span[1]";
}
