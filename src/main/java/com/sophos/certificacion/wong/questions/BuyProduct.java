package com.sophos.certificacion.wong.questions;

import com.sophos.certificacion.wong.interfaces.HomePage;
import com.sophos.certificacion.wong.utils.DataRememberEnum;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class BuyProduct implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        String nameproductnuevp = HomePage.NAME_PRODUCT.resolveFor(actor).getText();
        actor.remember(DataRememberEnum.NAME_PRODUCTNUEVO.getValue(), nameproductnuevp);
        return nameproductnuevp.equals(nameproductnuevp);
    }
    public static BuyProduct succes(){
        return new BuyProduct();
    }
}