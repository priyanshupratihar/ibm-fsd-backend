package com.examples.spring.core;

public class Greetings {
	
	private String message = "Spring Hello World!!";
	private String message1 = "Spring Hello World! class path!";
	public  String getMessage() {
		return message;
		//System.out.println(message);
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void getMsg() {
		System.out.println(message1);
	}
	public void setMsg(String message1) {
		this.message1=message1;
	}
	
	

}
