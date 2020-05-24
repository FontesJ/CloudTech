public class JSONRead {

    public static void main(String[] args) {

        //API_HTTP.doHttpGet();

        Clima clima = new Clima();

        Headline.ReadJSON(clima);
        DailyForecasts.ReadJSON(clima);

        System.out.println(clima.daily_forecasts.temperature.minimun.Value + "°C");

    }
}
