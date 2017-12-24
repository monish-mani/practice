package com.monish.spring.test;

import java.util.List;

public class FruitBasket {
	
	private String name;
	private List<String> fruits;
	
	public FruitBasket(String name, List<String> fruits) {
		super();
		this.name = name;
		this.fruits = fruits;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("Name: " + name + " " );
		fruits.stream().forEach(f -> sb.append(f + " "));
		
		return sb.toString();
	}

}
