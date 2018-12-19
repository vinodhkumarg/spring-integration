package com.test.spring.service;

import org.springframework.messaging.Message;

public class DefaultService {
	public void print(Message<?> message) {
		System.out.println("default service"+message.getPayload());
		
	}
}
