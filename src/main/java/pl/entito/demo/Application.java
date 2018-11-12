package pl.entito.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private GreeterService greeter;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {

		greeter.greet();
	}

	@Autowired
	public void setGreeter(GreeterService greeter) {
		this.greeter = greeter;
	}

}
