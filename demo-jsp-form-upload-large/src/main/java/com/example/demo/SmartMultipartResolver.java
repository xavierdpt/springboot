package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.support.StandardServletMultipartResolver;

public class SmartMultipartResolver extends StandardServletMultipartResolver {
	@Override
	public boolean isMultipart(HttpServletRequest request) {
		if ("1".equals(request.getHeader("X-Large-Upload"))) {
			return false;
		}
		return super.isMultipart(request);
	}

}
