package com.kh.polymorphim;

public class Run {
	public static void main(String[] args) {
		/*
		 * 			  클래스 참조변수 = new 클래스 생성자();
		 *  (부모클래스가 위치할 수 있음) = (자식클래스가 위치할 수 있음) -> 업캐스팅
		 * 실제로 어디까지 접근이 가능한가 = 실제로 어떤형태의 메모리가 생성되는가
		 * 
		 * */
		/*
		Cake c1 = new CheeseCake();
		//Cake까지 접근 가능하며 메모리 공간은 실제 CheeseCake의 공간
		c1.sweet();
		//오버라이딩에는 실제 메모리에 있는 메서드가 호출됨.
		c1.yummy(); 
		//다운캐스팅 : 자식의 참조변수로 타입을 변경(업캐스팅 관계에 있을 경우에만 가능)
		((CheeseCake)c1).milky();
//		CheeseCake c2 = new Cake; 실제 메모리가 Cake이므로 CheeseCake공간에 접근할 수 없음.
//		-> 접근 범위가 실제 메모리의 크기보다 클 수 없음.
		*/
		
		//1. 부모타입의 레퍼런스(참조변수)로 부모객체를 다루는 경우
		Car c1 = new Car("빨간색", "가솔린", 2021);
		c1.drive();
//		((Sonata)c1).moveSonata(); Car는 부모 클래스이기 때문
		
		//2. 자식타입 레퍼런스(참조변수) 자식객체를 다루는 경우
		Avante c2 = new Avante("흰색", "LPG", 2022);
		c2.drive(); //Avante 클래스에서 오버라이딩된 drive()호출
		c2.moveAvante();
		//부모참조변수로 업캐스팅 가능 -> 오버라이딩된 생성된 메모리를 기준으로 호출됨
		((Car)c2).drive();
//		((Car)c2).moveAvante(); 업캐스팅시 자식요소의 메모리 접근이 불가
		
		//3. 부모타입 레퍼런스(참조변수)로 자식객체를 다루는 경우(업캐스팅)
		Car c3 = new Sonata("검정", "디젤", 2023);
//		c3.moveSonata(); 부모타입의 참조변수이기 때문에 자식요소의 메서드 접근 불가
		((Sonata)c3).moveSonata();
		
		/*
		 * 상속구조의 클래스들 간의 형변환이 가능
		 * 1. 업캐스팅
		 * 자식타입을 부모타입으로 형변환
		 * 자동형변환
		 * ex) Car c = new Sonata();
		 * 
		 * 2. 다운캐스팅
		 * 부모타입을 자식타입으로 형변환
		 * 강제형변환, 업캐스팅 관계에 있을 때만 가능
		 * ex) ((Sonata)c).moveSonata();
		 * */
		c2.driveCar(c1); //c1 -> 실제 메모리 Car
		c2.driveCar(c2); //c2 -> 실제 메모리 Avante
		c2.driveCar(c3); //c3 -> 실제 메모리 Sonata
	}
}
