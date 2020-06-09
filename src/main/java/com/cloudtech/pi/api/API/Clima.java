package com.cloudtech.pi.api.API;

public class Clima {
    public Headline headline;
    public DailyForecasts daily_forecasts;

    public Clima() {
        //Vazio
    }

    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    public void setDaily_forecasts(DailyForecasts daily_forecasts) {
        this.daily_forecasts = daily_forecasts;
    }
}

