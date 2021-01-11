package pageObjects.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import pageObjects.home.CheckURLs;
import pageObjects.navigation.NavigateTo;


public class HomeStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{actor}, an existing customer navigates to application home page")
    public void user_navigates_to_application_home_page(Actor actor) {
        actor.wasAbleTo(NavigateTo.theHomePage());
    }

    @SneakyThrows
    @Then("Check Butik page {string} links and their responses")
    public void check_links(String url) {
        CheckURLs.main(url);
    }

}
