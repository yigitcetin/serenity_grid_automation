package pageObjects.login;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPageElements {
    static Target EMAIL_FIELD = Target.the("login email")
            .locatedBy("#login-email");

    static Target PASSWORD_FIELD = Target.the("login-password")
            .locatedBy("#login-password-input");

    static Target Login_Button = Target.the("Giriş Yap")
            .locatedBy("//button[@type='submit']");

    public static Target ERROR_MESSAGE = Target.the("error message")
            .locatedBy("#error-box-wrapper > span.message");
}
