import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser {
    
    private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.+)\\].*");
    private static final Pattern REGEX_ATRIBUTOS_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");

    public static List<Map<String, String>> parse(String Jsondata){

        Matcher matcher = REGEX_ITEMS.matcher(Jsondata);
        if (!matcher.find())
            throw new IllegalArgumentException("Não encontrou items.");

        String[] items = matcher.group(1).split("\\},\\{");
        
        List<Map<String, String>> dados = new ArrayList<>();

        for (String item : items){

            Map<String,String> atributosItem = new HashMap<>();

            Matcher matcherAtributo = REGEX_ATRIBUTOS_JSON.matcher(item);
            while(matcherAtributo.find()){
                String atributo = matcherAtributo.group(1);
                String valor = matcherAtributo.group(2);
                atributosItem.put(atributo,valor);
            }
            
            dados.add(atributosItem);
        }

        return dados;
    }
}
