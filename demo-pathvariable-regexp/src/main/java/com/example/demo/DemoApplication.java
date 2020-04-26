package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("{uid:\\d+}/hello")
	public String hello(@PathVariable("uid") String uid) {
		return "Hello user  " + uid;
	}

	@GetMapping("{notanid}/*")
	public String notanid(@PathVariable("notanid") String notanid) {
		return "'" + notanid + "' is not a valid user id";
	}

}
