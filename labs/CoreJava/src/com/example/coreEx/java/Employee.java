package com.example.coreEx.java;
import java.util.*;
public class Employee implements Comparator{
	
	private static int empId;
	private int id;
	private String name;
	private int age;
	private String department;
	private int salary;
	private String gender;
	

	public Employee(String name,int age, String department,int salary , String gender){
	
		this.name=name;
		this.age=age;
		this.department=department;
		this.salary=salary;
		this.gender=gender;
		id=++empId;
	}
	public int compare(String str1, String str2) 
    { 
        String first_Str; 
        String second_Str; 
        first_Str = str1; 
        second_Str = str2; 
        return second_Str.compareTo(first_Str); 
    }
	



	public int getId() {
		return id;
	}






	public void setId(int id) {
		this.id = id;
	}






	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public int getSalary() {
		return salary;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	}


