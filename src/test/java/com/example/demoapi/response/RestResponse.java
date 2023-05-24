package com.example.demoapi.response;

import com.jayway.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.given;

public class RestResponse {


    public String prettify(ResponseBody responseBody){
        return responseBody.prettyPrint();
    }



    public Response sendRequest(String url, Method method, Object body){

        Response response = given()
                .contentType("application/json")
                .accept(String.valueOf(ContentType.JSON))
                .body(body)
                .when()
                .log().all()
                .request(String.valueOf(method), url)
                .then()
                .extract().response();

        return response;
    }


    public Response sendRequest(String url, Method method){

        Response response = given()
                .contentType("application/json")
                .accept(String.valueOf(ContentType.JSON))
                .when()
                .log().all()
                .request(String.valueOf(method), url)
                .then()
                .extract().response();

        return response;
    }




    public enum Method{
        GET,
        PUT,
        POST,
        DELETE,
        HEAD,
        TRACE,
        OPTIONS,
        PATCH;

        private Method() {
        }
    }




}
