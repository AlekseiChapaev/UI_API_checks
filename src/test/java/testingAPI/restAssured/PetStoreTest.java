package testingAPI.restAssured;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreTest {

    private static final String END_POINT = "https://petstore.swagger.io/v2/pet/";
    private static final String PET_ID = "77777";

    @Test
    public void positiveCheckPetNotExistTest() {
        RestAssured.when()
                .get(END_POINT.concat(PET_ID))
                .then()
                .statusCode(404)
                .body("type", equalTo("error"))
                .body("message", equalTo("Pet not found"));
    }

    @Test
    public void negativeCheckRequestWithoutPetIdTest() {
        RestAssured.when()
                .get(END_POINT.concat(""))
                .then()
                .statusCode(405)
                .statusLine(containsString("405 Method Not Allowed")); //here we check a notification into Response StatusCode row
    }
}
