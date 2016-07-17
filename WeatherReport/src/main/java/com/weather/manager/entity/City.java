package com.weather.manager.entity;

public class City {

    private String id;

    private String name;

    private String country;

    private Weather weather;

    public String getCountry() {
        return country;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setWeather(final Weather weather) {
        this.weather = weather;
    }

}
