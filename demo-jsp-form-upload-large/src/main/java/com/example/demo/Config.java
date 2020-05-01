package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;

@Configuration
public class Config {

	@Bean
	public MultipartResolver multipartResolver() {
		return new SmartMultipartResolver();
	}
	
}
