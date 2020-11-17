package com.innovect.weather.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innovect.weather.service.WeatherForecastService;

@RestController
@RequestMapping("/forecast")
@Validated
public class WeatherForecastController {

	@Autowired
	private WeatherForecastService forecastService;
	
	@GetMapping(path="/temperature", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getWeatherDetails(@RequestParam("zip") @Size(min=5, max=5) @Pattern(regexp = "^[0-9]+$") String zipCode, @RequestParam("days") @Min(1) @Max(10) int noOfDays) {
		return this.forecastService.getWeatherForecastByZipCode(zipCode, noOfDays);
	}

}
