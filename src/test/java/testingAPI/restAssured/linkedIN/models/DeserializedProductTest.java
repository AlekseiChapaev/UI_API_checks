package testingAPI.restAssured.linkedIN.models;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class DeserializedProductTest {
    @Test
    public void getDeserializedProduct() {
        String endpoint = "http://localhost:8888/api_testing/product/read_one.php";
        Product expectedProduct = new Product(
                2,
                "Cross-Back Training Tank",
                "The most awesome phone of 2013!",
                299.00,
                2,
                "Active Wear - Women"
        );
        Product actualProduct =
                given()
                        .queryParam("id", 2)
                .when()
                        .get(endpoint)
                        .as(Product.class);      //here we specify that we want to get our response as an object of Product class

        assertThat(actualProduct, samePropertyValuesAs(expectedProduct)); // if we check here through just equalTo we will check just object link but not what object contain from
    }
}
