package com.fc.protocol.server.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class PropertiesFileConfig {

	@Bean
	public PropertySourcesPlaceholderConfigurer createPropertySourcesPlaceholderConfigurer() {
		ClassPathResource server = new ClassPathResource("server.properties");
		ClassPathResource zookeeper = new ClassPathResource("zookeeper.properties");
		PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		propertyPlaceholderConfigurer.setLocations(new ClassPathResource[] { server, zookeeper });
		return propertyPlaceholderConfigurer;
	}

}
