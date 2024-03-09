package com.DatabaseClean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DatabaseCleanApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseCleanApplication.class, args);
	}

}
