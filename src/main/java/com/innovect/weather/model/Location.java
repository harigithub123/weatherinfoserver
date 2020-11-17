package com.innovect.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Location {
	private String name;
	private String region;
	private String country;
	private float lat;
	private float lon;
	private String tz_id;
	private float localtime_epoch;
	private String localtime;
}