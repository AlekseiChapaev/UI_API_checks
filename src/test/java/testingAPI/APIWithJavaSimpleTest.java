package testingAPI;

import com.google.common.net.HttpHeaders;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class APIWithJavaSimpleTest {
    /*
   This test is written on clear Java.
   In this case is shown how we can use inner Java mechanisms to interact with HTTP(S) requests.
   Byt we're still using external library - in this example - Apache HttpClient
    */
    @Test
    public void httpSimpleTest() throws IOException {

        // we use try-finally structure. It gives us an opportunity to automatically use interface closable after performing this block of code
        // after block of code within the try. We close the object that was created in the row bellow (httpClient)
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) { // we create httpClient and will use it to send our requests. Here port opening happens.
            HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon"); // here we create a request with "GET" type and point end-point for our request

            request.addHeader(HttpHeaders.USER_AGENT, "Googlebot"); // here we add headers in out request. If we need to add several headers we have to write several times request.addHeader(). In this case testing site will think that request from Google.com

            try (CloseableHttpResponse response = httpClient.execute(request)) { // here we send a request and get a response. Then save it into a variable response

                int responseCode = response.getStatusLine().getStatusCode();
                String bodyText = ""; // here we initialize a variable to use it in the future to store body text

                if(responseCode == 200) {   // here we check that our response have status code = 200
                    HttpEntity entity = response.getEntity();   // here we get a response's body
                    if(entity != null) {    // here we check that out response has a body (not null)
                        bodyText = EntityUtils.toString(entity); // here we transform our response from JSON to String.
                    }
                } else {
                    System.out.println("GET request failed. Response code: " + responseCode);
                }

                /*
                It's a very simple check and this approach very rarely because it's inconvenient to parse results to String or back
                */
                Assert.assertTrue(bodyText.startsWith("{\"count\":1302")); // we check is our response start with this value. In our test site this information can change and test can fail.
            }
        } // here we close our port httpClient because of try-finally structure
    }
}
