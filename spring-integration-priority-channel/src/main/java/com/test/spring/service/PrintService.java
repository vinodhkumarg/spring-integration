package com.test.spring.service;

import java.util.Map.Entry;

import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

public class PrintService {

	public Message<String> print(Message<String> message) {
		
		// return the message payload
		System.out.println(message.getPayload());
		int messageNumber = (int) message.getHeaders().get("messageNumber");
		return MessageBuilder.withPayload("sending a reply for a message : " + messageNumber).build();
	}

}
