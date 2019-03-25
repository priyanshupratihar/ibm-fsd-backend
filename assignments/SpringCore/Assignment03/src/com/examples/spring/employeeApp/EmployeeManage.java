package com.examples.spring.employeeApp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.examples.spring.employeeApp.Employee;

@SuppressWarnings("unchecked")
public class EmployeeManage {
	Employee emp=null;
	
	EmployeeDAO dao;
	public EmployeeManage() {
		
	}
	public EmployeeManage(EmployeeDAO dao) {
		super();
		this.dao = dao;
	}
	
	static Scanner sc=new Scanner(System.in);

	public void addEmp() throws ClassNotFoundException{
		// TODO Auto-generated method stub
		
		try {
			System.out.println("enter employee ID: ");
			String eid=sc.next();
			
			System.out.println("enter employee name: ");
			String name=sc.next();
			
			System.out.println("enter employee salary: ");
			int salary=sc.nextInt();
	//		while(true) {
	//			try {
	//				throw new CustomException(salary); 
	//				
	//			}
	//			catch(CustomException ex) {
	//				//System.out.println(ex.getMessage());
	//				if(CustomException.sl==0)
	//					break;
	//				System.out.println("enter employee salary: ");
	//				salary=sc.nextInt();
	//			}
	//		}
			
			System.out.println("enter employee Age: ");
			int age=sc.nextInt();
			
			
			System.out.println("enter employee depertment: ");
			String dept=sc.next();
			
			emp=new Employee(eid,name,salary,age,dept);
			 
			if(emp==null) {
				return;
			}
			else {
				
				int status=dao.addIntoDB(emp);
				if(status>0) {
					System.out.println("Employee successfully added");
				}else {
					System.out.println("Employee does not added");
				}
			
			}
		}catch(Exception ex) {
			System.out.println("error into service");
			ex.printStackTrace();
		}
	}
	public void viewEmp() {
		// TODO Auto-generated method stub
		List<Employee> empList=dao.retriveEmpFromDB();
		if(empList.isEmpty())
			System.out.println("No employee records available..!!");
		else
			showEmp(empList);
	}
	private void showEmp(List<Employee> empList) {
		// TODO Auto-generated method stub
		System.out.println("\t Emp ID \t Emp Name \t Emp salary \t Emp Age \t Emp Dept ");
		for(Employee emp:empList) {
			
			System.out.format("\t    %s \t      %s \t      %d \t      %d \t        %s ",emp.getEid(),emp.getName(),emp.getSalary(),emp.getAge(),emp.getDept());
			System.out.println("\n");
		}
	}
	public void deleteEmp() {
		// TODO Auto-generated method stub
		System.out.println("Enter Emp ID for delete");
		String deleteEid=sc.next();
		
		List<Employee> deleteEmp=dao.empRecord(deleteEid);
		if(deleteEmp==null) {
			System.out.println("No employee present with ID: "+deleteEid);
		}
		else {
			System.out.println("Deletable Record : " );
			showEmp(deleteEmp);
			
			System.out.println("Are you confirm to delete (y/n) : ");
			String confirm=sc.next();
			if(confirm.equals("y")) {
				System.out.println("into 'y'");
				int status = dao.deleteEmpFromDB(deleteEid);
				if(status>0)
					System.out.println("Employee deleted.");
				else
					System.out.println("Employee does not deleted !!");
			}
		}
	}
	public void editEmp() {
		// TODO Auto-generated method stub
		System.out.println("Enter Employee ID to Update Record : ");
		String editEid=sc.next();
		
		List<Employee> editEmp=dao.empRecord(editEid);
		if(editEmp==null) {
			System.out.println("No employee present with ID: "+editEid);
		}
		else {
			System.out.println("Editable Record : " );
			showEmp(editEmp);
			
			System.out.println("Please choose correct option ");
			while(true) {
				System.out.println("\n 1. edit name \n 2. edit salary \n 3. edit department \n 4. Exit");
				int editType=sc.nextInt();
				
				switch(editType) {
				case 1:
					System.out.println("Enter updated name : ");
					String updatedName=sc.next();
					
					int statusName=dao.updateName(editEid,updatedName);
					if(statusName>0)
						System.out.println("Employee NAME SUCCESSFULLY update.");
					else
						System.out.println("Employee name does not update !!");
					break;
					
				case 2:
					System.out.println("Enter updated salary : ");
					int updatedSalary=sc.nextInt();
					
					int statusSalary=dao.updateSalary(editEid,updatedSalary);
					if(statusSalary>0)
						System.out.println("Employee Salary SUCCESSFULLY update.");
					else
						System.out.println("Employee Salary does not update !!");
					break;
					
				case 3:
					System.out.println("Enter updated department : ");
					String updatedDept=sc.next();
					
					int statusDept=dao.updateDept(editEid,updatedDept);
					if(statusDept>0)
						System.out.println("Employee Department SUCCESSFULLY update.");
					else
						System.out.println("Employee Department does not update !!");
					break;
					
				case 4:
					return;
				}
				
			}
		}
		}
	
