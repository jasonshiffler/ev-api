package com.tesla.springboot.evapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;

@SpringBootApplication
@EntityScan(basePackageClasses = {EvApiApplication.class, Jsr310Converters.class})
public class EvApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvApiApplication.class, args);
	}

}
