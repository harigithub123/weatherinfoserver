package com.innovect.weather.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	public static ObjectMapper mapper;

	  static {
		  	mapper = new ObjectMapper();
		}

		public static ObjectMapper getJsonMapper() {
			return mapper;
		}
}
