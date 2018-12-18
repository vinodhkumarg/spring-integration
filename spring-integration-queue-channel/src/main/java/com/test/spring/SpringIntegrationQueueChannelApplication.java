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
import org.springframework.integration.support.MessageBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationQueueChannelApplication implements ApplicationRunner {

    @Autowired
    PrintGateway printGateway;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationQueueChannelApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws InterruptedException, ExecutionException {
        List<Future<Message<String>>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Message<String> message = MessageBuilder.withPayload("Printing message payload for " + i + " with priority " + i).setHeader("messageNumber", i).setPriority(i).build();
            System.out.println("sending message " + i);
            futures.add(this.printGateway.print1(message));
        }
        System.out.println("traversing futures");
        for (Future<Message<String>> future : futures) {
            System.out.println("future message payload " + future.get().getPayload());
        }
    }
}
