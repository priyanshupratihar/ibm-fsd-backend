package org.employee.model;

public class Employee<T extends Number>{
	String eid;
	String name;
	T salary;
	// LocalDate dob;
	int age;
	String dept;
	
	public Employee()
	{
		
	}
	
	public Employee(String eid,String name,T salary,int age,String dept) {
		this.eid=eid;
		this.name=name;
		this.salary=salary;
		this.age=age;
		this.dept=dept;
	}

	

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
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

	
	public T getSalary() {
		return salary;
	}

	public void setSalary(T salary) {
		this.salary = salary;
	}
}
