package testingAPI.withEmbeddedLibraryHttpClient;

import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class APIWithJavaAndGsonRegularTest {
    private static final class Pokemon { //we create inner class to discribe an object, which we will get from response
        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }
    }

    private static final class SetOfPokemon { //we create inner class to discribe an object, which we will get from response
        private int count;
        private String previous;
        private String next;
        private List<Pokemon> results;
    }

    @Test
    public void httpRegularTest() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient(); // we create a new HTTPclient for making a request. By default it is GET request. If we want to send another type we have to put the type of request after headers
        HttpRequest request = HttpRequest.newBuilder() // with newBuilder we build our request
                .uri(URI.create("https://pokeapi.co/api/v2/pokemon")) // here we add URL to our request
                .header("User-Agent", "Googlebot") // here we add header to our request
                .build(); // here the builder finish we build-process and create HttpRequest with necessary parameters

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); // here we send our request -> client.send(request, ...)
                                                                                                    // then we get a response as an object -> HttpResponse
                                                                                                    // then we get a body from response and convert it to a String -> HttpResponse.BodyHandlers.ofString()

        String bodyText = response.body();                                      // here we get body
        int responseCode = response.statusCode();                               // here we get status-code
        Map<String, List<String>> headers = response.headers().map();           // here we get headers as a Map
//        for (Map.Entry<String, List<String>> header : headers.entrySet()) {   // here the way how we can print headers from the Map
//            System.out.println(header.getKey() + ": " + String.join(", ", header.getValue()));
//        }

        if (responseCode != 200) {
            System.out.println("GET request failed. Response code: " + responseCode);
            return;
        }

        SetOfPokemon pokemons = new Gson().fromJson(bodyText, SetOfPokemon.class);

        Assert.assertEquals(pokemons.count, 1302);
        Assert.assertNull(pokemons.previous);
        Assert.assertEquals(pokemons.next, "https://pokeapi.co/api/v2/pokemon?offset=20&limit=20");
        Assert.assertEquals(pokemons.results.get(0).getName(), "bulbasaur");
        Assert.assertEquals(pokemons.results.get(0).getUrl(), "https://pokeapi.co/api/v2/pokemon/1/");
        Assert.assertEquals(pokemons.results.size(), 20);

        Assert.assertEquals(headers.get("strict-transport-security").get(0), "max-age=31556926");
    }
}
