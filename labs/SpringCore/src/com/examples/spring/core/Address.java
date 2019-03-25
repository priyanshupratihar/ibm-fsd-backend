package com.examples.spring.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class Address {
	
	//@Value(value="kolkata")
	private String city;
	//@Value(value="India")
	private String country;
	private int pin;
	
	public Address(String city,String country,int pin) {
		this.city=city;
		this.country=country;
		this.pin=pin;
	} 
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}

}
