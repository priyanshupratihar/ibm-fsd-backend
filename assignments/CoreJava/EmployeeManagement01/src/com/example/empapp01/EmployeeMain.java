package com.example.empapp01;

import java.util.Scanner;
import java.util.concurrent.Callable;

public class EmployeeMain {
	
	public static void main(String args[]) {
		EmployeeManager obj=new EmployeeManager();
		int ch;
		Scanner sc=new Scanner(System.in);
		while(true) {
		System.out.println("1.Add Employee");
		System.out.println("2. Edit Employee");
		System.out.println("3. Delete Employee");
		System.out.println("4. Display Details");
		System.out.println("5. Statistics");
		System.out.println("6.Exit");
		System.out.println("7.Import Employee");
		System.out.println("8.Export Employee");
		System.out.println("9.Insert into database");
		System.out.println("10.Show all from database");
		System.out.println("11.Delete from database");
		System.out.println("12.Update Emloyee in database");
		System.out.println("13.Show Statistics from database");
		System.out.println("Enter Your Choice 1,2,3,4,5,6:");
		ch=sc.nextInt();
		switch(ch) {
		case 1:obj.AddEmployee();
		break;
		case 2:
			int id;
			System.out.println("Enter The Employee Id You Want To Edit:");
			id=sc.nextInt();
			obj.EditEmployee(id);
			break;
		case 3:
			int idD;
			System.out.println("Enter The Id You Want To Delete:");
			idD=sc.nextInt();
			obj.DeleteEmployee(idD);
			break;
		case 4:obj.display();
		break;
		
		case 5:obj.statistics();
		break;
		case 6:System.exit(0);
		break;
		case 7:
			Callable<Boolean> importThread=new Callable<Boolean>() {
			@Override
			public Boolean call() {
				System.out.println();
				//Thread.sleep(1000);
				obj.bulkImport();
				return true;
			}
		};
		break;
		case 8:obj.employeeExport();
		break;
		case 9:try {
				obj.insertIntoDatabase();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		case 10:obj.showFromDatabase();
		break;
		case 11:try {
				obj.deleteFromDatabase();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		case 12:
			int editId;
			//.nextLine();
			System.out.println("Enter The Employee Id You Want To Edit:");
			editId=sc.nextInt();
			//System.out.println(editId);
			
			try {
				obj.editEmployeeInDatabase(editId);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			break;
		case 13:
			try {
				obj.employeeStatisticsFromDatabase();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;	
			//obj.editEmployeeInDatabase();
		default: System.out.println("Wrong Choice");
		}
	}
	}

}
