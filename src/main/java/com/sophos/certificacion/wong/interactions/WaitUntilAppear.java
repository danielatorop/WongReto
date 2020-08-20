package com.sophos.certificacion.wong.interactions;


import com.sophos.certificacion.wong.exceptions.ElementNotFoundException;
import com.sophos.certificacion.wong.utils.BasicUtils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;

import java.util.concurrent.TimeoutException;


import static com.sophos.certificacion.wong.exceptions.ElementNotFoundException.WAIT_ELEMENT_ERROR;
import static com.sophos.certificacion.wong.utils.BasicUtils.setTime;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WaitUntilAppear implements Interaction {

    private Target targetName;

    public WaitUntilAppear(Target targetName) {
        this.targetName = targetName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        long start = setTime();
        long end;
        double time = 0;
        try {
            while (true) {
                if (targetName.resolveFor(actor).isVisible()) {
                    break;
                } else if (time > 30) {
                    if (!targetName.getName().equals("Alerts")) {
                        throw new TimeoutException();
                    } else {
                        break;
                    }
                }
                end = setTime();
                time = BasicUtils.getTimeInSeconds(start, end);
            }
        } catch (TimeoutException e) {
            throw new ElementNotFoundException(WAIT_ELEMENT_ERROR + targetName.getCssOrXPathSelector() + e);
        }
    }

    public static Performable theTarget(Target targetName) {
        return instrumented(WaitUntilAppear.class, targetName);
    }
}
