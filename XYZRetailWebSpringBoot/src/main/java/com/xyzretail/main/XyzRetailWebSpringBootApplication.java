package com.xyzretail.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages ="com.xyzretail")
public class XyzRetailWebSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(XyzRetailWebSpringBootApplication.class, args);
	}

}
