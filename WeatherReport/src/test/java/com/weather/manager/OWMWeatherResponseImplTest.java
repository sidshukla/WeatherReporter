package com.weather.manager;

import junit.framework.Assert;

import org.json.JSONObject;
import org.junit.Test;
import org.springframework.stereotype.Service;

public class OWMWeatherResponseImplTest  {
	

	private final static String OWN_URL = "http://api.openweathermap.org/data/2.5/weather?id=";
	private final static String APP_KEY = "25fdeab57e8eec923796b58a53258e63";
	
	private WeatherReponse ownWeatherResponse = new OWMWeatherResponseImpl(OWN_URL, APP_KEY);
	
    @Test
    public void getTodaysWeatherTest() throws WeatherException {
    	JSONObject actualResult = ownWeatherResponse.getTodaysWeather("6058560");
    	
    	Assert.assertEquals("London", actualResult.get("name"));
    }

}