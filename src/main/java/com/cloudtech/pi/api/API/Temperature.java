package com.cloudtech.pi.api.API;

public class Temperature extends DailyForecasts{
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