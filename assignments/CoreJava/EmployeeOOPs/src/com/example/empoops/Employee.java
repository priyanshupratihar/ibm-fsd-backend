package com.example.empoops;

public class Employee extends Person {
	int Salary;
	String Designation;
	
	public Employee(String name,String gender,double age,int salary,String designation) {
		super(name, gender, age);
		this.Salary=salary;
		this.Designation=designation;
	}
	
	public static void main(String[] args) {
		Employee emp1=new Employee("abc","female",56,5000,"soft-dev");
		System.out.println(emp1.Designation);
		System.out.println(emp1.getName());
	}
}
