package com.examples.spring.employeeApp;

public class CustomException extends Exception{
	static int sl=0;
	public CustomException(int salary) {
		if(salary<0) {
			sl+=1;
			System.out.println("Salary can not be negetive");
		}
		else {
			sl=0;
		}
	}
	
}
