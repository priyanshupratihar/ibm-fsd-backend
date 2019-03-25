package com.examples.spring.core;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class FsAppContextMain {

	public static void main(String[] args) {

		AbstractApplicationContext context = new FileSystemXmlApplicationContext("src/beans-config.xml");
		Greetings obj=(Greetings) context.getBean("greetings");
		System.out.println(context.containsBean("greetings"));
		System.out.println(context.getBeanDefinitionNames());
		
		//Greetings obj1= context.getBean("greetings", Greetings.class);
		
		obj.setMsg("setting the message");
		obj.getMsg();
		
		//context.close();
		
		//Graceful shutdown
		context.registerShutdownHook();  
	}

}
