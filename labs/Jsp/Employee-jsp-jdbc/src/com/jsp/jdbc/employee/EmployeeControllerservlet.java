package com.jsp.jdbc.employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class EmployeeControllerservlet
 */
@WebServlet("/EmployeeControllerservlet")
public class EmployeeControllerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeDbUtil empDbUtil;
	@Resource(name="jdbc/web_employee_management")
	private DataSource dataSource;
	
	

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			empDbUtil=new EmployeeDbUtil(dataSource);
			
		}catch(Exception e){
			throw new ServletException(e);
		}
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			String theCommand=request.getParameter("command");
			//if command missing
			if(theCommand==null) {
				theCommand="LIST";
			}
			//route to appropiate method
			switch(theCommand) {
			case "LIST":
				listEmployees(request,response);
				break;
			case "ADD":
				addEmployee(request,response);
				
			default:
				listEmployees(request,response);
				
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//String eid=request.getParameter("eid");
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		int salary=Integer.parseInt(request.getParameter("salary"));
		String dept=request.getParameter("dept");
		
		Employee theEmployee=new Employee(name, age, salary, dept);
		EmployeeDbUtil.addEmployee(theEmployee);
		
		listEmployees(request, response);
	}



	private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//get emp from employeeDbutil
		List<Employee> employees=EmployeeDbUtil.getEmployees();
		request.setAttribute("EMPLOYEE_LIST", employees);
		RequestDispatcher rd=request.getRequestDispatcher("/list-employee.jsp");
		rd.forward(request, response);
	}

}
