package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeansConfig {

	@Bean
	public RestTemplate getRestTemplate() throws HttpClientErrorException {
		RestTemplate res = new RestTemplate();
		if (res.acceptHeaderRequestCallback(null) != null) {
			return res;
		}
		 throw new HttpClientErrorException (HttpStatus.BAD_REQUEST, "CEP inválido!");
		
		
	}
}