package webapp.pages;

import com.aventstack.extentreports.Status;
import data.Constants;
import objects.LoginPageElements;
import tests.TestBase;
import core.base.ElementActions;

public class LoginPageActions {

    ElementActions elementActions = new ElementActions();

    public void login(String email, String password) {
        elementActions.textBoxInput(LoginPageElements.emailTextbox, email);
        elementActions.textBoxInput(LoginPageElements.passwordTextbox, password);
        elementActions.clickButton(Constants.loginButton);
        TestBase.logger.log(Status.INFO, String.format("logged in with %s and %s", email, password));
    }

}
