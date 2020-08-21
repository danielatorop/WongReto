package com.sophos.certificacion.wong.tasks;

import com.sophos.certificacion.wong.interactions.CloseUi;
import com.sophos.certificacion.wong.interactions.WaitUntilAppear;
import com.sophos.certificacion.wong.interfaces.HomePageProduct;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.sophos.certificacion.wong.exceptions.AssertionError.EMPTY_CAR;

public class AgregateProduct implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(HomePageProduct.ADD_TO_CART));
        actor.attemptsTo(WaitUntilAppear.theTarget(HomePageProduct.CLOSE_ALERT));
        actor.attemptsTo(CloseUi.theAlert(HomePageProduct.CLOSE_ALERT));
        if (HomePageProduct.VALIDATE_CART.resolveFor(actor).isVisible()) {
            actor.attemptsTo(WaitUntilAppear.theTarget(HomePageProduct.SEE_MY_CART));
            actor.attemptsTo(Click.on(HomePageProduct.SEE_MY_CART));
        } else {
            throw new AssertionError(EMPTY_CAR);
        }
    }
    public static Performable pay(){
        return Tasks.instrumented(AgregateProduct.class);
        }
    }

