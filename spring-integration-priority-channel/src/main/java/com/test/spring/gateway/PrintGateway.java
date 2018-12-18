package com.test.spring.gateway;

import java.util.concurrent.Future;

import org.springframework.messaging.Message;

public interface PrintGateway {

	public Future<Message<String>> print1(Message<?> String);

}
