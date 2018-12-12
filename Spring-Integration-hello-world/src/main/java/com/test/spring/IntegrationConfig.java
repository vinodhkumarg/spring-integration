package com.test.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.ServiceActivator;

@Configuration
public class IntegrationConfig {

	@Gateway
	@ServiceActivator
	public void test() {
		
	}
}
