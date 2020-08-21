package com.sophos.certificacion.wong.stepdefinitions;

import com.sophos.certificacion.wong.exceptions.AssertionError;
import com.sophos.certificacion.wong.questions.BuyProduct;
import com.sophos.certificacion.wong.tasks.OpenPage;
import com.sophos.certificacion.wong.tasks.SearchProduct;
import com.sophos.certificacion.wong.utils.Options;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static com.sophos.certificacion.wong.exceptions.AssertionError.EMPTY_CAR;
import static com.sophos.certificacion.wong.exceptions.AssertionError.NAME_SEARCHED_DOES_NOT_MATCH;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BuyProductStepdefinitions {

    @Managed(driver="Chrome")
    WebDriver hisDriver;

    @Before
    public void setUp(){
        setTheStage(new OnlineCast());
        theActorCalled("Daniela Toro");
        theActorInTheSpotlight().can(BrowseTheWeb.with(hisDriver));
    }
    @Given("^that the wong page is open$")
    public void thatTheWongPageIsOpen() {
        theActorInTheSpotlight().wasAbleTo(OpenPage.to(Options.PAGE));
    }

    @When("^the actor search and chooses the product$")
    public void theActorSearchAndChoosesTheProduct(List<Map<String, String>> data) {
        theActorInTheSpotlight().attemptsTo(SearchProduct.search(data));

    }
    @Then("^the actor must validate the product chosen for the purchase$")
    public void theActorMustValidateTheProductChosenForThePurchase(List<Map<String, String>> data) {
          theActorInTheSpotlight().should(seeThat(BuyProduct.succes(data)).orComplainWith(AssertionError.class , NAME_SEARCHED_DOES_NOT_MATCH));
    }
}
