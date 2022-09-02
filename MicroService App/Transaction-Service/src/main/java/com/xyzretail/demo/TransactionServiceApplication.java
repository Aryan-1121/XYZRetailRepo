package com.xyzretail.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.xyzretail.persistence.TransactionDao;


@SpringBootApplication(scanBasePackages = "com.xyzretail")
@EntityScan(basePackages = "com.xyzretail.bean")
@EnableJpaRepositories(basePackages = "com.xyzretail.persistence")
//@EnableEurekaClient
public class TransactionServiceApplication implements CommandLineRunner {

	@Autowired 
	private TransactionDao t;
	
	public static void main(String[] args) {
		SpringApplication.run(TransactionServiceApplication.class, args);
	}

@Override
public void run(String... args) throws Exception {
	// TODO Auto-generated method stub
//	t.findAll();
	System.out.println(t.findAll());
	
	t.deleteAll();
	
	System.out.println(t.findAll());
}

//	@Bean
//	@LoadBalanced
//	public RestTemplate getRestTemplate() {
//		return new RestTemplate();
//	}
	
}
