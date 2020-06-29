package io.kai.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootApiApplication {

	public static void main(String[] args) {
		// first argument is the class where have the main method
		// second is basically the arguments that could have bean pass to the main method
		SpringApplication.run(SpringBootApiApplication.class, args);
	}

}
