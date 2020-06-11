package com.cloudtech.pi.api.API;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.FileWriter;
import java.io.IOException;

public class API_HTTP {

    public static void doHttpGet(String codigo){

        String url = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/"+codigo+"?apikey=" + Chave.getApiKey();

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
