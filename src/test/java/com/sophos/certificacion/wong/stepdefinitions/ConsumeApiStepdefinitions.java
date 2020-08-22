package com.sophos.certificacion.wong.stepdefinitions;

import com.sophos.certificacion.wong.exceptions.AssertionError;
import com.sophos.certificacion.wong.questions.CosumeApiSucces;
import com.sophos.certificacion.wong.tasks.services.ConsumePostApi;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.List;
import java.util.Map;


import static com.sophos.certificacion.wong.exceptions.AssertionError.NAME_SEARCHED_DOES_NOT_MATCH;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class ConsumeApiStepdefinitions {


    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^the API is running$")
    public void theAPIIsRunning(){
    theActorCalled("Daneila toro").whoCan(CallAnApi.at(""));
    }

    @When("^I check the aplication status$")
    public void iCheckTheAplicationStatus(List<Map<String, String>> data) {
        OnStage.theActorInTheSpotlight().wasAbleTo(ConsumePostApi.to(data));
    }
    @Then("^The API should return$")
    public void theAPIShouldReturn(List<Map<String, String>> data) {
        OnStage.theActorInTheSpotlight().should(seeThat(CosumeApiSucces.succes(data)).orComplainWith(AssertionError.class, NAME_SEARCHED_DOES_NOT_MATCH));
    }
}
