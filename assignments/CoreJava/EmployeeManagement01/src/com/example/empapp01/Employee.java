package com.example.empapp01;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4643596500094070080L;
	String name;
	public int id;
	int age;
	String Location;
	String department;
	public int Salary;
	LocalDate dob;
	
	public Employee() {
		
	}
	public Employee(String name,int id,int age,String Location,String department,int Salary,LocalDate dob) {
		this.name=name;
		this.id=id;
		this.age=age;
		this.Location=Location;
		this.department=department;
		this.Salary=Salary;
		this.dob=dob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	



	
}
