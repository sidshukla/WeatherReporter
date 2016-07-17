package com.weather.manager;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.manager.entity.City;
import com.weather.manager.entity.Weather;
import com.weather.manager.util.WeatherUtil;

@Service
public class WeatherHandlerImpl implements WeatherHandler {

	@Autowired
	private WeatherReponse weatherReponse;
	
	@Autowired
	private WeatherUtil weatherUtil;

	
	@Override
	public Weather getTodaysWeather(final City city) throws WeatherException {

		final JSONObject weatherData = weatherReponse.getTodaysWeather(city
				.getId());
		

		if (weatherData != null) {
			try {
				final Weather weather = new Weather();

				weather.setDate(weatherUtil.getFormattedDate(weatherData
						.getLong("dt")));
				JSONObject weatherDetails = weatherData.getJSONArray("weather")
						.getJSONObject(0);
				weather.setDescription(weatherDetails.getString("description"));

				JSONObject mainDetails = weatherData.getJSONObject("main");
				double kelvinTemp = mainDetails.getBigDecimal("temp")
						.doubleValue();
				weather.setTempratureCelsius(weatherUtil
						.getCelsiusTemp(kelvinTemp));
				weather.setTempratureFahrenheit(weatherUtil
						.getFahrenheitTemp(kelvinTemp));

				JSONObject sysDetails = weatherData.getJSONObject("sys");
				weather.setSunriseTime(weatherUtil.getFormattedTime(sysDetails
						.getLong("sunrise")));
				weather.setSunsetTime(weatherUtil.getFormattedTime(sysDetails
						.getLong("sunset")));
				weather.setCityName(weatherData.getString("name"));
				return weather;

			} catch (Exception e) {
				throw new WeatherException(e.getMessage());
			}
		} else{
			throw new WeatherException("Error in retrieving weather information");
		}
		
	}

}
