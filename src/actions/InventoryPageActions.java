package actions;

import com.aventstack.extentreports.Status;
import data.Constants;
import objects.InventoryPageElements;
import tests.TestBase;
import utils.SeleniumHelper;

public class InventoryPageActions {

    SeleniumHelper seleniumHelper = new SeleniumHelper();
    /*public void createProduct(String productName) {
        seleniumHelper.clickButton(Constants.createButton);
        seleniumHelper.textBoxInput(InventoryPageElements.productNameInput, productName);
        seleniumHelper.click(InventoryPageElements.updateQuantityButton);
        TestBase.logger.log(Status.INFO, String.format("product name: %s", productName));
    }
    public void updateQuantity(String quantity) {
        seleniumHelper.clickButton(Constants.createButton);
        seleniumHelper.click(InventoryPageElements.locationDropdown);
        seleniumHelper.clickByText(InventoryPageElements.locationItemXpath, Constants.productLocation);
        seleniumHelper.textBoxInput(InventoryPageElements.inventoryQuantityInput, quantity);
        seleniumHelper.clickButton(Constants.saveButton);
        TestBase.logger.log(Status.INFO, String.format("updated product quantity to %s", quantity));
    }*/
}
