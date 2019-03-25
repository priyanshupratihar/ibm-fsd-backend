package com.examples.spring.employeeApp;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.examples.spring.employeeApp.Employee;
import com.examples.spring.employeeApp.EmployeeManage;

public class EmployeeMenu {

	public static void main(String[] args) throws  ClassNotFoundException {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		//EmployeeManage empManage=new EmployeeManage();
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("employeeApp-config.xml");

		EmployeeManage empManage = (EmployeeManage) context.getBean("service");
		while(true) {
			
			
			System.out.println("\n");
			System.out.println("---- Operations with MySql Database ----");
			System.out.println("Press '1' - Insert into database");
			System.out.println("Press '2' - display from database");
			System.out.println("Press '3' - delete from database");
			System.out.println("Press '4' - update from database");
			System.out.println("Press '5' - Searching from database");
			System.out.println("Press '6' - Employee Statistics from database");
			
			System.out.println("Press '7' -  Exit");
			System.out.println("\n");
			System.out.println("Enter Your Option : ");
			int	type=sc.nextInt();
		 switch(type){
		 case 1:
			 empManage.addEmp();
			 break;
			 
		 case 2:
			 empManage.viewEmp();
			 break;
			 
		 case 3:
			 empManage.deleteEmp();
			 break;
			 
		 case 4:
			 empManage.editEmp();
			 break;
			 
		 case 5:
			 empManage.serchEmp();
			 break;
			 
		 case 6:
			 empManage.statisticsEmp();
			 break;
			
		case 7:
			System.exit(0);
			
		
		}
		}
	}

}