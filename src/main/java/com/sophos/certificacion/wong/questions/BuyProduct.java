package com.sophos.certificacion.wong.questions;

import com.sophos.certificacion.wong.interfaces.HomePage;
import com.sophos.certificacion.wong.interfaces.HomePageProduct;
import com.sophos.certificacion.wong.utils.DataRememberEnum;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.Map;

public class BuyProduct implements Question {
    private List<Map<String, String>> data;

    public BuyProduct(List<Map<String, String>> data) {
        this.data = data;
    }

    @Override
    public Object answeredBy(Actor actor) {
        String nameproduct = HomePageProduct.GET_NAME_PRODUCT.resolveFor(actor).getText();
        actor.remember(DataRememberEnum.NAME_PRODUCT.getValue(), nameproduct);
        return nameproduct.equals(data.get(0).get("name product result"));
    }
    public static BuyProduct succes( List<Map<String, String>> data){
        return new BuyProduct(data);
    }
}