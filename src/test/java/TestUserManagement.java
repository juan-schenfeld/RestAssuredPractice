import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestUserManagement {

    @BeforeTest
    public void setUp(){
        Utils.setBaseURI();
    }

    @Test
    public void testGetUserList() {
        Response response = given()
                .when()
                .get("/users");

        response.then()
                .statusCode(200)
                .body("data", notNullValue())
                .body("data", hasSize(greaterThan(0)));
    }

    @Test
    public void testGetSingleUser() {
        Response response = given()
                .when()
                .get("/users/2");

        response.then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.email", equalTo("janet.weaver@reqres.in"));
    }

    @Test
    public void testGetSingleUser_expect404() {
        Response response = given()
                .when()
                .get("/users/23");

        response.then()
                .statusCode(404);
    }

    @Test
    public void createNewUser() {
        String requestBody = "{\"name\": \"morpheus\", \"job\": \"leader\"}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("users/")
                .then().statusCode(201)
                .extract().response();


        response.then()
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());
    }
    @Test
    public void testUpdateUser() {
        String requestBody = "{\"name\": \"morpheus\", \"job\": \"zion resident\"}";
        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("/users/2");

        response.then()
                .statusCode(200)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("zion resident"))
                .body("updatedAt", notNullValue());
    }

    @Test
    public void testDeleteUser() {
        Response response = given()
                .when()
                .delete("/users/2");

        response.then()
                .statusCode(204);
    }

}
