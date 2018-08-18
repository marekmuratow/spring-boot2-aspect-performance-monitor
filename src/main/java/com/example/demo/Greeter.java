package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class Greeter {

	public void greet() {
		System.out.println("Greeting from a Service");
	}
	
}
