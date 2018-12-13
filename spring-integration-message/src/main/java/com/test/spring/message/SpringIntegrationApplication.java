package com.test.spring.message;

import com.test.spring.message.service.PrintService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //normal message building
//		Map<String, Object> headerMap = new HashMap<>();
//		headerMap.put("HeaderKey", "Header Value or Object");
//		MessageHeaders headers = new MessageHeaders(headerMap);
//		Message<String> message = new GenericMessage<String>("Spring Integration : Message",headers);

        //message with message builder
        Message<String> message1 = MessageBuilder.withPayload("test")
                .setHeader("foo", "bar")
                .build();
        //copy message
        Message<String> message2 = MessageBuilder.withPayload("new message ").copyHeaders(message1.getHeaders())
                .build();


        //send the message to service component
        PrintService service = new PrintService();
        service.print(message1);
        service.print(message2);

    }
}
