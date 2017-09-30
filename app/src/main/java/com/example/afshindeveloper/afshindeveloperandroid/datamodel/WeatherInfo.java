package com.example.afshindeveloper.afshindeveloperandroid.datamodel;

/**
 * Created by afshindeveloper on 03/09/2017.
 */

public class WeatherInfo {
    private String weathername;
    private String description;
    private float windspeed;
    private float windDegree;
    private int humidity;
    private float weatherTempratur;
    private float minTempratur;
    private float maxTempratur;
    private int pressure;

    public String getWeathername() {
        return weathername;
    }

    public void setWeathername(String weathername) {
        this.weathername = weathername;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(float windspeed) {
        this.windspeed = windspeed;
    }

    public float getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(float windDegree) {
        this.windDegree = windDegree;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getWeatherTempratur() {
        return weatherTempratur;
    }

    public void setWeatherTempratur(float weatherTempratur) {
        this.weatherTempratur = weatherTempratur;
    }

    public float getMinTempratur() {
        return minTempratur;
    }

    public void setMinTempratur(float minTempratur) {
        this.minTempratur = minTempratur;
    }

    public float getMaxTempratur() {
        return maxTempratur;
    }

    public void setMaxTempratur(float maxTempratur) {
        this.maxTempratur = maxTempratur;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }
}
