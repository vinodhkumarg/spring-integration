package com.test.spring;

import com.test.spring.gateway.PrintGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import java.util.concurrent.ExecutionException;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationHeaderValueRouterApplication implements ApplicationRunner {

    @Autowired
    PrintGateway printGateway;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationHeaderValueRouterApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws InterruptedException, ExecutionException {

        for (int i = 0; i < 10; i++) {
            Message<?> message = MessageBuilder.withPayload(i).setHeader("routeHeader2", "string").setHeader("routeHeader1", "int").build();
            System.out.println("sending message " + i);
            this.printGateway.print1(message);
        }

    }
}
