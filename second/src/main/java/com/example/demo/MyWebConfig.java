package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 나는 설정파일
public class MyWebConfig implements WebMvcConfigurer {
	
	//for window
	// static final public String savePath = "c:/upload/";
	
	//for window
	static final public String savePath = "/usr/upload/";

	// <resources mapping="/upload/**" location="file:///c:upload/" />

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// registry.addResourceHandler("/upload/**").addResourceLocations("file:///c:/upload/");
		registry.addResourceHandler("/upload/**").
		addResourceLocations("file:/usr/upload/");
	}

}
