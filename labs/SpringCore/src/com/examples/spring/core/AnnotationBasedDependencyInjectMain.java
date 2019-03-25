package com.examples.spring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBasedDependencyInjectMain {

	public static void main(String[] args) {

		//AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans-config-annotation.xml");
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfiguration.class);

		Employee obj = (Employee) context.getBean("employee");

		obj.printDetails();
		context.registerShutdownHook();
		context.close();
	}

}
