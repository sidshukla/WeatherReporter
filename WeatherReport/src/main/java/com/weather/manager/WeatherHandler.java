package com.weather.manager;

import com.weather.manager.entity.City;
import com.weather.manager.entity.Weather;

public interface WeatherHandler {

    public Weather getTodaysWeather(City city) throws WeatherException;
}
