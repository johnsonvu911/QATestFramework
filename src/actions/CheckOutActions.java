package actions;

import objects.CheckOutElements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.SeleniumHelper;

import static tests.TestBase.driver;

public class CheckOutActions {

    SeleniumHelper seleniumHelper = new SeleniumHelper();

    public static void textInput(String label, String textBox, String inputValue) {
        WebElement element_enter = driver.findElement(By.xpath(label));
        element_enter.findElement(By.xpath(textBox)).sendKeys(inputValue);
    }

    public static void selectComboBox(String dropDown, String inputText, String inputValue) {
        WebElement comboBox = driver.findElement(By.xpath(dropDown));
        comboBox.click();
        WebElement textInput = driver.findElement(By.xpath(inputText));
        textInput.sendKeys(inputValue);
        textInput.sendKeys(Keys.RETURN);
    }

    public static void fillOutBilling() {
        textInput(CheckOutElements.firstNameLabel, CheckOutElements.firstName, "Ashley");
        textInput(CheckOutElements.lastNameLabel, CheckOutElements.lastName, "Nguyen");
        selectComboBox(CheckOutElements.countryDropdown, CheckOutElements.countryInput, "United States (US)");
        textInput(CheckOutElements.streetAddressLabel, CheckOutElements.streetAddress, "123 main street");
        textInput(CheckOutElements.townLabel, CheckOutElements.town, "Atlanta");
        selectComboBox(CheckOutElements.stateDropdown, CheckOutElements.stateInput, "Georgia");
        textInput(CheckOutElements.zipCodeLabel, CheckOutElements.zipCode, "30009");
        textInput(CheckOutElements.phoneLabel, CheckOutElements.phone, "4709878909");
        textInput(CheckOutElements.emailAddressLabel, CheckOutElements.emailAddress, "abc@gmail.com");
    }

    }

