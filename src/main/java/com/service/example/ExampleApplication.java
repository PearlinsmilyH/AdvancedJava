package com.service.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ExampleApplication {

	@GetMapping("/")
	public String test(){
		return "hai, example for maven tool";
	}

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

}