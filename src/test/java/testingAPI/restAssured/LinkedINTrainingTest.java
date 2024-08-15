package testingAPI.restAssured;

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
}
