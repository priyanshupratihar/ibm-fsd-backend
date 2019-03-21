package com.example.empoops;

public class Person {
	private String Name;
	private String Gender;
	private double Age;
	
	public Person(String name,String gender,double age) {
		this.Name=name;
		this.Gender=gender;
		this.Age=age;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public double getAge() {
		return Age;
	}
	public void setAge(double age) {
		Age = age;
	}

}
