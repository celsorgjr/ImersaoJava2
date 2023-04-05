import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHttp {
    
    public String BusgaDados(String url)
    {
        String result ="";

        try {
            HttpResponse<String> response = HttpClient.newHttpClient()
                .send(
                        HttpRequest.newBuilder(URI.create(url)).GET().build(), 
                        BodyHandlers.ofString()
                    );
            result = response.body();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }    
}
