package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.forms.Signup;

@SpringBootApplication
@Controller
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/signup")
	public String signupGet() {
		return "signup";
	}

	@PostMapping("/signup")
	public String signupPost(@ModelAttribute("signup") Signup signup, Model model) {

		Map<String, String> errors = new HashMap<>();
		if (!signup.isAgree()) {
			errors.put("agree", "You must agree.");
		}
		if (signup.getAge() < 18) {
			errors.put("age", "You must be at least 18.");
		}
		model.addAttribute("errors", errors);

		if (errors.size() > 0) {
			return "signup";
		}
		return "signup-success";
	}

}
