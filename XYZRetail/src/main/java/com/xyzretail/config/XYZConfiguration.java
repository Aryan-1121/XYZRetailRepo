package com.xyzretail.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages =  {"com.xyzretail.persistence","com.xyzretail.presentation","com.xyzretail.service"})
public class XYZConfiguration {

}
