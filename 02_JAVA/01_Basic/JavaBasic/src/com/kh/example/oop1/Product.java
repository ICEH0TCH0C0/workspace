package com.kh.example.oop1;

public class Product {
	private String pName;
	private int price;
	private String brand;
	
	public Product() {
	}
	
	void information(String pName, int price, String brand) {
		System.out.println(pName+ " " + price+"원 "+ brand);
	}
	
}
