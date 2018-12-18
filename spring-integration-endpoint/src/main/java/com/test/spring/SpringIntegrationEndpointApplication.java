package com.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationEndpointApplication implements ApplicationRunner {

    @Autowired
    @Qualifier("inputChannel")
    DirectChannel inputChannel;
    @Autowired
    @Qualifier("outputChannel")
    DirectChannel outputChannel;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationEndpointApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Register a message handler
        outputChannel.subscribe(new MessageHandler() {

            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                // create a service & invoke a print method
                System.out.println(message.getPayload());
            }
        });

        //java8 lambda
//		channel.subscribe((message)->{
//			new PrintService().print((Message<String>) message);
//		});

        // message with message builder
        Message<String> message1 = MessageBuilder.withPayload("Spring Integration message from channel").setHeader("foo", "bar").build();

        // send the message to service component
        inputChannel.send(message1);

    }
}
