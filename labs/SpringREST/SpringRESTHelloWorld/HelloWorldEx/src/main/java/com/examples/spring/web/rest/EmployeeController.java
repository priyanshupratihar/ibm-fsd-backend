package com.examples.spring.web.rest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	Employee emp;
	List<Employee> empList=new ArrayList<Employee>();
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String createEmployee(@RequestBody Employee employee) {
		//System.out.println("post method");
		empList.add(employee);
		return "emp added";
	}
	
	@GetMapping(value="/view")
	public List showEmp() {
		
		return empList;
	}
	
	@RequestMapping(value = {"/employee/{id}"}, method = RequestMethod.GET)
	public List showEmpById(@PathVariable String id) {
		return  empList.stream().filter(e->e.getId().equals(id)).collect(Collectors.toList());
	}
}
