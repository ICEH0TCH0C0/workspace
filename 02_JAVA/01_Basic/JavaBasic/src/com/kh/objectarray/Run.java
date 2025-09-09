package com.kh.objectarray;

public class Run {
	
	/*
	 * 객체배열
	 * 같은 타입의 객체 여러개를 하나의 배열에 저장해서 관리하는 것
	 * 단, 배열의 각 요소가 객체자체를 저장하는 게 아니라 객체의 주소(참조값)을 저장.
	 * 		배열 생성시 객체까지 자동으로 생성되는 것이 아니라, 각 요소에 객체를 직접 생성해서 넣어야함
	 * */
	
	public static void main(String[] args) {
		
		//1. 객체 배열 선언 및 생성
		Book[] books = new Book[3]; //=Book book1, book2, book3;
		
		for(Book b : books) System.out.print(b + " ");
		
		books[0] = new Book();
		books[1] = new Book();
		books[2] = new Book();
		
		System.out.println();
		for(Book b : books) System.out.print(b + " ");
		

		books[0].setTitle("어린왕자");
		books[1].setTitle("이기적유전자");
		books[2].setTitle("라플라스의 마녀");
		
		String[] str = new String[3];
		
		str[0] = books[0].getTitle();
		str[1] = books[1].getTitle();
		str[2] = books[2].getTitle();
		
		System.out.println();
		System.out.println(str[0]);
		System.out.println(str[1]);
		System.out.println(str[2]);
		
	}

}
