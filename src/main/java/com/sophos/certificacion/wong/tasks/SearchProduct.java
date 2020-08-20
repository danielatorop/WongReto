package com.sophos.certificacion.wong.tasks;

import com.sophos.certificacion.wong.interactions.CloseUi;
import com.sophos.certificacion.wong.interactions.WaitUntilAppear;
import com.sophos.certificacion.wong.interfaces.HomePage;
import com.sophos.certificacion.wong.interfaces.HomePageProduct;
import com.sophos.certificacion.wong.utils.DataRememberEnum;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;
import java.util.Map;

public class SearchProduct implements Task {
    private List<Map<String, String>> data;

    public SearchProduct(List<Map<String, String>> data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntilAppear.theTarget(HomePage.ClOSE_ALERT_TOP));
        actor.attemptsTo(CloseUi.theAlert(HomePage.ClOSE_ALERT_TOP));
        actor.attemptsTo(Enter.theValue(data.get(0).get("type product")).into(HomePage.SEARCH_PRODUCT));
        WaitUntilAppear.theTarget(HomePage.RESULTS_PRODUCT);
        actor.attemptsTo(Click.on(HomePage.RESULTS_PRODUCT));
        actor.attemptsTo(Click.on(HomePage.NAME_PRODUCT.of(data.get(0).get("name product"))));
        actor.attemptsTo(AgregateProduct.pay());
    }
    public static Performable search(List<Map<String, String>> data){
        return Tasks.instrumented(SearchProduct.class, data);
    }
}
