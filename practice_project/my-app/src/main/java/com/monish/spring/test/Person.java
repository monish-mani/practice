package com.monish.spring.test;

public class Person {
	
	private int id;
	private String name;
	private int taxId;
	private Address address;
	
	
	public static Person getInstance(int id,String name){
		System.out.println("Creating person instance using factoty method: " + name);
		return new Person(id,name);
	}
	
	
	public void setAddress(Address address) {
		this.address = address;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public Person(){
		
	}
	
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public static void speak(){
		System.out.println("Hi I am a person!");
		
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", taxId=" + taxId + ", address=" + address + "]";
	}

	

}
