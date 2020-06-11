package com.cloudtech.pi.api.API;

public class JSONRead {

    public static void main(String[] args) {

        API_HTTP.doHttpGet("36358");

        Clima clima = new Clima();

        Headline.ReadJSON(clima);
        DailyForecasts.ReadJSON(clima);

        clima.setPrev(clima);
    }
}
