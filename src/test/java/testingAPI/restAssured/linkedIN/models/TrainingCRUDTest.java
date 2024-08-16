package testingAPI.restAssured.linkedIN.models;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TrainingCRUDTest {
    @Test
    public void create() {
        String endpoint = "http://localhost:8888/api_testing/product/create.php";
        Product product = new Product(
               "Sweatband",
                "New red color sweatband",
                5,
                3
        );

        var response = given().body(product).when().post(endpoint).then();
        response.log().body();
    }

    @Test
    public void read() {
        String endpoint = "http://localhost:8888/api_testing/product/read_one.php";

        var response = given().queryParam("id", 26).when().get(endpoint).then();

        response.log().body();
    }

    @Test(dependsOnMethods = "create")
    public void update() {
        String endpoint = "http://localhost:8888/api_testing/product/update.php";
        Product product = new Product(
                26,
                "Sweatband",
                "New red color sweatband",
                6,
                3
        );

        var response = given().body(product).when().put(endpoint).then();
        response.log().body();
    }

    @Test
    public void delete() {
        String endpoint = "http://localhost:8888/api_testing/product/delete.php";
        String body = """
                {
                "id": 26
                }
                """;

        var response = given().body(body).when().delete(endpoint).then();

        response.log().body();
    }
}
