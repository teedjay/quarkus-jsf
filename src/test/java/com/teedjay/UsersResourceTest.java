package com.teedjay;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class UsersResourceTest {

    String json = """
        {
            "username" : "teedjay",
            "email" : "root@teedjay.com"
        }
        """;

    @Test
    public void insertNewUser() {
        given()
            .body(json)
          .when()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .post("/users")
          .then()
            .statusCode(200)
            .body("email", is("root@teedjay.com"))
        ;
    }

    @Test
    public void lookupKnownUser() {
        given()
          .when()
            .accept(ContentType.JSON)
            .get("/users/2")
          .then()
            .statusCode(200)
            .body("username", is("ola"))
        ;
    }

}
