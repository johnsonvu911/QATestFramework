package webapp.objects;

import org.openqa.selenium.By;

public interface LoginPageElements {

    By emailTextbox = By.xpath("//input[@id='login']");
    By passwordTextbox = By.xpath("//input[@id='password']");
}
