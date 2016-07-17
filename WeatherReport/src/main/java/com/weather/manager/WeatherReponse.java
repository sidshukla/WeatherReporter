package com.weather.manager;

import org.json.JSONObject;


public interface WeatherReponse {

    public JSONObject getTodaysWeather(String cityID) throws WeatherException;
}
