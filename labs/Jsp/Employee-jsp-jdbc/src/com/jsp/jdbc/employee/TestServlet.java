package com.jsp.jdbc.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	
   @Resource(name="jdbc/web_employee_management")
   private DataSource dataSource;
	
	// Get DataSource
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/plain");
		
	
		try {
			System.out.println("abc");
			Connection conn=dataSource.getConnection();
			Statement stmt=conn.createStatement();
			String sql="select * from employee";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				String name=rs.getString("name");
				out.println(name);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
