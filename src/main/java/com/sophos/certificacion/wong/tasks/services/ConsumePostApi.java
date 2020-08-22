package com.sophos.certificacion.wong.tasks.services;


import com.sophos.certificacion.wong.utils.Constant;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class ConsumePostApi implements Task {

    private List<Map<String, String>> data;
    private String hash;
    public String name;

    public ConsumePostApi(String hash, String  name) {
        this.hash = hash;
        this.name = name;
    }

    public ConsumePostApi(List<Map<String, String>> data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        OkHttpClient client = new OkHttpClient();
        String body = "{\"name\":\"" + data.get(0).get("name") +"\", "
                              +"\"email\":\""+ data.get(0).get("email") + "\" ,"
                              + "\"gender\":\"" + data.get(0).get("gender") +"\", "
                              + "\"status\":\""+ data.get(0).get("status")+"\" "+"}";
        String token = Constant.TOKEN;
        String url = Constant.URLPOST;

        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        System.out.println(body);
        try {
            RequestBody requestBody = RequestBody.create(mediaType, body);
            Request request = new Request.Builder().url(url).post(requestBody)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization","Bearer "+token)
                    .build();
            okhttp3.Response RespuestaApi = client.newCall(request).execute();


            if (RespuestaApi.isSuccessful()) {
                JSONObject myResponse = new JSONObject(RespuestaApi.body().string());
                System.out.println(myResponse);
                JSONObject myResponseA = (JSONObject) myResponse.get("data");
                String hash = String.valueOf(myResponseA.get("id"));
                actor.attemptsTo(ConsumeGetApi.get(hash,name));

            } else {
             }
        } catch (IOException ioexception) {
            System.out.println(ioexception);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static Performable to(List<Map<String, String>> data ){
        return Tasks.instrumented(ConsumePostApi.class, data);
    }
}
