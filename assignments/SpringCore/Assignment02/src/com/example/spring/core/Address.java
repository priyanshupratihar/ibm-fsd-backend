package com.example.spring.core;

public class Address {

	String city;
	int pin;
	String country;
	
	public Address() {}
	public Address(String city, int pin, String country){
		this.city = city;
		this.pin = pin;
		this.country= country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
