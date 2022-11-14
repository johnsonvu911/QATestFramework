package actions;

import com.aventstack.extentreports.Status;
import data.Constants;
import objects.ManufacturingPageElements;
import tests.TestBase;
import utils.SeleniumHelper;

public class ManufacturingPageActions {

    SeleniumHelper seleniumHelper = new SeleniumHelper();
    public void createOrder(String productName, String productToConsume) {
//        seleniumHelper.clickButton(Constants.createButton);
//        seleniumHelper.textBoxInput(ManufacturingPageElements.productNameInput, productName);
//        seleniumHelper.clickByText(productName);
//
//        seleniumHelper.click(ManufacturingPageElements.addALineButton);
//        seleniumHelper.textBoxInput(ManufacturingPageElements.productNameToConsumeInput, productName);
//        seleniumHelper.clickByText(ManufacturingPageElements.foundProductName, productName);
//
//        seleniumHelper.textBoxInput(ManufacturingPageElements.productNumberToConsumeInput, productToConsume);
//
//        seleniumHelper.clickButton(Constants.saveButton);
//        TestBase.logger.log(Status.INFO, String.format("Created order with product name: %s", productName));
    }

    public void updateNewOrderToDone(String orderNumberToCompare) {
        String orderNumber = getOrderName();
        if (orderNumber.equalsIgnoreCase(orderNumberToCompare)) {
            seleniumHelper.click(ManufacturingPageElements.confirmButton);
            seleniumHelper.click(ManufacturingPageElements.markDoneButton);
            seleniumHelper.click(ManufacturingPageElements.applyButton);
        } else {
            TestBase.logger.log(Status.INFO, String.format("Incorrect order! the order under update is %s", orderNumber));
        }

    }
    public String getOrderName() {
        seleniumHelper.waitForElementDisplayed(ManufacturingPageElements.orderNameLabel, Constants.defaultTimeout);
        String orderName = seleniumHelper.getText(ManufacturingPageElements.orderNameLabel);
        while (orderName.equalsIgnoreCase("new")) {
            orderName = seleniumHelper.getText(ManufacturingPageElements.orderNameLabel);
        }
        return orderName;
    }
    public String getProductName() {
        seleniumHelper.waitForElementDisplayed(ManufacturingPageElements.productNameLabel, Constants.defaultTimeout);
        return seleniumHelper.getText(ManufacturingPageElements.productNameLabel);
    }
    public boolean validateOrder(String orderNumberBefore, String productNameBefore) {
        return orderNumberBefore.equalsIgnoreCase(getOrderName()) && productNameBefore.equalsIgnoreCase(getProductName());
    }

}
