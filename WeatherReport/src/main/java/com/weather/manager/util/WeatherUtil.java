package com.weather.manager.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class WeatherUtil {

	private final static DateTimeFormatter DATEFORMATTER = DateTimeFormatter
			.ofPattern("dd-MM-yyyy");

	private final static DateTimeFormatter TIMEFORMATTER = DateTimeFormatter
			.ofPattern("hh:mm:ss a");

	public String getFormattedDate(long rawTime) {
		final String formattedDate = Instant.ofEpochSecond(rawTime)
				.atZone(ZoneId.of("GMT")).format(DATEFORMATTER);

		return formattedDate;
	}

	public String getFormattedTime(long rawTime) {
		final String formattedTime = Instant.ofEpochSecond(rawTime)
				.atZone(ZoneId.of("GMT")).format(TIMEFORMATTER);

		return formattedTime;
	}

	public double getCelsiusTemp(double kelvinTemp) {
		return Math.round((kelvinTemp - 273.16) * 100.0) / 100.0;

	}

	public double getFahrenheitTemp(double kelvinTemp) {
		return Math.round(((((kelvinTemp - 273) * 9 / 5) + 32)) * 100.0) / 100.0;
	}
}
