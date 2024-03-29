package br.com.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import br.com.quarkus.rest.resource.dto.UserResponseDTO;

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
                .extract()
                .response()
                .body()
                .as(UserResponseDTO[].class);
    }

    @Test
    public void testGetOneUsersEndpoint() {
        given()
                .when().get("/api/user/3")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .body()
                .as(UserResponseDTO.class);
    }

    @Test
    public void testPostUsersEndpoint() {
        given()
                .body("{\"email\": \"Bruce\", \"name\": \"Banner\", \"password\": \"123\"}")
                .header("Content-Type", "application/json")
                .when()
                .post("/api/user/")
                .then()
                .statusCode(200);
    }

    @Test
    public void testDeleteUsersEndpoint() {
        given()
                .when().delete("/api/user/5")
                .then()
                .statusCode(204)
                .extract()
                .response()
                .body();
    }

}