package com.jsp.jdbc.employee;

import java.lang.reflect.Executable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmployeeDbUtil {

	
	private static DataSource dataSource;
	
	public EmployeeDbUtil(DataSource theDataSource) {
		 dataSource=theDataSource;
	}
	
	public static List<Employee> getEmployees() throws Exception{
		
		List<Employee> employees=new ArrayList<>();
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			conn=dataSource.getConnection();
			stmt=conn.createStatement();
		String sql="select * from employee order by name";
		stmt=conn.createStatement();
	    rs=stmt.executeQuery(sql);
		while(rs.next()) {
			String eid=rs.getString("eid");
			String name=rs.getString("name");
			int salary=rs.getInt("salary");
			int age=rs.getInt("age");
			String dept=rs.getString("dept");
			
			Employee tempEmp=new Employee(eid,name,salary,age,dept);
			employees.add(tempEmp);
		}
		return employees;
	   }
		
		finally {
		
			rs.close();
			stmt.close();
			conn.close();
		}
   }

	public static void addEmployee(Employee theEmployee) throws SQLException  {

		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			conn=dataSource.getConnection();
			String sql="insert into employee(eid,name,age,salary,dept)"
					+"values(?,?,?,?,?)";
			
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,theEmployee.getEid());
			stmt.setString(2,theEmployee.getName());
			stmt.setInt(3,theEmployee.getAge());
			stmt.setInt(4, theEmployee.getSalary());
			stmt.setString(5, theEmployee.getDept());
			stmt.execute();
		}finally {
			
			rs.close();
			stmt.close();
			conn.close();
		}
		
		
	}

	
}
