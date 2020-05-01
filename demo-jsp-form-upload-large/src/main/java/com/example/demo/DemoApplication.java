package com.example.demo;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String submitform(@RequestParam("myfile") MultipartFile myfile, Model model) {
		model.addAttribute("myfile", myfile.getOriginalFilename() + " " + myfile.getSize());
		return "mypage";
	}

	@PostMapping("/submitform-large")
	public String submitformLarge(HttpServletRequest request, Model model) {

		if (!ServletFileUpload.isMultipartContent(request)) {
			throw new RuntimeException("TODO: Handle this case");
		}

		ServletFileUpload upload = new ServletFileUpload();
		try {
			FileItemIterator it = upload.getItemIterator(request);
			while (it.hasNext()) {
				if (model.containsAttribute("myfile")) {
					throw new RuntimeException("TODO: Handle this case");
				}
				FileItemStream fis = it.next();
				String name = fis.getName();
				long[] size = new long[] { 0 };
				IOUtils.copy(fis.openStream(), new OutputStream() {
					@Override
					public void write(int arg0) throws IOException {
						++size[0];
					}
				});
				model.addAttribute("myfile", name + " " + size[0]);
			}
		} catch (FileUploadException | IOException e) {
			throw new RuntimeException("TODO: Handle this case");
		}

		if (!model.containsAttribute("myfile")) {
			model.addAttribute("myfile", "oups");
		}
		return "mypage";
	}

}
