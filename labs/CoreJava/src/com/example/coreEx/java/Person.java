package com.example.coreEx.java;

public class Person {
	private String Name;
	private int Age;
	private String Gender;
	
	public Person(String name,String gender,int age) {
		this.Name=name;
		this.Gender=gender;
		this.Age=age;
	}
	public void AddEmployee() {
		
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}
}
