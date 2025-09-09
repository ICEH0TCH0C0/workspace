package com.kh.example.oop3;

public class Run {

	public static void main(String[] args) {
		Book book1 = new Book();
		Book book2 = new Book("마녀와의 7일", "현대문학", "히가시노 게이고");
		Book book3 = new Book("라플라스의 마녀", "현대문학", "히가시노 게이고", 15120, 0.2);
		
		book1.inform();
		System.out.println();
		book2.inform();
		System.out.println();
		book3.inform();
		System.out.println();
		
	}

}
