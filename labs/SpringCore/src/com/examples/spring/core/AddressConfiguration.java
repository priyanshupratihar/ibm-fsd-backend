package com.examples.spring.core;

import org.springframework.context.annotation.Bean;

public class AddressConfiguration {
	
	@Bean
	public Address address() {
		return new Address("kolkata","India",700098);
	}

}
