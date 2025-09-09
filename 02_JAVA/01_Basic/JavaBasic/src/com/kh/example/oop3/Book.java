package com.kh.example.oop3;

public class Book {
	private String title;
	private String publisher;
	private String author;
	private int price;
	private double discointRate;
	
	public Book() {
		super();
	}

	public Book(String title, String publisher, String author) {
		this(title, publisher, author, 0, 0.0);
		
	}

	public Book(String title, String publisher, String author, int price, double discointRate) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.author = author;
		this.price = price;
		this.discointRate = discointRate;
	}
	
	void inform() {
		System.out.printf("제목 : %s 출판사 : %s 저자 : %s 가격 : %d원 할인율 : %.1f", title, publisher, author, price, discointRate);
	}
	
}
