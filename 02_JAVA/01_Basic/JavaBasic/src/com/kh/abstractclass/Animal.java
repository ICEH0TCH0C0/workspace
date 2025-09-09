package com.kh.abstractclass;

public abstract class Animal {
	//일반 메서드
	public void breathe() {
		System.out.println("숨을 쉰다.");
	}
	
	//추상 메서드
	public abstract void speak(); //소리내
	public abstract void move(); //움직이기
}
