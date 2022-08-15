
package com.xyzretail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.xyzretail")
public class XyzConfiguration {

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(mysqlDataSource());
		
		return jdbcTemplate;
	}

	
	@Bean("mysqlDataSource")
	public DriverManagerDataSource mysqlDataSource() {
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/shoppingbasket");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("wiley");
		return dataSource;
	}
}

