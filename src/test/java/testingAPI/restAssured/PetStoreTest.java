package testingAPI.restAssured;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreTest {

    private static final String END_POINT = "https://petstore.swagger.io/v2/pet/";
    private static final String PET_ID = "77777";

    @Test
    public void positiveCheckPetNotExistTest() {
        RestAssured.given()
                .baseUri(END_POINT)
                .when()
                .get(PET_ID)
                .then()
                .statusCode(404)
                .body("type", equalTo("error"))
                .body("message", equalTo("Pet not found"));
    }

    @Test
    public void negativeCheckRequestWithoutPetIdTest() {
        RestAssured.when()
                .get(END_POINT.concat(""))  //https://petstore.swagger.io/v2/pet/""
                .then()
                .statusCode(405)
                .statusLine(containsString("405 Method Not Allowed")); //here we check a notification into Response StatusCode row
    }

    @Test
    public void positiveGetListPetByStatusAsStringTest() {
        String listPetsAsString = RestAssured.given()
                .baseUri(END_POINT)
                .queryParam("status", "available")
                .when()
                .get("findByStatus/")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .asString();
    }

    @Test
    public void positiveGetListPetByStatusAsObjectsTest() {
        List<Map<String, Object>> listPetsAsObjects = //мы ждем список, где каждый элемент Map это питомец, с ключами и значениями.
                RestAssured.given()
                        .baseUri(END_POINT)
                        .queryParam("status", "available")
                        .when()
                        .get("findByStatus/")   // https://petstore.swagger.io/v2/pet/findByStatus?status=available
                        .then()
                        .statusCode(200)
                        .extract()
                        .response()
                        .as(new TypeRef<>() {}); //указываем что тело ответа должно быть десериализовано в список Map
        /*
        Используем List<Map<String, Object>> вместо List<Map<String, String>>
        потому что значения в JSON могут быть различных типов,
        таких как строки, числа, логические значения, вложенные объекты и массивы
         */
    }
}
