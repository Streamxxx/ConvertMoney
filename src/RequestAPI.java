import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestAPI {
    final static String API_KEY = "7d316e2f342c8393c6b7edd9";
    public Monedas consultaMoneda(String valorMoneda) {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+API_KEY+"/latest/"+valorMoneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
