package com.sophos.certificacion.api.tasks;


import com.sophos.certificacion.api.utils.Constant;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
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
        String token = "2ee9bb90c950317ede18e294b9486372ec61f3b27b9ad8a90f6f6bd3e4002d61";
        String url = "https://gorest.co.in/public-api/users";

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
                System.out.println("id " + hash);

                RestAssured.baseURI = "https://gorest.co.in/public-api";
                RequestSpecification httpRequest = RestAssured.given();
                Response response1 = httpRequest.get("/users/"+hash);

                ResponseBody api = response1.getBody();
                System.out.println("Response Body is: " + api.asString());
                JSONObject myResponsebody = new JSONObject(api.asString());
                System.out.println(myResponsebody);
                JSONObject myResponseget = (JSONObject) myResponsebody.get("data");
                String name = String.valueOf(myResponseget.get("name"));
                System.out.println("name " + name);

            } else {
                System.out.println("NO PASOOOOO");
            }

        } catch (IOException ioexception) {

            System.out.println(ioexception);


        } catch (Exception e) {

            System.out.println(e);
        }



    }
    public static Performable to(List<Map<String, String>> data){
        return Tasks.instrumented(ConsumePostApi.class, data);
    }
}
