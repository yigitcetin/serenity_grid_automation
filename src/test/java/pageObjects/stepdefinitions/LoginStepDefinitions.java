package pageObjects.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.Wait;
import net.thucydides.core.annotations.Steps;
import pageObjects.home.HomePageActions;
import pageObjects.home.HomePageElements;
import pageObjects.login.LoginPageElements;
import pageObjects.navigation.NavigateTo;
import pageObjects.login.LoginPageActions;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

public class LoginStepDefinitions {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Steps
    LoginPageActions LogIn;

    @Steps
    HomePageActions Profile;


    @When("{actor} click login button")
    public void user_goes_to_login_page(Actor actor) {
        actor.attemptsTo(NavigateTo.theLoginPage());
    }

    @Then("{actor} writes his {string} email address")
    public void user_enters_email(Actor actor, String status) {
        actor.attemptsTo(LogIn.emailField(status));
    }

    @Then("{actor} writes his {string} password")
    public void user_enters_password(Actor actor, String status) {
        actor.attemptsTo(LogIn.passwordField(status));
    }

    @Then("{actor} click submit button")
    public void user_click_submit(Actor actor) {
        actor.attemptsTo(LogIn.loginButton());
    }

    @Then("{actor} should redirect to home page")
    public void loggedIn_home_page(Actor actor) {
        actor.attemptsTo(Wait.until(
                WebElementQuestion.the(HomePageElements.Sub_Menu), WebElementStateMatchers.isEnabled()
        ).forNoLongerThan(20).seconds());
    }

    @And("{actor} should see his {string} under account button")
    public void see_username(Actor actor, String username) {
        actor.attemptsTo(Profile.moveToProfile());
        actor.attemptsTo(
                Ensure.that(HomePageElements.USER_NAME).hasText(username)
        );
    }

    @And("{actor} should see invalid credentials error message")
    public void wrong_password(Actor actor) {
        actor.attemptsTo(
                Ensure.that(LoginPageElements.ERROR_MESSAGE)
                        .hasText("E-posta adresiniz ve/veya şifreniz hatalı.")
        );
    }

    @And("{actor} should see wrong email format error message")
    public void wrong_email_format(Actor actor) {
        actor.attemptsTo(
                Ensure.that(LoginPageElements.ERROR_MESSAGE)
                        .hasText("Lütfen geçerli bir e-posta adresi giriniz.")
        );
    }

}
