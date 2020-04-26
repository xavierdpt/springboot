package com.example.demo;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping(value = "/hello", produces = { MediaType.TEXT_PLAIN_VALUE })
	public String hello(@RequestParam Map<String, String> params) {
		StringBuilder sb = new StringBuilder();
		sb.append("Here are all request parameters:\n");
		params.forEach((key, value) -> {
			sb.append(" - " + key + " = " + value + "\n");
		});
		return sb.toString();
	}

}
