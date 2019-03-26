package com.examples.java.servlet.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetingServlet extends HttpServlet {
	
	public void init() {
		System.out.println("init method");
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		System.out.println("get method");
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		System.out.println("service method invoked..");
		PrintWriter out= response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><body><h1>Hello world Maven Servlet Filter Test</></body></html>");
		out.println("Current date: "+LocalDate.now());
	}
	public void destroy() {
		System.out.println("destroy method");
	}
}
