package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.dao.MyDao;

@Configuration
@ComponentScan(basePackages = "com.example")
public class SpringBootConfig {
	
	@Bean
	public MyDao myDao() {
		return new MyDao();
	}
	
//	@Bean
//	public DatabaseConfig databaseConfig() {
//		return new DatabaseConfig();
//	}
}
