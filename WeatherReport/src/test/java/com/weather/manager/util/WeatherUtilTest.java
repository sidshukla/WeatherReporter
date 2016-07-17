package com.weather.manager.util;

import org.junit.Assert;
import org.junit.Test;

public class WeatherUtilTest {
	
	private WeatherUtil weatherUtil = new WeatherUtil();

	@Test
	public void getFormattedDateTest() {
		Assert.assertEquals("14-07-2016", weatherUtil.getFormattedDate(1468454581l));
	}

	@Test
	public void getFormattedTimeTest() {
		Assert.assertEquals("12:03:01 AM", weatherUtil.getFormattedTime(1468454581l));
	}

	@Test
	public void getCelsiusTempTest() {
		Assert.assertEquals(26.99, weatherUtil.getCelsiusTemp(300.15),0.00);
	}

	@Test
	public void getFahrenheitTempTest() {
		Assert.assertEquals(80.87, weatherUtil.getFahrenheitTemp(300.15),0.00);
	}
}
