package com.service.gradleexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GradleExampleApplication {

	@GetMapping("/")
	public String test(){
		return "hai, example for Gradle tool";
	}

	public static void main(String[] args) {
		SpringApplication.run(GradleExampleApplication.class, args);
	}

}