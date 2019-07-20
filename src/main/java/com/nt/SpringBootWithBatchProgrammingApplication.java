package com.nt;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBootWithBatchProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithBatchProgrammingApplication.class, args);
	}

}
