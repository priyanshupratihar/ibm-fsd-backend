package com.example.spring.core;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class EmployeeMain {

	public static void main(String[] args) {

		AbstractApplicationContext context=new ClassPathXmlApplicationContext("beans-config-annotation.xml");
		Employee emp = (Employee) context.getBean("employee");
		emp.printDetails();		
		context.close();
	}

}
