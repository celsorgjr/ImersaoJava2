import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class App {

    public static final String PURPLE_BACKGROUD = "\033[45m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String BLACK_BACKGROUD  = "\u001B[40m";
    public static final String RESET_BACKGROUD  = "\u001B[0m";
    public static final String EstrelaAmarela = "⭐️";

    public static void main(String[] args) throws InterruptedException, Exception {
        //Fazer uma conexão HTTP e buscar os filmes
        String url[] = {"https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", 
                        "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json"};
        HttpResponse<String> response = HttpClient.newHttpClient()
            .send(
                    HttpRequest.newBuilder(URI.create(url[0])).GET().build(), 
                    BodyHandlers.ofString()
                );
        String jsonData = response.body();

        //Extrair somente os dados que interessa(titulo poster, classificação)
        List<Map<String,String>> listaFilmes = JsonParser.parse(jsonData);

        // Exibir os dados
        for (Map<String,String> filme : listaFilmes) {
            
            System.out.println("Titulo: " + filme.get("title"));
            System.out.println("Poster: " + filme.get("image"));
            System.out.println(GREEN_BACKGROUND + "Classificação: "
                                 + filme.get("imDbRating") + RESET_BACKGROUD);
            float avalicao = Float.parseFloat(filme.get("imDbRating"));
            int numeroDeEstrela = Math.round(avalicao);

            for (int i = 0; i < numeroDeEstrela; i++) {
                System.out.print(EstrelaAmarela);
            }
            System.out.println(" ");
            System.out.println(" ");
        }
    }
}