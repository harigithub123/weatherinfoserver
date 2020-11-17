package com.innovect.weather.exception;

public class WeatherForecastException extends RuntimeException {
	private int statusCode;
	private String message;
	
	public WeatherForecastException() {
	}
	
	public WeatherForecastException(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
