package com.sophos.certificacion.wong.tasks.services;

import com.sophos.certificacion.wong.utils.Constant;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public class ConsumeGetApi implements Task {


    private String hash;

    public ConsumeGetApi(String hash) {
        this.hash = hash;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        RestAssured.baseURI = Constant.URLGET;
        RequestSpecification httpRequest = RestAssured.given();
        Response response1 = httpRequest.get("/users/" + hash);
        ResponseBody api = response1.getBody();
        JSONObject myResponsebody = new JSONObject(api.asString());
        JSONObject myResponseget = (JSONObject) myResponsebody.get("data");
        String name = String.valueOf(myResponseget.get("name"));

    }

    public static Performable get(String hash) {
        return Tasks.instrumented(ConsumeGetApi.class, hash);
    }
}
