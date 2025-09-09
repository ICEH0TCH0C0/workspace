package com.kh.generic;

public class Run extends Number{

	/*
	 * 제네릭
	 * 
	 * 제네릭을 사용하지 않고 Object와 같은 넓은 범위를 수용할 수 있는 필드 변수의 타입을 사용시 
	 * -> 형반환이 필요, 런타임 오류 발생
	 * 클래스나 메서드가 사용할 데이터타입을 컴파일 시점에 지정할 수 있도록 지원하는 문법 -> 매개타입(객체 생성시 타입을 전달받아 결정)
	 * 
	 * */
	
	public static void main(String[] args) {
		//제네릭 클래스의 매개타입을 전달하지 않으면 기본적으로 Object로 설정
		Box aBox = new Box<>();
		aBox.setValue("value");
//		int num = aBox.getValue(); // 반한시에도 Object로 반환
		int num = (Integer)aBox.getValue(); //형변환
		
		System.out.println(aBox.getValue());
		
		Box<Integer> iBox = new Box<>();
//		iBox.setValue("value"); 매개타입이 Integer이므로 Stirng 전달불가
		iBox.setValue(100);
		int num2 = iBox.getValue(); //형변환 불필요
		
		Integer[] arr = new Integer[5];
		iBox.setArr(arr);
		
//		iBox.setArr(new String[] {"1", "2"}); String이라서 불가능
		
		
	}

}
