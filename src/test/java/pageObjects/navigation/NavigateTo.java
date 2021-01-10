package pageObjects.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theHomePage() {
        return Task.where("{0} opens the Trendyol home page",
                Open.browserOn().the(HomePage.class));
    }

    public static Performable theLoginPage() {
        return Task.where("{0} opens the Trendyol login page",
                Open.browserOn().the(LoginPage.class));
    }

}
