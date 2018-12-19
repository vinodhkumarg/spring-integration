package com.test.spring.service;

import java.util.Map.Entry;

import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

public class PrintService {

	public void print(Message<String> message) {
//		throw new RuntimeException("this is error...");
		// return the message payload
		System.out.println(message.getPayload());
		
	}

}
