package com.java.ex;

public class Car {
	private int speed;
	
	public void accelerate() {
		this.speed += 10;
		System.out.println("현재 속력: " + speed);
	}
	
	public void breakCar() {
		this.speed = 0;
		System.out.println("현재 속력: " + speed);
	}
}
