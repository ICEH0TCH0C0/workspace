package com.kh.inherit;

public class TV extends Product{
	private int inch;

	public TV() {
		super();
	}

	public TV(String pName, int price, String brand, int inch) {
		super(pName, price, brand);
		this.inch = inch;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}
	
	//오버라이딩
	//부모클래스에 있는 메서드를 자식클래스에서 내용만 재정의
	@Override
	public String inform() {
		return super.inform() + "/ 올인원 : "+ inch;
	}
	
}
