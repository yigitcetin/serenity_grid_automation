package pageObjects.login;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.Keys;
import pageObjects.home.HomePageElements;
import utils.testdata.LoadTestData;

public class LoginPageActions {

    public Performable emailField(String status) {
       if(status.equals("valid")) {
           return
                   Enter.theValue(LoadTestData.testData.getUserValidEmail()).into(LoginPageElements.EMAIL_FIELD);
       } else {
           return
                   Enter.theValue(LoadTestData.testData.getUserInvalidEmail()).into(LoginPageElements.EMAIL_FIELD);
       }
    }

    public Performable passwordField(String status) {
        if (status.equals("valid")) {
            return
                    Enter.theValue(LoadTestData.testData.getUserValidPassword()).into(LoginPageElements.PASSWORD_FIELD);
        } else {
            return
                    Enter.theValue(LoadTestData.testData.getUserInvalidPassword()).into(LoginPageElements.PASSWORD_FIELD);
        }
    }

    public Performable loginButton() {
        return
                Hit.the(Keys.ENTER).into(LoginPageElements.Login_Button);
    }
}



