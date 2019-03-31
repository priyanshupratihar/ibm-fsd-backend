package org.employee.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.employee.model.Employee;
import org.employee.service.EmployeeService;

/**
 * Servlet implementation class UpdateEmployeeServlet
 */
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String eid = request.getParameter("eid");
		String name = request.getParameter("name").trim();
		int salary = Integer.parseInt(request.getParameter("salary"));
		int age = Integer.parseInt(request.getParameter("age"));
		String dept = request.getParameter("department").trim();
		
		
		Employee<Integer> emp = new Employee<>(eid,name,salary,age,dept);
		EmployeeService service = new EmployeeService();
		
		int status = service.update(emp);
		if(status>=1) {
			response.sendRedirect("EmployeeList.do");
		}
		
	}

}
