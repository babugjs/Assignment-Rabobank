package com.rabobank.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "com.rabobank.service", "com.rabobank.model", "com.rabobank.response", "com.rabobank.parsers" })
@SpringBootApplication
public class StatementValidatorApplication {

	public static void main(String[] args) {

		SpringApplication.run(StatementValidatorApplication.class, args);
	}

}
