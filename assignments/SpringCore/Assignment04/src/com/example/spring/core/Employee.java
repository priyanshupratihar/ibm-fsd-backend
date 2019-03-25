package com.example.spring.core;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {

	@Value("1")
	private int id;
	@Value("Priyanshu")
	private String name;
	//@Value("1996-09-09")
	private LocalDate dob;
	@Value("soft-dev")
	private String designation;
	@Value("34000")
	private double salary;
	private List<String> skills;
	@Autowired
	private Address address;
	private boolean fulltime;

	public Employee() {
	}
    	
//	public Employee(int id, String name, Address address) {
//		this.id = id;
//		this.name = name;
//		this.address = address;
//
//	}

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
		System.out.println("Id :" + id);
		System.out.println("Name: " + name);
		System.out.println("DOB: " + dob);
		System.out.println("Designation: " + designation);
		System.out.println("Salary:" + salary);
		System.out.println("Skills: " + skills);
		System.out.println("City: " + address.getCity());
		System.out.println("Pin: " + address.getPin());
	}
}
