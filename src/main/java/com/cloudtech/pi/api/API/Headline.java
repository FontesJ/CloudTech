package com.cloudtech.pi.api.API;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Headline extends Clima{
    public static String EffectiveDate;    //Data efetiva
    public long EffectiveEpochDate;    //Data efetiva em milisegundos
    public long Severity;               //Seriedade (Potencial de problemas)
    public String Text;                //Descrição breve
    public String Category;            //Categoria
    public String EndDate;          //Término da previsão
    public long EndEpochDate;          //Término em milisegundos
    public String MobileLink;          //Link para dispositivos mobile
    public String Link;                //Link para dispositivos desktop

    public Headline() {
        //Vazio
    }

    public static void ReadJSON(Clima clima){

        Headline headline = new Headline();
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();
        Map hl;

        try {
            jsonObject = (JSONObject) parser.parse(new FileReader("saida.json"));
            hl = (Map) jsonObject.get("Headline");
            headline.Text = (String) hl.get("Text");
            headline.EffectiveDate = (String) hl.get("EffectiveDate");
            headline.EffectiveEpochDate = (Long) hl.get("EffectiveEpochDate");
            headline.Text = (String) hl.get("Text");
            headline.Severity = (Long) hl.get("Severity");
            headline.Category = (String) hl.get("Category");
            headline.EndDate = (String) hl.get("EndDate");
            headline.EndEpochDate = (Long) hl.get("EndEpochDate");
            headline.MobileLink = (String) hl.get("MobileLink");
            headline.Link = (String) hl.get("Link");

            clima.setHeadline(headline);

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

    }

}