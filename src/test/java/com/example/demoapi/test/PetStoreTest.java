package com.example.demoapi.test;

import com.example.demoapi.model.Pet;
import com.example.demoapi.response.RestResponse;

import com.example.demoapi.util.Util;

import com.jayway.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.hamcrest.core.IsEqual;

import java.util.List;


public class PetStoreTest {
    private static Logger LOGGER = LoggerFactory.getLogger(PetStoreTest.class);


    RestResponse restResponse = new RestResponse();
    Response response;

    @Test
    public void petTest_GET(){

        response = restResponse.sendRequest(
                Util.APP_URL.concat(Util.FIND_PET_BY_ID_ENDPOINT),
                RestResponse.Method.GET
        );

        restResponse.prettify(
                response.body()
        );


        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "pet was not get"
        );



    }



    @Test
    public void petTest_POST(){

        LOGGER.info("Create PET");

        response = restResponse.sendRequest(
                Util.APP_URL,
                RestResponse.Method.POST,
                Util.testData()
        );

        restResponse.prettify(
                response.body()
        );

        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "pet was not added"
        );



    }


    @Test
    public void petTest_UPDATE(){

        LOGGER.info("PUT PET");

        response = restResponse.sendRequest(
                Util.APP_URL,
                RestResponse.Method.PUT,
                Util.testData()
        );

        restResponse.prettify(
                response.body()
        );

        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "pet was not updated"
        );

    }

    @Test
    public void petTest_DELETE(){

        LOGGER.info("PUT PET");
        String petId = "3";

        response = restResponse.sendRequest(
                Util.APP_URL.concat(petId),
                RestResponse.Method.DELETE
        );

        restResponse.prettify(
                response.body()
        );

        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "pet was not deleted"
        );




    }







}
