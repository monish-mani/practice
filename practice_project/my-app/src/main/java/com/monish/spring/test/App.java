package com.monish.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class App {
	public static void main(String[] args) {
		ApplicationContext  context = new ClassPathXmlApplicationContext("com/monish/spring/test/beans/beans.xml");
		
//		Person person = (Person)context.getBean("person");
//		Person person2 = (Person)context.getBean("person2");
//		Address address =(Address)context.getBean("address");
//		person.speak();
//		
//		System.out.println(person.toString());
//		System.out.println(person2.toString());
		
		FruitBasket basket = (FruitBasket)context.getBean("basket");
		System.out.println(basket.toString());
	}
}