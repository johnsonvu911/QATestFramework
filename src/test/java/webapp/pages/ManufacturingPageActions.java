package webapp.pages;

import com.aventstack.extentreports.Status;
import data.Constants;
import objects.ManufacturingPageElements;
import tests.TestBase;
import core.base.ElementActions;

public class ManufacturingPageActions {

    ElementActions elementActions = new ElementActions();
    public void createOrder(String productName, String productToConsume) {
        elementActions.clickButton(Constants.createButton);
        elementActions.textBoxInput(ManufacturingPageElements.productNameInput, productName);
        elementActions.clickByText(productName);

        elementActions.click(ManufacturingPageElements.addALineButton);
        elementActions.textBoxInput(ManufacturingPageElements.productNameToConsumeInput, productName);
        elementActions.clickByText(ManufacturingPageElements.foundProductName, productName);

        elementActions.textBoxInput(ManufacturingPageElements.productNumberToConsumeInput, productToConsume);

        elementActions.clickButton(Constants.saveButton);
        TestBase.logger.log(Status.INFO, String.format("Created order with product name: %s", productName));
    }

    public void updateNewOrderToDone(String orderNumberToCompare) {
        String orderNumber = getOrderName();
        if (orderNumber.equalsIgnoreCase(orderNumberToCompare)) {
            elementActions.click(ManufacturingPageElements.confirmButton);
            elementActions.click(ManufacturingPageElements.markDoneButton);
            elementActions.click(ManufacturingPageElements.applyButton);
        } else {
            TestBase.logger.log(Status.INFO, String.format("Incorrect order! the order under update is %s", orderNumber));
        }

    }
    public String getOrderName() {
        elementActions.waitForElementDisplayed(ManufacturingPageElements.orderNameLabel, Constants.defaultTimeout);
        String orderName = elementActions.getText(ManufacturingPageElements.orderNameLabel);
        while (orderName.equalsIgnoreCase("new")) {
            orderName = elementActions.getText(ManufacturingPageElements.orderNameLabel);
        }
        return orderName;
    }
    public String getProductName() {
        elementActions.waitForElementDisplayed(ManufacturingPageElements.productNameLabel, Constants.defaultTimeout);
        return elementActions.getText(ManufacturingPageElements.productNameLabel);
    }
    public boolean validateOrder(String orderNumberBefore, String productNameBefore) {
        return orderNumberBefore.equalsIgnoreCase(getOrderName()) && productNameBefore.equalsIgnoreCase(getProductName());
    }

}
