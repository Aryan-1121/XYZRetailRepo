package com.xyzretail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.xyzretail")
public class JdbcConfiguration {

	@Bean(name="mysqlDataSource")
	public DriverManagerDataSource mySqlDataSource() {
		DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/shoppongbasket");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("wiley");
		return driverManagerDataSource;
		
	}
	
	@Bean(name="jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbc=new JdbcTemplate();
		jdbc.setDataSource(mySqlDataSource());
		return jdbc;
	}
}
