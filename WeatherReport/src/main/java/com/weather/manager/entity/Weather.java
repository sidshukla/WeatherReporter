package com.weather.manager.entity;


public class Weather {

    private String date;
    
    private String cityName;

    private String description;

    private double tempratureCelsius;

    private double tempratureFahrenheit;

    private String sunriseTime;

    private String sunsetTime;
 
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTempratureCelsius() {
		return tempratureCelsius;
	}

	public void setTempratureCelsius(double tempratureCelsius) {
		this.tempratureCelsius = tempratureCelsius;
	}

	public double getTempratureFahrenheit() {
		return tempratureFahrenheit;
	}

	public void setTempratureFahrenheit(double tempratureFahrenheit) {
		this.tempratureFahrenheit = tempratureFahrenheit;
	}

	public String getSunriseTime() {
		return sunriseTime;
	}

	public void setSunriseTime(String sunriseTime) {
		this.sunriseTime = sunriseTime;
	}

	public String getSunsetTime() {
		return sunsetTime;
	}

	public void setSunsetTime(String sunsetTime) {
		this.sunsetTime = sunsetTime;
	}

	@Override
	public String toString() {
		return "Weather [date=" + date + ", cityName=" + cityName
				+ ", description=" + description + ", tempratureCelsius="
				+ tempratureCelsius + ", tempratureFahrenheit="
				+ tempratureFahrenheit + ", sunriseTime=" + sunriseTime
				+ ", sunsetTime=" + sunsetTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cityName == null) ? 0 : cityName.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((sunriseTime == null) ? 0 : sunriseTime.hashCode());
		result = prime * result
				+ ((sunsetTime == null) ? 0 : sunsetTime.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tempratureCelsius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(tempratureFahrenheit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weather other = (Weather) obj;
		if (cityName == null) {
			if (other.cityName != null)
				return false;
		} else if (!cityName.equals(other.cityName))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (sunriseTime == null) {
			if (other.sunriseTime != null)
				return false;
		} else if (!sunriseTime.equals(other.sunriseTime))
			return false;
		if (sunsetTime == null) {
			if (other.sunsetTime != null)
				return false;
		} else if (!sunsetTime.equals(other.sunsetTime))
			return false;
		if (Double.doubleToLongBits(tempratureCelsius) != Double
				.doubleToLongBits(other.tempratureCelsius))
			return false;
		if (Double.doubleToLongBits(tempratureFahrenheit) != Double
				.doubleToLongBits(other.tempratureFahrenheit))
			return false;
		return true;
	}
}
