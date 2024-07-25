package testingAPI.withExternalLibraryApacheHttpcomponents;

import com.google.common.net.HttpHeaders;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class APIWithJavaAndGsonRegularTest {

    /*
    we create inner class Pokemon to be able to store in it each pokemon
    */
    private static final class Pokemon {
        private String name;
        private String url;

        public Pokemon(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }
    }

    /*
    we create inner class setOfPokemon to be able to store in it several pokemons
     */
    private static final class SetOfPokemon {
        private int count;
        private String previous;
        private String next;
        private List<Pokemon> results;
    }

    @Test
    public void httpRegularTest() throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon");

            request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");

            try (CloseableHttpResponse response = httpClient.execute(request)) {

                int responseCode = response.getStatusLine().getStatusCode();
                String bodyText = "";

                if (responseCode == 200) {
                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        bodyText = EntityUtils.toString(entity);
                    }
                } else {
                    System.out.println("GET request failed. Response code: " + responseCode);
                }

                SetOfPokemon pokemons = new Gson().fromJson(bodyText, SetOfPokemon.class);    //With Gson we convert response from JSON-format to Java-object from SetOfPokemon class
                Assert.assertEquals(pokemons.count, 1302);  //we can check this list
                Assert.assertNull(pokemons.previous);
                Assert.assertEquals(pokemons.next, "https://pokeapi.co/api/v2/pokemon?offset=20&limit=20");
                Assert.assertEquals(pokemons.results.get(0).getName(),"bulbasaur");
                Assert.assertEquals(pokemons.results.get(0).getUrl(),"https://pokeapi.co/api/v2/pokemon/1/");
                Assert.assertEquals(pokemons.results.size(), 20);
            }
        }
    }
}



