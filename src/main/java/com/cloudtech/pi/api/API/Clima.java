package com.cloudtech.pi.api.API;

import com.cloudtech.pi.domain.Previsao;

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

    public void setPrev(Clima clima){
        Previsao previsao = new Previsao();
        previsao.setNome("São Paulo");
        previsao.setSeriedade(clima.headline.Severity);
        previsao.setTexto(clima.headline.Text);
        previsao.setMaxima((int)clima.daily_forecasts.temperature.maximun.Value);
        previsao.setMinima((int)clima.daily_forecasts.temperature.minimun.Value);
    }
}

