package com.sophos.certificacion.wong.interactions;

import com.sophos.certificacion.wong.exceptions.ElementNotFoundException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;

import static com.sophos.certificacion.wong.exceptions.ElementNotFoundException.CLICK_ELEMENT_ERROR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CloseUi implements Interaction {

    private Target targetName;

    public CloseUi(Target targetName) {
        this.targetName = targetName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(WaitUntilAppear.theTarget(targetName));
            actor.attemptsTo(Check.whether(targetName.resolveFor(actor).isVisible() || targetName.resolveFor(actor).isPresent()).
                    andIfSo(Click.on(targetName)));
        } catch (ElementNotInteractableException | ElementNotSelectableException e) {
            throw new ElementNotFoundException(CLICK_ELEMENT_ERROR + e);
        }
    }

    public static Performable theAlert(Target targetName) {
        return instrumented(CloseUi.class, targetName);
    }
}
