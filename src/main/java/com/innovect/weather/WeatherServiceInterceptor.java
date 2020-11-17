package com.innovect.weather;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * logging debug message just to make sure that handler is working fine.
 * In future we can add the code to authorize the request etc etc.
 * @author Hari Nale
 *
 */
@Component
@Slf4j
public class WeatherServiceInterceptor implements HandlerInterceptor {
	   @Override
	   public boolean preHandle(
	      HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	      log.debug("request received="+request.getPathInfo());
	      return true;
	   }
	   @Override
	   public void postHandle(
	      HttpServletRequest request, HttpServletResponse response, Object handler, 
	      ModelAndView modelAndView) throws Exception {
		   log.debug("sending reponse with status code ="+response.getStatus());
	   }
	   
	   @Override
	   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
	      Object handler, Exception exception) throws Exception {}
}