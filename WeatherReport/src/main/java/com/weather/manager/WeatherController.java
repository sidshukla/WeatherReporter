package com.weather.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weather.manager.entity.City;
import com.weather.manager.entity.Weather;

@Controller
public class WeatherController {

    @Autowired
    private WeatherHandler weatherHandler;

    @RequestMapping(value = "/todaysWeather", method = RequestMethod.POST)
    public String getTodaysWeather(@ModelAttribute final City city, final Model model) throws WeatherException {
        final Weather weather = weatherHandler.getTodaysWeather(city);
        city.setWeather(weather);
        model.addAttribute("weatherResponse", city);
        return "weatherResponse";

    }

    @RequestMapping(value = "/todaysWeather", method = RequestMethod.GET)
    public String weatherForm(final Model model) {
        model.addAttribute("city", new City());
        return "weatherRequest";
    }

}
