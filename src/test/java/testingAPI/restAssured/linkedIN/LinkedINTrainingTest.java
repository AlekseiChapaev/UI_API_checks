package testingAPI.restAssured.linkedIN;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

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