	public void serchEmp() {
		// TODO Auto-generated method stub
		System.out.println("Please choose correct option ");
		while(true) {
			System.out.println("\n 1. search by Emp ID \n 2. search by Emp Name \n 3. search by Department \n 4. Exit");
			int searchType=sc.nextInt();
			
			switch(searchType) {
			case 1:
				System.out.println("Enter employe ID : ");
				String searchEid=sc.next();
				
				List<Employee> statusEid=dao.searchByEid(searchEid);
				if(statusEid==null) {
					System.out.println("Employee does not exist with Eid :" + searchEid);
				}
				else {
					showEmp(statusEid);
				}
				break;
				
			case 2:
				System.out.println("Enter employe Name : ");
				String searchName=sc.next();
				
				List<Employee> statusName=dao.searchByName(searchName);
				if(statusName==null) {
					System.out.println("Employee does not exist with Name :" + searchName);
				}
				else {
					showEmp(statusName);
				}
				break;
				
			case 3:
				System.out.println("Enter Department Name : ");
				String searchDept=sc.next();
				
				List<Employee> statusDept=dao.searchByDept(searchDept);
				if(statusDept==null) {
					System.out.println("Employee does not exist with Department :" + searchDept);
				}
				else {
					showEmp(statusDept);
				}
				break;
			
			case 4:
				return;
			}
			
		}
	}
	public void statisticsEmp() {
		// TODO Auto-generated method stub
		List empIdListByAge = dao.empByAge(30);
		if(empIdListByAge==null) {
			System.out.println("Employee does not exist with Age > 30 " );
		}
		else {
			System.out.println("Emp Id With Age > 30 : "+ empIdListByAge);
		}
	}
	
	public void exportEmp() {
		// TODO Auto-generated method stub
		List<Employee> empList = dao.retriveEmpFromDB();
		
		try {
			File file = new File("C:\\Users\\PRIYANSHUPRATIHAR\\Desktop\\EmpManagement.txt");
			PrintWriter pw = new PrintWriter(file);
			
			for(Employee emp : empList) {
				
				pw.printf("%s,%s,%d,%d,%s%n", emp.getEid(),emp.getName(),emp.getSalary(),emp.getAge(),emp.getDept());
			}
			pw.close();
			System.out.println("Export Successfull");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void importEmp() {
		// TODO Auto-generated method stub
		int empCount = 0;
		try {
			File file = new File("C:\\\\Users\\\\PRIYANSHUPRATIHAR\\\\Desktop\\\\EmpManagement.txt");
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
			
				String word[] = sc.nextLine().split(",");
				String eid = word[0];
				String name=word[1];
				int salary = Integer.parseInt(word[2]);
				int age = Integer.parseInt(word[3]);
				String dept = word[4];
				
				Employee emp = new Employee(eid,name,salary,age,dept);
				int status = dao.addIntoDB(emp);
				if(status>0)
				empCount++;
			}
			sc.close();
			System.out.println(empCount+" employee(s) imported successfully..");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	

}