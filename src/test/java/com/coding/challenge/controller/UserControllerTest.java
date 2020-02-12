package com.coding.challenge.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Value("http://localhost:${local.server.port}/users/{id}")
    private String baseUrl;

    @Test
    public void testExistingUserId() {
        final long existingUserId = 1L;

        given()
                .accept(MediaType.APPLICATION_JSON_VALUE)
        .when()
                .get(baseUrl, existingUserId)
        .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testNonExistingUserId() {
        final long nonExistingUserId = 574893758934L;

        given()
                .accept(MediaType.APPLICATION_JSON_VALUE)
        .when()
                .get(baseUrl, nonExistingUserId)
        .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void testInvalidUserId() {
        final String invalidUserId = "anyString";

        given()
                .accept(MediaType.APPLICATION_JSON_VALUE)
        .when()
                .get(baseUrl, invalidUserId)
        .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

}
