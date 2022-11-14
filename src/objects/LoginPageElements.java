package objects;

import org.openqa.selenium.By;

public interface LoginPageElements {
    By loginLable = By.xpath("//*[contains(text(), 'Login')]");

    By emailTextbox = By.xpath("//input[@id='login']");
    By passwordTextbox = By.xpath("//input[@id='password']");

    By usernameTextBox = By.xpath("//*[@id='username']");

}
