import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import javax.swing.*;
import java.io.IOException;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class API_HTTP {

    public static void doHttpGet(){
        //http://dataservice.accuweather.com/forecasts/v1/daily/1day/<ID CIDADE>?apikey=<ApiKey>  348735

        //int codigo_cidade = Integer.parseInt(JOptionPane.showInputDialog("Código da cidade:"));
        String url = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/348735?apikey=" + Chave.getApiKey();

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse resp = null;
        String json;
        FileWriter writeFile = null;
        Clima clima = new Clima();

        try {
            resp = client.execute(get);
            HttpEntity entity = resp.getEntity();
            System.out.println("Json response");
            json = EntityUtils.toString(entity);

            try {
                writeFile = new FileWriter("saida.json");
                //Escreve no arquivo conteudo do Objeto JSON
                writeFile.write(json);
                writeFile.close();
            }

            catch(IOException e){
                e.printStackTrace();
            }

        System.out.println(json);
        }

        catch (IOException ioe) {
            System.err.println("Something went wrong getting the weather: ");
            ioe.printStackTrace();
        }

        catch (Exception e){
            System.err.println("Unknown error: ");
            e.printStackTrace();
        }
    }
}
