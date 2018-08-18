package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopDemoApplication implements CommandLineRunner {

	private Greeter greeter;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AopDemoApplication.class);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {

		greeter.greet();
	}

	@Autowired
	public void setGreeter(Greeter greeter) {
		this.greeter = greeter;
	}

	

}
