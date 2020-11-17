package com.innovect.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Astro {
	private String sunrise;
	private String sunset;
	private String moonrise;
	private String moonset;
	private String moon_phase;
	private String moon_illumination;
}