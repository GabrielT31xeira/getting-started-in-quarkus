package br.com.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class UserResourceTest {

    @Test
    public void testGetAllUsersEndpoint() {
        given()
                .when().get("/api/user")
                .then()
                .statusCode(200)
                .body(is("Hello from RESTEasy Reactive"));
    }
    @Test
    public void testGetOneUsersEndpoint() {
        given()
                .when().get("/api/user/1")
                .then()
                .statusCode(200)
                .body(is("Hello from RESTEasy Reactive"));
    }
    @Test
    public void testPostUsersEndpoint() {
        given()
                .when().post("/api/user")
                .then()
                .statusCode(200)
                .body(is("Hello from RESTEasy Reactive"));
    }
    @Test
    public void testDeleteUsersEndpoint() {
        given()
                .when().delete("/api/user/1")
                .then()
                .statusCode(200)
                .body(is("Hello from RESTEasy Reactive"));
    }

}