package com.kindredgroup.unibetlivetest;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableScheduling
@EnableBatchProcessing
@EnableWebMvc
public class UnibetLiveTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnibetLiveTestApplication.class, args);
	}

}
