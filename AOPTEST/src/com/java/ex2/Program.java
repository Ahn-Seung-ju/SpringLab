package com.java.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("classpath:com/java/ex/aop.xml");
		
		Car car = context.getBean("car", Car.class);
		car.accelerate();
	}

}
