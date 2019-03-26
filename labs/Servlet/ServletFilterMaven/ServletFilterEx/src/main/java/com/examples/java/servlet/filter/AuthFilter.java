package com.examples.java.servlet.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthFilter implements Filter{

	public void init(FilterConfig config) {
		System.out.println("Auth filter initialized..");
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		

		String userName=(String)request.getParameter("userName");
		if(userName!=null) {
			System.out.println("Invalid User: "+userName);
			chain.doFilter(request, response);
		}
		else {
			response.setContentType("text/html");
			PrintWriter out= response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html><body><h1>Auth successful</h1></body></html>");
			out.println("Current date: "+LocalDate.now());
		}
	}

}
