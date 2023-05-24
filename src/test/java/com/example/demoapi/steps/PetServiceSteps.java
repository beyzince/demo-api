package com.example.demoapi.steps;

import com.example.demoapi.model.Pet;
import com.example.demoapi.service.PetService;
import io.restassured.response.Response;

import static com.example.demoapi.uri.PetServiceUri.PET;
import static com.example.demoapi.uri.PetServiceUri.PET_BY_ID;


public class PetServiceSteps {
    private static final PetService PET_SERVICE = PetService.getInstance();


    public static Response getPetById(String petId) {
        return PET_SERVICE.getRequest(PET_BY_ID, petId);
    }

    public static Response addPet(Pet pet) {
        return PET_SERVICE.postRequest(PET, pet);
    }
    public static Response updatePet(Pet pet) {
        return PET_SERVICE.postRequest(PET_BY_ID, pet);
    }

    public static void deletePetById(String id) {
        PET_SERVICE.deleteRequest(PET_BY_ID, id);
    }

}
