package pageObjects.home;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class HomePageElements extends PageObject {

    public static Target Sub_Menu = Target.the("submenu").locatedBy("#browsing-gw-homepage > div > div.circled-slider > div > div");

    public static Target PROFILE_BUTTON = Target.the("Hesabım")
            .locatedBy("//*[@id=\"account-navigation-container\"]/div/div[1]/div[1]/p");

    public static Target USER_NAME = Target.the("User name").locatedBy(".user-name");
}
