package com.xyzretail.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.xyzretail")
@EntityScan(basePackages = "com.xyzretail.bean")
@EnableJpaRepositories(basePackages = "com.xyzretail.model.persistence")
//@EnableEurekaClient
public class CustomerServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	//@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	
}




















//public class CustomerServiceApplication implements CommandLineRunner{
//	@Autowired 
//	private CustomerService customerService;
//	@Autowired
//	private CustomerResource customerResource;
//
//	public static void main(String[] args) {
//		SpringApplication.run(CustomerServiceApplication.class, args);
//
//		
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		customerService.getAllCustomer();
//		customerResource.getAllCustomerResource();
//		
//	}
//
//}
