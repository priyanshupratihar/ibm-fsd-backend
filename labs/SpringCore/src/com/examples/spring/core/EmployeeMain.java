package com.examples.spring.core;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class EmployeeMain {

	public static void main(String[] args) {

		//AbstractApplicationContext context = new FileSystemXmlApplicationContext("beans-config-emp.xml");
		
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("beans-config-emp.xml");
		Employee obj=(Employee) context.getBean("employee");
		obj.printDetails();
		context.registerShutdownHook();
		context.close();
	}

}
