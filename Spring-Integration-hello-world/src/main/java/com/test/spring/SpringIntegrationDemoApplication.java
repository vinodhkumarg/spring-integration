package com.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("spring-integration.xml")
public class SpringIntegrationDemoApplication implements ApplicationRunner {

	@Autowired
	private CustomGateway gateway;

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception{
		gateway.print("Spring integration demo");
	}

}

