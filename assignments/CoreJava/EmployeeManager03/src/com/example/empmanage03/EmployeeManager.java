package com.example.empmanage03;

import java.util.Scanner;
import java.util.TreeMap;

public class EmployeeManager {
	
	TreeMap <Integer,Employee> obj =new <Integer,Employee> TreeMap(); 
	Scanner sc=new Scanner(System.in);
	public void AddEmployee() {
		
		String name,loc,dept;
		int id,age;
		int Salary;
		
		System.out.println("Enter The Employee Name:");
		name=sc.next();
		System.out.println("Enter The Employee Id:");
		id=sc.nextInt();
		System.out.println("Enter The Employee Location:");
		loc=sc.next();
		System.out.println("Enter The Employee Department:");
		dept=sc.next();
		System.out.println("Enter The Employee Age:");
		age=sc.nextInt();
		System.out.println("Enter The Employee Salary:");
		Salary=sc.nextInt();
		obj.put(id, new Employee(name,id,age,loc,dept,Salary));
		}
	
	
	public boolean SearchEmpl(int id) {
		if(obj.containsKey(id)) {
			return true;
		}
		return false;
	}
	
	public void DeleteEmployee(int id) {
		if(SearchEmpl(id)) {
			System.out.println("Employee Deleted:"+obj.remove(id));
		}
		else {
			System.out.println("Data Not Found");
		}
	}
	
	public void display() {
		
		
		System.out.println("Id:\t\t Name:\t\t Location:\t\t Salary:");
		for(Object O:obj.keySet()) {
			System.out.format("%d\t\t %s\t\t %s\t\t %d",obj.get(O).getId(),obj.get(O).getName(),obj.get(O).getLocation(),obj.get(O).getSalary());
			System.out.println();
		}
	}
	
	public void EditEmployee(int id) {
		
		if(SearchEmpl(id)) {
			int ch;
			while(true) {
				System.out.println("1.Edit Name:");
				System.out.println("2. Edit Location:");
				
				System.out.println("3. Edit Salary");
				System.out.println("4.Back To The Main Menu");
				System.out.println("Enter Your Choice 1,2,3,4:");
				ch=sc.nextInt();
				switch(ch) {
				case 1:
					String name;
					System.out.println("Enter The Updated Name:");
					name=sc.next();
					obj.get(id).setName(name);
					break;
				case 2:
					String loc;
					System.out.println("Enter The Updated Location:");
					loc=sc.next();
					obj.get(id).setLocation(loc);
					break;
					
				
				case 3:
					int sal;
					System.out.println("Enter The Updated Salary:");
					sal=sc.nextInt();
					obj.get(id).setSalary(sal);
					break;
									
				
				case 4:return;
				
				default:System.out.println("Enter valid Choice");
					
				}
			}
		}
		else {
			System.out.println("Employee Not Found");
		}
		
	}
	
		
	
		
public void statistics() {
	int ch;
	while(true) {
		System.out.println("1.Show By Department");
		System.out.println("2. Show By Location");
		System.out.println("3.Search Employee Having Salary Less Than 25000");
		System.out.println("4.Search Employee Having Salary Greater Than 25000");
		System.out.println("5.Back To Main Menu");
		System.out.println("Enter Your Choice 1,2,3,4,5:");
		ch=sc.nextInt();
		switch(ch) {
		
		case 1:System.out.println("Enter The Department:");
			String dep=sc.next();
			TreeMap <Integer,Employee> D=new <Integer,Employee>TreeMap();
			for(Object o:obj.keySet()) {
				if(obj.get(o).getDepartment().equals(dep)) {
					D.put(obj.get(o).getId(),obj.get(o));
				}
			}
			System.out.println("Id:\t\t Name:\t\t Location:\t\t Salary:");
			for(Object O:D.keySet()) {
				System.out.format("%d\t\t %s\t\t %s\t\t %d",obj.get(O).getId(),obj.get(O).getName(),obj.get(O).getLocation(),obj.get(O).getSalary());
				System.out.println();
			}
			break;
			
		case 2: 
			System.out.println("Enter The Location:");
			String loc=sc.next();
		TreeMap <Integer,Employee> L=new <Integer,Employee>TreeMap();
		
		
		for(Object o:obj.keySet()) {
			if(obj.get(o).getDepartment().equals(loc)) {
				L.put(obj.get(o).getId(),obj.get(o));
			}
		}
		
		System.out.println("Id:\t\t Name:\t\t Location:\t\t Salary:");
		for(Object O:L.keySet()) {
			System.out.format("%d\t\t %s\t\t %s\t\t %d",obj.get(O).getId(),obj.get(O).getName(),obj.get(O).getLocation(),obj.get(O).getSalary());
			System.out.println();
		}
		break;
		
		
		case 3:TreeMap <Integer,Employee> LTS=new <Integer,Employee>TreeMap();
		for(Object o:obj.keySet()) {
			if(obj.get(o).getSalary()<25000) {
				LTS.put(obj.get(o).getId(),obj.get(o));
			}
		}
		for(Object O:LTS.keySet()) {
			System.out.format("%d\t\t %s\t\t %s\t\t %d",obj.get(O).getId(),obj.get(O).getName(),obj.get(O).getLocation(),obj.get(O).getSalary());
			System.out.println();
		}
			break;
			
		case 4:
			TreeMap <Integer,Employee> GTS=new <Integer,Employee>TreeMap();
			for(Object o:obj.keySet()) {
				if(obj.get(o).getSalary()>25000) {
					GTS.put(obj.get(o).getId(),obj.get(o));
				}
			}
			for(Object O:GTS.keySet()) {
				System.out.format("%d\t\t %s\t\t %s\t\t %d",obj.get(O).getId(),obj.get(O).getName(),obj.get(O).getLocation(),obj.get(O).getSalary());
				System.out.println();
			}
				break;
				
		case 5:
			return;
			
	default:System.out.println("Wrong Choice");
			}
			
		}
	
}

}
