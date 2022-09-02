package com.xyzretail.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.xyzretail")
@EntityScan(basePackages = "com.xyzretail.bean")
@EnableJpaRepositories(basePackages = "com.xyzretail.persistence")
//@EnableEurekaClient
public class XyzRetailCartProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(XyzRetailCartProducerApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
