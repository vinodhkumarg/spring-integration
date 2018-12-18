package com.test.spring.service;

import java.util.Map.Entry;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

public class PrintService {

/*//endpoint consumer which only receives message
	public void print(Message<String> message) {
		//obtain message headers
		MessageHeaders headers = message.getHeaders();
		
		for(Entry<String, Object> entry : headers.entrySet()) {
			System.out.println("header : headerKey = "+ entry.getKey() + "  header value = "+entry.getValue() );
		}
		
		
		//return the message payload
		System.out.println(message.getPayload());
	}
*/
	
	//endpoint consumer which outputs message
		public Message<String> print(Message<String> message) {
			//obtain message headers
			MessageHeaders headers = message.getHeaders();
			
			for(Entry<String, Object> entry : headers.entrySet()) {
				System.out.println("header : headerKey = "+ entry.getKey() + "  header value = "+entry.getValue() );
			}
			
			
			//return the message payload
			System.out.println(message.getPayload());
			return MessageBuilder.withPayload("message from print service as output message").build();
		}

}
