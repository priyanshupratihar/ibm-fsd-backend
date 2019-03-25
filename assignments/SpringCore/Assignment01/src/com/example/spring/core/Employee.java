package com.example.spring.core;

import java.time.LocalDate;
import java.util.List;

public class Employee {

	private int id;
	private String name;
	private LocalDate dob;
	private String designation;
	private double salary;
	private List<String> skills;
	private Address address;
	private boolean fulltime;
	
	Employee(int id, String name, Address address, double salary){
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
   public boolean isFulltime() {
		return fulltime;
	}
	public void setFulltime(boolean fulltime) {
		this.fulltime = fulltime;
	}
	public void printDetails() {
		System.out.println("Id :"+id);
		System.out.println("Name: "+name);
		System.out.println("DOB: "+dob);
		System.out.println("Designation: "+designation);
		System.out.println("Salary:"+salary);
		System.out.println("Skills: "+skills);
		System.out.println("City: "+address.getCity());
		System.out.println("Pin: "+address.getPin());
	}
}
