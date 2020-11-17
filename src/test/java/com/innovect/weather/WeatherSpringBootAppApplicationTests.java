package com.innovect.weather;

//@RunWith(MockitoJUnitRunner.class)
public class WeatherSpringBootAppApplicationTests {

	public static final String validZipCodeUri = "/weather/info/get?zip=94111&days=1";
	public static final String invalidZipCodeUri = "http://localhost:8080/weather/info/get?zip=94adasdasdasdasdasdadas111&days=1";
	   
	//@InjectMocks
	//WeatherForecastService weatherService;

	/*@Test
	public void getWeatherDetailsFound() throws Exception {	   
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(validZipCodeUri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   WeatherInfo[] info = mapFromJson(content, WeatherInfo[].class);
	   assertTrue(info.length > 0);
	}
	
	@Test
	public void getWeatherNotDetailsFound() throws Exception {	   
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(invalidZipCodeUri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   WeatherInfo[] info = mapFromJson(content, WeatherInfo[].class);
	   assertTrue(info.length > 0);
	}*/
	
}
