package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@Controller
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		return "mypage";
	}

	@PostMapping("/submitform")
	public ModelAndView submitform(@RequestParam("name") String name, @RequestParam("age") Integer age) {
		ModelAndView mav = new ModelAndView("mypage");
		mav.getModel().put("name", name);
		mav.getModel().put("age", age);
		return mav;
	}

}
