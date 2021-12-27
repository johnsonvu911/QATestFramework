package objects;

import org.openqa.selenium.By;

public interface ManufacturingPageElements {

    By productNameInput = By.xpath("//*[@name='product_id']//input");
    By orderNameLabel = By.xpath("//*[@name='name']");
    By addALineButton = By.xpath("(//*[contains(text(), 'Add a line')])[1]");
    By productNameToConsumeInput = By.xpath("//*[starts-with(@data-id, 'stock.move')]//input");
    By productNumberToConsumeInput = By.xpath("//*[@name='product_uom_qty']");
    By productNameLabel = By.xpath("//*[@name='product_id']");
    String foundProductName = "(//*[starts-with(@id, 'ui-id')]//a[contains(text(), '%s')])[2]";
    By confirmButton = By.xpath("//*[@name='action_confirm']");
    By markDoneButton = By.xpath("//*[@name='button_mark_done']/*[contains(text(), 'Mark as Done')]");
    By applyButton = By.xpath("//button/*[contains(text(), 'Apply')]");

}
