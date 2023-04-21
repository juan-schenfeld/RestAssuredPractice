import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestRegisterAndLogin extends BaseTest {
    @Test
    public void registerUser() {
        String requestBody = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\"}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/register")
                .then()
                .statusCode(200)
                .body("token", notNullValue());

    }
    @Test
    public void loginUser() {
        String requestBody = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .body("token", notNullValue());
    }

}
