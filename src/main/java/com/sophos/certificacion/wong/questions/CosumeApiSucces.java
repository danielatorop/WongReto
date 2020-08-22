package com.sophos.certificacion.wong.questions;

import com.sophos.certificacion.wong.tasks.services.ConsumeGetApi;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.Map;

public class CosumeApiSucces implements Question {

    private List<Map<String, String>> data;
    public  String name;

    public CosumeApiSucces(String name) {
        this.name = name;
    }

    public CosumeApiSucces(List<Map<String, String>> data) {
        this.data = data;
    }

    @Override
    public Object answeredBy(Actor actor) {
        if (data.get(0).get("name").equals(name)){
            System.out.println("dd");
        }return data.get(0).get("name").equals(name);
    }
    public static CosumeApiSucces succes( List<Map<String, String>> data){
        return new CosumeApiSucces(data);
    }
}
