package com.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")

public class SpringIntegrationMessageTemplateApplication implements ApplicationRunner {

    @Autowired
    DirectChannel inputChannel;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationMessageTemplateApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // message with message builder
        Message<String> message1 = MessageBuilder.withPayload("Spring Integration message from channel").setHeader("foo", "bar").build();

        MessagingTemplate messageTemplate = new MessagingTemplate();
        Message returnMessage = messageTemplate.sendAndReceive(inputChannel, message1);
        System.out.println(returnMessage.getPayload());

    }
}
