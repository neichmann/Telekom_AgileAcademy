package org.javacream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(BooksApplication.class);
		springApplication.setAdditionalProfiles("dev");
		springApplication.run(args);
	}
}
