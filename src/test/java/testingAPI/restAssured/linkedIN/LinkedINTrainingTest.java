package testingAPI.restAssured.linkedIN;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class LinkedINTrainingTest {

    @Test
    public void getCategories() {
        String endpoint = "http://localhost:8888/api_testing/product/read.php";
        var response = given().when().get(endpoint).then();
        response.log().body();
    }

    @Test
    public void getProduct() {
        String endpoint = "http://localhost:8888/api_testing/product/read_one.php";
        var response =
                given().
                        queryParam("id", 2).
                when().
                        get(endpoint).
                then();

        response.log().body();
    }

    @Test
    public void getProductWithStatusCodeVerification() {
        String endpoint = "http://localhost:8888/api_testing/product/read_one.php";

        given().
                queryParam("id", 2).
        when().
                get(endpoint).
        then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void getProductAndVerifyBodyFields() {
        String endpoint = "http://localhost:8888/api_testing/product/read_one.php";

        given().
                queryParam("id", 2).
                when().
                get(endpoint).
                then()
                .assertThat()
                .statusCode(200)
                .body("id", equalTo("2"))
                .body("name", equalTo("Cross-Back Training Tank"))
                .body("description", equalTo("The most awesome phone of 2013!"))
                .body("price", equalTo("299.00"))
                .body("category_id", equalTo(2))
                .body("category_name", equalTo("Active Wear - Women"));
    }

    @Test
    public void getSeveralProducts() {
        String endpoint = "http://localhost:8888/api_testing/product/read.php";
        given()
        .when()
                .get(endpoint)
        .then()
                .log()
                .body()
                .assertThat()
                .statusCode(200)
                .body("records.size()", greaterThan(0)) // here we check that we got not empty array. The check depends on the requirement
                .body("records.size()", equalTo(23)) // here we check that we get an array with name "records" and it contains from 23 objects
                .body("records.id", everyItem(notNullValue())) // here we check that every record in "records" has an ID. What there are no empty values in our DB
                .body("records.name", everyItem(notNullValue()))
                .body("records.description", everyItem(notNullValue()))
                .body("records.price", everyItem(notNullValue()))
                .body("records.category_id", everyItem(notNullValue()))
                .body("records.category_name", everyItem(notNullValue()))
                .body("records.id[0]", equalTo(28)) //here we check that the first object in "records" array has id = 28
                .body("records.name[22]", equalTo("Bamboo Thermal Ski Coat")); //here we check that the last object in "records" array has specified name
    }

    @Test
    public void createProduct() {
        String endpoint = "http://localhost:8888/api_testing/product/create.php";
        String body = """
                {
                "name": "Water battle",
                "description": "Blue water bottle. Holds 64 ounces",
                "price": 12,
                "category_id": 3
                }
                """;
        var response = given().body(body).when().post(endpoint).then();

        response.log().body();
    }

    @Test
    public void updateProduct() {
        String endpoint = "http://localhost:8888/api_testing/product/update.php";
        String body = """
                {
                "id":19,
                "name": "Water Bottle",
                "description": "Blue water bottle. Holds 64 ounces",
                "price": 20,
                "category_id": 3
                }
                """;

        var request = given().body(body).when().put(endpoint).then();

        request.log().body();
    }

    @Test
    public void deleteProduct() {
        String endpoint = "http://localhost:8888/api_testing/product/delete.php";
        String body = """
                {
                "id": 21
                }
                """;

        var response = given().body(body).when().delete(endpoint).then();

        response.log().body();
    }
}
