package com.salsatechnology.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ProductOrderIntegrationTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/orders";
    }

    @Test
    public void testListOrdersEndpoint() {
        given()
                .when()
                .get("/list")
                .then()
                .statusCode(200)
                .body("$", hasSize(greaterThan(0)));
    }

    @Test
    public void testCreateOrderEndpoint() {
        // Dados para criar um novo pedido
        String requestBody = "{ \"userName\": \"carlos\", \"productType\": \"SURFBOARD\", \"timeHour\": 2 }";

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/create")
                .then()
                .statusCode(201);
    }
}
