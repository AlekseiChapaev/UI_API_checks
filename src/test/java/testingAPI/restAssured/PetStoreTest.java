package testingAPI.restAssured;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

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

        System.out.println(listPetsAsString.substring(0, 200));
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

    /*
    This class was created to describe a pet which will be input to store
     */
    static class Pet {
        @JsonProperty       //  используем эти аннотации чтобы указать что нужно сериализовать
        private long id;
        @JsonProperty
        private PetCategory category;
        @JsonProperty
        private String name;
        @JsonProperty
        private String status;

        public Pet(long id, PetCategory category, String name, String status) {
            this.id = id;
            this.category = category;
            this.name = name;
            this.status = status;
        }
    }

    static class PetCategory { // this class to describe category of pet
        @JsonProperty
        long id;
        @JsonProperty
        String name;

        public PetCategory(long id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    @Test
    public void positiveAddNewPetToStoreTest() {
        RestAssured.given()
                .baseUri(END_POINT)
                .contentType(ContentType.JSON)
                .body(new Pet(77777, new PetCategory(1, "Dragons"), "Toothless", "Imaginary"))
                .when()
                .post()
                .then()
                .statusCode(200);
    }
}
