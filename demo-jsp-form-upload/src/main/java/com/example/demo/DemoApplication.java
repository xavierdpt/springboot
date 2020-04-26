package com.example.demo;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	public ModelAndView submitform(@RequestParam("name") String name, @RequestParam("age") Integer age,
			@RequestParam("myfile") MultipartFile myfile) {
		ModelAndView mav = new ModelAndView("mypage");
		mav.getModel().put("name", name);
		mav.getModel().put("age", age);
		try {
			mav.getModel().put("myfile",
					myfile.getOriginalFilename() + " " + new String(myfile.getBytes(), Charset.forName("UTF-8")));
		} catch (IOException e) {
			mav.getModel().put("myfile", myfile.getOriginalFilename() + " " + "Couldn't get bytes");
		}
		return mav;
	}

}
