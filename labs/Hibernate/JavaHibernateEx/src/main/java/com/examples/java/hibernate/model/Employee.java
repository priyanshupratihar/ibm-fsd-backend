package com.examples.java.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int sl_no;
	String eid;
	String name;
	int salary;
	int age;
	String dept;
	
	public Employee()
	{
		
	}
	
	public Employee(String eid,String name,int salary,int age,String dept) {
		this.eid=eid;
		this.name=name;
		this.salary=salary;
		this.age=age;
		this.dept=dept;
	}

	

	@Column
	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	@Column
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Column
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	@Column
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Column
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Column
	public int getSl_no() {
		return sl_no;
	}

	public void setSl_no(int sl_no) {
		this.sl_no = sl_no;
	}
	
	
}
