import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements IExtratorDeConteudo
{
    public List<Conteudo> extrairConteudo(String jsonData)
    {
        List<Map<String,String>> listaAtributos = JsonParser.parse(jsonData);

        List<Conteudo> conteudos = new ArrayList<>();

        for (Map<String,String> stributos : listaAtributos) {
            
            conteudos.add(
                new Conteudo(stributos.get("title"), stributos.get("url"))
            );
        }        
        return conteudos;
    }
}
