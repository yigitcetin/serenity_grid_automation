package pageObjects.home;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.MoveMouse;

public class HomePageActions {
    public Performable moveToProfile() {
        return
                MoveMouse.to(HomePageElements.PROFILE_BUTTON);
    }
}
