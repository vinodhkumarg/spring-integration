package com.test.spring.service;

import java.util.Map.Entry;

import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

public class NumbericPrintService {

	public void print(Message<?> message) {
//		throw new RuntimeException("this is error...");
		// return the message payload
		System.out.println("numeric print service "+message.getPayload().toString());
		
	}

}
