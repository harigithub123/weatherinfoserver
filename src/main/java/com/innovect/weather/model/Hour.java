package com.innovect.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Hour {
	private float time_epoch;
	private String time;
	private float temp_c;
	private float temp_f;
	private float is_day;
}
