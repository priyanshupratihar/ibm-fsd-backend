package com.examples.java.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet{

	public void init()
	{
		
		//Display server config parameters
		
		System.out.println("EmployeeRegistration Servlet Initialized...");
	}
	
	public void doGet(HttpServletRequest request,  HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("Calling GET method");
		this.doPost(request, response);
	}

	
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			
			System.out.println("Session ID: " + session.getId());
			
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			
			session.setAttribute("userName", userName);
			session.setAttribute("password", password);

			// Output stream to write data into HTTP response
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html><body>");
			out.print("<p>Registration Successful.</p>");
			out.println("<p>UserName: " + userName + "</p>");
			out.println("<a href='register.jsp'>home</a>");
			out.println("</body></html>");
		}
	
	public void destroy()
	{
		System.out.println("EmployeeRegistration Servlet Destroyed...");		
	}
}
