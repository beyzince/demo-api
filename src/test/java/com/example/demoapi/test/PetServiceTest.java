package com.example.demoapi.test;

import com.example.demoapi.model.Pet;
import com.example.demoapi.steps.PetServiceSteps;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PetServiceTest {
    Pet createdPet = createPet();

    @Test
    public void addPetTest() {
        Response expectedPet = PetServiceSteps.addPet(createdPet);
        Assert.assertEquals(expectedPet.getStatusCode(), 200,
                "pet was not added");
    }

    @Test
    public void deletePetTest() {
        addPetTest();
        PetServiceSteps.deletePetById(String.valueOf(createdPet.getId()));
        Assert.assertEquals(getPetById().getStatusCode(), 404,
                "pet has not been deleted");
    }

    @Test
    public void updatePetTest() {
        addPetTest();
        Pet update = createPetUpdate();
        Assert.assertEquals(PetServiceSteps.updatePet(update).getStatusCode(), 200,
                "pet was not updated");
        Assert.assertEquals(getPetById().as(Pet.class).getName(), "testupdate",
                "name is not updated");
    }

    public Response getPetById() {
        return PetServiceSteps.getPetById(String.valueOf(createdPet.getId()));
    }

    private Pet createPetUpdate() {
        return new Pet().setId(1).
                setName("testupdate").
                setStatus("available");
    }


    private Pet createPet() {
        String[] ar = new String[]{"string"};
        return new Pet().setId(1).
                setName("pablo").
                setPhotoUrls(ar).
                setStatus("available");
    }

}
