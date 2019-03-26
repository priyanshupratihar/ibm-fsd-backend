package com.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeServlet extends HttpServlet{

	public void init()
    {
        System.out.println("Sevlet Initialized");
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("Getting Get method Called");
        this.doPost(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
    	HttpSession session=req.getSession();
    	System.out.println("Session id: "+session.getId());
    	
    	
         String firstName= req.getParameter("firstName");
         String lastName= req.getParameter("lastName");
         session.setAttribute("firstName", firstName);
         session.setAttribute("lastName", lastName);
         
        resp.setContentType("text/html");
        //resp.setIntHeader("refresh", 5);
        System.out.println("Service method invoked");
        PrintWriter outs=resp.getWriter();
        
        outs.println("<!DOCTYPE html>");
        outs.println("<html><body>");
        outs.println("<h1>Registration Succesfull</h1>");
        outs.println("<h1>FirstName: "+firstName+"</h1>");
        outs.println("<h1>LastName: "+lastName+"</h1>");
        outs.println("</body></html>");
    
        System.out.println("Servlet Invoked!!!!!!");
  
        outs.println("<i><h2>Today's Date : </h2></i>"+LocalDate.now());
    }
    
  
        
        

    public void destroy()
    {
        System.out.println("Servlet Destroyed");
    }

	
}
