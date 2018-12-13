package com.test.spring.channel;

import com.test.spring.channel.service.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationApplication implements ApplicationRunner {

	@Autowired
	DirectChannel channel;

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		// Register a message handler
//		channel.subscribe(new MessageHandler() {
//
//			@Override
//			public void handleMessage(Message<?> message) throws MessagingException {
//				// create a service & invoke a print method
//				new PrintService().print((Message<String>) message);
//			}
//		});

		//java8 lambda
		channel.subscribe((message)->{
			new PrintService().print((Message<String>) message);
		});

		// message with message builder
		Message<String> message1 = MessageBuilder.withPayload("Spring Integration message from channel").setHeader("foo", "bar").build();

		// send the message to service component
		channel.send(message1);

	}

}

