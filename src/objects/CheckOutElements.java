package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface CheckOutElements {
    String firstNameLabel = "//*[@id=\"billing_first_name_field\"]/label";
    String firstName = "//*[@id=\"billing_first_name\"]";
    String lastNameLabel = "//*[@id=\"billing_last_name_field\"]/label";
    String lastName = "//*[@id=\"billing_last_name\"]";
    String countryDropdown = "//*[@id=\"select2-billing_country-container\"]";
    String countryInput = "/html/body/span[2]/span/span[1]/input";
    String streetAddressLabel = "//*[@id=\"billing_address_1_field\"]/label";
    String streetAddress = "//*[@id=\"billing_address_1\"]";
    String townLabel = "//*[@id=\"billing_city_field\"]/label";
    String town = "//*[@id=\"billing_city\"]";
    String stateDropdown = "//*[@id=\"select2-billing_state-container\"]";
    String stateInput = "/html/body/span[2]/span/span[1]/input";
    String zipCodeLabel = "//*[@id=\"billing_postcode_field\"]/label";
    String zipCode = "//*[@id=\"billing_postcode\"]";
    String phoneLabel = "//*[@id=\"billing_phone_field\"]/label";
    String phone = "//*[@id=\"billing_phone\"]";
    String emailAddressLabel = "//*[@id=\"billing_email_field\"]/label";
    String emailAddress = "//*[@id=\"billing_email\"]";
    String subTotal = "//*[@id=\"order_review\"]/table/tfoot/tr[1]/td/span/bdi";
    String quantity = "//*[@id=\"order_review\"]/table/tbody/tr/td[1]/strong";
    String colorCheckout = "//*[@id=\"order_review\"]/table/tbody/tr[1]/td[1]/dl/dd[1]/p";
    String sizeCheckout = "//*[@id=\"order_review\"]/table/tbody/tr[1]/td[1]/dl/dd[2]/p";
}
