package com.example.library;

import com.example.library.User.User;
import com.example.library.User.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}
	@Bean
	CommandLineRunner run(UserRepository userRepository) {
		return args -> IntStream.rangeClosed(1 ,30).forEach(i->{
			User user = new User();
			user.setUsername("user"+ i);
			user.setEmail("user"+ i +"@mail.com");
			user.setPassword("password");
			userRepository.save(user);
		});
	}
}
