package com.exampales.java.io;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6831047018549944648L;
	public String name;
	public String address;
	public transient int SSN;   //this member will not be serialized
	public int id;
	public List<String> skills;
	
//	public void mailCheck() {
//		System.out.println("Mailing a check to " + name + " " + address);
//	}
}
