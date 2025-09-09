package com.kh.api;

/*
 * Wrapper클래스
 * 기본자료형을 객체로 포장해줄 수 있는 클래스
 * boolean(Boolean)
 * char(Char)
 * byte(Byte)
 * ...
 * 
 * 원시타입을 객체로 표현해야할 경우 사용
 * 		메서드의 매개변수로 전달해야할 때
 * 		원시타입에도 다형성을 적용하고 싶을 때
 * */

public class WrapperAPI {
	
	public void method() {
		//Boxing : 기본자료형 -> Wrapper클래스 자료형
		int num1 = 10;
		int num2 = 20;
		
		System.out.println(num1 == num2);
		
		//1. 객체 생성구문 통해서 클래스 타입으로 변경
		Integer i1 = new Integer(num1);
		
		//2. 객체를 생성하지 않고 곧바로 대입(AutoBoxing)
		Integer i2 = num2; // new Integer(num1);
		
		System.out.println(i1.equals(i2));
		System.out.println(i1.equals(10));
		System.out.println(i1.compareTo(i2)); 
		//두 값을 비교해서 기준값이 크면 1, 전달값이 크면 -1, 동일하면 0 반환
		
		//문자욜을 Integer 타입으로 변환하고 싶을 때 -> 객체생성을 통해서 가능
		Integer i3 = Integer.parseInt("13");
		Integer i4 = new Integer("13");
		
		//Unboxing : Wrapper클래스 자료형 -> 기본자료형
		//1. Wrapper클래스에서 제공하는 xxxValue() 메서드 사용
		int num3 = i3.intValue();
		
		//2. 메서드 사용하지 않고 바로대입(AutoUnboxing)
		int num4 = i4;
		
		//int뿐만이 아니라 다른 자료형도 가능
	}
}
