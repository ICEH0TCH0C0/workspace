package com.kh.object.ex1;

public class Run {
	
	/*
	 * 해당 클래스는 객체를 생성하기 위함이 아닌 실행을 위한 main문을 포함한 클래스
	 * */
	
	public static void main(String[] args) {
		//객체를 생성할 때
		//class명 객체이름; -> 해당 class타입의 참조 변수 생성
		Student shin;
		//객체이름 = new class명(); -> 새로운 class타입의 메모리 공간을 할당해서 주소를 참조
		shin = new Student();
		
		Student kim = new Student();
		
		shin.name = "신유빈";
		shin.age = 20;
		
		kim.name = "김종민";
		kim.age = 46;
		
		shin.myInfo();
		kim.myInfo();
		
		System.out.println(shin);
		System.out.println(kim);
	}

}
