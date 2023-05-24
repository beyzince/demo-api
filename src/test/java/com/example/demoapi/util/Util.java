package com.example.demoapi.util;

import com.example.demoapi.model.Category;
import com.example.demoapi.model.Pet;
import com.example.demoapi.model.Tag;

import java.util.ArrayList;

public class Util {

    public static final String APP_URL = "https://petstore.swagger.io/v2/pet/";
    public static final String FIND_PET_BY_ID_ENDPOINT = "findByStatus?status=sold";


    public static Pet testData(){

        // POST DATA SET
        // model imppp

        Category category = new Category(0, "string");

        ArrayList<String> photos = new ArrayList<>();
        photos.add("string");

        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(new Tag(0, "string"));


        Pet pet = new Pet(
                0,
                category,
                "doggie",
                photos,
                tags,
                "available"
        );

        return pet;
    }
    public static Pet testDataInvalid(){



        Category category = new Category(0, "string");

        ArrayList<String> photos = new ArrayList<>();
        photos.add("string");

        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(new Tag(0, "string"));


        Pet pet = new Pet(
                0,
                category,
                "doggie",
                photos,
                tags,
                "available"
        );

        return pet;
    }
}
