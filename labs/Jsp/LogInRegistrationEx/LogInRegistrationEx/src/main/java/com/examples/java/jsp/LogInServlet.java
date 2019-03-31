package com.examples.java.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogInServlet {
	public void init()
	{
		System.out.println("EmployeeAuthenticate Servlet Initialized..");
	}
	
	public void doGet(HttpServletRequest request,  HttpServletResponse response) throws IOException, ServletException
	{
		this.doPost(request, response);
	}
	
	/*
	 * Called for every HTTP request
	 */
	public void doPost(HttpServletRequest request,  HttpServletResponse response) throws IOException, ServletException
	{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		String userName1 = (String) session.getAttribute("userName");
		String password1 = (String) session.getAttribute("password");
		response.setContentType("text/html");
		// Output stream to write data into HTTP response
		PrintWriter out = response.getWriter();
	
		if(userName.equals(userName1) && password.equals(password1))
		{
			
			// Forwards the request to employee list servlet
			 RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			 rd.forward(request, response);
		}
		else {
			response.sendError(500, "Login Failed");

		}
	
	}
	
	public void destroy()
	{
		System.out.println("EmployeeAuthenticate Servlet Destroyed...");		
	}

}
