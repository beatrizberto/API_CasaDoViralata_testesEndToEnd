package com.ada.ResApiCasaDoViralata.test.user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class UserDefinitions {


    private RequestSpecification request = RestAssured.given()
            .baseUri("http://localhost:8080")
            .contentType(ContentType.JSON);
    private Response response = null;
    private User user = new User();

    @Given("user is unknown")
    public void userIsUnknown() {
        user = new User();
        user.setName(RandomStringUtils.randomAlphabetic(20));
        user.setEmail(user.getName() + "@email.com");
        user.setPassword(RandomStringUtils.randomAlphabetic(6));
    }

    @When("user is registered with success")
    public void userIsRegistered() {
        response = request.body(user).when().post("/user");
    }

    @Then("user is known")
    public void userIsKnown() {
        response.then().statusCode(201);

    }
//////////////////////////

    @Given("user without email")
    public void userWithoutEmail() {
        user = new User();
        user.setName(RandomStringUtils.randomAlphabetic(20));
        user.setEmail(null);
        user.setPassword(RandomStringUtils.randomAlphabetic(6));
    }

    @When("user fail to register")
    public void userFailedToRegister() {
        response = request.body(user).when().post("/user");
        response.then().statusCode(400);
    }

    @Then("notify email must be not null")
    public void notifyEmailMustBeNotNull() {
        String failReason = response.jsonPath().get("errors[0].message");

        System.out.println("Full API Response: " + response.prettyPrint());

        Assertions.assertEquals("O campo email não pode estar vazio.", response.jsonPath().get("[0].message"));


    }


}


