package com.weather.manager;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.weather.manager.entity.City;
import com.weather.manager.entity.Weather;
import com.weather.manager.util.WeatherUtil;

@RunWith(MockitoJUnitRunner.class) 
public class WeatherHandlerImplTest {

	@Mock
	private WeatherReponse weatherReponse;
	
	@Mock
	private WeatherUtil weatherUtil;

	@Before
	public void setup() throws Exception{
	    String weatherData= "{\"coord\":{\"lon\":77.22,\"lat\":28.67},\"weather\":[{\"id\":200,\"main\":\"Thunderstorm\",\"description\":\"thunderstorm with light rain\",\"icon\":\"11n\"}],\"base\":\"cmc stations\",\"main\":{\"temp\":300.15,\"pressure\":1000,\"humidity\":94,\"temp_min\":300.15,\"temp_max\":300.15},\"wind\":{\"speed\":2.6,\"deg\":120},\"clouds\":{\"all\":90},\"dt\":1468508400,\"sys\":{\"type\":1,\"id\":7809,\"message\":0.0539,\"country\":\"IN\",\"sunrise\":1468454581,\"sunset\":1468504255},\"id\":1273294,\"name\":\"london\",\"cod\":200}";
		when(weatherReponse.getTodaysWeather(eq("123"))).thenReturn(new JSONObject(weatherData));
		
	}
	
	@InjectMocks
	WeatherHandler weatherHandler = new WeatherHandlerImpl();
	
	@Test
	public void getTodaysWeatherTest() throws WeatherException {
		when(weatherUtil.getFormattedDate(eq(1468508400l))).thenReturn("2016-05-14");
		when(weatherUtil.getFormattedTime(eq(1468454581l))).thenReturn("06:00:00 AM");
		when(weatherUtil.getFormattedTime(eq(1468504255l))).thenReturn("08:00:00 PM");
		when(weatherUtil.getFahrenheitTemp(eq(300.15))).thenReturn(12.22);
		when(weatherUtil.getCelsiusTemp(eq(300.15))).thenReturn(44.44);
		
		City london = new City();
		london.setId("123");
		london.setName("london");
		Weather actualWeather = weatherHandler.getTodaysWeather(london);

		Weather expectedWeather = new Weather();
		expectedWeather.setCityName("london");
		expectedWeather.setDate("2016-05-14");
		expectedWeather.setDescription("thunderstorm with light rain");
		expectedWeather.setSunriseTime("06:00:00 AM");
		expectedWeather.setSunsetTime("08:00:00 PM");
		expectedWeather.setTempratureCelsius(44.44);
		expectedWeather.setTempratureFahrenheit(12.22);
		
		Assert.assertEquals(expectedWeather.getCityName(),actualWeather.getCityName());
		Assert.assertEquals(expectedWeather.getDescription(),actualWeather.getDescription());
	}
	
	@Test (expected = WeatherException.class)
	public void getTodaysWeatherTestEmptyResponse() throws WeatherException{
		when(weatherReponse.getTodaysWeather(eq("123"))).thenReturn(null);
		
		City london = new City();
		london.setId("123");
		london.setName("london");
		weatherHandler.getTodaysWeather(london);
	}
	
	@Test (expected = WeatherException.class)
	public void getTodaysWeatherTestExceptionResponse() throws WeatherException{
		
		when(weatherUtil.getFormattedDate(eq(1468508400l))).thenThrow(new IllegalArgumentException("Illegal argument"));
		City london = new City();
		london.setId("123");
		london.setName("london");
		weatherHandler.getTodaysWeather(london);
	}

}
