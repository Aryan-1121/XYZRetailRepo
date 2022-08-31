package com.xyzretail.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.xyzretail")
@EntityScan(basePackages = "com.xyzretail.bean")
@EnableJpaRepositories(basePackages = "com.xyzretail.model.persistence")
public class CustomerServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
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
