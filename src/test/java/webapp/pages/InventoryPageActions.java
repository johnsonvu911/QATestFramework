package webapp.pages;

import com.aventstack.extentreports.Status;
import data.Constants;
import objects.InventoryPageElements;
import tests.TestBase;
import core.base.ElementActions;

public class InventoryPageActions {

    ElementActions elementActions = new ElementActions();
    public void createProduct(String productName) {
        elementActions.clickButton(Constants.createButton);
        elementActions.textBoxInput(InventoryPageElements.productNameInput, productName);
        elementActions.click(InventoryPageElements.updateQuantityButton);
        TestBase.logger.log(Status.INFO, String.format("product name: %s", productName));
    }
    public void updateQuantity(String quantity) {
        elementActions.clickButton(Constants.createButton);
        elementActions.click(InventoryPageElements.locationDropdown);
        elementActions.clickByText(InventoryPageElements.locationItemXpath, Constants.productLocation);
        elementActions.textBoxInput(InventoryPageElements.inventoryQuantityInput, quantity);
        elementActions.clickButton(Constants.saveButton);
        TestBase.logger.log(Status.INFO, String.format("updated product quantity to %s", quantity));
    }
}
