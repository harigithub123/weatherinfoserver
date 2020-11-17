package com.innovect.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class WeatherForecastAppConfig extends WebMvcConfigurerAdapter {
   @Autowired
   WeatherServiceInterceptor serviceInterceptor;

   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(serviceInterceptor);
   }
}