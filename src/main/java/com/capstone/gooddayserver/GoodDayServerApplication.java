package com.capstone.gooddayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GoodDayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodDayServerApplication.class, args);
	}

}
