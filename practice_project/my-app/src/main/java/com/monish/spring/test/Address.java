package com.monish.spring.test;

public class Address {
	
	private String street;
	private int postcode;
	
	
	public Address(){
		
	}
	
	public Address(String street, int postcode) {
		super();
		this.street = street;
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", postcode=" + postcode + "]";
	}
	
	

	
	
}
