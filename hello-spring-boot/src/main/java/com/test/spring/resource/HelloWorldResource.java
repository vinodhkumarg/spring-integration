package com.test.spring.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {
	
	@GetMapping(path="/hello")
	public String greetings() {
		return "hello greetins ----";
	}

}
