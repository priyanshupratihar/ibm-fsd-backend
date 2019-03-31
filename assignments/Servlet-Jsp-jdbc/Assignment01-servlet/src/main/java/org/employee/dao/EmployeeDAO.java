package org.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.employee.model.Employee;
import org.employee.model.User;

public class EmployeeDAO {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/EmployeeManagement_db";
	static final String DB_USER = "root";
	static final String DB_PASS = "";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public EmployeeDAO() {

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int registerUser(User user) {
		String query = "insert into admin(name,email,password) values(?,?,?)";
		int status = 0;
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			
			status = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//
		return status;
	}
	
	public User validateUser(String email, String password) {
		
		User user = null;
		String query = "select name,email from admin where email=? and password=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String name = rs.getString("name");
				String mail = rs.getString("email");
				user = new User(name,mail,password);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public int addEmp(Employee<Integer> emp) {

		int status = 0;
		String insert = "insert into employee (eid,name,salary,age,dept) values(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, emp.getEid());
			pstmt.setString(2, emp.getName());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setInt(4, emp.getAge());
			pstmt.setString(5, emp.getDept());
			

			status = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public List<Employee<Integer>> viewEmp() {

		List<Employee<Integer>> empList = new ArrayList<>();
		try {
			String select = "select eid,name,salary,age,dept from employee";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				String id = rs.getString("eid");
				String name = rs.getString("name");
				int salary = rs.getInt("salary");
				int age = rs.getInt("age");				
				String department = rs.getString("dept");
				
				Employee<Integer> emp = new Employee<>(id,name,salary,age, department);
				

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

	public Employee<Integer> findEmp(String empID) {
		Employee<Integer> emp = null;
		try {
			String find = "select eid,name,salary,age,dept from employee where eid=?";
			pstmt = conn.prepareStatement(find);
			pstmt.setString(1, empID);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				String id = rs.getString("eid");
				String name = rs.getString("name");
				int salary = rs.getInt("salary");
				int age = rs.getInt("age");
				String department = rs.getString("dept");
				
				emp = new Employee<>(id,name,salary, age, department);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return emp;

	}

	public int updateEmp(Employee<Integer> emp) {
		int status = 0;
		try {
			String update = "update employee set name=?,salary=?,age=?,dept=? where eid=?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, emp.getName());
			pstmt.setInt(2, emp.getSalary());
			pstmt.setInt(3, emp.getAge());			
			pstmt.setString(4, emp.getDept());
			
			pstmt.setString(5, emp.getEid());

			status = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return status;
	}

	public int deleteEmp(String empID) {
		int status = 0;
		try {
			String delete = "delete from employee where eid=?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setString(1, empID);

			status = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return status;
	}

	
	public List<Integer> countEmpByAge(int minAge){
		List<Integer> empIdList = new ArrayList<>();
		try {
			String query = "select id from employee where age>?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, minAge);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("id");
				empIdList.add(id);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empIdList;
	}
	
	public Map<String, Integer> empCountByDept(){
		Map<String, Integer> deptMap = new LinkedHashMap<String, Integer>();
		
		try {
			String query = "select department,count(*) as total from employee group by department order by department";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				String dept = rs.getString("department");
				int total = rs.getInt("total");
				deptMap.put(dept, total);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deptMap;
	}
	
	public Map<String, Integer> maxSalByDept(){
		Map<String, Integer> salMap = new LinkedHashMap<String, Integer>();
		
		try {
			String query = "select department,max(salary) as salary from employee group by department order by department";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				String dept = rs.getString("department");
				int salary = rs.getInt("salary");
				salMap.put(dept, salary);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salMap;
	}
	
	public Map<String, Integer> avgSalDept(){
		Map<String, Integer> avgSalMap = new LinkedHashMap<String, Integer>();
		
		try {
			String query = "select department,avg(salary) as avg from employee group by department order by department";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				String dept = rs.getString("department");
				int avgSal = rs.getInt("avg");
				avgSalMap.put(dept, avgSal);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return avgSalMap;
	}
	
	public void closeConn() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
