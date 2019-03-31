package com.examples.spring.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping(value="/",method=RequestMethod.GET,produces="application/json")
	public String sayHello() {
		System.out.println("sayHello method...");
		return "{\"message\":\"hello rest\"}";
	}
	@RequestMapping("/greeting")
	//@ResponseBody
	public String greeting1( String msg1) {
		System.out.println("greeting1 method...");
		
		return "msg1";
	}
	@RequestMapping(value="/greeting",params= {"msg"})
	//@ResponseBody
	public String greeting2( String msg2) {
		System.out.println("greeting2 method...");
		
		return "msg2";
	}
	@PostMapping(value="/greeting",consumes= {"text/plain","text/html"})
	//@ResponseBody
	public String postGreeting(@RequestBody String reqBody) {
		System.out.println("greetingpost method...");
		
		return "Received request:"+reqBody;
	}
	
	@PutMapping(value="/greeting")
	//@ResponseBody
	public String putGreeting() {
		System.out.println("greeting Put method...");
		
		return "put msg";
	}
	
	@DeleteMapping(value="/greeting")
	//@ResponseBody
	public String deleteGreeting() {
		System.out.println("greeting delete method...");
		
		return "delete msg";
	}
	
	
	
}
