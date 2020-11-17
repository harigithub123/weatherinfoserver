package com.innovect.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Day {
	private float maxtemp_c;
	private float maxtemp_f;
	private float mintemp_c;
	private float mintemp_f;
	private float avgtemp_c;
	private float avgtemp_f;
	private float maxwind_mph;
	private float maxwind_kph;
	private float totalprecip_mm;
	private float totalprecip_in;
	private float avgvis_km;
	private float avgvis_miles;
	private float avghumidity;
	private float daily_will_it_rain;
	private String daily_chance_of_rain;
	private float daily_will_it_snow;
	private String daily_chance_of_snow;
	private float uv;
}