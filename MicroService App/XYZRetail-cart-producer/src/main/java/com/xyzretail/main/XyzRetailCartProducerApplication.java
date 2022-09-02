package com.xyzretail.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class XyzRetailCartProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(XyzRetailCartProducerApplication.class, args);
	}
	
	@Bean
	private RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
