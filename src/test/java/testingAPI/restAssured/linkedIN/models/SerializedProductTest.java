package testingAPI.restAssured.linkedIN.models;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SerializedProductTest {
    @Test
    public void CreateSerializedProductTest() {
        String endpoint = "http://localhost:8888/api_testing/product/create.php";
        Product product = new Product(
                "Water battle",
                "Blue water bottle. Holds 64 ounces",
                12,
                3
        );

        var response = given().body(product).when().post(endpoint).then();

        //here two ways to get response's body
        response.log().body();
        System.out.println(response.extract().asString());
    }
}
