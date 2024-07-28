package testingAPI.restAssured;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class PokemonTest {

    @Test
    public void pokemonWithRestAssuredTest() {
        RestAssured.when()                                 // after when() we have to specify a type of request
                .get("https://pokeapi.co/api/v2/pokemon") // here we send a request on necessary end point
                .then()                                     //after this key word we start out checks
                .statusCode(200)                         //here we check that status code = 200
                .body("count", Matchers.equalTo(1302), //here we check that a response has a key count with value 1302
                        "results.name", Matchers.hasItems("bulbasaur", "ivysaur")); // here we check wat in array results there are values bulbasaur and ivysaur
    }
}
