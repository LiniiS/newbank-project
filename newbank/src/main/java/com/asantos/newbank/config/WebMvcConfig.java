package com.asantos.newbank.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		
		registry.addResourceHandler("/css/*").addResourceLocations("/resources/static/css/");
		registry.addResourceHandler("/images/*").addResourceLocations("/resources/static/images/");
	}
	
	

}
