package com.example.spring.core.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfiguration {
	@Bean
	public Employee employee() {
		return new Employee(1,"Barun",address(),date(),skill());
	}
	
	@Bean
	public Address address() {
		return new Address("kolkata",700098,"India");
	}
	@Bean
	public LocalDate date() {
		LocalDate dob=LocalDate.parse("1996-09-09");
		return dob;
	}
	
	@Bean
	public List<String> skill() {
		List<String> skills=new ArrayList<String>();
		skills.add("java");
		skills.add("python");
		skills.add("spring");
		return skills;
	}
	
	@PostConstruct
	public void initiaze()
	{
		System.out.println("Bean is getting initialized...");
	}

	@PreDestroy
	public void cleanup()
	{
		System.out.println("Bean is getting cleaned up.");
	}
}
