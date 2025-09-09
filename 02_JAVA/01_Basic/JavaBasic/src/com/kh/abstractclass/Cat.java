package com.kh.abstractclass;

public class Cat extends Animal{

	@Override
	public void breathe() {
		// TODO Auto-generated method stub
		super.breathe();
	}

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("야옹");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("고양이가 움직인다.");
	}
	
}
