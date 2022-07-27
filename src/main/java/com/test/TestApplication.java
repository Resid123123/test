package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) throws ClassNotFoundException {
		SpringApplication.run(TestApplication.class, args);
		Class.forName("com.mysql.cj.jdbc.Driver");
	}

}
