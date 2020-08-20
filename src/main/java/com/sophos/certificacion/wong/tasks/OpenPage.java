package com.sophos.certificacion.wong.tasks;

import com.sophos.certificacion.wong.utils.Options;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class OpenPage implements Task {
    private Options options;

    public OpenPage(Options options) {
        this.options = options;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(options.url()));
    }
    public static Performable to(Options options){
        return Tasks.instrumented(OpenPage.class, options);
    }
}
