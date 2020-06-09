package com.cloudtech.pi.api.API;

public class JSONRead {

    public static void main(String[] args) {

        API_HTTP.doHttpGet();

        Clima clima = new Clima();

        Headline.ReadJSON(clima);
        DailyForecasts.ReadJSON(clima);

        System.out.println((int)clima.daily_forecasts.temperature.maximun.Value + "°C");
        System.out.println((int)clima.daily_forecasts.temperature.minimun.Value + "°C");
                            //clima.getMaximaValor();

    }
}
