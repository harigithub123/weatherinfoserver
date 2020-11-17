package com.innovect.weather.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Data
public class Forecastday {
	private String date;
	private float date_epoch;
	private Day day;
	private List<Hour> hour;
}
