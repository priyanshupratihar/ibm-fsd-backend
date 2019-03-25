package com.example.spring.core.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class EmployeeMain {

	public static void main(String[] args) {

		AbstractApplicationContext context= new AnnotationConfigApplicationContext(EmployeeConfiguration.class);
		Employee emp=(Employee) context.getBean("employee");
		emp.printDetails();
		context.registerShutdownHook();
		context.close();
	}

}
