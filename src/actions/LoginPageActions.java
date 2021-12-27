package actions;

import com.aventstack.extentreports.Status;
import data.Constants;
import objects.LoginPageElements;
import tests.TestBase;
import utils.SeleniumHelper;

public class LoginPageActions {

    SeleniumHelper seleniumHelper = new SeleniumHelper();

    public void login(String email, String password) {
        seleniumHelper.textBoxInput(LoginPageElements.emailTextbox, email);
        seleniumHelper.textBoxInput(LoginPageElements.passwordTextbox, password);
        seleniumHelper.clickButton(Constants.loginButton);
        TestBase.logger.log(Status.INFO, String.format("logged in with %s and %s", email, password));
    }

}
