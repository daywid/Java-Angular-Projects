package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// ApplicationContext ctx = 
		SpringApplication.run(DemoApplication.class, args);

		// MyController controller = (MyController) ctx.getBean("MyController");

		// controller.hello();
	}

}