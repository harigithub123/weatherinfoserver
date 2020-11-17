package com.innovect.weather.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.innovect.weather.constants.Constant;
import com.innovect.weather.exception.WeatherForecastException;
import com.innovect.weather.model.Forecastday;
import com.innovect.weather.model.Hour;
import com.innovect.weather.model.WeatherInfo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WeatherForecastService {

	@Autowired
	private Environment env;

	public ResponseEntity<Object> getWeatherForecastByZipCode(String zipCode, int noOfDays)
			throws WeatherForecastException {
		 return getWeatherForecastFromWeatherApi(zipCode, noOfDays);
	}

	public ResponseEntity<Object> getWeatherForecastFromWeatherApi(String zipCode, int noOfDays)
			throws WeatherForecastException {
		HttpHeaders headers = new HttpHeaders();
		String uri = env.getProperty(Constant.WEATHER_API_URI);
		String queryString = getRequestQuery(zipCode, noOfDays);
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));

		HttpEntity<WeatherInfo> entity = new HttpEntity<WeatherInfo>(headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<WeatherInfo> response = restTemplate.exchange(uri+queryString,
				HttpMethod.GET, entity, WeatherInfo.class);
		return getResponseEnity(response);
	}

	private ResponseEntity<Object> getResponseEnity(ResponseEntity<WeatherInfo> response) {
		HttpStatus statusCode = response.getStatusCode();
		log.debug("Response Satus Code: " + statusCode);

		if (statusCode != HttpStatus.OK) {
			log.error("Received KO response with status code = "+statusCode);
			return new ResponseEntity<Object>(response.getBody(), statusCode);
		}
		WeatherInfo info = response.getBody();
		if (info == null) {
			log.debug("Received empty response");
			return new ResponseEntity<Object>(response.getBody(), HttpStatus.NO_CONTENT);
		}
		List<Forecastday> list = info.getForecast().getForecastday();
		List<Hour> hours = new LinkedList<Hour>();

		list.forEach(forecastday -> {
			hours.addAll(forecastday.getHour());
		});
		return new ResponseEntity<Object>(hours, HttpStatus.OK);
	}

	private String getRequestQuery(String zipCode, int noOfDays) {
		StringBuilder sb = new StringBuilder();
		sb.append("?").append(Constant.ZIP_CODE_QUERY_PARAM).append("=").append(zipCode);
		sb.append("&").append(Constant.API_KEY_QUERY_PARAM).append("=")
				.append(env.getProperty(Constant.WEATHER_APP_KEY));
		sb.append("&").append(Constant.DAYS_QUERY_PARAM).append("=").append(noOfDays);
		return sb.toString();
	}

}
