package com.test.spring;

import com.test.spring.gateway.PrintGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.concurrent.ExecutionException;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationCustomRouterApplication implements ApplicationRunner {

    @Autowired
    PrintGateway printGateway;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationCustomRouterApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws InterruptedException, ExecutionException {

        for (int i = 0; i < 10; i++) {
            Message<?> message = MessageBuilder.withPayload(i).build();
            System.out.println("sending message " + i);
            this.printGateway.print1(message);
        }

    }
}
