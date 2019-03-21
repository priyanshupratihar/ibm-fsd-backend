package com.example.java.collection;
import java.util.*;
public class CollectionHashEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set employees=new HashSet(); 
		employees.add(new Employee("abc",22,"fsd",25000, "male"));
		employees.add(new Employee("xyz",21,"fsd",35000, "female"));
		employees.add(new Employee("ghi",21,"fsd",75000, "male"));
		//System.out.println(employees);
		for(Object emp:employees) {
			System.out.println(emp.hashCode());
		}
		
	}

}
