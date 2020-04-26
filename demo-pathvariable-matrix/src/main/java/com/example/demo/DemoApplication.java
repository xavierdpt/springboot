package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// http://localhost:8080/john;vegetables=cucumber/hello
	@GetMapping("/{user}/hello")
	public String hello(@PathVariable("user") String user,
			@MatrixVariable("vegetables") String vegetables) {
		return "Hello " + user + ", you like " + vegetables + ".";
	}

}
