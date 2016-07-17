package com.weather.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OWMWeatherResponseImpl implements WeatherReponse {
	
	private String BASE_URL;
	
    private String KEY;
    
	@Autowired
	public OWMWeatherResponseImpl(@Value("${OWN_URL}") String url ,@Value("${APP_KEY}") String key) {
		this.BASE_URL = url;
		this.KEY = "&APPID="+key;
	}

	@Override
    public JSONObject getTodaysWeather(final String cityID) throws WeatherException {
        HttpURLConnection con = null;
        InputStream is = null;

        try {
            con = (HttpURLConnection) (new URL(BASE_URL + cityID + KEY)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            // Let's read the response
            final StringBuffer buffer = new StringBuffer();
            is = con.getInputStream();
            final BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line + "rn");
            }

            is.close();
            con.disconnect();

            return new JSONObject(buffer.toString());
        } catch (final IOException e) {
           throw new WeatherException(e.getMessage());
        } finally {
            try {
                is.close();
            } catch (final Throwable t) {
            }
            try {
                con.disconnect();
            } catch (final Throwable t) {
            }
        }
    }
}