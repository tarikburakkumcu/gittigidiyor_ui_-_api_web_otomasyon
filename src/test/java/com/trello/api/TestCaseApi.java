package com.trello.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class TestCaseApi extends TestBaseApi {

    Response response;
    Data data= new Data();

    List<String> cardId=new ArrayList<>();
    public static String boardId ="62535f20d7a87610cb596373";
    public static String listId ="62535f76108377782b13e2b3";

    @Test
    @Order(1)
    public void create_a_board(){
        String Key = "7e63c980de5941dd8062972aef455d10";
        String Token = "0743a002cc700bebacb4a4fd58cb6a6e21a91c1134b66a9c9f55ae05a3bfb5fa";
        String Name = "Testinium0";
        setUp();
        spec.pathParams("parametre1", 1, "parametre2", "boards");
        HashMap<String, String> requestBody = new HashMap<>();
        requestBody.put("name", Name);
        requestBody.put("key", Key);
        requestBody.put("token", Token);
//        System.out.println(requestBody);
        response = given().
                spec(spec).
                contentType("application/json").
                body(requestBody).
                when().
                post("/{parametre1}/{parametre2}");
        System.out.println(response);
    }

    @Test
    @Order(2)
    public void create_a_list(){
        spec.pathParams("first",1,"second","lists");
        HashMap<String,String> postBodyMap=data.postListData();
        response=given()
                .contentType(ContentType.JSON).spec(spec).
                body(postBodyMap).when().post("/{first}/{second}");
    }

    @Test
    @Order(3)
    public void create_two_card(){
        spec.pathParams("first",1,"second","cards");
        HashMap<String,String> postBodyMap=data.postCardData();
        for (int i = 0; i <2 ; i++) {
            response = given()
                    .contentType(ContentType.JSON).spec(spec).body(postBodyMap).
                    when().post("/{first}/{second}");
        }
    }

    @Test
    @Order(4)
    public void update_a_card(){
        cardId.add("62535fb978d5b7641e60bc13");
        Random rd= new Random();
        int sayi=rd.nextInt(cardId.size());
        spec.pathParams("first",1,"second","cards","cardId",cardId.get(sayi));
        HashMap<String,String> updateBodyMap=data.updateData();
        response=given()
                .contentType(ContentType.JSON).spec(spec).body(updateBodyMap).when().
                put("/{first}/{second}/{cardId}");
    }

    @Test
    @Order(5)
    public void delete_cards(){
        for (int i = 0; i < cardId.size(); i++) {
            spec.pathParams("first", 1, "second", "cards", "cardId", cardId.get(i));
            HashMap<String, String> deleteMap = data.delete();
            response = given()
                    .contentType(ContentType.JSON).spec(spec).body(deleteMap).when().delete("/{first}/{second}/{cardId}");
        }
    }

    @Test
    @Order(6)
    public void delete_board(){
        spec.pathParams("first", 1, "second", "boards", "boardId", boardId);
        HashMap<String, String> deleteMap = data.delete();
        response=given()
                .contentType(ContentType.JSON).spec(spec).body(deleteMap).when().delete("/{first}/{second}/{boardId}");
    }


}
