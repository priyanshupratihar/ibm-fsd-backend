package com.examples.java.servlet.filter;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoggingFilter implements Filter{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String host=request.getRemoteHost();
		request.getContentType();
		request.getRemotePort();
		System.out.println("request received from: "+host+" at "+LocalDateTime.now());
		
		//deligate the filter
		chain.doFilter(request, response);
	}

}
