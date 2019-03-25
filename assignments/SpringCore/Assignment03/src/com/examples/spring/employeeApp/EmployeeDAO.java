package com.examples.spring.employeeApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	 static String JDBC_DRIVER;
	 static String DB_URL;
	 static String USER;
	 static String PASS;

	 Connection conn = null;
	 PreparedStatement pstmt = null;
	 ResultSet rs = null;
	 
	 public EmployeeDAO() {
		 
	 }
	 public EmployeeDAO(String driver, String url, String user, String pass) {
			JDBC_DRIVER = driver;
			DB_URL = url;
			USER = user;
			PASS = pass;
			
			try {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("connecting to db ....");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	 }
	
	 
	public int addIntoDB(Employee emp) {
		// TODO Auto-generated method stub
		
		
		
		
		int status = 0;
		String insertSql = "insert into employee (eid,name,salary,age,dept) values(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(insertSql);
			pstmt.setString(1, emp.getEid());
			pstmt.setString(2, emp.getName());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setInt(4, emp.getAge());
			pstmt.setString(5, emp.getDept());
	
			status = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error into addIntoDB");
			e.printStackTrace();
		}
		return status;
	
	}
	public List<Employee> retriveEmpFromDB() {
		// TODO Auto-generated method stub
		List<Employee> empList = new ArrayList<>();
		try {
			String selectRetrive = "select eid,name,age,dept,salary from employee";
			pstmt = conn.prepareStatement(selectRetrive);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				String eid = rs.getString("eid");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String dept = rs.getString("dept");
				int salary = rs.getInt("salary");
				Employee emp = new Employee(eid,name,salary,age,dept);
				

				empList.add(emp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
		
	}
	public List<Employee> empRecord(String deleteEid) {
		// TODO Auto-generated method stub
		List<Employee> empList = new ArrayList<>();
		try {
			String selectDelete = "select eid,name,age,dept,salary from employee where eid='"+ deleteEid +"' ";
			pstmt = conn.prepareStatement(selectDelete);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				String eid = rs.getString("eid");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String dept = rs.getString("dept");
				int salary = rs.getInt("salary");
				Employee emp = new Employee(eid,name,salary,age,dept);
				

				empList.add(emp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
		
	}
	public int deleteEmpFromDB(String deleteEid) {
		// TODO Auto-generated method stub
		int status = 0;
		try {
			String deleteSql = "delete from employee where eid='"+ deleteEid +"'";
			pstmt = conn.prepareStatement(deleteSql);
			//pstmt.setInt(1, empID);

			status = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}
	public int updateName(String editEid,String updatedName) {
		// TODO Auto-generated method stub
		int status = 0;
		try {
			String updateNameSql = "update employee set name='"+ updatedName +"' where eid='"+ editEid +"'";
			pstmt = conn.prepareStatement(updateNameSql);

			status = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
		
	}
	public int updateSalary(String editEid, int updatedSalary) {
		// TODO Auto-generated method stub
		int status = 0;
		try {
			String updateSalarySql = "update employee set salary='"+ updatedSalary +"' where eid='"+ editEid +"'";
			pstmt = conn.prepareStatement(updateSalarySql);

			status = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}
	public int updateDept(String editEid, String updatedDept) {
		// TODO Auto-generated method stub
		int status = 0;
		try {
			String updateDeptSql = "update employee set dept='"+ updatedDept +"' where eid='"+ editEid +"'";
			pstmt = conn.prepareStatement(updateDeptSql);

			status = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}
	public List<Employee> searchByEid(String searchEid) {
		// TODO Auto-generated method stub
		
		List<Employee> empList = new ArrayList<>();
		try {
			String searchEidSql = "select eid,name,age,dept,salary from employee where eid='"+ searchEid +"' ";
			pstmt = conn.prepareStatement(searchEidSql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				String eid = rs.getString("eid");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String dept = rs.getString("dept");
				int salary = rs.getInt("salary");
				Employee emp = new Employee(eid,name,salary,age,dept);
				

				empList.add(emp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}
	public List<Employee> searchByName(String searchName) {
		// TODO Auto-generated method stub
		List<Employee> empList = new ArrayList<>();
		try {
			String searchNameSql = "select eid,name,age,dept,salary from employee where name='"+ searchName +"' ";
			pstmt = conn.prepareStatement(searchNameSql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				String eid = rs.getString("eid");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String dept = rs.getString("dept");
				int salary = rs.getInt("salary");
				Employee emp = new Employee(eid,name,salary,age,dept);
				

				empList.add(emp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}
	public List<Employee> searchByDept(String searchDept) {
		// TODO Auto-generated method stub
		List<Employee> empList = new ArrayList<>();
		try {
			String searchDeptSql = "select eid,name,age,dept,salary from employee where dept='"+ searchDept +"' ";
			pstmt = conn.prepareStatement(searchDeptSql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				String eid = rs.getString("eid");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String dept = rs.getString("dept");
				int salary = rs.getInt("salary");
				Employee emp = new Employee(eid,name,salary,age,dept);
				

				empList.add(emp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}
	public List empByAge(int i) {
		// TODO Auto-generated method stub
		List empIdList = new ArrayList();
		try {
			String sql = "select eid from employee where age>?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, i);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String eid = rs.getString("eid");
				empIdList.add(eid);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empIdList;
	}
}
