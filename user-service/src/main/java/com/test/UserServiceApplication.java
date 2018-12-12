package com.test;

import com.test.model.User;
import com.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication implements ApplicationRunner {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {

		userRepository.save(new User("userFirstName", "userLastName"));
		userRepository.save(new User("userFirstName", "userLastName"));
		userRepository.save(new User("userFirstName", "userLastName"));
		userRepository.save(new User("userFirstName", "userLastName"));
		userRepository.save(new User("userFirstName", "userLastName"));
	}

}

