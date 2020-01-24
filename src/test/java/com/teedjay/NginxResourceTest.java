package com.teedjay;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.NginxContainer;
import org.testcontainers.containers.wait.strategy.HttpWaitStrategy;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@Testcontainers
public class NginxResourceTest {

    @Container
    public NginxContainer nginx = new NginxContainer<>()
        .waitingFor(new HttpWaitStrategy());

    @Test
    public void testNginxEndpoint() {
        String host = nginx.getContainerIpAddress();
        int port = nginx.getFirstMappedPort();
        String uri = "http://" + host + ":" + port + "/";
        System.out.println("URI = " + uri);
        given()
          .baseUri(uri)
          .when().get("/")
          .then()
             .statusCode(200)
             .body(containsString("<p><em>Thank 2 you for using nginx.</em></p>"));
    }

}
