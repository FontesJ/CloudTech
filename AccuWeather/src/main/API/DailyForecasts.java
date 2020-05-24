import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class DailyForecasts extends Clima{
    public Temperature temperature;

    public DailyForecasts() {
        //Vazio
    }

    public static void ReadJSON(Clima clima) {

        Temperature temperature = new Temperature();
        DailyForecasts dailyForecasts = new DailyForecasts();
        JSONObject jsonObject = null, tempList;
        JSONParser parser = new JSONParser();
        JSONArray  dailyFor, sources;
        Map temp, min, max, dia, noite;
        Maximun maximun = new Maximun();
        Minimun minimun = new Minimun();
        Day day = new Day();
        Night night = new Night();
        double ma, mi;

        try {
            jsonObject = (JSONObject) parser.parse(new FileReader("saida.json"));
            dailyFor = (JSONArray) jsonObject.get("DailyForecasts");
            tempList = (JSONObject) dailyFor.get(0);
            temp = (Map) tempList.get("Temperature");
            min = (Map) temp.get("Minimum");
            mi = (Double) min.get("Value");
            minimun.Value = Temperature.getCelsius(mi);
            max = (Map) temp.get("Maximum");
            ma = (Double) max.get("Value");
            maximun.Value = Temperature.getCelsius(ma);
            dia = (Map) tempList.get("Day");
            day.Icon = (Long) dia.get("Icon");
            day.HasPrecipitation = (Boolean) dia.get("HasPrecipitation");
            noite = (Map) tempList.get("Night");
            night.Icon = (Long) noite.get("Icon");
            night.HasPrecipitation = (Boolean) noite.get("HasPrecipitation");
            temperature.EpochDate = (Long) tempList.get("EpochDate");
            sources = (JSONArray) tempList.get("Sources");
            temperature.Source = sources.toString();
            temperature.Link = (String) tempList.get("Link");
            temperature.MobileLink = (String) tempList.get("MobileLink");
            temperature.Date = (String) tempList.get("Date");

            temperature.setMaximun(maximun);
            temperature.setMinimun(minimun);
            temperature.setDay(day);
            temperature.setNight(night);

            dailyForecasts.setTemperature(temperature);
            clima.setDaily_forecasts(dailyForecasts);

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }


    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
}

class Temperature extends DailyForecasts{
    public Minimun minimun;
    public Maximun maximun;
    public Day day;
    public Night night;
    public long  EpochDate;
    public String Date, Source, Link, MobileLink;

    public Temperature() {
        //Vazio
    }

    public static double getCelsius(double F){
        return (F-32.0)*(5.0/9.0);
    }

    public void setMinimun(Minimun minimun) {
        this.minimun = minimun;
    }

    public void setMaximun(Maximun maximun) {
        this.maximun = maximun;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public void setNight(Night night) {
        this.night = night;
    }
}

class Minimun extends DailyForecasts{
    public double Value;
    public char Unity;
    public int UnityType;

    public Minimun(){
        //Vazio
    }
}

class Maximun extends DailyForecasts{
    public double Value;
    public char Unity;
    public int UnityType;

    public Maximun(){
        //Vazio
    }
}

class Day extends DailyForecasts{
    public long Icon;
    public String iconPhrase;
    public boolean HasPrecipitation;

    public Day(){
        //Vazio
    }
}

class Night extends DailyForecasts{
    public long Icon;
    public String iconPhrase;
    public boolean HasPrecipitation;
    public String PrecipitationType;
    public String PrecipitationIntensity;

    public Night() {
        //Vazio
    }
}