import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;


public class App {

    public static final String PURPLE_BACKGROUD = "\033[45m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String BLACK_BACKGROUD  = "\u001B[40m";
    public static final String RESET_BACKGROUD  = "\u001B[0m";
    public static final String EstrelaAmarela = "⭐️";
    public static final String PATHROOT = "/home/cjunior/Documents/alura/ImersaoJava2/stickers/saida/";

    public static void main(String[] args) throws InterruptedException, Exception {
        //Fazer uma conexão HTTP e buscar os filmes
        String url[] = {"https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json"
                       ,"https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json"
                       ,"https://api.nasa.gov/planetary/apod?api_key=b0a3XqfldluU4hVsV530UNhTB3IKCQBaBLHEzpzG&start_date=2022-06-12&end_date=2022-06-15"
                       };
        String jsonData = new ClienteHttp().BusgaDados(url[2]);

        //Extrair somente os dados que interessa(titulo poster, classificação)
        IExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
        List<Conteudo> conteudos = extrator.extrairConteudo(jsonData);

        // Exibir os dados
        for (Conteudo conteudo : conteudos) {

            var inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = PATHROOT + conteudo.getTitulo() + ".png";
            new GeradoraDeFigurinhas().cria(inputStream, nomeArquivo);

            // Print line
            System.out.println("Titulo: " + conteudo.getTitulo());
            System.out.println();
        }
    }
}