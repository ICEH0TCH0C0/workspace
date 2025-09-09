package com.kh.override;

public class Run {
	
	/*
	 * 참조변수를 호출하면 자동으로 .toString()이 호출
	 * -> Object에 정의된 메서드로 모든클래스는 Object를 상속받아 toString()을 사용 가능
	 * 
	 * 오버라이딩 전(Object) toString() : 클래스명 + @ + 객체 주소의 hashCode를 16진수로 변환
	 * 오버라이딩 후(Man) toString() : 내가 원하는 형식의 구조로 재정의 가능
	 * 
	 * 오버라이딩
	 * 자식클래스가 상속받고 있는 부모 클래스의 메서드를 재정의 하는 것
	 * 부모가 제공하는 메서드를 자식이 일부 수정해서 사용하겠다는 의미
	 * 
	 * 오버라이딩의 성립조건
	 * 부모메서드 명과 메서드명이 동일
	 * 매개변수의 개수, 자료형, 순서를 포함
	 * 반환형도 동일
	 * 부모 메서드의 접근제한자보다는 범위가 같거나 커야한다.
	 * */
	
	public static void main(String[] args) {
		String str1 = new String("홍길동");
		String str2 = new String("홍길동");
		
		Man m1 = new Man("홍길동", "111111-1111111");
		Man m2 = new Man("홍길동", "111111-1111111");
		
		System.out.println(m2);
		System.out.println(m1);
		System.out.println(str1);
		System.out.println(str2);
		
		System.out.println(str1.equals(str2));
		System.out.println(m1.equals(m2));
	}

}
